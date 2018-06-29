package br.com.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.banco.bean.AgenciasBean;
import br.com.banco.bean.DepositosBean;
import br.com.banco.connection.ConnectionFactory;

public class DepositosDao {

	// Atributo para obter conex�o
	private Connection conexao;

	// M�todo para estabelecer conex�o com o banco de dados
	public DepositosDao() {

		this.conexao = new ConnectionFactory().obterConexao();

	}

	// M�todo para cadastrar ag�ncias
	public void cadastrarDepositos(DepositosBean db) {

		// Comando SQL
		String sql = "INSERT INTO depositos (idConta, valor, idCaixa) VALUES (?, ?, ?)";

		// Tentar realizar o comando SQL
		try {

			// Enviando e executando os par�metros
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, db.getIdConta());
			pstmt.setDouble(2, db.getValorDepositado());
			pstmt.setInt(3, db.getIdCaixa());
			pstmt.execute();

			// Fechar a conex�o
			pstmt.close();

			// Aviso de cadastro
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "", 0);

		} catch (Exception e) {

			// Caso haja falhas
			JOptionPane.showMessageDialog(null, "Falha ao inserir os dados" + e);

		}

	}

	// M�todo para selecionar e listar ag�ncias
	public DefaultTableModel listarAgencias() {

		// Criando o DefaultTableModel
		DefaultTableModel modelo = new DefaultTableModel();

		// Definir as colunas do DefaultTableModel
		modelo.addColumn("ID");
		modelo.addColumn("ID conta");
		modelo.addColumn("Valor");
		modelo.addColumn("Data e Hora");
		modelo.addColumn("ID caixa");

		// Comando SQL
		String sql = "SELECT * FROM depositos";

		// Tentar realizar o comando SQL
		try {

			// Conectar e selecionar o comando SQL
			java.sql.Statement stmt = conexao.createStatement();

			// Executando comando SQL e obtendo dados
			ResultSet rs = stmt.executeQuery(sql);

			// Listando cursos
			while (rs.next()) {

				modelo.addRow(new Object[] { rs.getInt("id"), rs.getInt("idConta"), rs.getInt("valor"),
						rs.getString("dataHora"), rs.getInt("idCaixa") });
			}

			// Fechar a conex�o
			stmt.close();

		} catch (Exception e) {

			// Caso haja falhas na sele��o
			JOptionPane.showMessageDialog(null, "Falha ao selecionar as ag�ncias.\n" + e);
		}

		// Retornar para o m�todo
		return modelo;

	}

	// M�todo para dados pelo ID
	public DepositosBean obterInformacoesDoId(int idDeposito) {

		// Criando um objeto da classe CursosBean
		DepositosBean db = new DepositosBean();

		// Comando SQL
		String sql = "SELECT * FROM depositos WHERE id = ?";

		// Tentar realizar o comando SQL
		try {

			// Enviando os par�metros
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, idDeposito);

			// Executando e retornando dados
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				db.setIdConta(rs.getInt("endereco"));
				db.setIdCaixa(rs.getInt("id"));
				db.setValorDepositado(rs.getDouble("nome"));
			}

			// Fechar a conex�o
			pstmt.close();

		} catch (Exception e) {

			// Caso haja falhas
			JOptionPane.showMessageDialog(null, "Falha ao selecionar os dados" + e.getMessage());

		}

		// Retorno
		return db;

	}

}
