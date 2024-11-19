package com.br.api.v1.controller;

import java.util.UUID;

import javax.validation.Valid;

import com.br.domain.model.Organization;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.br.api.v1.mapper.*;
import com.br.api.v1.model.OrganizationModel;
import com.br.api.v1.model.input.*;
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

    @GetMapping("/search-for-id/{id}")
    public ResponseEntity<OrganizationModel> getUser(@PathVariable(name = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(organizationModelMapper.toModel(organizationService.findById(id)));
    }

    @GetMapping("/filter")
    public ResponseEntity<Page<?>> findAll(String name,
                                           @PageableDefault(page = 0, size = 10) Pageable pageable) {
        return ResponseEntity.status (HttpStatus.OK).body(organizationService.filter(name, pageable));
    }

    @PostMapping("/registry")
    public ResponseEntity<OrganizationModel> cadastrar(@RequestBody @Valid OrganizationModelInput organizationModelInput) {
        Organization organization = organizationModelMapeerBack.toModel(organizationModelInput);
        OrganizationModel organizationModel = organizationModelMapper.toModel(organizationService.save(organization));
        return ResponseEntity.status(HttpStatus.CREATED).body(organizationModel);
    }
    
    @PatchMapping("/activate-deactivate/{id}")
    public ResponseEntity<OrganizationModel> activateDepartamento(@RequestBody OrganizationActiveModelInput departamentoActiveModelInput,
                                                                  @PathVariable(name = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                organizationModelMapper.toModel(organizationService.activeOrDesactived(id, departamentoActiveModelInput.isActive())));
    }

}
