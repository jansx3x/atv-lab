package com.lpweb.lojamusical.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.lpweb.lojamusical.model.base.EntityBase;

@Entity
@Table(name = "album")
public class Album extends EntityBase{
	
	private String nome;
	private Integer ano;
	
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
	
	
}
