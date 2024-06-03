package com.br.domain.repository;

import com.br.domain.model.Orgao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrgaoRepositoryQuery {

    Page<Orgao> buscarOrgaoDoFiltro(Long endereco, Pageable pageable);

}
