package br.com.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.banco.bean.AgenciasBean;
import br.com.banco.connection.ConnectionFactory;

public class AgenciasDao {

	// Atributo para obter conex�o
	private Connection conexao;

	// M�todo para estabelecer conex�o com o banco de dados
	public AgenciasDao() {

		this.conexao = new ConnectionFactory().obterConexao();

	}
	
	// M�todo para cadastrar ag�ncias
		public void cadastrarAgencias(AgenciasBean ab) {

			// Comando SQL
			String sql = "INSERT INTO agencias (nome, endereco, telefone) VALUES (?, ?, ?)";

			// Tentar realizar o comando SQL
			try {

				// Enviando e executando os par�metros
				PreparedStatement pstmt = this.conexao.prepareStatement(sql);
				pstmt.setString(1, ab.getNomeAgencia());
				pstmt.setString(2, ab.getEnderecoAgencia());
				pstmt.setInt(3, ab.getTelefoneAgencia());
				pstmt.execute();

				// Fechar a conex�o
				pstmt.close();

			} catch (Exception e) {

				// Caso haja falhas
				JOptionPane.showMessageDialog(null, "Falha ao inserir os dados");

			}

		}

	// M�todo para selecionar e listar ag�ncias
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

			// Fechar a conex�o
			stmt.close();

		} catch (Exception e) {

			// Caso haja falhas na sele��o
			JOptionPane.showMessageDialog(null, "Falha ao selecionar as ag�ncias.");
		}

		// Retornar para o m�todo
		return modelo;

	}

}
