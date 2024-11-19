package com.br.domain.service;

import java.util.UUID;

import com.br.domain.model.Organization;
import org.springframework.data.domain.*;

public interface OrganizationService {

	Page<Organization> filter(String name, Pageable pageable);
	Organization save(Organization organization);
	Organization findById(UUID id);
	Organization activeOrDesactived(UUID id, Boolean active);

}
