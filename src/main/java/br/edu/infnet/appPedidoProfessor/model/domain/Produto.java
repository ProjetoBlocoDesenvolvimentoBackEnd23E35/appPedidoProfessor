package br.edu.infnet.appPedidoProfessor.model.domain;

public abstract class Produto {

	private String nome;
	private float valor;
	private int codigo;
	
	@Override
	public String toString() {
		
		return String.format("nome (%s) - valor (%.2f) - codigo (%d)", 
					nome, valor, codigo
				);
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}