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
				pedido.setSolicitante(new Solicitante(campos[3], campos[4], campos[5]));
				pedido.setProdutos(new ArrayList<Produto>());
				
				pedidoService.incluir(pedido);
				
				break;

			case "B":
				Bebida bebida = new Bebida();
				bebida.setNome(campos[1]);
				bebida.setValor(Float.valueOf(campos[2]));
				bebida.setCodigo(Integer.valueOf(campos[3]));
				bebida.setGelada(Boolean.valueOf(campos[4]));
				bebida.setTamanho(Float.valueOf(campos[5]));
				bebida.setMarca(campos[5]);
				
				pedido.getProdutos().add(bebida);
				
				break;
				
			case "C":
				Comida comida = new Comida();
				comida.setNome(campos[1]);
				comida.setValor(Float.valueOf(campos[2]));
				comida.setCodigo(Integer.valueOf(campos[3]));
				comida.setIngredientes(campos[4]);
				comida.setPeso(Float.valueOf(campos[5]));
				comida.setVegana(Boolean.valueOf(campos[6]));

				pedido.getProdutos().add(comida);
				
				break;

			case "S":
				Sobremesa sobremesa = new Sobremesa();
				sobremesa.setNome(campos[1]);
				sobremesa.setValor(Float.valueOf(campos[2]));
				sobremesa.setCodigo(Integer.valueOf(campos[3]));
				sobremesa.setQuantidade(Integer.valueOf(campos[4]));
				sobremesa.setDoce(Boolean.valueOf(campos[5]));
				sobremesa.setInformacao(campos[6]);
				
				pedido.getProdutos().add(sobremesa);

				
				break;

			default:
				break;
			}

			linha = leitura.readLine();
		}
		
		for(Pedido p : pedidoService.obterLista()) {
			System.out.println("[PEDIDO] " + p);			
		}
		
		leitura.close();
	}

}
