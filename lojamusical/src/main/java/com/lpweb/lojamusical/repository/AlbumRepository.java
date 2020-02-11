package com.lpweb.lojamusical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lpweb.lojamusical.model.Album;
import com.lpweb.lojamusical.repository.album.AlbumRepositoryQuery;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer>, AlbumRepositoryQuery{

}
