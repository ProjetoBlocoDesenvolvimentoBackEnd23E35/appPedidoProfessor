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

import br.edu.infnet.appPedidoProfessor.model.domain.Bebida;
import br.edu.infnet.appPedidoProfessor.model.domain.Produto;
import br.edu.infnet.appPedidoProfessor.model.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;

	@GetMapping(value = "/listar")
	public List<Produto> obterLista(){
		return (List<Produto>) produtoService.obterLista();
	}
	
	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Produto produto) {
		produtoService.incluir(produto);
	}

	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		produtoService.excluir(id);
	}
}