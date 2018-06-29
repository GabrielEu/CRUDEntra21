package br.com.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.banco.bean.AgenciasBean;
import br.com.banco.bean.ContasBean;
import br.com.banco.connection.ConnectionFactory;

public class ContasDao {

	// Atributo para obter conex�o
		private Connection conexao;

		// M�todo para estabelecer conex�o com o banco de dados
		public ContasDao() {

			this.conexao = new ConnectionFactory().obterConexao();
 
		}
		
		// M�todo para cadastrar ag�ncias
			public void cadastrarContas(ContasBean cb) {

				// Comando SQL
				String sql = "INSERT INTO agencias (idPessoa, contaCorrente, agencia, fundos, senha) VALUES (?, ?, ?, ?, ?)";

				// Tentar realizar o comando SQL
				try {

					// Enviando e executando os par�metros
					PreparedStatement pstmt = this.conexao.prepareStatement(sql);
					pstmt.setInt(1, cb.getIdPessoa());
					pstmt.setString(2, cb.getContaCorrente());
					pstmt.setInt(3, cb.getAgencia());
					pstmt.setDouble(4, cb.getFundos());
					pstmt.setString(5, cb.getSenha()); 
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
			modelo.addColumn("ID pessoa");
			modelo.addColumn("Conta corrente");
			modelo.addColumn("Ag�ncia");
			modelo.addColumn("Fundos");
			modelo.addColumn("Senha");
			
			// Comando SQL
			String sql = "SELECT * FROM contas";

			// Tentar realizar o comando SQL
			try {

				// Conectar e selecionar o comando SQL
				java.sql.Statement stmt = conexao.createStatement();

				// Executando comando SQL e obtendo dados
				ResultSet rs = stmt.executeQuery(sql);

				// Listando cursos
				while (rs.next()) {

					modelo.addRow(new Object[] { rs.getInt("id"), rs.getString("idPessoa"), rs.getString("contaCorrente"), rs.getInt("agencia"),
							rs.getDouble("fundos"), rs.getString("senha") });
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
