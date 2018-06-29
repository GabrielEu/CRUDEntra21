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
import br.com.banco.bean.DepositosBean;
import br.com.banco.dao.AgenciasDao;
import br.com.banco.dao.DepositosDao;

public class DepositosView {

	private JTable tabela;
	private JTextField campoIdConta;
	private JTextField campoValor;
	private JTextField campoIdCaixa;

	public DepositosView() {

		JFrame construtor = new JFrame();
		construtor.setSize(527, 423);
		construtor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		construtor.setLocationRelativeTo(null);
		construtor.getContentPane().setLayout(null);

		JLabel labelIdConta = new JLabel("ID da Conta");
		labelIdConta.setBounds(24, 26, 75, 14);
		construtor.getContentPane().add(labelIdConta);

		JLabel labelIdCaixa = new JLabel("ID do caixa");
		labelIdCaixa.setBounds(24, 70, 75, 14);
		construtor.getContentPane().add(labelIdCaixa);

		JLabel labelValor = new JLabel("Valor");
		labelValor.setBounds(225, 26, 71, 14);
		construtor.getContentPane().add(labelValor);

		campoIdConta = new JTextField();
		campoIdConta.setBounds(102, 23, 86, 20);
		construtor.getContentPane().add(campoIdConta);
		campoIdConta.setColumns(10);

		campoValor = new JTextField();
		campoValor.setColumns(10);
		campoValor.setBounds(289, 23, 86, 20);
		construtor.getContentPane().add(campoValor);

		campoIdCaixa = new JTextField();
		campoIdCaixa.setColumns(10);
		campoIdCaixa.setBounds(102, 67, 86, 20);
		construtor.getContentPane().add(campoIdCaixa);

		DepositosDao dd = new DepositosDao();

		tabela = new JTable(dd.listarAgencias());

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
				DepositosBean db = new DepositosBean();
				db.setIdCaixa(Integer.parseInt(campoIdCaixa.getText()));
				db.setIdConta(Integer.parseInt(campoIdConta.getText()));
				db.setValorDepositado(Double.parseDouble(campoValor.getText()));

				// Enviar os dados
				dd.cadastrarDepositos(db);

				// Atualizar lista
				tabela = new JTable(dd.listarAgencias());

				// Limpar campos
				campoIdCaixa.setText("");
				campoIdConta.setText("");
				campoValor.setText("");

				campoIdConta.requestFocus();

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
