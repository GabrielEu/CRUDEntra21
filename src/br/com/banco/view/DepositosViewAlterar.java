package br.com.banco.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DepositosViewAlterar {
	private JTextField campoIdConta;
	private JTextField campoValor;
	private JTextField campoIdCaixa;

	public DepositosViewAlterar(int idDeposito) {
		JFrame construtor = new JFrame();
		construtor.setSize(411, 317);
		construtor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		construtor.getContentPane().setLayout(null);

		JLabel labelIdConta = new JLabel("ID  da conta");
		labelIdConta.setBounds(23, 26, 70, 14);
		construtor.getContentPane().add(labelIdConta);

		JLabel labelValor = new JLabel("Valor");
		labelValor.setBounds(23, 69, 46, 14);
		construtor.getContentPane().add(labelValor);

		JLabel labelIdCaixa = new JLabel("ID do caixa");
		labelIdCaixa.setBounds(23, 108, 70, 14);
		construtor.getContentPane().add(labelIdCaixa);

		campoIdConta = new JTextField();
		campoIdConta.setBounds(103, 23, 86, 20);
		construtor.getContentPane().add(campoIdConta);
		campoIdConta.setColumns(10);

		campoValor = new JTextField();
		campoValor.setColumns(10);
		campoValor.setBounds(103, 66, 86, 20);
		construtor.getContentPane().add(campoValor);

		campoIdCaixa = new JTextField();
		campoIdCaixa.setColumns(10);
		campoIdCaixa.setBounds(103, 105, 86, 20);
		construtor.getContentPane().add(campoIdCaixa);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(281, 232, 104, 35);
		construtor.getContentPane().add(btnAlterar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(144, 232, 104, 35);
		construtor.getContentPane().add(btnExcluir);

		JButton btnVoltar = new JButton("Cancelar");
		btnVoltar.setBounds(10, 232, 105, 35);
		construtor.getContentPane().add(btnVoltar);
		construtor.setLocationRelativeTo(null);

		btnVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				DepositosView dv = new DepositosView();
				construtor.dispose();

			}
		});

		construtor.setVisible(true);

	}

}
