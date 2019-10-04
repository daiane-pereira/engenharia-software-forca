package com.engenharia.software.forca.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engenharia.software.forca.converter.ConverterJogadorDtoToEntity;
import com.engenharia.software.forca.converter.ConverterRodadaDtoToEntity;
import com.engenharia.software.forca.domain.RodadaJogadorDTO;
import com.engenharia.software.forca.model.Jogador;
import com.engenharia.software.forca.model.Rodada;
import com.engenharia.software.forca.model.RodadaJogador;
import com.engenharia.software.forca.service.RodadaJogadorService;

@RestController
@CrossOrigin
@RequestMapping(value = "/rodada/jogador", produces = MediaType.APPLICATION_JSON_VALUE)
public class RodadaJogadorController {
	
	@Autowired
	private RodadaJogadorService rodadaJogadorService;
	
	@PostMapping
	public ResponseEntity<RodadaJogador> incluirRodadaJogador(@RequestBody @Valid RodadaJogadorDTO rodadaJogadorDTO) throws Exception {
		Jogador jogador = ConverterJogadorDtoToEntity.converter(rodadaJogadorDTO.getNome());
		Rodada rodada = ConverterRodadaDtoToEntity.converter(rodadaJogadorDTO.getPontuacao(), 
				rodadaJogadorDTO.getCategoria());
		RodadaJogador rodadaJogador = rodadaJogadorService.salvarRodadaJogador(jogador, rodada);
		return new ResponseEntity<RodadaJogador>(rodadaJogador, HttpStatus.OK);
	}

}
