package com.lpweb.lojamusical.model;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lpweb.lojamusical.model.base.EntityBase;

@Entity
@Table(name = "artista", schema = "lojamusical")
public class Artista extends EntityBase{
	
	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty
	private String nacionalidade;
	
	@Column(name = "momento_criacao")
    private LocalDateTime momentoCriacao;
	
	@PrePersist
    private void persist() {
        this.momentoCriacao = LocalDateTime.now();
    }

	@JsonIgnore
	@ManyToMany(mappedBy = "artistas", fetch = FetchType.LAZY)			
	private Set<Album> albuns = new LinkedHashSet<>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public LocalDateTime getMomentoCriacao() {
		return momentoCriacao;
	}
	public void setMomentoCriacao(LocalDateTime momentoCriacao) {
		this.momentoCriacao = momentoCriacao;
	}
	public Set<Album> getAlbuns() {
		return albuns;
	}
	public void adiciona(Album album) {
        albuns.add(album);
    }
}
