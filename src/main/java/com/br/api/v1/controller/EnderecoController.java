package com.br.api.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.api.v1.model.input.EnderecoModelInput;
import com.br.domain.model.Cidade;
import com.br.domain.model.Endereco;
import com.br.domain.model.Estado;
import com.br.domain.service.CidadeService;
import com.br.domain.service.EnderecoService;
import com.br.domain.service.EstadoService;

import io.swagger.annotations.Api;

@Api(tags ="endereco")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v1/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private CidadeService cidadeService;
	
	@Autowired
	private EstadoService estadoService;

	
	@GetMapping("/listar")
	public List<Endereco> listar(){
		return enderecoService.findAll();
	}
	
	@PostMapping("/cadastrar")
	public Endereco cadastrar(@RequestBody EnderecoModelInput enderecoModelInput) {
		Estado estado = estadoService.findById(enderecoModelInput.getEstadoId());
        Cidade cidade = cidadeService.findById(enderecoModelInput.getCidadeId());
        Endereco endereco = new Endereco();
        endereco.setEstadoId(estado);
        endereco.setCidadeId(cidade);
        
        endereco.getCidadeId();
		return enderecoService.salvar(endereco);
	}
}
