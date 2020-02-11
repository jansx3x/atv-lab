package com.lpweb.lojamusical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpweb.lojamusical.service.MusicaService;

@RestController
@RequestMapping("/musica")
public class MusicaController {
	
	private final MusicaService musicaService;
	
	@Autowired
    private ApplicationEventPublisher publisher;
	
	@Autowired
    public MusicaController(MusicaService service) {
        this.musicaService = service;
    }
}
