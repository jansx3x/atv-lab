package com.lpweb.lojamusical.repository.filter;

public class AlbumFiltro {

	private String nome;
    private Integer ano;
    private Integer artistaId;
    
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
	public Integer getArtistaId() {
		return artistaId;
	}
	public void setArtistaId(Integer artistaId) {
		this.artistaId = artistaId;
	}
	
}
