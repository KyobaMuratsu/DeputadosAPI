package br.ifsul.controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.entity.Evento;
import br.ifsul.entity.Orgao;
import br.ifsul.entity.valueobjects.ListaDeputado;
import br.ifsul.entity.valueobjects.ListaEvento;
import br.ifsul.repository.DeputadoRepository;
import br.ifsul.repository.EventoRepository;
import br.ifsul.service.ApiService;
import br.ifsul.service.DeputadoService;
import br.ifsul.service.EventoService;

@RestController
public class ApiController {
	
	@Autowired
	private DeputadoService deputadoService;
	
	@Autowired
	private EventoService eventoService;
	
	@Autowired
	private EventoRepository eventoRepo;
	
	@Autowired
	private DeputadoRepository deputadoRepo;
	
	@GetMapping(value = "/salvarDeputadoeEvento", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getData() {
		ListaDeputado deputadoData = deputadoService.getDeputadosDados();
		ListaEvento eventoData = eventoService.getEventoDados();
		eventoRepo.saveAll(eventoData.getDados());
		deputadoRepo.saveAll(deputadoData.getDados());
		return ResponseEntity.ok("Seu banco está com As informações");
	}
	
}
