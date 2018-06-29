package br.com.banco.bean;

public class ContasBean {

	private int id;
	private int idPessoa;
	private String contaCorrente;
	private int agencia;
	private int fundos;
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
	public String getContaCorrente() {
		return contaCorrente;
	}
	public void setContaCorrente(String contaCorrente) {
		this.contaCorrente = contaCorrente;
	}
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public int getFundos() {
		return fundos;
	}
	public void setFundos(int fundos) {
		this.fundos = fundos;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
