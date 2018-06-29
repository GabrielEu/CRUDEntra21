package br.com.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.banco.bean.AgenciasBean;
import br.com.banco.connection.ConnectionFactory;

public class AgenciasDao {

	// Atributo para obter conexão
	private Connection conexao;

	// Método para estabelecer conexão com o banco de dados
	public AgenciasDao() {

		this.conexao = new ConnectionFactory().obterConexao();

	}
	
	// Método para cadastrar agências
		public void cadastrarAgencias(AgenciasBean ab) {

			// Comando SQL
			String sql = "INSERT INTO agencias (nome, endereco, telefone) VALUES (?, ?, ?)";

			// Tentar realizar o comando SQL
			try {

				// Enviando e executando os parâmetros
				PreparedStatement pstmt = this.conexao.prepareStatement(sql);
				pstmt.setString(1, ab.getNomeAgencia());
				pstmt.setString(2, ab.getEnderecoAgencia());
				pstmt.setInt(3, ab.getTelefoneAgencia());
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
		modelo.addColumn("Nome");
		modelo.addColumn("Endereco");
		modelo.addColumn("Telefone");

		// Comando SQL
		String sql = "SELECT * FROM agencias";

		// Tentar realizar o comando SQL
		try {

			// Conectar e selecionar o comando SQL
			java.sql.Statement stmt = conexao.createStatement();

			// Executando comando SQL e obtendo dados
			ResultSet rs = stmt.executeQuery(sql);

			// Listando cursos
			while (rs.next()) {

				modelo.addRow(new Object[] { rs.getInt("id"), rs.getString("nome"), rs.getString("endereco"), rs.getInt("telefone") });
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
