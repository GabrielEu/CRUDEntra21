package br.com.banco.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ContasViewAlterar {
	private JTextField campoIdPessoa;
	private JTextField campoContaCorrente;
	private JTextField campoAgencia;
	private JTextField campoFundos;
	private JTextField campoSenha;

	public ContasViewAlterar(int idConta) {
		JFrame construtor = new JFrame();
		construtor.setSize(411, 317);
		construtor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		construtor.getContentPane().setLayout(null);

		JLabel labelIdPessoa = new JLabel("ID da pessoa");
		labelIdPessoa.setBounds(23, 26, 70, 14);
		construtor.getContentPane().add(labelIdPessoa);

		JLabel labelContaCorrente = new JLabel("ContaCorrente");
		labelContaCorrente.setBounds(23, 69, 84, 14);
		construtor.getContentPane().add(labelContaCorrente);

		JLabel labelAgencia = new JLabel("Ag\u00EAncia");
		labelAgencia.setBounds(23, 108, 46, 14);
		construtor.getContentPane().add(labelAgencia);

		campoIdPessoa = new JTextField();
		campoIdPessoa.setBounds(103, 23, 86, 20);
		construtor.getContentPane().add(campoIdPessoa);
		campoIdPessoa.setColumns(10);

		campoContaCorrente = new JTextField();
		campoContaCorrente.setColumns(10);
		campoContaCorrente.setBounds(117, 66, 86, 20);
		construtor.getContentPane().add(campoContaCorrente);

		campoAgencia = new JTextField();
		campoAgencia.setColumns(10);
		campoAgencia.setBounds(103, 105, 86, 20);
		construtor.getContentPane().add(campoAgencia);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(281, 232, 104, 35);
		construtor.getContentPane().add(btnAlterar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(144, 232, 104, 35);
		construtor.getContentPane().add(btnExcluir);

		JButton btnVoltar = new JButton("Cancelar");
		btnVoltar.setBounds(10, 232, 105, 35);
		construtor.getContentPane().add(btnVoltar);

		btnVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ContasView cv = new ContasView();
				construtor.dispose();

			}
		});

		JLabel labelFundos = new JLabel("Fundos");
		labelFundos.setBounds(23, 144, 46, 14);
		construtor.getContentPane().add(labelFundos);

		JLabel labelSenha = new JLabel("Senha");
		labelSenha.setBounds(23, 181, 46, 14);
		construtor.getContentPane().add(labelSenha);

		campoFundos = new JTextField();
		campoFundos.setColumns(10);
		campoFundos.setBounds(103, 141, 86, 20);
		construtor.getContentPane().add(campoFundos);

		campoSenha = new JTextField();
		campoSenha.setColumns(10);
		campoSenha.setBounds(103, 178, 86, 20);
		construtor.getContentPane().add(campoSenha);
		construtor.setLocationRelativeTo(null);

		construtor.setVisible(true);

	}

}
