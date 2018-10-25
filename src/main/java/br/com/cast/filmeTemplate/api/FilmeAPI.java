package br.com.cast.filmeTemplate.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.filmeTemplate.client.FilmeClient;
import br.com.cast.filmeTemplate.dto.FilmeDTO;
import br.com.cast.filmeTemplate.dto.SearchDTO;
import br.com.cast.filmeTemplate.service.FilmeService;

@RestController
@RequestMapping(path = "angularsearch")
public class FilmeAPI {
	
	@Autowired
	private FilmeClient client;
	
	@Autowired
	private FilmeService service;
	
	@RequestMapping(path = "/{titulo}" , method = RequestMethod.GET)
	public SearchDTO buscaFilmes(@PathVariable("titulo")String titulo) {
		
		SearchDTO search =  client.getFilmeTitulo(titulo);
		
		service.inserir(search);
		
		return search;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<FilmeDTO> getFilmes (){
		return service.buscarTodos();
	}
}


