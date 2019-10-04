package com.engenharia.software.forca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.engenharia.software.forca.model.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {

}
