package br.com.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.banco.bean.AgenciasBean;
import br.com.banco.bean.TransferenciasBean;
import br.com.banco.connection.ConnectionFactory;

public class TransferenciasDao {

	// Atributo para obter conexão
	private Connection conexao;

	// Método para estabelecer conexão com o banco de dados
	public TransferenciasDao() {

			this.conexao = new ConnectionFactory().obterConexao();

		}

	// Método para cadastrar agências
	public void cadastrarTransferencias(TransferenciasBean tb) {

		// Comando SQL
		String sql = "INSERT INTO agencias (de, para, valor, idCaixa) VALUES (?, ?, ?, ?)";

		// Tentar realizar o comando SQL
		try {

			// Enviando e executando os parâmetros
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, tb.getRemetente());
			pstmt.setInt(2, tb.getDestinatario());
			pstmt.setDouble(3, tb.getValor());
			pstmt.setInt(4, tb.getIdCaixa());
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
		modelo.addColumn("Remetente");
		modelo.addColumn("Destinatário");
		modelo.addColumn("Valor");
		modelo.addColumn("Data e hora");
		modelo.addColumn("IdCaixa");

		// Comando SQL
		String sql = "SELECT * FROM transferencias";

		// Tentar realizar o comando SQL
		try {

			// Conectar e selecionar o comando SQL
			java.sql.Statement stmt = conexao.createStatement();

			// Executando comando SQL e obtendo dados
			ResultSet rs = stmt.executeQuery(sql);

			// Listando cursos
			while (rs.next()) {

				modelo.addRow(new Object[] { rs.getInt("id"), rs.getInt("de"), rs.getString("para"), rs.getDouble("valor"),
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
