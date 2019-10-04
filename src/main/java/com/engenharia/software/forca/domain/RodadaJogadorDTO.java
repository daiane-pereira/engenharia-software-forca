package com.engenharia.software.forca.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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
public class RodadaJogadorDTO {
	
	@NotBlank(message = "Nome do jogador nao informado.")
	private String nome;
	
	@NotNull(message = "Pontuacao nao informada.")
	private Long pontuacao;
	
	private Categoria categoria;

}
