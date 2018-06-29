package br.com.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.banco.bean.AgenciasBean;
import br.com.banco.bean.EmprestimosBean;
import br.com.banco.connection.ConnectionFactory;

public class EmprestimosDao {

	// Atributo para obter conex�o
		private Connection conexao;

		// M�todo para estabelecer conex�o com o banco de dados
		public EmprestimosDao() {

			this.conexao = new ConnectionFactory().obterConexao();

		}
		
		// M�todo para cadastrar ag�ncias
			public void cadastrarEmprestimos(EmprestimosBean eb) {

				// Comando SQL
				String sql = "INSERT INTO agencias (idConta, valorInicial, valorProximaParcela, dataProximaParcela, parcelasRestantes) VALUES (?, ?, ?, ?, ?)";

				// Tentar realizar o comando SQL
				try {

					// Enviando e executando os par�metros
					PreparedStatement pstmt = this.conexao.prepareStatement(sql);
					pstmt.setInt(1, eb.getIdConta());
					pstmt.setDouble(2, eb.getValorInicial());
					pstmt.setDouble(3, eb.getValorProximaParcela());
					pstmt.setString(4, eb.getDataProximaParcela());
					pstmt.setInt(5, eb.getParcelasRestantes());
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
			modelo.addColumn("ID da conta");
			modelo.addColumn("Valor inicial");
			modelo.addColumn("Valor da pr�xima parcela");
			modelo.addColumn("Data da pr�xima parcela");
			modelo.addColumn("Parcelas Restantes");
			
			
			// Comando SQL
			String sql = "SELECT * FROM emprestimos";

			// Tentar realizar o comando SQL
			try {

				// Conectar e selecionar o comando SQL
				java.sql.Statement stmt = conexao.createStatement();

				// Executando comando SQL e obtendo dados
				ResultSet rs = stmt.executeQuery(sql);

				// Listando cursos
				while (rs.next()) {

					modelo.addRow(new Object[] { rs.getInt("id"), rs.getInt("idConta"), rs.getInt("valorInicial"), rs.getInt("valorProximaParcela"),
							rs.getInt("dataProximaParcela"), rs.getInt("parcelasRestantes")});
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
