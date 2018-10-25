package br.com.cast.filmeTemplate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.filmeTemplate.dto.FilmeDTO;
import br.com.cast.filmeTemplate.dto.SearchDTO;
import br.com.cast.filmeTemplate.entity.Filme;
import br.com.cast.filmeTemplate.repository.FilmeRepository;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepository repo;
	
	public SearchDTO inserir (SearchDTO filmes) {
		
		for(FilmeDTO f : filmes.getFilmes()) {
			Filme filmeInserir = repo.buscarPorImdbid(f.getImdbID());
			if(filmeInserir == null) {
				Filme entity = convertForFilme(f);
				repo.inserir(entity);
			}
		}
		return filmes;
	}
	
	public List<FilmeDTO> buscarTodos (){
		
		List<Filme> filmes = repo.buscarTodos();
		List<FilmeDTO> filmesdto = new ArrayList<>();
		
		for (Filme f : filmes) {
			
			FilmeDTO reposta = convertForFilmeDTO(f);
			filmesdto.add(reposta);
		}
		
		return filmesdto;
	}
	
	public Filme convertForFilme(FilmeDTO dto) {
		
		Filme entity = new Filme();
		
		entity.setImdbID(dto.getImdbID());
		entity.setPoster(dto.getPoster());
		entity.setTitle(dto.getTitle());
		entity.setYear(dto.getYear());
		
		return entity;
		
	}
	public FilmeDTO convertForFilmeDTO(Filme entity) {
		
		FilmeDTO dto = new FilmeDTO();
		
		dto.setImdbID(entity.getImdbID());
		dto.setPoster(entity.getPoster());
		dto.setTitle(entity.getTitle());
		dto.setYear(entity.getYear());
		
		return dto;
		
	}
}
