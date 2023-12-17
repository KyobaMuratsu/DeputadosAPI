package br.ifsul.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.entity.Deputado;

public interface DeputadoRepository extends JpaRepository<Deputado, Long> {

}
