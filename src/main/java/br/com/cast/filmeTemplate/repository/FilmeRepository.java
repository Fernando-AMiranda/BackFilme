package br.com.cast.filmeTemplate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.filmeTemplate.entity.Filme;

@Repository
public class FilmeRepository {
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public void inserir (Filme filme) {
		em.persist(filme);
	}
	
	@SuppressWarnings("unchecked")
	public List<Filme> buscarTodos (){
		return em.createQuery("from " + Filme.class.getName())
				.getResultList();
	}
	public Filme buscarPorImdbid(String imdbid) {
		return em.find(Filme.class, imdbid);
	}
	
	
}
