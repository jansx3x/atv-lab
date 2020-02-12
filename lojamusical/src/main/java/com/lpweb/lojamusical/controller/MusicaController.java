package com.lpweb.lojamusical.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lpweb.lojamusical.controller.event.HeaderLocationEvento;
import com.lpweb.lojamusical.controller.response.Resposta;
import com.lpweb.lojamusical.model.Musica;
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
	
	@SuppressWarnings("unchecked")
	@GetMapping
    public Resposta<List<Musica>> busca() {

        List<Musica> musicas = musicaService.todos();

        return Resposta.comDadosDe(musicas);
    }
	
	@SuppressWarnings("unchecked")
	@PostMapping
    public ResponseEntity<Resposta<Musica>> salva(@Valid @RequestBody Musica musica,
                                                      HttpServletResponse response )  {
		musicaService.salva(musica);

        publisher.publishEvent(new HeaderLocationEvento(this, response, musica.getId() ));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Resposta.comDadosDe(musica));
    }
	
	@SuppressWarnings("unchecked")
	@GetMapping("/{id}")
    public Resposta<Musica> buscaPor(@PathVariable Integer id) {
      Musica musica = musicaService.buscaPor(id);
      return Resposta.comDadosDe(musica );
    }
	
	@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void exclui(@PathVariable Integer id) {
		musicaService.excluiPor(id);
    }
	
	@SuppressWarnings("unchecked")
	@PutMapping("/{id}")
    public ResponseEntity<Resposta<Musica>> atualizar(@PathVariable Integer id,
                                                            @RequestBody Musica musica) {

        Musica musicaManager = musicaService.atualiza(id, musica);

        return ResponseEntity.ok(Resposta.comDadosDe(musicaManager));
    }
}
