package com.lpweb.lojamusical.repository.filter;

public class MusicaFiltro {

	private String nome;
    private Integer duracaoDe;
    private Integer duracaoAte;
    private Integer artistaId;
    
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getDuracaoDe() {
		return duracaoDe;
	}
	public void setDuracaoDe(Integer duracaoDe) {
		this.duracaoDe = duracaoDe;
	}
	public Integer getDuracaoAte() {
		return duracaoAte;
	}
	public void setDuracaoAte(Integer duracaoAte) {
		this.duracaoAte = duracaoAte;
	}
	public Integer getArtistaId() {
		return artistaId;
	}
	public void setArtistaId(Integer artistaId) {
		this.artistaId = artistaId;
	}
	
	@Override
	public String toString() {
		return "MusicaFiltro [nome=" + nome + ", duracaoDe=" + duracaoDe + ", duracaoAte=" + duracaoAte + ", artistaId="
				+ artistaId + "]";
	}
    
    
}
