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
import com.br.domain.model.Endereco;
import com.br.domain.model.Orgao;
import com.br.domain.service.CidadeService;
import com.br.domain.service.OrgaoService;
import io.swagger.annotations.Api;

@Api(tags ="orgao")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v1/cidade")
public class CidadeController {

	@Autowired
	private CidadeService cideadeService;
	

	@GetMapping("/listar")
	public List<Cidade> getDepartamentos() {
		return cideadeService.findAll();
	}
	
	@PostMapping("/cadastrar")
	public Cidade cadastrar(@RequestBody Cidade cidade) {
		
		return cideadeService.salvar(cidade);
	}
}
