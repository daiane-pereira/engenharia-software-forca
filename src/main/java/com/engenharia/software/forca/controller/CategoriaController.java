package com.engenharia.software.forca.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engenharia.software.forca.converter.ConverterCategoriaDtoToEntity;
import com.engenharia.software.forca.converter.ConverterCategoriaEntityToDto;
import com.engenharia.software.forca.domain.CategoriaDTO;
import com.engenharia.software.forca.model.Categoria;
import com.engenharia.software.forca.service.CategoriaService;

@RestController
@RequestMapping(value = "/categoria", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@PostMapping(value = "/incluir")
	public ResponseEntity<Categoria> incluirCategoria(@RequestBody @Valid CategoriaDTO categoriaDTO) {
		Categoria categoria = ConverterCategoriaDtoToEntity.converter(categoriaDTO);
		categoriaService.incluirCategoria(categoria);
		return new ResponseEntity<>(categoria, HttpStatus.CREATED);
	}

	@PutMapping(value = "/alterar/{categoriaId}")
	public ResponseEntity<Categoria> alterarCategoria(@PathVariable("categoriaId") Long categoriaId,
			@RequestBody CategoriaDTO categoriaDTO) throws Exception {
		Categoria categoriaParaAtualizacao = ConverterCategoriaDtoToEntity.converter(categoriaDTO);
		Optional<Categoria> categoriaAtualizada = categoriaService.atualizarCategoria(categoriaId, categoriaParaAtualizacao);

		if (!categoriaAtualizada.isPresent()) {	
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/remover/{categoriaId}")
	public ResponseEntity<Categoria> removerCategoria(@PathVariable("categoriaId") Long categoriaId) {
		categoriaService.removerCategoria(categoriaId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/listar")
	public ResponseEntity<List<Categoria>> listarCategorias() {
		List<Categoria> categorias = categoriaService.listarCategorias();
		
		if(categorias == null || categorias.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Categoria>>(categorias, HttpStatus.OK);
	}

}
