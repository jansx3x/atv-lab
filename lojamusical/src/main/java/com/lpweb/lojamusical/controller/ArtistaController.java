package com.lpweb.lojamusical.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpweb.lojamusical.controller.dto.ArtistaDTO;
import com.lpweb.lojamusical.controller.response.Resposta;
import com.lpweb.lojamusical.service.ArtistaService;

@RestController
@RequestMapping("/artista")
public class ArtistaController {

	private final ArtistaService artistaService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	public ArtistaController(ArtistaService artistaService) {
		this.artistaService = artistaService;
	}
	
	@GetMapping
    public Resposta<List<ArtistaDTO>> todas() {
        List<ArtistaDTO> artistasDTO = artistaService.todas()
                                   .stream()
                                   .map(artista -> new ArtistaDTO(artista))
                                   .collect(Collectors.toList());

        return Resposta.comDadosDe(artistasDTO);
    }
}
