package br.ifsul.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.repository.DeputadoRepository;
import br.ifsul.service.ApiService;
import br.ifsul.service.ListarDeputado;

@RestController
public class ApiController {
	
	@Autowired
	private ApiService apiService;
	
	@Autowired
	private DeputadoRepository deputadoRepo;
	
	@GetMapping(value = "/dados", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ListarDeputado> getData() {
		ListarDeputado data = apiService.getDados();
		deputadoRepo.saveAll(data.getDados());
		return ResponseEntity.ok(data);
	}
	
}
