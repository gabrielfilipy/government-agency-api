package com.br.domain.repository;

import com.br.domain.model.Organization;
import org.springframework.data.domain.*;

public interface OrganizationRepositoryQuery {

    Page<Organization> filter(String name, Pageable pageable);

}
