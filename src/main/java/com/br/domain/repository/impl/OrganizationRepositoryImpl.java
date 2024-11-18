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

    private Predicate[] criarRestricoes(String name, CriteriaBuilder builder, Root<Orgao> root){
        List<Predicate> predicates = new ArrayList<>();
        Join<Orgao, Endereco> estado = root.join("endereco");

        if(name != null){
            predicates.add(builder.like(root.get("nome"), "%" + name + "%"));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }

    private void adicionarRestricoesDePaginacao(TypedQuery<Orgao> query, Pageable pageable){
        int paginaAtual = pageable.getPageNumber();
        int totalDeRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalDeRegistrosPorPagina;
        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalDeRegistrosPorPagina);
    }

    private Long totalElementos(String name) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
    Root<Orgao> root = criteria.from(Orgao.class);
    Predicate[] predicates = criarRestricoes(name, builder, root);
    criteria.where(predicates);
    criteria.select(builder.count(root));
    return manager.createQuery(criteria).getSingleResult();
    }

    @Override
    public Page<Orgao> filter(String name, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Orgao> criteria = builder.createQuery(Orgao.class);
        Root<Orgao> root = criteria.from(Orgao.class);
        Predicate[] predicates = criarRestricoes(name, builder, root);
        criteria.orderBy(builder.asc(root.get("nome")));
        criteria.where(predicates);
        TypedQuery<Orgao> query = manager.createQuery(criteria);
        adicionarRestricoesDePaginacao(query, pageable);
        return new PageImpl<>(query.getResultList(), pageable, totalElementos(name));
    }

}
