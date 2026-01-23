package com.br.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.domain.model.State;

public interface StateRepository extends JpaRepository<State, UUID>{

}
