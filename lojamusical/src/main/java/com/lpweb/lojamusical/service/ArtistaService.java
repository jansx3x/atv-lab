package com.lpweb.lojamusical.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lpweb.lojamusical.model.Artista;
import com.lpweb.lojamusical.repository.ArtistaRepository;

@Service
public class ArtistaService {
	
	@SuppressWarnings("unused")
	private final ArtistaRepository artistaRepository;
	
	private final GenericoService<Artista> genericoService;
	
	@Autowired
    public ArtistaService(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;

        genericoService = new GenericoService<>(artistaRepository);
    }
	

    @Transactional(readOnly = true)
    public List<Artista> todos() {
        return genericoService.todos();
    }

    @Transactional
    public Artista salva(Artista artista) {
        return genericoService.salva(artista);

    }

    @Transactional(readOnly = true)
    public Artista buscaPor(Integer id ) {
        return genericoService.buscaPor(id );
    }

    @Transactional
    public void excluiPor(Integer id) {
        genericoService.excluirPor(id );
    }
    
    @Transactional
    public Artista atualiza(Integer id, Artista artista) {
        return this.genericoService.atualiza(artista, id);
    }
}
