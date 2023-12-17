package br.ifsul.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.entity.LocalCamara;

public interface LocalCamaraRepository extends JpaRepository<LocalCamara, Long> {

}
