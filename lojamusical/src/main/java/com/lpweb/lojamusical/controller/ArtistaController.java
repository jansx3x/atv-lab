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
import com.lpweb.lojamusical.model.Album;
import com.lpweb.lojamusical.model.Artista;
import com.lpweb.lojamusical.service.ArtistaService;

@RestController
@RequestMapping("/artista")
public class ArtistaController {

	private final ArtistaService service;
	
	@Autowired
    private ApplicationEventPublisher publisher;
	
	@Autowired
    public ArtistaController(ArtistaService service) {
        this.service = service;
    }
	
	@SuppressWarnings("unchecked")
	@GetMapping
	public Resposta<List<Artista>> lista() {
		List<Artista> artistas = service.todos();
		return Resposta.comDadosDe(artistas);
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping
    public ResponseEntity<Resposta<Artista>> salva(@Valid @RequestBody Artista artista,
                                                      HttpServletResponse response )  {
		try {
			service.salva(artista);

			publisher.publishEvent(new HeaderLocationEvento(this, response, artista.getId() ));

			return ResponseEntity
			        .status(HttpStatus.CREATED)
			        .body(Resposta.comDadosDe(artista));
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
    }
	
	@SuppressWarnings("unchecked")
	@GetMapping("/{id}")
    public Resposta<Artista> buscaPor(@PathVariable Integer id) {
      Artista artista = service.buscaPor(id);
      return Resposta.comDadosDe(artista );
    }
	
	@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void exclui(@PathVariable Integer id) {
        service.excluiPor(id);
    }
	
	@SuppressWarnings("unchecked")
	@PutMapping("/{id}")
    public ResponseEntity<Resposta<Artista>> atualizar(@PathVariable Integer id,
                                                            @RequestBody Artista artista) {
        try {
			Artista artistaManager = service.atualiza(id, artista);

			return ResponseEntity.ok(Resposta.comDadosDe(artistaManager));
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
    }
	
	@SuppressWarnings("unchecked")
	@GetMapping("/{id}/albuns")
	public ResponseEntity<Resposta<Album>> listarAlbuns(@PathVariable Integer id, HttpServletResponse response) {
		try {
			Artista artista = service.buscaPor(id);
			
			if(!artista.getAlbuns().isEmpty()) {
				return ResponseEntity.ok(Resposta.comDadosDe(artista.getAlbuns()));
			}
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
