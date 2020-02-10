package com.lpweb.lojamusical.controller.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lpweb.lojamusical.model.Artista;

public class ArtistaDTO {
	
	private Integer id;
	
	@NotNull
    @Size(min = 2, max = 50)
    private String nome;
	
	@NotNull @NotEmpty
    private String nacionalidade;
	
	private DTO<Artista, ArtistaDTO> dto = new DTO<>(this);
	
	public ArtistaDTO() {}
	
	public ArtistaDTO(Artista artista) {
        this.comDadosDe(artista);
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
	
	@JsonIgnore
    public Artista getArtista() {
        return dto.getEntity(new Artista() );
    }

    public ArtistaDTO comDadosDe(Artista artista) {
        return dto.comDadosDe(artista );
    }

    public Artista atualizaIgnorandoNuloA(Artista categoria) {
        return dto.mergeIgnorandoNulo(categoria );
    }

}
