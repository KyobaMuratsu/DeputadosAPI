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
import br.ifsul.repository.DeputadoRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class DeputadoService {
	
	private final String url = "https://dadosabertos.camara.leg.br/api/v2/deputados?nome= &ordem=ASC&ordenarPor=nome";
	
	@Autowired
	private DeputadoRepository deputadoRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public ListaDeputado getDeputadosDados() {
		ResponseEntity<ListaDeputado> responseEntity = restTemplate.getForEntity(url, ListaDeputado.class);
		ListaDeputado responseBody = responseEntity.getBody();
		
		return responseBody;
	}
	
	public Optional<Deputado> getDeputado(Long id) {
		return deputadoRepo.findById(id);
	}
	
	public List<Evento> getEventoByDeputadoId(Long id){
		return deputadoRepo.findEventoById(id);
	}
	
	public void cadastrarDeputadoEvento(Long id, Evento evento) {
		Deputado deputados = deputadoRepo.findDeputadoById(id);
		deputados.getEvento().add(evento);
		deputadoRepo.save(deputados);
	}
	
	public void excluirEventoDeputado(Long id, Evento evento) {
		Deputado deputados = deputadoRepo.findDeputadoById(id);
		deputados.getEvento().remove(evento);
		deputadoRepo.save(deputados);
	}
	
}
