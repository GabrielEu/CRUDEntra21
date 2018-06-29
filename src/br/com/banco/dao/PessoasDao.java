package br.com.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.banco.bean.AgenciasBean;
import br.com.banco.bean.PessoasBean;
import br.com.banco.connection.ConnectionFactory;

public class PessoasDao {

	// Atributo para obter conexão
		private Connection conexao;

		// Método para estabelecer conexão com o banco de dados
		public PessoasDao() {

			this.conexao = new ConnectionFactory().obterConexao();

		}
		
		// Método para cadastrar agências
			public void cadastrarPessoas(PessoasBean cb) {

				// Comando SQL
				String sql = "INSERT INTO agencias (idAgencia, nome, codigo) VALUES (?, ?, ?)";

				// Tentar realizar o comando SQL
				try {

					// Enviando e executando os parâmetros
					PreparedStatement pstmt = this.conexao.prepareStatement(sql);
					pstmt.setInt(1, cb.getIdAgencia());
					pstmt.setString(2, cb.getNome());
					pstmt.setString(3, cb.getCodigo());
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
			modelo.addColumn("ID da agência");
			modelo.addColumn("Nome");
			modelo.addColumn("Código");

			// Comando SQL
			String sql = "SELECT * FROM pessoas";

			// Tentar realizar o comando SQL
			try {

				// Conectar e selecionar o comando SQL
				java.sql.Statement stmt = conexao.createStatement();

				// Executando comando SQL e obtendo dados
				ResultSet rs = stmt.executeQuery(sql);

				// Listando cursos
				while (rs.next()) {

					modelo.addRow(new Object[] { rs.getInt("id"), rs.getInt("idAgencia"), rs.getString("nome"), rs.getString("codigo") });
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
