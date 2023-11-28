package br.edu.infnet.appPedidoProfessor.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appPedidoProfessor.model.domain.Bebida;

@Repository
public interface BebidaRepository extends CrudRepository<Bebida, Integer> {

}
