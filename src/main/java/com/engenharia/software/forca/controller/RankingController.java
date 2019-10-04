package com.engenharia.software.forca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engenharia.software.forca.domain.RodadaJogadorDTO;
import com.engenharia.software.forca.service.RankingService;

import javassist.NotFoundException;

@RestController
@CrossOrigin
@RequestMapping(value = "/ranking")
public class RankingController {
	
	@Autowired
	private RankingService rankingService;
	
	@GetMapping(value = "/listar")
	public ResponseEntity<List<Object>> getRanking() throws NotFoundException {
		
		List<Object> listRankingDTO = rankingService.listarRanking();
		return new ResponseEntity<List<Object>>(listRankingDTO, HttpStatus.OK);
	}
}
