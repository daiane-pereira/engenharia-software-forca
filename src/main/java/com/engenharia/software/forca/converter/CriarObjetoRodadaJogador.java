package com.engenharia.software.forca.converter;

import com.engenharia.software.forca.model.Jogador;
import com.engenharia.software.forca.model.Rodada;
import com.engenharia.software.forca.model.RodadaJogador;

public class CriarObjetoRodadaJogador {
	
	public static RodadaJogador criar(Jogador jogador, Rodada rodada) {
		return RodadaJogador.builder()
				.jogador(jogador)
				.rodada(rodada)
				.build();
	}

}
