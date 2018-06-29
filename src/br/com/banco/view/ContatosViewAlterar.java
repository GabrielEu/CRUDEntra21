package br.com.banco.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ContatosViewAlterar {
	private JTextField campoIdPessoa;
	private JTextField campoContato;

	public ContatosViewAlterar(int idContato) {
		JFrame construtor = new JFrame();
		construtor.setSize(411, 317);
		construtor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		construtor.getContentPane().setLayout(null);

		JLabel labelIdPessoa = new JLabel("ID da pessoa");
		labelIdPessoa.setBounds(23, 26, 63, 14);
		construtor.getContentPane().add(labelIdPessoa);

		JLabel labelContato = new JLabel("Contato");
		labelContato.setBounds(23, 69, 46, 14);
		construtor.getContentPane().add(labelContato);

		campoIdPessoa = new JTextField();
		campoIdPessoa.setBounds(103, 23, 86, 20);
		construtor.getContentPane().add(campoIdPessoa);
		campoIdPessoa.setColumns(10);

		campoContato = new JTextField();
		campoContato.setColumns(10);
		campoContato.setBounds(103, 66, 86, 20);
		construtor.getContentPane().add(campoContato);

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

				ContatosView cv = new ContatosView();
				construtor.dispose();

			}
		});

		construtor.setVisible(true);

	}

}
