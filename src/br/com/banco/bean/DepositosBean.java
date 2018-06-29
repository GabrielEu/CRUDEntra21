package br.com.banco.bean;

public class DepositosBean {

	private int id;
	private int idConta;
	private double valorDepositado;
	private String dataHora;
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
	public double getValorDepositado() {
		return valorDepositado;
	}
	public void setValorDepositado(double valorDepositado) {
		this.valorDepositado = valorDepositado;
	}
	public String getDataHora() {
		return dataHora;
	}
	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}
	public int getIdCaixa() {
		return idCaixa;
	}
	public void setIdCaixa(int idCaixa) {
		this.idCaixa = idCaixa;
	}
	
}
