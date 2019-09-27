package com.engenharia.software.forca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engenharia.software.forca.model.Categoria;
import com.engenharia.software.forca.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria incluirCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	public Optional<Categoria> atualizarCategoria(Long categoriaId, Categoria categoriaParaAtualizacao) {
		return categoriaRepository.findById(categoriaId).map(categoria -> {
			categoria.setDescricao(categoriaParaAtualizacao.getDescricao());
			return categoriaRepository.save(categoria);
		});
	}
	
	public void removerCategoria(Long categoriaId) {
		categoriaRepository.deleteById(categoriaId);
	}
	
	public List<Categoria> listarCategorias() {
		return categoriaRepository.findAll();
	}

}
