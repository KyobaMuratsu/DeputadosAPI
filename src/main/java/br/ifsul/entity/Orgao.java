package br.ifsul.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Orgao {
	
	@Id
	private Long id;
	
	private String uri;
	private String sigla;
	private String nome;
	private String apelido;
	private String codTipoOrgao;
	private String tipoOrgao;
	private String nomePublicacao;
	private String nomeResumido;
	
	@OneToOne(mappedBy = "orgaos")
	private Evento evento;
	
}
