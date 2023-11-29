package br.edu.infnet.appPedidoProfessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appPedidoProfessor.model.domain.Bebida;
import br.edu.infnet.appPedidoProfessor.model.domain.Comida;
import br.edu.infnet.appPedidoProfessor.model.domain.Pedido;
import br.edu.infnet.appPedidoProfessor.model.domain.Produto;
import br.edu.infnet.appPedidoProfessor.model.domain.Sobremesa;
import br.edu.infnet.appPedidoProfessor.model.domain.Solicitante;
import br.edu.infnet.appPedidoProfessor.model.service.PedidoService;

@Order(5)
@Component
public class PedidoLoader implements ApplicationRunner {
	
	@Autowired
	private PedidoService pedidoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader file = new FileReader("files/pedidos.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		Pedido pedido = null;
		
		while(linha != null) {
			campos = linha.split(";");
			
			switch (campos[0]) {
			case "P":
								
				pedido = new Pedido();
				pedido.setDescricao(campos[1]);
				pedido.setWeb(Boolean.valueOf(campos[2]));
				pedido.setData(LocalDateTime.now());
				pedido.setSolicitante(new Solicitante(Integer.valueOf(campos[3])));
				pedido.setProdutos(new ArrayList<Produto>());
								
				break;

			case "B":
				Bebida bebida = new Bebida();
				bebida.setId(Integer.valueOf(campos[1]));

				pedido.getProdutos().add(bebida);
				
				break;
				
			case "C":
				Comida comida = new Comida();
				comida.setId(Integer.valueOf(campos[1]));

				pedido.getProdutos().add(comida);
				
				break;

			case "S":
				Sobremesa sobremesa = new Sobremesa();
				sobremesa.setId(Integer.valueOf(campos[1]));
				
				pedido.getProdutos().add(sobremesa);
				
				break;

			default:
				break;
			}

			linha = leitura.readLine();
		}
		
		pedidoService.incluir(pedido);
		
		
		for(Pedido p : pedidoService.obterLista()) {
			System.out.println("[PEDIDO] " + p);			
		}
		
		leitura.close();
	}

}
