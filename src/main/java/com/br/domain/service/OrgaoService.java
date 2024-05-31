package com.br.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.br.domain.model.Orgao;

public interface OrgaoService {

	Page<Orgao> buscarTodos(Specification<Orgao> spec, Pageable pageable);
	Orgao save(Orgao orgao);
	Orgao findById(Long id);
	Orgao activeOrgao(Long id, Boolean active);
	Orgao desactiveOrgao(Long id);
}
