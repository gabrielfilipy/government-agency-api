package com.br.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.br.domain.model.Orgao;

@Repository
public interface OrgaoRepository extends JpaRepository<Orgao, Long>,
        JpaSpecificationExecutor<Orgao> {

}
