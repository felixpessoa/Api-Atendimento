package com.example.teste.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.example.teste.domain.model.Atendimento;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class AtendimentoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer atendimentoId;
	private Integer prestador;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataCriacao;
	
	public AtendimentoDto() {
		super();
	}
	
	public AtendimentoDto (Atendimento obj) {
		super();
		this.atendimentoId = obj.getAtendimentoId();
		this.prestador = obj.getPrestador().getPrestadorId();
		this.dataCriacao = obj.getDataCriacao();
	}



	

	
}
