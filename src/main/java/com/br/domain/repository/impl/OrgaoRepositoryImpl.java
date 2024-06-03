package com.br.domain.repository.impl;
import com.br.domain.model.Endereco;
import com.br.domain.model.Orgao;
import com.br.domain.repository.OrgaoRepositoryQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.*;

public class OrgaoRepositoryImpl implements OrgaoRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    private Predicate[] criarRestricoes(Long endereco, CriteriaBuilder builder, Root<Orgao> root){
        List<Predicate> predicates = new ArrayList<>();
        Join<Orgao, Endereco> estado = root.join("endereco");

        if(endereco != null){
            predicates.add(builder.equal(estado.get("enderecoId"), endereco));
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

    private Long totalElementos(Long endereco){
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
    Root<Orgao> root = criteria.from(Orgao.class);
    Predicate[] predicates = criarRestricoes(endereco, builder, root);
    criteria.where(predicates);
    criteria.select(builder.count(root));
    return manager.createQuery(criteria).getSingleResult();
    }

    @Override
    public Page<Orgao> buscarOrgaoDoFiltro(Long endereco, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Orgao> criteria = builder.createQuery(Orgao.class);
        Root<Orgao> root = criteria.from(Orgao.class);
        Predicate[] predicates = criarRestricoes(endereco, builder, root);
        criteria.where(predicates);
        TypedQuery<Orgao> query = manager.createQuery(criteria);
        adicionarRestricoesDePaginacao(query, pageable);
        return new PageImpl<>(query.getResultList(), pageable, totalElementos(endereco));
    }
}
