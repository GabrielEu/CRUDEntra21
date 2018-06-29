package br.com.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.banco.bean.AgenciasBean;
import br.com.banco.bean.CaixasEletronicosBean;
import br.com.banco.connection.ConnectionFactory;

public class CaixasEletronicosDao {

	// Atributo para obter conex�o
	private Connection conexao;

	// M�todo para estabelecer conex�o com o banco de dados
	public CaixasEletronicosDao() {

		this.conexao = new ConnectionFactory().obterConexao();

	}

	// M�todo para cadastrar ag�ncias
	public void cadastrarCaixasEletronicos(CaixasEletronicosBean ceb) {

		// Comando SQL
		String sql = "INSERT INTO agencias (fundos, idagencia) VALUES (?, ?)";

		// Tentar realizar o comando SQL
		try {

			// Enviando e executando os par�metros
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setDouble(1, ceb.getFundo());
			pstmt.setInt(2, ceb.getIdAgencia());
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
		modelo.addColumn("Fundos");
		modelo.addColumn("ID ag�ncia");

		// Comando SQL
		String sql = "SELECT * FROM caixaseletronicos";

		// Tentar realizar o comando SQL
		try {

			// Conectar e selecionar o comando SQL
			java.sql.Statement stmt = conexao.createStatement();

			// Executando comando SQL e obtendo dados
			ResultSet rs = stmt.executeQuery(sql);

			// Listando cursos
			while (rs.next()) {

				modelo.addRow(new Object[] { rs.getInt("id"), rs.getString("fundos"), rs.getString("idagencia") });
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
