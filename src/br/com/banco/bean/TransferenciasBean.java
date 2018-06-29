package br.com.banco.bean;

public class TransferenciasBean {

	private int id;
	private int remetente;
	private int destinatario;
	private int valor;
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
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
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
