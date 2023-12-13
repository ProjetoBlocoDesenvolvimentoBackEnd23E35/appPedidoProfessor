package br.edu.infnet.appPedidoProfessor.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appPedidoProfessor.model.domain.Comida;
import br.edu.infnet.appPedidoProfessor.model.repositories.ComidaRepository;

@Service
public class ComidaService {
	
	@Autowired
	private ComidaRepository comidaRepository;

	public void incluir(Comida comida){
		comidaRepository.save(comida);
	}
	
	public Collection<Comida> obterLista(){
		return (Collection<Comida>) comidaRepository.findAll();
	}

	public void excluir(Integer id) {
		comidaRepository.deleteById(id);
	}
}