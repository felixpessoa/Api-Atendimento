package com.example.teste.dto;

import java.io.Serializable;

import com.example.teste.domain.model.Prestador;

import lombok.Data;

@Data
public class PrestadorDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer prestadorId;
	private String nome;

	public PrestadorDto() {
		super();
	}

	public PrestadorDto(Prestador obj) {
		super();
		this.prestadorId = obj.getPrestadorId();
		this.nome = obj.getNome();
	}

}
