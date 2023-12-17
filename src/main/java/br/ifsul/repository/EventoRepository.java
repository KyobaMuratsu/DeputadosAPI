package br.ifsul.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.entity.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
	
	
}
