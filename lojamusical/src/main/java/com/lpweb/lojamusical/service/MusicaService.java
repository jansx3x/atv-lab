package com.lpweb.lojamusical.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lpweb.lojamusical.model.Musica;
import com.lpweb.lojamusical.repository.MusicaRepository;

@Service
public class MusicaService {
	
	@SuppressWarnings("unused")
	private final MusicaRepository musicaRepository;
	
	private final GenericoService<Musica> genericoService;
	
	@Autowired
    public MusicaService(MusicaRepository musicaRepository) {
        this.musicaRepository = musicaRepository;

        genericoService = new GenericoService<>(musicaRepository);
    }
	
	@Transactional(readOnly = true)
    public List<Musica> todos() {
        return genericoService.todos();
    }

    @Transactional
    public Musica salva(Musica musica) {
        return genericoService.salva(musica);

    }

    @Transactional(readOnly = true)
    public Musica buscaPor(Integer id ) {
        return genericoService.buscaPor(id );
    }

    @Transactional
    public void excluiPor(Integer id) {
        genericoService.excluirPor(id );
    }
    
    @Transactional
    public Musica atualiza(Integer id, Musica musica) {
        return this.genericoService.atualiza(musica, id);
    }
}
