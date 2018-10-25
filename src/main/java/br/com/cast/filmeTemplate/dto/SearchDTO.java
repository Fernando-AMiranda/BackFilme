package br.com.cast.filmeTemplate.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchDTO {
	
	@JsonProperty("Search")
	private List<FilmeDTO> filmes;

	public List<FilmeDTO> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<FilmeDTO> filmes) {
		this.filmes = filmes;
	}
	

}
