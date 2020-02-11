package com.lpweb.lojamusical.repository.album;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lpweb.lojamusical.model.Album;
import com.lpweb.lojamusical.repository.filter.AlbumFiltro;

public interface AlbumRepositoryQuery {
	
	Page<Album> filtrar(AlbumFiltro filtro, Pageable pageable);

}
