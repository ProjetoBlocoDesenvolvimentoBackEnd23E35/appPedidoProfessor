package br.edu.infnet.appPedidoProfessor.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appPedidoProfessor.model.domain.Pedido;
import br.edu.infnet.appPedidoProfessor.model.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public void incluir(Pedido pedido){
		pedidoRepository.save(pedido);
	}
	
	public Collection<Pedido> obterLista(){		
		return (Collection<Pedido>) pedidoRepository.findAll();
	}
	
	public void excluir(Integer id) {
		pedidoRepository.deleteById(id);
	}	
}