package br.edu.infnet.appPedidoProfessor.model.domain;

public class Solicitante {

	private String nome;
	private String cpf;
	private String email;
	
	@Override
	public String toString() {

		return String.format("nome (%s) - cpf (%s) - email (%s)", nome, cpf, email);
	}

	public Solicitante() {
		// TODO Auto-generated constructor stub
	}
	
	public Solicitante(String nome, String cpf, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}