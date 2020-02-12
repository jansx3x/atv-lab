package com.lpweb.lojamusical.service;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lpweb.lojamusical.model.Album;
import com.lpweb.lojamusical.model.Artista;
import com.lpweb.lojamusical.repository.AlbumRepository;
import com.lpweb.lojamusical.repository.filter.AlbumFiltro;

@Service
public class AlbumService {
	
	private final AlbumRepository albumRepository;
	
 	@Autowired
    private ArtistaService artistaService;
	
	private final GenericoService<Album> genericoService; 

	@Autowired
    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;

        genericoService = new GenericoService<>(albumRepository);
    }
	
	@Transactional(readOnly = true)
    public List<Album> todos() {
        return genericoService.todos();
    }

    @Transactional
    public Album salva(Album album) {
        return genericoService.salva(album);

    }

    @Transactional(readOnly = true)
    public Album buscaPor(Integer id ) {
        return genericoService.buscaPor(id );
    }

    @Transactional
    public void excluiPor(Integer id) {
        genericoService.excluirPor(id );
    }
    
    @Transactional
    public Album atualiza(Integer id, Album album) {
        return this.genericoService.atualiza(album, id);
    }
    
    @Transactional(readOnly = true)
    public Page<Album> busca(AlbumFiltro filtro, Pageable pageable) {
        return albumRepository.filtrar(filtro, pageable );
    }
    
    @SuppressWarnings("unused")
	private void validaArtistas(Set<Artista> artistas) {
        if (artistas !=null && !artistas.isEmpty() )
            artistas.forEach(this::accept);
    }
    
    private void accept(Artista a) {
        Objects.requireNonNull(a, "A categoria não pode ser nula");
        Integer id = Objects.requireNonNull(a.getId(), "O id da categoria não pode ser nulo");
        a = artistaService.buscaPor(id );
    }
}
