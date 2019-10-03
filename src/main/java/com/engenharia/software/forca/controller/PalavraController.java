package com.engenharia.software.forca.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engenharia.software.forca.converter.ConverterPalavraDtoToEntity;
import com.engenharia.software.forca.domain.PalavraDTO;
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

}
