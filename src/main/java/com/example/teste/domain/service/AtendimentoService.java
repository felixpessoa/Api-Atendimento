package com.example.teste.domain.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.teste.domain.model.Atendimento;
import com.example.teste.domain.model.Prestador;
import com.example.teste.domain.repository.AtendimentoRepository;
import com.example.teste.domain.service.exceptions.ObjectNotFoundException;
import com.example.teste.dto.AtendimentoDto;

@Service
public class AtendimentoService {
		
		private AtendimentoRepository atendimentoRepository;
		private PrestadorService prestadorService;
		
		public AtendimentoService(AtendimentoRepository atendimentoRepository, PrestadorService prestadorService) {
			super();
			this.atendimentoRepository = atendimentoRepository;
			this.prestadorService = prestadorService;
		}

		public Atendimento save(AtendimentoDto atendimentoDto) {
			Atendimento atendimento = fromDto(atendimentoDto);
			atendimento.setDataCriacao(LocalDateTime.now());
			return atendimentoRepository.save(atendimento);
		}
		
		public Atendimento findById(Integer atendimentoId) {
			Optional<Atendimento> obj = atendimentoRepository.findById(atendimentoId);
			return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado! " + atendimentoId + ", Tipo "+ Atendimento.class.getName()));
		}
		
		public List<Atendimento> findAll(){
			return atendimentoRepository.findAll();
		}
		
		public Atendimento upDate(AtendimentoDto atendimentoDto) {
			Atendimento atendimento = fromDto(atendimentoDto);
			return atendimentoRepository.save(atendimento);
		}
		
		
		private Atendimento fromDto(AtendimentoDto atendimentoDto) {
			Atendimento newAtendimento = new Atendimento();
			newAtendimento.setAtendimentoId(atendimentoDto.getAtendimentoId());
			Prestador prestador = prestadorService.findById(atendimentoDto.getPrestador());
			newAtendimento.setPrestador(prestador);
			return newAtendimento;
		}
}
