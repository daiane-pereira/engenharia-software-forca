package com.engenharia.software.forca.converter;

import com.engenharia.software.forca.domain.CategoriaDTO;
import com.engenharia.software.forca.model.Categoria;

public class ConverterCategoriaEntityToDto {
	
	public static CategoriaDTO converter(Categoria categoria) {
		return CategoriaDTO.builder()
				.descricao(categoria.getDescricao())
				.build();
	}

}
