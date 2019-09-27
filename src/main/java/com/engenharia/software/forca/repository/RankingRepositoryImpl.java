package com.engenharia.software.forca.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.engenharia.software.forca.domain.RankingDTO;
import com.engenharia.software.forca.model.Ranking;

@Repository
public class RankingRepositoryImpl {

	@PersistenceContext
	EntityManager em;

	@Autowired
	EntityManagerFactory emf;

	public List<RankingDTO> getRanking() {

		em = emf.createEntityManager();
		Session session = (Session) em.getDelegate();

		Criteria criteria = session.createCriteria(Ranking.class, "r");
		criteria.createAlias("r.rodadaJogador", "rj");
		criteria.createAlias("rj.rodada", "rodada");
		criteria.createAlias("rj.jogador", "jogador");
		criteria.createAlias("rodada.categoria", "categoria");

		ProjectionList p1 = Projections.projectionList();
		p1.add(Projections.groupProperty("jogador.nome"));
		p1.add(Projections.groupProperty("categoria.descricao"));
		p1.add(Projections.groupProperty("rodada.pontuacao"));
		criteria.setProjection(p1);

		criteria.addOrder(Order.asc("rodada.pontuacao"));
		criteria.setMaxResults(10);
		List<Object[]> list = criteria.list();

		for (int i = 0; i < list.size(); i++) {
			Object[] objects = list.get(i);
		}
		
		return null;
	}

}