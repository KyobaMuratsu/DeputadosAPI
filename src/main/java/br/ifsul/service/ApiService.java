package br.ifsul.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.ifsul.entity.Deputado;

@Service
public class ApiService {
	
	private final String url = "https://dadosabertos.camara.leg.br/api/v2/deputados?nome= &ordem=ASC&ordenarPor=nome";
	@Autowired
	private RestTemplate restTemplate;
	
	public ListarDeputado getDados() {
		ResponseEntity<ListarDeputado> responseEntity = restTemplate.getForEntity(url, ListarDeputado.class);
		ListarDeputado responseBody = responseEntity.getBody();
		
		return responseBody;
	}
	
	
}
