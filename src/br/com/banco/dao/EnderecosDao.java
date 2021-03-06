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

	// Atributo para obter conex�o
	private Connection conexao;

	// M�todo para estabelecer conex�o com o banco de dados
	public EnderecosDao() {

		this.conexao = new ConnectionFactory().obterConexao();

	}

	// M�todo para cadastrar ag�ncias
	public void cadastrarEnderecos(EnderecosBean eb) {

		// Comando SQL
		String sql = "INSERT INTO enderecos(idPessoa, rua, numero, bairro, complemento) VALUES (?, ?, ?, ?, ?)";

		// Tentar realizar o comando SQL
		try {

			// Enviando e executando os par�metros
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, eb.getIdPessoa());
			pstmt.setString(2, eb.getRua());
			pstmt.setInt(3, eb.getNumero());
			pstmt.setString(4, eb.getBairro());
			pstmt.setString(5, eb.getComplemento());
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
		modelo.addColumn("ID da Pessoa");
		modelo.addColumn("Rua");
		modelo.addColumn("N�mero");
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
	public EnderecosBean obterInformacoesDoId(int idEndereco) {

		// Criando um objeto da classe CursosBean
		EnderecosBean eb = new EnderecosBean();

		// Comando SQL
		String sql = "SELECT * FROM endereco WHERE id = ?";

		// Tentar realizar o comando SQL
		try {

			// Enviando os par�metros
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, idEndereco);

			// Executando e retornando dados
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				eb.setBairro(rs.getString("bairro"));
				eb.setComplemento(rs.getString("complemento"));
				eb.setIdPessoa(rs.getInt("idPessoa"));
				eb.setNumero(rs.getInt("numero"));
				eb.setRua(rs.getString("rua"));
			}

			// Fechar a conex�o
			pstmt.close();

		} catch (Exception e) {

			// Caso haja falhas
			JOptionPane.showMessageDialog(null, "Falha ao selecionar os dados" + e.getMessage());

		}

		// Retorno
		return eb;

	}

}
