package com.lpweb.lojamusical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lpweb.lojamusical.model.Musica;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Integer>{

}
