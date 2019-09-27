package com.engenharia.software.forca.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RankingDTO {
	
	@NotBlank(message = "Jogador nao informado.")
	private String jogador;
	
	@NotBlank(message = "Categoria nao informada.")
	private String categoria;
	
	@NotNull(message = "Pontuacao nao informada.")
	private Integer pontuacao;

}
