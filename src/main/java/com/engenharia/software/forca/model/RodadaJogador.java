package com.engenharia.software.forca.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RodadaJogador implements Serializable {

	private static final long serialVersionUID = -7365424044261125207L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "rodada_id")
	private Rodada rodada;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "jogador_id")
	private Jogador jogador;

}
