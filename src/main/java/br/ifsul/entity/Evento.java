package br.ifsul.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Evento {
	
	@Id
	private Long id;
	
	private String uri;
	private LocalDateTime dataHoraInicio;
	private LocalDateTime dataHoraFim;
	private String situacao;
	private String descricaoTipo;
	
	@Column(columnDefinition = "VARCHAR(2000)")
	private String descricao;
	
	private String urlRegistro;
	
	@OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
	private List<Orgao> orgaos;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "localcamara_id", referencedColumnName = "id")
	private LocalCamara localCamara;
	
}
