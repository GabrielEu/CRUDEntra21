package br.com.banco.bean;

public class AgenciasBean {

	private int id;
	private String nomeAgencia;
	private String enderecoAgencia;
	private int telefoneAgencia;

	public int getIdAgencia() {

		return id;
	}

	public void setIdAgencia(int id) {
		this.id = id;
	}

	public String getNomeAgencia() {
		return nomeAgencia;
	}

	public void setNomeAgencia(String nomeAgencia) {
		this.nomeAgencia = nomeAgencia;
	}

	public String getEnderecoAgencia() {
		return enderecoAgencia;
	}

	public void setEnderecoAgencia(String enderecoAgencia) {
		this.enderecoAgencia = enderecoAgencia;
	}

	public int getTelefoneAgencia() {
		return telefoneAgencia;
	}

	public void setTelefoneAgencia(int telefoneAgencia) {
		this.telefoneAgencia = telefoneAgencia;
	}

}
