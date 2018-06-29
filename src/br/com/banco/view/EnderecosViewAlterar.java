package br.com.banco.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EnderecosViewAlterar {
	private JTextField campoIdPessoa;
	private JTextField campoRua;
	private JTextField campoNumero;
	private JTextField campoBairro;
	private JTextField campoComplemento;

	public EnderecosViewAlterar(int idEndereco) {
		JFrame construtor = new JFrame();
		construtor.setSize(411, 317);
		construtor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		construtor.getContentPane().setLayout(null);

		JLabel labelIdPessoa = new JLabel("ID da pessoa");
		labelIdPessoa.setBounds(23, 26, 70, 14);
		construtor.getContentPane().add(labelIdPessoa);

		JLabel labelRua = new JLabel("Rua");
		labelRua.setBounds(23, 69, 46, 14);
		construtor.getContentPane().add(labelRua);

		JLabel labelNumero = new JLabel("N\u00FAmero");
		labelNumero.setBounds(23, 108, 46, 14);
		construtor.getContentPane().add(labelNumero);

		campoIdPessoa = new JTextField();
		campoIdPessoa.setBounds(103, 23, 86, 20);
		construtor.getContentPane().add(campoIdPessoa);
		campoIdPessoa.setColumns(10);

		campoRua = new JTextField();
		campoRua.setColumns(10);
		campoRua.setBounds(103, 66, 86, 20);
		construtor.getContentPane().add(campoRua);

		campoNumero = new JTextField();
		campoNumero.setColumns(10);
		campoNumero.setBounds(103, 105, 86, 20);
		construtor.getContentPane().add(campoNumero);

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

				EnderecosView ev = new EnderecosView();
				construtor.dispose();

			}
		});

		JLabel labelBairro = new JLabel("Bairro");
		labelBairro.setBounds(23, 144, 46, 14);
		construtor.getContentPane().add(labelBairro);

		JLabel labelComplemento = new JLabel("Complemento");
		labelComplemento.setBounds(23, 182, 70, 14);
		construtor.getContentPane().add(labelComplemento);

		campoBairro = new JTextField();
		campoBairro.setColumns(10);
		campoBairro.setBounds(103, 141, 86, 20);
		construtor.getContentPane().add(campoBairro);

		campoComplemento = new JTextField();
		campoComplemento.setColumns(10);
		campoComplemento.setBounds(103, 179, 86, 20);
		construtor.getContentPane().add(campoComplemento);
		construtor.setLocationRelativeTo(null);

		construtor.setVisible(true);

	}
}
