package br.com.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.banco.bean.AgenciasBean;
import br.com.banco.bean.ContatosBean;
import br.com.banco.connection.ConnectionFactory;

public class ContatosDao {

	// Atributo para obter conex�o
	private Connection conexao;

	// M�todo para estabelecer conex�o com o banco de dados
	public ContatosDao() {

		this.conexao = new ConnectionFactory().obterConexao();

	}

	// M�todo para cadastrar ag�ncias
	public void cadastrarContatos(ContatosBean cb) {

		// Comando SQL
		String sql = "INSERT INTO contatos (idPessoa, contato) VALUES (?, ?)";

		// Tentar realizar o comando SQL
		try {

			// Enviando e executando os par�metros
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, cb.getIdPessoa());
			pstmt.setString(2, cb.getContato());
			pstmt.execute();

			// Fechar a conex�o
			pstmt.close();

			// Aviso de cadastro
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "", 0);

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
		modelo.addColumn("ID Pessoa");
		modelo.addColumn("Contato");

		// Comando SQL
		String sql = "SELECT * FROM contatos";

		// Tentar realizar o comando SQL
		try {

			// Conectar e selecionar o comando SQL
			java.sql.Statement stmt = conexao.createStatement();

			// Executando comando SQL e obtendo dados
			ResultSet rs = stmt.executeQuery(sql);

			// Listando cursos
			while (rs.next()) {

				modelo.addRow(new Object[] { rs.getInt("id"), rs.getString("idPessoa"), rs.getString("contato") });

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
	public ContatosBean obterInformacoesDoId(int idContatos) {

		// Criando um objeto da classe CursosBean
		ContatosBean cb = new ContatosBean();

		// Comando SQL
		String sql = "SELECT * FROM contatos WHERE id = ?";

		// Tentar realizar o comando SQL
		try {

			// Enviando os par�metros
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, idContatos);

			// Executando e retornando dados
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				cb.setContato(rs.getString("contato"));
				cb.setIdPessoa(rs.getInt("idPessoa"));

			}

			// Fechar a conex�o
			pstmt.close();

		} catch (Exception e) {

			// Caso haja falhas
			JOptionPane.showMessageDialog(null, "Falha ao selecionar os dados" + e.getMessage());

		}

		// Retorno
		return cb;

	}
}
