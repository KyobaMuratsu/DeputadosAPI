package br.ifsul.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.entity.Deputado;
import br.ifsul.entity.Evento;

public interface DeputadoRepository extends JpaRepository<Deputado, Long> {
	
	public List<Evento> findEventoById(Long id);
	public Deputado findDeputadoById(Long id);
	
}
