package com.engenharia.software.forca.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.engenharia.software.forca.model.Categoria;
import com.engenharia.software.forca.model.Palavra;

@Repository
public interface PalavraRepository extends CrudRepository<Palavra, Long>{
	
	Palavra findByCategoriaId(Long categoriaId);
	
	List<Palavra> findAll();
	
	List<Palavra> findByCategoria(Categoria categoria);

}
