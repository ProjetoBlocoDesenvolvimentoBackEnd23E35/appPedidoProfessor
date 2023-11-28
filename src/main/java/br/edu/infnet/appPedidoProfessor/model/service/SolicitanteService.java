package br.edu.infnet.appPedidoProfessor.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appPedidoProfessor.model.domain.Solicitante;
import br.edu.infnet.appPedidoProfessor.model.repositories.SolicitanteRepository;

@Service
public class SolicitanteService {
	
	@Autowired
	private SolicitanteRepository solicitanteRepository;
	
	public void incluir(Solicitante solicitante){
		solicitanteRepository.save(solicitante);
	}
	
	public Collection<Solicitante> obterLista(){		
		return (Collection<Solicitante>) solicitanteRepository.findAll();
	}
}