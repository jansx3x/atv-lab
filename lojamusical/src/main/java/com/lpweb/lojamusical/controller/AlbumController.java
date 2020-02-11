package com.lpweb.lojamusical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpweb.lojamusical.controller.response.Resposta;
import com.lpweb.lojamusical.model.Album;
import com.lpweb.lojamusical.repository.filter.AlbumFiltro;
import com.lpweb.lojamusical.service.AlbumService;

@RestController
@RequestMapping("/album")
public class AlbumController {
	
	private final AlbumService albumService;
	
	@Autowired
    private ApplicationEventPublisher publisher;
	
	@Autowired
    public AlbumController(AlbumService service) {
        this.albumService = service;
    }

	@GetMapping
    public Resposta<List<Album>> busca(AlbumFiltro filtro, Pageable page  ) {

        List<Album> albuns = albumService.todos();

        return Resposta.comDadosDe(albuns);
    }
}
