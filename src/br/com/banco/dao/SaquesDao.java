package br.com.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.banco.bean.AgenciasBean;
import br.com.banco.bean.SaquesBean;
import br.com.banco.connection.ConnectionFactory;

public class SaquesDao {
	// Atributo para obter conexão
	private Connection conexao;

	// Método para estabelecer conexão com o banco de dados
	public SaquesDao() {

		this.conexao = new ConnectionFactory().obterConexao();

	}

	// Método para cadastrar agências
	public void cadastrarSaques(SaquesBean sb) {

		// Comando SQL
		String sql = "INSERT INTO agencias (idConta, valor, idCaixa) VALUES (?, ?, ?)";

		// Tentar realizar o comando SQL
		try {

			// Enviando e executando os parâmetros
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, sb.getIdConta());
			pstmt.setDouble(2, sb.getValorSacado());
			pstmt.setInt(3, sb.getIdCaixa());
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
		modelo.addColumn("ID da conta");
		modelo.addColumn("Valor");
		modelo.addColumn("Data e hora");
		modelo.addColumn("ID do caixa");

		// Comando SQL
		String sql = "SELECT * FROM saques";

		// Tentar realizar o comando SQL
		try {

			// Conectar e selecionar o comando SQL
			java.sql.Statement stmt = conexao.createStatement();

			// Executando comando SQL e obtendo dados
			ResultSet rs = stmt.executeQuery(sql);

			// Listando cursos
			while (rs.next()) {

				modelo.addRow(new Object[] { rs.getInt("id"), rs.getInt("idConta"), rs.getInt("Valor"),
						rs.getString("dataHora"), rs.getInt("idCaixa") });
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
