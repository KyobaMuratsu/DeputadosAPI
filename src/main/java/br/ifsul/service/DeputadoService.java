package br.ifsul.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.ifsul.entity.Deputado;
import br.ifsul.entity.Evento;
import br.ifsul.entity.valueobjects.EventoDto;
import br.ifsul.entity.valueobjects.ListaDeputado;
import br.ifsul.repository.DeputadoRepository;
import br.ifsul.repository.EventoRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class DeputadoService {
	
	private final String url = "https://dadosabertos.camara.leg.br/api/v2/deputados?nome= &ordem=ASC&ordenarPor=nome";
	
	@Autowired
	private EventoRepository eventoRepo;
	
	@Autowired
	private DeputadoRepository deputadoRepo;

	@Autowired
	private RestTemplate restTemplate;
	
	public ListaDeputado getDeputadosDados() {
		ResponseEntity<ListaDeputado> responseEntity = restTemplate.getForEntity(url, ListaDeputado.class);
		ListaDeputado responseBody = responseEntity.getBody();
		
		return responseBody;
	}

	public List<Deputado> getDeputadosBase() {
		return deputadoRepo.findAll();
	}
	
	public Optional<Deputado> getDeputado(Long id) {
		return deputadoRepo.findById(id);
	}
	
	public Set<Evento> getEventoByDeputadoId(Long id){
		return deputadoRepo.findEventoById(id);
	}
	
	public void cadastrarDeputadoEvento(Long id, Long eventoId) {
		Deputado deputados = deputadoRepo.findDeputadoById(id);
		Evento evento = eventoRepo.findById(eventoId).get();

		deputados.getEvento().add(evento);
		deputadoRepo.save(deputados);
	}
	
	public void excluirEventoDeputado(Long id, Long eventoId) {
		Deputado deputados = deputadoRepo.findDeputadoById(id);
		deputados.getEvento().removeIf(x -> x.getId().equals(eventoId));
		deputadoRepo.save(deputados);
	}
	
}
