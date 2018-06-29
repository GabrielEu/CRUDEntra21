package br.com.banco.bean;

public class FuncionariosBean {

	private int id;
	private int idPessoa;
	private double salario;
	private int nivelDePermissao;
	private String senha;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public int getNivelDePermissao() {
		return nivelDePermissao;
	}
	public void setNivelDePermissao(int nivelDePermissao) {
		this.nivelDePermissao = nivelDePermissao;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
