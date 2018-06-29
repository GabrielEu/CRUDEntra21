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
import br.com.banco.bean.ContasBean;
import br.com.banco.dao.ContasDao;

public class ContasView {

	private JTable tabela;
	private JTextField campoIdPessoa;
	private JTextField campoContaCorrente;
	private JTextField campoAgencia;
	private JTextField campoFundos;
	private JTextField campoSenha;

	public ContasView() {

		JFrame construtor = new JFrame();
		construtor.setSize(527, 423);
		construtor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		construtor.setLocationRelativeTo(null);
		construtor.getContentPane().setLayout(null);

		JLabel labelIdPessoa = new JLabel("ID da pessoa");
		labelIdPessoa.setBounds(24, 26, 75, 14);
		construtor.getContentPane().add(labelIdPessoa);

		JLabel labelFundos = new JLabel("Fundos");
		labelFundos.setBounds(225, 71, 71, 14);
		construtor.getContentPane().add(labelFundos);

		JLabel labelSenha = new JLabel("Senha");
		labelSenha.setBounds(24, 106, 75, 14);
		construtor.getContentPane().add(labelSenha);

		JLabel lblContaCorrente = new JLabel("Conta corrente");
		lblContaCorrente.setBounds(225, 26, 71, 14);
		construtor.getContentPane().add(lblContaCorrente);

		JLabel labelAgencia = new JLabel("Ag\u00EAncia");
		labelAgencia.setBounds(24, 71, 75, 14);
		construtor.getContentPane().add(labelAgencia);

		campoIdPessoa = new JTextField();
		campoIdPessoa.setBounds(105, 23, 86, 20);
		construtor.getContentPane().add(campoIdPessoa);
		campoIdPessoa.setColumns(10);

		campoContaCorrente = new JTextField();
		campoContaCorrente.setColumns(10);
		campoContaCorrente.setBounds(306, 23, 86, 20);
		construtor.getContentPane().add(campoContaCorrente);

		campoAgencia = new JTextField();
		campoAgencia.setColumns(10);
		campoAgencia.setBounds(105, 68, 86, 20);
		construtor.getContentPane().add(campoAgencia);

		campoFundos = new JTextField();
		campoFundos.setColumns(10);
		campoFundos.setBounds(306, 68, 86, 20);
		construtor.getContentPane().add(campoFundos);

		campoSenha = new JTextField();
		campoSenha.setColumns(10);
		campoSenha.setBounds(105, 99, 86, 20);
		construtor.getContentPane().add(campoSenha);

		ContasDao cd = new ContasDao();

		tabela = new JTable(cd.listarAgencias());

		JScrollPane barra = new JScrollPane(tabela);
		barra.setBounds(10, 199, 491, 140);
		construtor.getContentPane().add(barra);

		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoCadastrar.setBounds(139, 139, 220, 49);
		construtor.getContentPane().add(botaoCadastrar);

		botaoCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Obter dados
				ContasBean cb = new ContasBean();
				cb.setAgencia(Integer.parseInt(campoAgencia.getText()));
				cb.setContaCorrente(campoContaCorrente.getText());
				cb.setFundos(Integer.parseInt(campoFundos.getText()));
				cb.setIdPessoa(Integer.parseInt(campoIdPessoa.getText()));
				cb.setSenha(campoSenha.getText());

				// Enviar dados
				cd.cadastrarContas(cb);

				// Atualizar lista
				tabela = new JTable(cd.listarAgencias());

				// Limpar campos
				campoAgencia.setText("");
				campoContaCorrente.setText("");
				campoFundos.setText("");
				campoIdPessoa.setText("");
				campoSenha.setText("");

				campoAgencia.requestFocus();

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
