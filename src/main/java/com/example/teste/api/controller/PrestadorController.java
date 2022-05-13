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

import com.example.teste.domain.service.PrestadorService;
import com.example.teste.dto.PrestadorDto;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/prestador")
public class PrestadorController {

	private PrestadorService prestadorService;

	public PrestadorController(PrestadorService prestadorService) {
		super();
		this.prestadorService = prestadorService;
	}

	@PostMapping
	public ResponseEntity<PrestadorDto> create(@RequestBody PrestadorDto prestadorDto) {
		prestadorDto = new PrestadorDto(prestadorService.save(prestadorDto));
		return ResponseEntity.status(HttpStatus.CREATED).body(prestadorDto);
	}
	
	@GetMapping
	public ResponseEntity<List<PrestadorDto>> findAll(){
		List<PrestadorDto> list = prestadorService.findAll().stream()
				.map(obj -> new PrestadorDto(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{prestadorId}")
	public ResponseEntity<PrestadorDto> findById(@PathVariable Integer prestadorId){
		PrestadorDto obj = new PrestadorDto(prestadorService.findById(prestadorId));
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping(value = "/{prestadorId}")
	public ResponseEntity<PrestadorDto> update(@PathVariable Integer prestadorId, @Valid @RequestBody PrestadorDto prestadorDto){
		PrestadorDto newObj = new PrestadorDto(prestadorService.upDate(prestadorId, prestadorDto));
		return ResponseEntity.ok().body(newObj);
	}


}
