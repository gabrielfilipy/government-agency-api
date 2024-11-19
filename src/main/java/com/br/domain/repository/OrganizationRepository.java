package com.br.domain.repository;

import com.br.domain.model.Organization;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, UUID>,
        JpaSpecificationExecutor<Organization>, OrganizationRepositoryQuery {

    @Query("SELECT org FROM Organization org WHERE org.address = :id")
    Optional<Organization> buscarOrgaoPage(@Param("id") UUID id);

}
