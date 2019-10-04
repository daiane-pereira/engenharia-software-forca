package com.engenharia.software.forca.converter;

import com.engenharia.software.forca.model.Ranking;
import com.engenharia.software.forca.model.RodadaJogador;

public class CriarObjetoRanking {
	
	public static Ranking criar(RodadaJogador rodadaJogador) {
		return Ranking.builder()
				.rodadaJogador(rodadaJogador)
				.build();
	}

}
