package com.br.domain.service.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.br.domain.exception.EntidadeNaoExisteException;
import com.br.domain.model.Orgao;
import com.br.domain.repository.OrganizationRepository;
import com.br.domain.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationRepository orgaoRepository;
	
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
	public Page<Orgao> filter(String name, Pageable pageable) {
		return orgaoRepository.filter(name, pageable);
	}

	@Override
	public Orgao findById(UUID id) {
		Optional<Orgao> orgao = orgaoRepository.findById(id);
		if(orgao.isEmpty()) {
			throw new EntidadeNaoExisteException("Esse orgão não existe!");
		}
		return orgao.get();
	}

	@Override
	public Orgao activeOrgao(UUID id, Boolean active) {
		Orgao orgao = orgaoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("O orgão informado não existe! "));
		orgao.setActive(active);
		return orgaoRepository.save(orgao);
	}

	@Override
	public Orgao desactiveOrgao(UUID id) {
		Orgao orgao = orgaoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("O orgão informado não existe! "));
		orgao.setActive(false);
		return orgaoRepository.save(orgao);
	}

}
