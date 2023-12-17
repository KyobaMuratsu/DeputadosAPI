package br.ifsul.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
	
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
      name = "deputado_evento", 
      joinColumns = @JoinColumn(name = "deputado_id"), 
      inverseJoinColumns = @JoinColumn(name = "evento_id"))
    private Set<Evento> evento = new HashSet<>();
	
}
