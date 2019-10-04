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

import com.engenharia.software.forca.converter.ConverterPalavraDtoToEntity;
import com.engenharia.software.forca.domain.PalavraDTO;
import com.engenharia.software.forca.model.Categoria;
import com.engenharia.software.forca.model.Palavra;
import com.engenharia.software.forca.service.PalavraService;

@RestController
@RequestMapping(value = "/palavra", produces = MediaType.APPLICATION_JSON_VALUE)
public class PalavraController {

	@Autowired
	private PalavraService palavraService;

	@PostMapping(value = "/incluir")
	public ResponseEntity<Palavra> incluirPalavra(@RequestBody @Valid PalavraDTO palavraDTO) {
		Palavra palavra = ConverterPalavraDtoToEntity.converter(palavraDTO);
		palavraService.incluirPalavra(palavra);
		return new ResponseEntity<Palavra>(palavra, HttpStatus.CREATED);
	}

	@PutMapping(value = "/alterar/{palavraId}")
	public ResponseEntity<Palavra> alterarPalavra(@PathVariable("palavraId") Long palavraId,
			@RequestBody PalavraDTO palavraDTO) {
		Palavra palavraParaAtualizacao = ConverterPalavraDtoToEntity.converter(palavraDTO);
		Optional<Palavra> palavraAtualizada = palavraService.atualizarPalavra(palavraId, palavraParaAtualizacao);

		if (!palavraAtualizada.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/remover/{palavraId}")
	public ResponseEntity<Palavra> removerPalavra(@PathVariable("palavraId") Long palavraId) {
		palavraService.removerPalavra(palavraId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(value = "/listar")
	public ResponseEntity<List<Palavra>> listarTodasPalavras() {
		List<Palavra> palavras = palavraService.listarPalavras();

		if (palavras == null || palavras.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Palavra>>(palavras, HttpStatus.OK);
	}

	@GetMapping(value = "/listar/{categoriaId}/categoria")
	public Optional<List<Palavra>> listarPalavrasPorCategoria(@PathVariable("categoriaId") Long categoriaId) {
		Optional<List<Palavra>> palavras = palavraService.listarPalavrasPorCategoria(categoriaId);
		return palavras;
	}

}
