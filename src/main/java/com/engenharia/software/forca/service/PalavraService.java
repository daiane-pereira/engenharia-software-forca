package com.engenharia.software.forca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engenharia.software.forca.model.Categoria;
import com.engenharia.software.forca.model.Palavra;
import com.engenharia.software.forca.repository.CategoriaRepository;
import com.engenharia.software.forca.repository.PalavraRepository;

@Service
public class PalavraService {
	
	@Autowired
	private PalavraRepository palavraRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Palavra incluirPalavra(Palavra palavra) {
		return palavraRepository.save(palavra);
	}
	
	public Optional<Palavra> atualizarPalavra(Long palavraId, Palavra palavraParaAtualizacao) {
		return palavraRepository.findById(palavraId).map(palavra -> {
			palavra.setPalavra(palavraParaAtualizacao.getPalavra());
			palavra.setDica(palavraParaAtualizacao.getDica());
			palavra.setCategoria(palavraParaAtualizacao.getCategoria());
			return palavraRepository.save(palavra);
		});
	}
	
	public void removerPalavra(Long palavraId) {
		palavraRepository.deleteById(palavraId);
	}
	
	public List<Palavra> listarPalavras() {
		return palavraRepository.findAll();
	}
	
	public Optional<List<Palavra>> listarPalavrasPorCategoria(Long categoriaId) {
		return categoriaRepository.findById(categoriaId).map(categoria -> {
			return palavraRepository.findByCategoria(categoria);
		});
	}

}
