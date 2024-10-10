package com.br.api.v1.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.br.api.v1.mapper.OrgaoModelMapper;
import com.br.api.v1.mapper.OrgaoModelMapeerBack;
import com.br.api.v1.model.OrgaoModel;
import com.br.api.v1.model.input.OrgaoActiveModelInput;
import com.br.api.v1.model.input.OrgaoModelInput;
import com.br.domain.model.Orgao;
import com.br.domain.service.OrgaoService;

import io.swagger.annotations.Api;

@Api(tags = "orgao")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v1/orgao")
public class OrgaoController {

	@Autowired
    private OrgaoService orgaoService;
    
    @Autowired
    private OrgaoModelMapper orgaoModelMapper;
    
    @Autowired
    private OrgaoModelMapeerBack orgaoModelMapeerBack;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/buscar/{id}")
    public ResponseEntity<OrgaoModel> getUser(@PathVariable(name = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(orgaoModelMapper.toModel(orgaoService.findById(id)));
    }

    @GetMapping("/filtro")
    public ResponseEntity<Page<?>> findAll(UUID endereco,
                                           @PageableDefault(page = 0, size = 10) Pageable pageable) {
        return ResponseEntity.status (HttpStatus.OK).body(orgaoService.buscarOrgao(endereco, pageable));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<OrgaoModel> cadastrar(@RequestBody @Valid OrgaoModelInput orgaoModelInput) {
        Orgao orgao = orgaoModelMapeerBack.toModel(orgaoModelInput);

        OrgaoModel orgaoModel = orgaoModelMapper.toModel(orgaoService.save(orgao));

        rabbitTemplate.convertAndSend("government-department", orgaoModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(orgaoModel);
    }
    
    @PatchMapping("/ativar-desativar/{id}")
    public ResponseEntity<OrgaoModel> activateDepartamento(@RequestBody OrgaoActiveModelInput departamentoActiveModelInput,
                                                           @PathVariable(name = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                orgaoModelMapper.toModel(orgaoService.activeOrgao(id, departamentoActiveModelInput.isActive())));
    }

    @PutMapping("/desativar/{id}")
    public ResponseEntity<OrgaoModel> deactivateDepartamento(@RequestBody OrgaoActiveModelInput departamentoActiveModelInput,
                                                             @PathVariable(name = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orgaoModelMapper.toModel(orgaoService.desactiveOrgao(id)));
    }
}
