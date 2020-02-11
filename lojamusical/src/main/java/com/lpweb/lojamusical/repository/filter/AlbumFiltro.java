package com.lpweb.lojamusical.repository.filter;

import java.util.List;

public class AlbumFiltro {

	private String nome;
    private Integer ano;
    private List<Integer> artistaId;
    
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
	public List<Integer> getArtistaId() {
		return artistaId;
	}
	public void setArtistaId(List<Integer> artistaId) {
		this.artistaId = artistaId;
	}
	public void adiciona(Integer artistaId) {
		this.artistaId.add(artistaId);
	}
}
