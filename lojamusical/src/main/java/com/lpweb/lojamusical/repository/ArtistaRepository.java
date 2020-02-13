package com.lpweb.lojamusical.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lpweb.lojamusical.model.Artista;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Integer>{

	List<Artista> findByNomeContainingOrderByNome(String nome);
	
	List<Artista> findByNacionalidade(String nacionalidade);
}
