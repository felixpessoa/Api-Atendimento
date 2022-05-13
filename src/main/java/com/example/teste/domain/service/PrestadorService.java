package com.example.teste.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.teste.domain.model.Prestador;
import com.example.teste.domain.repository.PrestadorRepository;
import com.example.teste.domain.service.exceptions.ObjectNotFoundException;
import com.example.teste.dto.PrestadorDto;

@Service
public class PrestadorService {

	private PrestadorRepository prestadorRepository;

	public PrestadorService(PrestadorRepository prestadorRepository) {
		super();
		this.prestadorRepository = prestadorRepository;
	}

	public Prestador save(PrestadorDto prestadorDto) {
		Prestador prestador = fromDto(prestadorDto);
		return prestadorRepository.save(prestador);
	}

	public Prestador findById(Integer prestadorId) {
		Optional<Prestador> obj = prestadorRepository.findById(prestadorId);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! " + prestadorId + ", Tipo " + Prestador.class.getName()));
	}

	public List<Prestador> findAll() {
		return prestadorRepository.findAll();
	}

	public Prestador upDate(Integer prestadorId, PrestadorDto prestadorDto) {
		Prestador oldPrestador = findById(prestadorId);
		oldPrestador.setNome(prestadorDto.getNome());
		return prestadorRepository.save(oldPrestador);
	}

	public void delete(Integer prestadorId) {
		Prestador prestador = findById(prestadorId);
		prestadorRepository.deleteById(prestador.getPrestadorId());
	}

	private Prestador fromDto(PrestadorDto prestadorDto) {
		Prestador newPrestador = new Prestador();
		newPrestador.setPrestadorId(prestadorDto.getPrestadorId());
		newPrestador.setNome(prestadorDto.getNome());

		return newPrestador;
	}

}
