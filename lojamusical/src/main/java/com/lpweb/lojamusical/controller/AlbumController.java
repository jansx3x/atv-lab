package com.lpweb.lojamusical.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import com.lpweb.lojamusical.model.Musica;
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

	@SuppressWarnings("unchecked")
	@GetMapping
    public Resposta<Page<Album>> busca(AlbumFiltro filtro, Pageable page  ) {

        Page<Album> albuns = albumService.busca(filtro, page);

        return Resposta.comDadosDe(albuns);
    }
	
	@SuppressWarnings("unchecked")
	@PostMapping
    public ResponseEntity<Resposta<Album>> salva(@Valid @RequestBody Album album,
                                                      HttpServletResponse response )  {
		try {
			albumService.salva(album);

			publisher.publishEvent(new HeaderLocationEvento(this, response, album.getId() ));

			return ResponseEntity
			        .status(HttpStatus.CREATED)
			        .body(Resposta.comDadosDe(album));
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
    }
	
	@SuppressWarnings("unchecked")
	@GetMapping("/{id}")
    public Resposta<Album> buscaPor(@PathVariable Integer id) {
      Album album = albumService.buscaPor(id);
      return Resposta.comDadosDe(album );
    }
	
	@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void exclui(@PathVariable Integer id) {
		albumService.excluiPor(id);
    }
	
	@SuppressWarnings("unchecked")
	@PutMapping("/{id}")
    public ResponseEntity<Resposta<Album>> atualizar(@PathVariable Integer id,
                                                            @RequestBody Album album) {
        try {
			Album albumManager = albumService.atualiza(id, album);

			return ResponseEntity.ok(Resposta.comDadosDe(albumManager));
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
    }
	
	@SuppressWarnings("unchecked")
	@PutMapping("/{id}/adicionarArtista")
	public ResponseEntity<Resposta<Album>> adicionarArtista(@PathVariable Integer idAlbum, @PathVariable Integer idArtista) {
		try {
			Album album = albumService.adicionarArtista(idAlbum, idArtista);
			
			Album albumManager = albumService.atualiza(idAlbum, album);

			return ResponseEntity.ok(Resposta.comDadosDe(albumManager));
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/{id}/adicionarMusica")
	public ResponseEntity<Resposta<Musica>> adicionarMusica(@PathVariable Integer idAlbum, @PathVariable Integer idMusica) {
		try {
			Album album = albumService.adicionarMusica(idAlbum, idMusica);

			Album albumManager = albumService.atualiza(idAlbum, album);

			return ResponseEntity.ok(Resposta.comDadosDe(albumManager));
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
}
