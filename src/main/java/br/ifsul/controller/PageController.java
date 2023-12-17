package br.ifsul.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifsul.entity.Deputado;
import br.ifsul.entity.Evento;
import br.ifsul.entity.valueobjects.ListaDeputado;
import br.ifsul.entity.valueobjects.ListaEvento;
import br.ifsul.gambis.EventoCadastro;
import br.ifsul.service.DeputadoService;
import br.ifsul.service.EventoService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PageController {
    @Autowired
    private DeputadoService deputadoService;

    @Autowired
    private EventoService eventoService;
    
    @GetMapping("/inicio")
    public String inicio(HttpServletRequest request) {
        ListaDeputado listaDeputados = deputadoService.getDeputadosDados();
        request.setAttribute("deputados", listaDeputados.getDados());
        // dados.addObject("deputados", listaDeputados);
        return "inicio";
    }

    @GetMapping("/deputado/{id}")
    public String deputado(@PathVariable Long id, HttpServletRequest request) {
        Optional<Deputado> deputadoOptional = deputadoService.getDeputado(id);

        if (deputadoOptional.isEmpty()) {
            return "redirect:/inicio";
        }

        Deputado deputado = deputadoOptional.get(); 

        request.setAttribute("deputado", deputado);
        // dados.addObject("deputados", listaDeputados);
        return "deputado";
    }

    @GetMapping("/deputado/{id}/eventos/cadastrar")
    public String cadastraremeventotela(@PathVariable Long id, HttpServletRequest request) {
        Optional<Deputado> deputadoOptional = deputadoService.getDeputado(id);
        ListaEvento eventos = eventoService.getEventoDados();
        
        if (deputadoOptional.isEmpty()) {
            return "redirect:/inicio";
        }

        Deputado deputado = deputadoOptional.get(); 

        request.setAttribute("deputado", deputado);
        request.setAttribute("eventos", eventos.getDados());
        // dados.addObject("deputados", listaDeputados);
        return "cadastraremevento";
    }

    @PostMapping("/deputado/{id}/eventos/cadastrar")
    public String cadastraremevento(EventoCadastro cadastro, HttpServletRequest request) {
        // System.out.println(cadastro.getId());
        
        deputadoService.cadastrarDeputadoEvento(cadastro.getId(), cadastro.getEvento().getId());

        return "redirect:/deputado/" + cadastro.getId();
    }
}
