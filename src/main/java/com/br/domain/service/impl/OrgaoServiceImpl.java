package com.br.domain.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.br.domain.exception.EntidadeNaoExisteException;
import com.br.domain.model.Orgao;
import com.br.domain.repository.OrgaoRepository;
import com.br.domain.service.OrgaoService;

@Service
public class OrgaoServiceImpl implements OrgaoService{

	@Autowired
	private OrgaoRepository orgaoRepository;
	
	@Override
	public Orgao save(Orgao orgao) {
		Orgao salvar = orgaoRepository.save(orgao);
		return salvar;
	}


	@Override
	public Page<Orgao> buscarTodos(Specification<Orgao> spec, Pageable pageable) {
		return orgaoRepository.findAll(spec, pageable);
	}

	@Override
	public Orgao findById(Long id) {
		Optional<Orgao> orgao = orgaoRepository.findById(id);
		if(orgao.isEmpty()) {
			throw new EntidadeNaoExisteException("Esse orgão não existe!");
		}
		return orgao.get();
	}

	@Override
	public Orgao activeOrgao(Long id, Boolean active) {
		Orgao orgao = orgaoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("O orgão informado não existe! "));
		orgao.setActive(active);
		return orgaoRepository.save(orgao);
	}

	@Override
	public Orgao desactiveOrgao(Long id) {
		Orgao orgao = orgaoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("O orgão informado não existe! "));
		orgao.setActive(false);
		return orgaoRepository.save(orgao);
	}

}
