package br.com.cast.filmeTemplate.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.cast.filmeTemplate.dto.FilmeDTO;
import br.com.cast.filmeTemplate.dto.SearchDTO;

@Component
public class FilmeClient {
	

	private final static String FILME_TITULO = "http://www.omdbapi.com/?s={titulo}&apikey={apikeyuser}";
	private final static String FILME_IMDBCID= "http://www.omdbapi.com/?i={idmbid}&apikey={apikeyuser}";
	
	private static String apikeyuser = "937e64";
	
	private RestTemplate rest;
	
	public FilmeClient(RestTemplateBuilder builder) {
		this.rest = builder.build();
	}
	
	public SearchDTO getFilmeTitulo (String title) {
		return this.rest.getForObject(FILME_TITULO, SearchDTO.class,title,apikeyuser);
	}
	
	public FilmeDTO getFilmeImdbID (String imdbid) {
		return this.rest.getForObject(FILME_IMDBCID, FilmeDTO.class,imdbid,apikeyuser);
	}

}
