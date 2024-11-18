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

import com.br.api.v1.mapper.OrganizationModelMapper;
import com.br.api.v1.mapper.OrganizationModelMapeerBack;
import com.br.api.v1.model.OrgaoModel;
import com.br.api.v1.model.input.OrgaoActiveModelInput;
import com.br.api.v1.model.input.OrgaoModelInput;
import com.br.domain.model.Orgao;
import com.br.domain.service.OrganizationService;

import io.swagger.annotations.Api;

@Api(tags = "Organization")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v1")
public class OrganizationController {

	@Autowired
    private OrganizationService organizationService;
    
    @Autowired
    private OrganizationModelMapper organizationModelMapper;
    
    @Autowired
    private OrganizationModelMapeerBack organizationModelMapeerBack;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/search-for-id/{id}")
    public ResponseEntity<OrgaoModel> getUser(@PathVariable(name = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(organizationModelMapper.toModel(organizationService.findById(id)));
    }

    @GetMapping("/filter")
    public ResponseEntity<Page<?>> findAll(String name,
                                           @PageableDefault(page = 0, size = 10) Pageable pageable) {
        return ResponseEntity.status (HttpStatus.OK).body(organizationService.filter(name, pageable));
    }

    @PostMapping("/registry")
    public ResponseEntity<OrgaoModel> cadastrar(@RequestBody @Valid OrgaoModelInput orgaoModelInput) {
        Orgao orgao = organizationModelMapeerBack.toModel(orgaoModelInput);
        OrgaoModel orgaoModel = organizationModelMapper.toModel(organizationService.save(orgao));
        rabbitTemplate.convertAndSend("government-department", orgaoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(orgaoModel);
    }
    
    @PatchMapping("/activate-deactivate/{id}")
    public ResponseEntity<OrgaoModel> activateDepartamento(@RequestBody OrgaoActiveModelInput departamentoActiveModelInput,
                                                           @PathVariable(name = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                organizationModelMapper.toModel(organizationService.activeOrgao(id, departamentoActiveModelInput.isActive())));
    }

}
