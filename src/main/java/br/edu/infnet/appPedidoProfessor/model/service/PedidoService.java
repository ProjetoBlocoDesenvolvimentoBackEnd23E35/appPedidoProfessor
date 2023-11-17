package br.edu.infnet.appPedidoProfessor.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appPedidoProfessor.model.domain.Pedido;

@Service
public class PedidoService {
	
	private Map<String, Pedido> mapa = new HashMap<String, Pedido>();

	public void incluir(Pedido pedido){
		mapa.put(pedido.getDescricao(), pedido);
	}
	
	public Collection<Pedido> obterLista(){
		return mapa.values();
	}
}