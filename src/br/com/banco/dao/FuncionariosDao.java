package br.com.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.banco.bean.AgenciasBean;
import br.com.banco.bean.FuncionariosBean;
import br.com.banco.connection.ConnectionFactory;

public class FuncionariosDao {

	// Atributo para obter conex�o
	private Connection conexao;

	// M�todo para estabelecer conex�o com o banco de dados
	public FuncionariosDao() {

		this.conexao = new ConnectionFactory().obterConexao();

	}

	// M�todo para cadastrar ag�ncias
	public void cadastrarFuncionarios(FuncionariosBean fb) {

		// Comando SQL
		String sql = "INSERT INTO funcionarios(idPessoa, salario, nivelDePermissao, senha) VALUES (?, ?, ?, ?)";

		// Tentar realizar o comando SQL
		try {

			// Enviando e executando os par�metros
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, fb.getIdPessoa());
			pstmt.setDouble(2, fb.getSalario());
			pstmt.setInt(3, fb.getNivelDePermissao());
			pstmt.setString(4, fb.getSenha());
			pstmt.execute();

			// Fechar a conex�o
			pstmt.close();

			// Aviso de cadastro
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "", -1);

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
		modelo.addColumn("ID da pessoa");
		modelo.addColumn("Sal�rio");
		modelo.addColumn("N�vel de permiss�o");
		modelo.addColumn("Senha");

		// Comando SQL
		String sql = "SELECT * FROM funcionarios";

		// Tentar realizar o comando SQL
		try {

			// Conectar e selecionar o comando SQL
			java.sql.Statement stmt = conexao.createStatement();

			// Executando comando SQL e obtendo dados
			ResultSet rs = stmt.executeQuery(sql);

			// Listando cursos
			while (rs.next()) {

				modelo.addRow(new Object[] { rs.getInt("id"), rs.getInt("idPessoa"), rs.getDouble("salario"),
						rs.getInt("nivelDePermissao"), rs.getString("senha") });
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
	public FuncionariosBean obterInformacoesDoId(int idFuncionario) {

		// Criando um objeto da classe CursosBean
		FuncionariosBean fb = new FuncionariosBean();

		// Comando SQL
		String sql = "SELECT * FROM funcionarios WHERE id = ?";

		// Tentar realizar o comando SQL
		try {

			// Enviando os par�metros
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, idFuncionario);

			// Executando e retornando dados
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				fb.setIdPessoa(rs.getInt("idPessoa"));
				fb.setNivelDePermissao(rs.getInt("nivelDePermissao"));
				fb.setSalario(rs.getDouble("salario"));
				fb.setSenha(rs.getString("senha"));
			}

			// Fechar a conex�o
			pstmt.close();

		} catch (Exception e) {

			// Caso haja falhas
			JOptionPane.showMessageDialog(null, "Falha ao selecionar os dados" + e.getMessage());

		}

		// Retorno
		return fb;

	}

}
