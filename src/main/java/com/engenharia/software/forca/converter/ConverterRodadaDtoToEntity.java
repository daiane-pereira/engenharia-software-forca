package com.engenharia.software.forca.converter;

import com.engenharia.software.forca.model.Categoria;
import com.engenharia.software.forca.model.Rodada;

public class ConverterRodadaDtoToEntity {
	
	public static Rodada converter(Long pontuacao, Categoria categoria) {
		return Rodada.builder()
				.pontuacao(pontuacao)
				.categoria(categoria)
				.build();
	}

}
