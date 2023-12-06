package br.edu.infnet.appPedidoProfessor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appPedidoProfessor.model.domain.Solicitante;
import br.edu.infnet.appPedidoProfessor.model.service.SolicitanteService;

@RestController
@RequestMapping("/api/solicitante")
public class SolicitanteController {
	
	@Autowired
	private SolicitanteService solicitanteService;

	@GetMapping(value = "/listar")
	public List<Solicitante> obterLista(){
		return (List<Solicitante>) solicitanteService.obterLista();
	}
	
	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Solicitante solicitante) {
		solicitanteService.incluir(solicitante);
	}

	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		solicitanteService.excluir(id);
	}
}