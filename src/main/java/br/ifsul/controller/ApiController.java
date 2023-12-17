package br.ifsul.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.entity.valueobjects.ListaDeputado;
import br.ifsul.repository.DeputadoRepository;
import br.ifsul.service.ApiService;
import br.ifsul.service.DeputadoService;
import br.ifsul.service.EventoService;

@RestController
public class ApiController {
	
	@Autowired
	private DeputadoService deputadoService;
	
	
	@Autowired
	private DeputadoRepository deputadoRepo;
	
	@GetMapping(value = "/salvarDeputadoeEvento", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ListaDeputado> getData() {
		ListaDeputado deputadoData = deputadoService.getDeputadosDados();
		deputadoRepo.saveAll(deputadoData.getDados());
		return ResponseEntity.ok(deputadoData);
	}
	
	
	
	
	
}
