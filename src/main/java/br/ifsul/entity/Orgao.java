package br.ifsul.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Orgao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dataId;
	
	private Long id;
	private String uri;
	private String sigla;
	private String nome;
	private String apelido;
	private String codTipoOrgao;
	private String tipoOrgao;
	private String nomePublicacao;
	private String nomeResumido;
	
	@ManyToOne
	@JoinColumn(name = "evento_id", referencedColumnName = "id")
	private Evento evento;
	
}
