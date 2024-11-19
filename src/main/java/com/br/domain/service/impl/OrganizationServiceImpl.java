package com.br.domain.service.impl;

import java.util.*;

import com.br.domain.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import com.br.api.exceptionhandler.exceptions.NotFoundException;
import com.br.domain.repository.OrganizationRepository;
import com.br.domain.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationRepository orgaoRepository;
	
	@Override
	public Organization save(Organization organization) {
		return orgaoRepository.save(organization);
	}

	@Override
	public Page<Organization> filter(String name, Pageable pageable) {
		return orgaoRepository.filter(name, pageable);
	}

	@Override
	public Organization findById(UUID id) {
		Optional<Organization> organization = orgaoRepository.findById(id);
		if(organization.isEmpty()) {
			throw new NotFoundException("Esse orgão não existe!");
		}
		return organization.get();
	}

	@Override
	public Organization activeOrDesactived(UUID id, Boolean active) {
		Organization organization = findById(id);
		organization.setActive(active);
		return orgaoRepository.save(organization);
	}

}
