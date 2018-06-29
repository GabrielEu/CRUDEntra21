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

	// Atributo para obter conexão
		private Connection conexao;

		// Método para estabelecer conexão com o banco de dados
		public EmprestimosDao() {

			this.conexao = new ConnectionFactory().obterConexao();

		}
		
		// Método para cadastrar agências
			public void cadastrarEmprestimos(EmprestimosBean eb) {

				// Comando SQL
				String sql = "INSERT INTO agencias (idConta, valorInicial, valorProximaParcela, dataProximaParcela, parcelasRestantes) VALUES (?, ?, ?, ?, ?)";

				// Tentar realizar o comando SQL
				try {

					// Enviando e executando os parâmetros
					PreparedStatement pstmt = this.conexao.prepareStatement(sql);
					pstmt.setInt(1, eb.getIdConta());
					pstmt.setDouble(2, eb.getValorInicial());
					pstmt.setDouble(3, eb.getValorProximaParcela());
					pstmt.setString(4, eb.getDataProximaParcela());
					pstmt.setInt(5, eb.getParcelasRestantes());
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
			modelo.addColumn("Valor inicial");
			modelo.addColumn("Valor da próxima parcela");
			modelo.addColumn("Data da próxima parcela");
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
