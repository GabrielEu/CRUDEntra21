package br.com.banco.bean;

public class PessoasBean {

	private int id;
	private int idAgencia;
	private String nome;
	private String codigo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdAgencia() {
		return idAgencia;
	}
	public void setIdAgencia(int idAgencia) {
		this.idAgencia = idAgencia;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
