package com.engenharia.software.forca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.engenharia.software.forca.model.Rodada;

@Repository
public interface RodadaRepository extends JpaRepository<Rodada, Long> {

}
