package br.com.banco.bean;

public class SaquesBean {

	private int id;
	private int idConta;
	private int valorSacado;
	private String dataEHora;
	private int idCaixa;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdConta() {
		return idConta;
	}
	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}
	public int getValorSacado() {
		return valorSacado;
	}
	public void setValorSacado(int valorSacado) {
		this.valorSacado = valorSacado;
	}
	public String getDataEHora() {
		return dataEHora;
	}
	public void setDataEHora(String dataEHora) {
		this.dataEHora = dataEHora;
	}
	public int getIdCaixa() {
		return idCaixa;
	}
	public void setIdCaixa(int idCaixa) {
		this.idCaixa = idCaixa;
	}
	
}
