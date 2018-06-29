package br.com.banco.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class CaixasEletronicosViewAlterar {
	private JTextField campoFundos;
	private JTextField campoIdAgencia;

	public CaixasEletronicosViewAlterar(int idCaixaEletronico) {

		JFrame construtor = new JFrame();
		construtor.setSize(411, 317);
		construtor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		construtor.getContentPane().setLayout(null);

		JLabel labelFundos = new JLabel("Fundos");
		labelFundos.setBounds(23, 26, 46, 14);
		construtor.getContentPane().add(labelFundos);

		JLabel labelIdAgencias = new JLabel("ID da ag\u00EAncia");
		labelIdAgencias.setBounds(23, 69, 70, 14);
		construtor.getContentPane().add(labelIdAgencias);

		campoFundos = new JTextField();
		campoFundos.setBounds(103, 23, 86, 20);
		construtor.getContentPane().add(campoFundos);
		campoFundos.setColumns(10);

		campoIdAgencia = new JTextField();
		campoIdAgencia.setColumns(10);
		campoIdAgencia.setBounds(103, 66, 86, 20);
		construtor.getContentPane().add(campoIdAgencia);

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

				CaixasEletronicosView cev = new CaixasEletronicosView();
				construtor.dispose();

			}
		});

		construtor.setVisible(true);

	}

}
