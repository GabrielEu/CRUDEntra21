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
	// Atributo para obter conex�o
	private Connection conexao;

	// M�todo para estabelecer conex�o com o banco de dados
	public SaquesDao() {

		this.conexao = new ConnectionFactory().obterConexao();

	}

	// M�todo para cadastrar ag�ncias
	public void cadastrarSaques(SaquesBean sb) {

		// Comando SQL
		String sql = "INSERT INTO saques (idConta, valor, dataHora, idCaixa) VALUES (?, ?, ?, ?)";

		// Tentar realizar o comando SQL
		try {

			// Enviando e executando os par�metros
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, sb.getIdConta());
			pstmt.setDouble(2, sb.getValorSacado());
			pstmt.setString(3, sb.getDataEHora());
			pstmt.setInt(4, sb.getIdCaixa());
			pstmt.execute();

			// Fechar a conex�o
			pstmt.close();

			// Aviso de cadastro
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "", 0);

		} catch (Exception e) {

			// Caso haja falhas
			JOptionPane.showMessageDialog(null, "Falha ao inserir os dados\n" + e);

		}

	}

	// M�todo para selecionar e listar ag�ncias
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

			// Fechar a conex�o
			stmt.close();

		} catch (Exception e) {

			// Caso haja falhas na sele��o
			JOptionPane.showMessageDialog(null, "Falha ao selecionar as ag�ncias.");
		}

		// Retornar para o m�todo
		return modelo;

	}

	// M�todo para dados pelo ID
	public SaquesBean obterInformacoesDoId(int idSaque) {

		// Criando um objeto da classe CursosBean
		SaquesBean sb = new SaquesBean();

		// Comando SQL
		String sql = "SELECT * FROM saques WHERE id = ?";

		// Tentar realizar o comando SQL
		try {

			// Enviando os par�metros
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, idSaque);

			// Executando e retornando dados
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				sb.setIdCaixa(rs.getInt("idCaixa"));
				sb.setIdConta(rs.getInt("idConta"));
				sb.setValorSacado(rs.getDouble("valor"));
			}

			// Fechar a conex�o
			pstmt.close();

		} catch (Exception e) {

			// Caso haja falhas
			JOptionPane.showMessageDialog(null, "Falha ao selecionar os dados" + e.getMessage());

		}

		// Retorno
		return sb;

	}

}
