package br.edu.infnet.appPedidoProfessor.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appPedidoProfessor.model.domain.Bebida;

@Service
public class BebidaService {

	private Map<Integer, Bebida> mapa = new HashMap<Integer, Bebida>();
	
	public void incluir(Bebida bebida){
		mapa.put(bebida.getCodigo(), bebida);
	}
	
	public Collection<Bebida> obterLista(){
		return mapa.values();
	}
}