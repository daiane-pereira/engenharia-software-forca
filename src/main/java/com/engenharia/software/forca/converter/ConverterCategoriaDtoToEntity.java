package com.engenharia.software.forca.converter;

import com.engenharia.software.forca.domain.CategoriaDTO;
import com.engenharia.software.forca.model.Categoria;

public class ConverterCategoriaDtoToEntity {
	
	public static Categoria converter(CategoriaDTO categoriaDTO) {
		return Categoria.builder()
				.descricao(categoriaDTO.getDescricao())
				.build();
	}

}
