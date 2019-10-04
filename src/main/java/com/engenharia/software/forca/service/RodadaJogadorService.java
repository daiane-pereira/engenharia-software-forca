package com.engenharia.software.forca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engenharia.software.forca.converter.CriarObjetoRanking;
import com.engenharia.software.forca.converter.CriarObjetoRodadaJogador;
import com.engenharia.software.forca.model.Jogador;
import com.engenharia.software.forca.model.Rodada;
import com.engenharia.software.forca.model.RodadaJogador;
import com.engenharia.software.forca.repository.JogadorRepository;
import com.engenharia.software.forca.repository.RankingRepository;
import com.engenharia.software.forca.repository.RodadaJogadorRepository;
import com.engenharia.software.forca.repository.RodadaRepository;

@Service
public class RodadaJogadorService {

	@Autowired
	private JogadorRepository jogadorRepository;

	@Autowired
	private RodadaRepository rodadaRepository;

	@Autowired
	private RodadaJogadorRepository rodadaJogadorRepository;

	@Autowired
	private RankingRepository rankingRepository;

	public RodadaJogador salvarRodadaJogador(Jogador jogador, Rodada rodada) throws Exception {
		try {
			jogadorRepository.saveAndFlush(jogador);
			rodadaRepository.saveAndFlush(rodada);
			RodadaJogador rodadaJogador = rodadaJogadorRepository
					.saveAndFlush(CriarObjetoRodadaJogador.criar(jogador, rodada));
			rankingRepository.saveAndFlush(CriarObjetoRanking.criar(rodadaJogador));
			return rodadaJogador;
		} catch (Exception erro) {
			throw new Exception(erro.getMessage());
		}
	}

}
