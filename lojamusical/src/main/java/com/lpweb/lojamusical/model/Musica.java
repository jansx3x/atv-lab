package com.lpweb.lojamusical.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.lpweb.lojamusical.model.base.EntityBase;

@Entity
@Table(name = "musica")
public class Musica extends EntityBase{

	private String nome;
	private Integer duracao;
	
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
