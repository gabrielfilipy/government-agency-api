package com.br.domain.repository;

import com.br.domain.model.Orgao;
import org.springframework.data.domain.*;

public interface OrganizationRepositoryQuery {

    Page<Orgao> filter(String name, Pageable pageable);

}
