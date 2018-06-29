package br.com.banco.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.banco.bean.AgenciasBean;
import br.com.banco.bean.CaixasEletronicosBean;
import br.com.banco.dao.CaixasEletronicosDao;

public class CaixasEletronicosView {

	private JTable tabela;
	private JTextField campoFundos;
	private JTextField campoIdAgencia;

	public CaixasEletronicosView() {

		JFrame construtor = new JFrame();
		construtor.setSize(527, 423);
		construtor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		construtor.setLocationRelativeTo(null);
		construtor.getContentPane().setLayout(null);

		JLabel labelFundos = new JLabel("Fundos");
		labelFundos.setBounds(24, 26, 46, 14);
		construtor.getContentPane().add(labelFundos);

		JLabel labelId = new JLabel("ID");
		labelId.setBounds(236, 26, 46, 14);
		construtor.getContentPane().add(labelId);

		campoFundos = new JTextField();
		campoFundos.setBounds(105, 23, 86, 20);
		construtor.getContentPane().add(campoFundos);
		campoFundos.setColumns(10);

		campoIdAgencia = new JTextField();
		campoIdAgencia.setColumns(10);
		campoIdAgencia.setBounds(306, 23, 86, 20);
		construtor.getContentPane().add(campoIdAgencia);

		// Listar Caixas Eletronicos
		CaixasEletronicosDao ced = new CaixasEletronicosDao();

		// Criar tabela
		tabela = new JTable(ced.listarAgencias());
		construtor.getContentPane().add(tabela);

		// Barra de rolagem
		JScrollPane barra = new JScrollPane(tabela);
		barra.setBounds(10, 180, 491, 159);
		construtor.getContentPane().add(barra);

		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoCadastrar.setBounds(138, 119, 220, 49);
		construtor.getContentPane().add(botaoCadastrar);

		botaoCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Obter dados
				CaixasEletronicosBean ceb = new CaixasEletronicosBean();
				ceb.setFundo(Double.parseDouble(campoFundos.getText()));
				ceb.setIdAgencia(Integer.parseInt(campoIdAgencia.getText()));

				// Enviar dados
				ced.cadastrarCaixasEletronicos(ceb);

				// Atualizar lista
				tabela = new JTable(ced.listarAgencias());

				// Limpar campos
				campoFundos.setText("");
				campoIdAgencia.setText("");

				campoIdAgencia.requestFocus();

			}
		});

		JButton botaoApagarTudo = new JButton("Apagar todos os registros");
		botaoApagarTudo.setBounds(336, 350, 165, 23);
		construtor.getContentPane().add(botaoApagarTudo);

		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setBounds(10, 350, 89, 23);
		construtor.getContentPane().add(botaoVoltar);

		botaoVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				TelaInicial ti = new TelaInicial();
				construtor.dispose();

			}
		});

		construtor.setVisible(true);

	}

}
