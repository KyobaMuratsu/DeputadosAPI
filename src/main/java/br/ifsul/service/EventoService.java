package br.ifsul.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.ifsul.entity.Deputado;
import br.ifsul.entity.Evento;
import br.ifsul.entity.valueobjects.ListaDeputado;
import br.ifsul.entity.valueobjects.ListaEvento;
import br.ifsul.repository.DeputadoRepository;
import br.ifsul.repository.EventoRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class EventoService {
	
	private final String url = "https://dadosabertos.camara.leg.br/api/v2/eventos?ordem=ASC&ordenarPor=dataHoraInicio";
	
	@Autowired
	private EventoRepository eventoRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public ListaEvento getEventoDados() {
		ResponseEntity<ListaEvento> responseEntity = restTemplate.getForEntity(url, ListaEvento.class);
		ListaEvento responseBody = responseEntity.getBody();
		
		return responseBody;
	}
	
	public Optional<Evento> getEvento(Long id) {
		return eventoRepo.findById(id);
	}
	
	
	
	
}
