package br.com.banco.bean;

public class TransferenciasBean {

	private int id;
	private int remetente;
	private int destinatario;
	private double valor;
	private String dataEHora;
	private int idCaixa;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRemetente() {
		return remetente;
	}
	public void setRemetente(int remetente) {
		remetente = remetente;
	}
	public int getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(int destinatario) {
		destinatario = destinatario;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
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
