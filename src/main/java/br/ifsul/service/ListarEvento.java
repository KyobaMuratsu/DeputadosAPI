package br.ifsul.service;

import java.util.List;

import br.ifsul.entity.Evento;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListarEvento {

	private List<Evento> dados;
	
	public List<Evento> getDados(){
		return dados;
	}
}
