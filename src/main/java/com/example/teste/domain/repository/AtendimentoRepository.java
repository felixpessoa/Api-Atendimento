package com.example.teste.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.teste.domain.model.Atendimento;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Integer>{

}
