package com.lpweb.lojamusical.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.lpweb.lojamusical.model.base.EntityBase;

@Entity
@Table(name = "musica", schema = "lojamusical")
public class Musica extends EntityBase{

	private String nome;
	private Integer duracao;
	
	@Column(name = "momento_criacao")
    private LocalDateTime momentoCriacao;
	
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
