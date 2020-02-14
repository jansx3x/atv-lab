package com.lpweb.lojamusical.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lpweb.lojamusical.model.Album;
import com.lpweb.lojamusical.repository.album.AlbumRepositoryQuery;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer>, AlbumRepositoryQuery{

//	@Query("select a.nome, a.ano, ar.nome from album_artista aa left join album a on "
//			+ "aa.album_id = a.id left join lojamusical.artista ar on aa.artista_id = ar.id"
//			+ "where ar.id = ?1")
//	List<Album> pesquisarAlbuns(Integer id);
}
