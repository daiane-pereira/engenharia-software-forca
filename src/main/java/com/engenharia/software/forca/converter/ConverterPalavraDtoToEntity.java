package com.engenharia.software.forca.converter;

import com.engenharia.software.forca.domain.PalavraDTO;
import com.engenharia.software.forca.model.Palavra;

public class ConverterPalavraDtoToEntity {

	public static Palavra converter(PalavraDTO palavraDTO) {
		return Palavra.builder()
			   .palavra(palavraDTO.getPalavra())
			   .dica(palavraDTO.getDica())
			   .categoria(palavraDTO.getCategoria())
			   .build();
	}
}
