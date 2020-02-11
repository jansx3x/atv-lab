package com.lpweb.lojamusical.controller;

import java.util.List;
import java.util.Objects;

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
import com.lpweb.lojamusical.controller.response.Erro;
import com.lpweb.lojamusical.controller.response.Resposta;
import com.lpweb.lojamusical.controller.validation.Validacao;
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
	
	@GetMapping
	public Resposta<List<Artista>> lista() {
		List<Artista> artistas = service.todos();
		return Resposta.comDadosDe(artistas);
	}
	
	@PostMapping
    public ResponseEntity<Resposta<Artista>> salva(@Valid @RequestBody Artista artista,
                                                      HttpServletResponse response )  {
		service.salva(artista);

        publisher.publishEvent(new HeaderLocationEvento(this, response, artista.getId() ));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Resposta.comDadosDe(artista));
    }
	
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
	
	@PutMapping("/{id}")
    public ResponseEntity<Resposta<Artista>> atualizar(@PathVariable Integer id,
                                                            @RequestBody Artista artista) {

        Artista artistaManager = service.atualiza(id, artista);

        return ResponseEntity.ok(Resposta.comDadosDe(artistaManager));
    }
	
	private boolean existe(List<Erro> erros) {
        return Objects.nonNull( erros ) &&  !erros.isEmpty();
    }

    private List<Erro> getErros(Artista artista) {
        Validacao<Artista> validacao = new Validacao<>();
        return validacao.valida(artista);
    }
    
}
