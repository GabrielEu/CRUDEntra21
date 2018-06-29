package br.com.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.banco.bean.AgenciasBean;
import br.com.banco.bean.EnderecosBean;
import br.com.banco.connection.ConnectionFactory;

public class EnderecosDao {

	// Atributo para obter conexão
	private Connection conexao;

	// Método para estabelecer conexão com o banco de dados
	public EnderecosDao() {

		this.conexao = new ConnectionFactory().obterConexao();

	}

	// Método para cadastrar agências
	public void cadastrarEnderecos(EnderecosBean eb) {

		// Comando SQL
		String sql = "INSERT INTO agencias (idPessoa, rua, numero, bairro, complemento) VALUES (?, ?, ?, ?, ?)";

		// Tentar realizar o comando SQL
		try {

			// Enviando e executando os parâmetros
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, eb.getIdPessoa());
			pstmt.setString(2, eb.getRua());
			pstmt.setInt(3, eb.getNumero());
			pstmt.setString(4, eb.getBairro());
			pstmt.setString	(5, eb.getComplemento());
			pstmt.execute();

			// Fechar a conexão
			pstmt.close();

		} catch (Exception e) {

			// Caso haja falhas
			JOptionPane.showMessageDialog(null, "Falha ao inserir os dados");

		}

	}

	// Mètodo para selecionar e listar agências
	public DefaultTableModel listarAgencias() {

		// Criando o DefaultTableModel
		DefaultTableModel modelo = new DefaultTableModel();

		// Definir as colunas do DefaultTableModel
		modelo.addColumn("ID");
		modelo.addColumn("ID da Pessoa");
		modelo.addColumn("Rua");
		modelo.addColumn("Número");
		modelo.addColumn("Bairro");
		modelo.addColumn("Complemento");

		// Comando SQL
		String sql = "SELECT * FROM enderecos";

		// Tentar realizar o comando SQL
		try {

			// Conectar e selecionar o comando SQL
			java.sql.Statement stmt = conexao.createStatement();

			// Executando comando SQL e obtendo dados
			ResultSet rs = stmt.executeQuery(sql);

			// Listando cursos
			while (rs.next()) {

				modelo.addRow(new Object[] { rs.getInt("id"), rs.getInt("idPessoa"), rs.getString("rua"),
						rs.getInt("numero"), rs.getString("bairro"), rs.getString("complemento") });
			}

			// Fechar a conexão
			stmt.close();

		} catch (Exception e) {

			// Caso haja falhas na seleção
			JOptionPane.showMessageDialog(null, "Falha ao selecionar as agências.");
		}

		// Retornar para o método
		return modelo;

	}

}
