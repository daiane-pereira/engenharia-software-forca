package com.engenharia.software.forca.converter;

import com.engenharia.software.forca.model.Jogador;

public class ConverterJogadorDtoToEntity {

	public static Jogador converter(String nomeJogador) {
		return Jogador.builder()
				.nome(nomeJogador)
				.build();
	}
}
