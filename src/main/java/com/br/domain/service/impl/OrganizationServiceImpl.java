package com.br.domain.service.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.br.domain.exception.OrganizationNotFoundException;
import com.br.domain.model.City;
import com.br.domain.model.Organization;
import com.br.domain.model.State;
import com.br.domain.repository.CityRepository;
import com.br.domain.repository.OrganizationRepository;
import com.br.domain.repository.StateRepository;
import com.br.domain.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Override
	public Organization save(Organization organization) {
		
		// Tem que salvar os dependentes antes de salvar o organization
		// salvo primeiro o state pois o city depende dele
		// depois salvo o city pois o adress depende dele e ele referencia o state
		
		State state = organization.getAddress().getCity().getState();
	    if(state.getId() == null) {
	        state = stateRepository.save(state);
	    }

	    City city = organization.getAddress().getCity();
	    if(city.getId() == null) {
	        city.setState(state);
	        city = cityRepository.save(city);
	    }

	    organization.getAddress().setCity(city);
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
