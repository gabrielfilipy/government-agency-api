package com.br.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.br.domain.model.Orgao;
import java.util.Optional;

@Repository
public interface OrgaoRepository extends JpaRepository<Orgao, Long>,
        JpaSpecificationExecutor<Orgao>, OrgaoRepositoryQuery {

    @Query("SELECT m FROM Orgao m WHERE m.endereco = :endereco")
    Optional<Orgao> buscarOrgaoPage(@Param("endereco") Long endereco);

}
