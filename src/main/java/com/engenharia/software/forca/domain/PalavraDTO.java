package com.engenharia.software.forca.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.engenharia.software.forca.model.Categoria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PalavraDTO {
	
	@NotBlank(message = "Palavra nao informada.")
	private String palavra;
	
	@NotBlank(message = "Dica nao informada.")
	private String dica;
	
	@NotNull(message = "Categoria nao informada.")
	private Categoria categoria;
	
}
