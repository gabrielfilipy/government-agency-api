package com.br.api.v1.controller;

import javax.validation.Valid;

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
import com.br.domain.model.Endereco;
import com.br.domain.model.Orgao;
import com.br.domain.service.OrgaoService;
import com.br.domain.service.spec.TemplateSpec;

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
    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<OrgaoModel> getUser(@PathVariable(name = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(orgaoModelMapper.toModel(orgaoService.findById(id)));
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<Orgao>> getDepartamentos(TemplateSpec.OrgaoSpec spec,
                                                        @PageableDefault(page = 0, size = 5) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(orgaoService.buscarTodos(spec, pageable));
    }
    
    @PostMapping("/cadastrar")
    public ResponseEntity<OrgaoModel> cadastrar(@RequestBody @Valid OrgaoModelInput orgaoModelInput) {
        Orgao orgao = orgaoModelMapeerBack.toModel(orgaoModelInput);
        orgao.setActive(true);
        OrgaoModel orgaoModel = orgaoModelMapper.toModel(orgaoService.save(orgao));
        return ResponseEntity.status(HttpStatus.CREATED).body(orgaoModel);
    }
    
    @PatchMapping("/ativar-desativar/{id}")
    public ResponseEntity<OrgaoModel> activateDepartamento(@RequestBody OrgaoActiveModelInput departamentoActiveModelInput,
                                                           @PathVariable(name = "id") Long id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                orgaoModelMapper.toModel(orgaoService.activeOrgao(id, departamentoActiveModelInput.isActive())));
    }

    @PutMapping("/desativar/{id}")
    public ResponseEntity<OrgaoModel> deactivateDepartamento(@RequestBody OrgaoActiveModelInput departamentoActiveModelInput,
                                                             @PathVariable(name = "id") Long id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orgaoModelMapper.toModel(orgaoService.desactiveOrgao(id)));
    }
}
