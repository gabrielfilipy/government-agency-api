package com.br.domain.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import com.br.domain.model.Orgao;

public interface OrgaoService {

	Page<Orgao> buscarTodos(Specification<Orgao> spec, Pageable pageable);
	Page<Orgao> buscarOrgao(UUID endereco, Pageable pageable);
	Orgao save(Orgao orgao);
	Orgao findById(UUID id);
	Orgao activeOrgao(UUID id, Boolean active);
	Orgao desactiveOrgao(UUID id);
}
