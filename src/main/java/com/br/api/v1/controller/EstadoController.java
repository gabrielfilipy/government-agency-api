package com.br.api.v1.controller;

import java.util.List;

import javax.validation.Valid;
import com.br.api.v1.mapper.OrgaoModelMapper;
import com.br.api.v1.model.input.OrgaoModelInput;
import com.br.domain.service.spec.TemplateSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.br.api.v1.mapper.OrgaoModelMapeerBack;
import com.br.api.v1.model.OrgaoModel;
import com.br.api.v1.model.input.OrgaoActiveModelInput;
import com.br.domain.model.Cidade;
import com.br.domain.model.Estado;
import com.br.domain.model.Orgao;
import com.br.domain.service.EstadoService;
import com.br.domain.service.OrgaoService;
import io.swagger.annotations.Api;

@Api(tags ="estado")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v1/estado")
public class EstadoController {

	@Autowired
	private EstadoService estadoService;

	@Autowired
	private OrgaoModelMapper orgaoModelMapper;
	@Autowired
	private OrgaoModelMapeerBack orgaoModelMapeerBack;

	@GetMapping("/listar")
	public List<Estado> buscar() {
		return estadoService.findAll();
	}
	
	@PostMapping("/cadastrar")
	public Estado cadastrar(@RequestBody Estado estado) {
		
		return estadoService.salvar(estado);
	}

}
