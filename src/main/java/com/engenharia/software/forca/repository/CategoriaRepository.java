package com.engenharia.software.forca.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.engenharia.software.forca.model.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
	
	List<Categoria> findAll();

}
