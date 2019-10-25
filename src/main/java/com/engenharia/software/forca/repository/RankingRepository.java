package com.engenharia.software.forca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.engenharia.software.forca.domain.RodadaJogadorDTO;
import com.engenharia.software.forca.model.Ranking;
import org.springframework.stereotype.Repository;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, Long>{
	
	@Query(
			value = "SELECT j.nome as jogador, c.descricao as categoria, r.pontuacao as pontuacao "+
					"FROM forca_db.ranking rk " + 
					"INNER JOIN forca_db.rodada_jogador rj ON rk.rodada_jogador_id = rj.id " + 
					"INNER JOIN forca_db.jogador j ON rj.jogador_id = j.id " + 
					"INNER JOIN forca_db.rodada r ON rj.rodada_id = r.id " + 
					"INNER JOIN forca_db.categoria c ON r.categoria_id = c.id " + 
					"ORDER BY r.pontuacao DESC " + 
					"LIMIT 10",
			nativeQuery = true)
	List<Object> listarRanking();

}
