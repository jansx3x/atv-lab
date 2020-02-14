package com.lpweb.lojamusical.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.lpweb.lojamusical.model.base.EntityBase;

@Entity
@Table(name = "musica", schema = "lojamusical")
public class Musica extends EntityBase{

	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty
	private Integer duracao;
	
	@Column(name = "momento_criacao")
    private LocalDateTime momentoCriacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="album_id")
	private Album album;
	
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
	public Integer getDuracao() {
		return duracao;
	}
	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}
	
	
}
