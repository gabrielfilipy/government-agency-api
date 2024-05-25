package com.br.domain.service;

import java.util.List;
import com.br.domain.model.Estado;

public interface EstadoService {

	List<Estado> findAll();
	Estado findById(Long id);
	Estado salvar(Estado estado);
}
