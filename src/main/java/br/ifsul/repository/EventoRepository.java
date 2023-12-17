package br.ifsul.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.entity.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}
