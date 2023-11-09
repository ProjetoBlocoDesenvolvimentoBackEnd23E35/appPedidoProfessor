package br.edu.infnet.appPedidoProfessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appPedidoProfessor.model.domain.Solicitante;

@Component
public class SolicitanteLoader implements ApplicationRunner {
	
	private Map<String, Solicitante> mapa = new HashMap<String, Solicitante>();

	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader file = new FileReader("files/solicitantes.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		while(linha != null) {
			campos = linha.split(";");

			Solicitante solicitante = new Solicitante();
			solicitante.setNome(campos[0]);
			solicitante.setCpf(campos[1]);
			solicitante.setEmail(campos[2]);
			
			mapa.put(solicitante.getCpf(), solicitante);
			
			linha = leitura.readLine();
		}

		for(Solicitante solicitante : mapa.values()) {
			System.out.println("[SOLICITANTE] " + solicitante);			
		}
				
		leitura.close();
	}
}