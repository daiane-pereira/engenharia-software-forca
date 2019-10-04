package com.engenharia.software.forca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engenharia.software.forca.domain.RodadaJogadorDTO;
import com.engenharia.software.forca.repository.RankingRepository;

@Service
public class RankingService {
	
	@Autowired
	private RankingRepository rankingRepository;
	
	public List<Object> listarRanking() {
		return rankingRepository.listarRanking();
	}

}
