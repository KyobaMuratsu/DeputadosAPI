package br.ifsul.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Deputado {

	@Id
	private Long id;
	
	private String uri;
	private String nome;
	private String siglaPartido;
	private String uriPartido;
	private String siglaUf;
	private String idLegislatura;
	private String urlFoto;
	private String email;
	
}
