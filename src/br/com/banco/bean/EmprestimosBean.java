package br.com.banco.bean;

public class EmprestimosBean {

	private int id;
	private int idConta;
	private double valorInicial;
	private double valorProximaParcela;
	private String dataProximaParcela;
	private int parcelasRestantes;
	
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
	public double getValorInicial() {
		return valorInicial;
	}
	public void setValorInicial(double valorInicial) {
		this.valorInicial = valorInicial;
	}
	public double getValorProximaParcela() {
		return valorProximaParcela;
	}
	public void setValorProximaParcela(double valorProximaParcela) {
		this.valorProximaParcela = valorProximaParcela;
	}
	public String getDataProximaParcela() {
		return dataProximaParcela;
	}
	public void setDataProximaParcela(String dataProximaParcela) {
		this.dataProximaParcela = dataProximaParcela;
	}
	public int getParcelasRestantes() {
		return parcelasRestantes;
	}
	public void setParcelasRestantes(int parcelasRestantes) {
		this.parcelasRestantes = parcelasRestantes;
	}
	
}
