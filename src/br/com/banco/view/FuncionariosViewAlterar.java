package br.com.banco.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FuncionariosViewAlterar {
	private JTextField campoIdPessoa;
	private JTextField campoSalario;
	private JTextField campoNivelPermissao;
	private JTextField campoSenha;

	public FuncionariosViewAlterar(int idFuncionario) {

		JFrame construtor = new JFrame();
		construtor.setSize(411, 317);
		construtor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		construtor.getContentPane().setLayout(null);

		JLabel labelIdPessoa = new JLabel("ID da pessoa");
		labelIdPessoa.setBounds(23, 26, 70, 14);
		construtor.getContentPane().add(labelIdPessoa);

		JLabel labelSalario = new JLabel("Sal\u00E1rio");
		labelSalario.setBounds(23, 69, 46, 14);
		construtor.getContentPane().add(labelSalario);

		JLabel labelNivelDePermissao = new JLabel("N\u00EDvel de permiss\u00E3o");
		labelNivelDePermissao.setBounds(23, 108, 92, 14);
		construtor.getContentPane().add(labelNivelDePermissao);

		campoIdPessoa = new JTextField();
		campoIdPessoa.setBounds(103, 23, 86, 20);
		construtor.getContentPane().add(campoIdPessoa);
		campoIdPessoa.setColumns(10);

		campoSalario = new JTextField();
		campoSalario.setColumns(10);
		campoSalario.setBounds(103, 66, 86, 20);
		construtor.getContentPane().add(campoSalario);

		campoNivelPermissao = new JTextField();
		campoNivelPermissao.setColumns(10);
		campoNivelPermissao.setBounds(125, 105, 86, 20);
		construtor.getContentPane().add(campoNivelPermissao);

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

				FuncionariosView fv = new FuncionariosView();
				construtor.dispose();

			}
		});

		JLabel labelSenha = new JLabel("Senha");
		labelSenha.setBounds(23, 146, 46, 14);
		construtor.getContentPane().add(labelSenha);

		campoSenha = new JTextField();
		campoSenha.setColumns(10);
		campoSenha.setBounds(103, 143, 86, 20);
		construtor.getContentPane().add(campoSenha);
		construtor.setLocationRelativeTo(null);

		construtor.setVisible(true);

	}

}
