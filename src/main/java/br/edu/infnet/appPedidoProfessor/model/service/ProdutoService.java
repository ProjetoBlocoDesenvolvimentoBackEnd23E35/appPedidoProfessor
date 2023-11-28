package br.edu.infnet.appPedidoProfessor.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appPedidoProfessor.model.domain.Produto;
import br.edu.infnet.appPedidoProfessor.model.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public void incluir(Produto produto){
		produtoRepository.save(produto);
	}
	
	public Collection<Produto> obterLista(){
		return (Collection<Produto>) produtoRepository.findAll();
	}
}
