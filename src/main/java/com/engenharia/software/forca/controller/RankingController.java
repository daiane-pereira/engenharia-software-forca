package com.engenharia.software.forca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engenharia.software.forca.domain.RankingDTO;
import com.engenharia.software.forca.service.RankingService;

import javassist.NotFoundException;

@RestController
@RequestMapping(value = "/ranking")
public class RankingController {
	
	@Autowired
	private RankingService rankingService;
	
	@GetMapping(value = "/get")
	public ResponseEntity<List<RankingDTO>> getRanking() throws NotFoundException {
		
		List<RankingDTO> listRankingDTO = rankingService.getRanking();
		
		if(!listRankingDTO.isEmpty()) {
			return new ResponseEntity<List<RankingDTO>>(listRankingDTO, HttpStatus.OK);
		} else {
			throw new NotFoundException("Ranking nao encontrado");
		}
	}
}
