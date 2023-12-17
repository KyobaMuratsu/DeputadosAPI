package br.ifsul.service;

import java.util.List;

import br.ifsul.entity.Deputado;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListarDeputado {

	private List<Deputado> dados;
	
	public List<Deputado> getDados(){
		return dados;
	}
	
}
