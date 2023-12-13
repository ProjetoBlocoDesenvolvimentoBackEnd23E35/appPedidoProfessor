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

import br.edu.infnet.appPedidoProfessor.model.domain.Sobremesa;
import br.edu.infnet.appPedidoProfessor.model.service.SobremesaService;

@RestController
@RequestMapping("/api/sobremesa")
public class SobremesaController {
	
	@Autowired
	private SobremesaService sobremesaService;

	@GetMapping(value = "/listar")
	public List<Sobremesa> obterLista(){
		return (List<Sobremesa>) sobremesaService.obterLista();
	}
	
	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Sobremesa sobremesa) {
		sobremesaService.incluir(sobremesa);
	}

	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		sobremesaService.excluir(id);
	}
}