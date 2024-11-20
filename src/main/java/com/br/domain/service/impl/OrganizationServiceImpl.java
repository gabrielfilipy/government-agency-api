package com.br.domain.service.impl;

import java.util.*;

import com.br.domain.exception.OrganizationNotFoundException;
import com.br.domain.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import com.br.domain.repository.OrganizationRepository;
import com.br.domain.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Override
	public Organization save(Organization organization) {
		organization.setActive(true);
		return organizationRepository.save(organization);
	}

	@Override
	public Page<Organization> filter(String name, Pageable pageable) {
		return organizationRepository.filter(name, pageable);
	}

	@Override
	public Organization findById(UUID id) {
		Optional<Organization> organization = organizationRepository.findById(id);
		if(organization.isEmpty()) {
			throw new OrganizationNotFoundException(id);
		}
		return organization.get();
	}

	@Override
	public Organization activeOrDesactived(UUID id, Boolean active) {
		Organization organization = findById(id);
		organization.setActive(active);
		return organizationRepository.save(organization);
	}

}
