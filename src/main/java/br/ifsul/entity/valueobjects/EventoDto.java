package br.ifsul.entity.valueobjects;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EventoDto {

	private LocalDateTime dataHoraInicio;
	private LocalDateTime dataHoraFim;
	private String descricaoTipo;
	@Column(columnDefinition = "VARCHAR(2000)")
	private String descricao;
	
}
