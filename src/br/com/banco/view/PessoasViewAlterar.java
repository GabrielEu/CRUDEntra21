package br.com.banco.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PessoasViewAlterar {
	private JTextField campoIdAgencia;
	private JTextField campoNome;
	private JTextField campoCodigo;

	public PessoasViewAlterar(int idPessoa) {
		JFrame construtor = new JFrame();
		construtor.setSize(411, 317);
		construtor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		construtor.getContentPane().setLayout(null);

		JLabel labelIdAgencia = new JLabel("ID da ag\u00EAncia");
		labelIdAgencia.setBounds(23, 26, 70, 14);
		construtor.getContentPane().add(labelIdAgencia);

		JLabel labelNome = new JLabel("Nome");
		labelNome.setBounds(23, 69, 46, 14);
		construtor.getContentPane().add(labelNome);

		JLabel labelCodigo = new JLabel("C\u00F3digo");
		labelCodigo.setBounds(23, 108, 46, 14);
		construtor.getContentPane().add(labelCodigo);

		campoIdAgencia = new JTextField();
		campoIdAgencia.setBounds(103, 23, 86, 20);
		construtor.getContentPane().add(campoIdAgencia);
		campoIdAgencia.setColumns(10);

		campoNome = new JTextField();
		campoNome.setColumns(10);
		campoNome.setBounds(103, 66, 86, 20);
		construtor.getContentPane().add(campoNome);

		campoCodigo = new JTextField();
		campoCodigo.setColumns(10);
		campoCodigo.setBounds(103, 105, 86, 20);
		construtor.getContentPane().add(campoCodigo);

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
			
				PessoasView pv = new PessoasView();
				construtor.dispose();
				
			}
		});
		
		construtor.setVisible(true);

	}
}
