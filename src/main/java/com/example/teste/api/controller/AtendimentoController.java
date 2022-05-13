package com.example.teste.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.teste.domain.service.AtendimentoService;
import com.example.teste.dto.AtendimentoDto;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/atendimento")
public class AtendimentoController {

	private AtendimentoService atendimentoService;

	public AtendimentoController(AtendimentoService atendimentoService) {
		super();
		this.atendimentoService = atendimentoService;
	}

	@PostMapping
	public ResponseEntity<AtendimentoDto> create(@RequestBody AtendimentoDto atendimentoDto) {
		atendimentoDto = new AtendimentoDto(atendimentoService.save(atendimentoDto));
		return ResponseEntity.status(HttpStatus.CREATED).body(atendimentoDto);
	}
	
	@GetMapping
	public ResponseEntity<List<AtendimentoDto>> findAll(){
		List<AtendimentoDto> list = atendimentoService.findAll().stream()
				.map(obj -> new AtendimentoDto(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{atendimentoId}")
	public ResponseEntity<AtendimentoDto> findById(@PathVariable Integer atendimentoId){
		AtendimentoDto obj = new AtendimentoDto(atendimentoService.findById(atendimentoId));
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping
	public ResponseEntity<AtendimentoDto> update(@Valid @RequestBody AtendimentoDto atendimentoDto){
		atendimentoDto = new AtendimentoDto(atendimentoService.upDate(atendimentoDto));
		return ResponseEntity.ok().body(atendimentoDto);
	}
	

}
