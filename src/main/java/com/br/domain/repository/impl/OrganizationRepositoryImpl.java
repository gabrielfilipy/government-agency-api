package com.br.domain.repository.impl;

import com.br.domain.model.*;
import com.br.domain.repository.OrganizationRepositoryQuery;
import org.springframework.data.domain.*;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.*;

public class OrganizationRepositoryImpl implements OrganizationRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    private Predicate[] criarRestricoes(String name, CriteriaBuilder builder, Root<Organization> root){
        List<Predicate> predicates = new ArrayList<>();
        Join<Organization, Address> estado = root.join("address");

        if(name != null){
            predicates.add(builder.like(root.get("name"), "%" + name + "%"));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }

    private void adicionarRestricoesDePaginacao(TypedQuery<Organization> query, Pageable pageable){
        int paginaAtual = pageable.getPageNumber();
        int totalDeRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalDeRegistrosPorPagina;
        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalDeRegistrosPorPagina);
    }

    private Long totalElementos(String name) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Organization> root = criteria.from(Organization.class);
        Predicate[] predicates = criarRestricoes(name, builder, root);
        criteria.where(predicates);
        criteria.select(builder.count(root));
        return manager.createQuery(criteria).getSingleResult();
    }

    @Override
    public Page<Organization> filter(String name, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Organization> criteria = builder.createQuery(Organization.class);
        Root<Organization> root = criteria.from(Organization.class);
        Predicate[] predicates = criarRestricoes(name, builder, root);
        criteria.orderBy(builder.asc(root.get("name")));
        criteria.where(predicates);
        TypedQuery<Organization> query = manager.createQuery(criteria);
        adicionarRestricoesDePaginacao(query, pageable);
        return new PageImpl<>(query.getResultList(), pageable, totalElementos(name));
    }

}
