package br.edu.infnet.appPedidoProfessor;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appPedidoProfessor.model.domain.Bebida;
import br.edu.infnet.appPedidoProfessor.model.service.BebidaService;

@Order(2)
@Component
public class BebidaLoader implements ApplicationRunner {

	@Autowired
	private BebidaService bebidaService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader file = new FileReader("files/bebidas.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		while(linha != null) {
			campos = linha.split(";");

			Bebida bebida = new Bebida();
			bebida.setNome(campos[0]);
			bebida.setValor(Float.valueOf(campos[1]));
			bebida.setCodigo(Integer.valueOf(campos[2]));
			bebida.setGelada(Boolean.valueOf(campos[3]));
			bebida.setTamanho(Float.valueOf(campos[4]));
			bebida.setMarca(campos[5]);
			
			bebidaService.incluir(bebida);
			
			linha = leitura.readLine();
		}

		for(Bebida bebida : bebidaService.obterLista()) {
			System.out.println("[BEBIDA] " + bebida);			
		}
				
		leitura.close();
	}

}
