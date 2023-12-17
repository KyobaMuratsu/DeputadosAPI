package br.ifsul.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.ifsul.entity.Deputado;
import br.ifsul.entity.valueobjects.ListaDeputado;
import br.ifsul.repository.DeputadoRepository;
import br.ifsul.service.DeputadoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.server.PathParam;

@Controller
public class PageController {
    @Autowired
    private DeputadoService deputadoService;
    
    @GetMapping("/inicio")
    public String inicio(HttpServletRequest request) {
        ListaDeputado listaDeputados = deputadoService.getDeputadosDados();
        request.setAttribute("deputados", listaDeputados.getDados());
        // dados.addObject("deputados", listaDeputados);
        return "inicio";
    }

    @GetMapping("/deputado/{id}")
    public String deputado(@PathVariable Long id, HttpServletRequest request) {
        Optional<Deputado> deputado = deputadoService.getDeputado(id); 

        request.setAttribute("deputados", deputado);
        // dados.addObject("deputados", listaDeputados);
        return "deputado";
    }


}
