package com.lpweb.lojamusical.model;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lpweb.lojamusical.model.base.EntityBase;

@Entity
@Table(name = "album", schema = "lojamusical")
public class Album extends EntityBase{
	
	@NotNull
	private String nome;
	@NotNull
	private Integer ano;
	
	@Column(name = "momento_criacao")
    private LocalDateTime momentoCriacao;
	
	@ManyToMany
    @JoinTable(name = "album_artista",
               joinColumns = @JoinColumn(name = "album_id"),
               inverseJoinColumns = @JoinColumn(name = "artista_id")    )
    private Set<Artista> artistas = new LinkedHashSet<>();
	
	@PrePersist
    private void persist() {
        this.momentoCriacao = LocalDateTime.now();
    }
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public LocalDateTime getMomentoCriacao() {
		return momentoCriacao;
	}

	public void setMomentoCriacao(LocalDateTime momentoCriacao) {
		this.momentoCriacao = momentoCriacao;
	}

	public Set<Artista> getArtistas() {
		return artistas;
	}

	public void setArtistas(Set<Artista> artistas) {
		this.artistas = artistas;
	}

	public void adiciona(Artista artista) {
        artistas.add(artista);
    }
	
	
}
