package br.com.banco.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.banco.bean.AgenciasBean;
import br.com.banco.dao.AgenciasDao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AgenciasViewAlterar {
	private JTextField campoNome;
	private JTextField campoEndereco;
	private JTextField campoTelefone;

	public AgenciasViewAlterar(int idAgencia) {

		JFrame construtor = new JFrame();
		construtor.setSize(411, 317);
		construtor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		construtor.getContentPane().setLayout(null);

		JLabel labelNome = new JLabel("Nome");
		labelNome.setBounds(23, 26, 46, 14);
		construtor.getContentPane().add(labelNome);

		JLabel labelEndereco = new JLabel("Endere\u00E7o");
		labelEndereco.setBounds(23, 69, 46, 14);
		construtor.getContentPane().add(labelEndereco);

		JLabel labelTelefone = new JLabel("Telefone");
		labelTelefone.setBounds(23, 108, 46, 14);
		construtor.getContentPane().add(labelTelefone);

		// Instanciar bean e adquirir a informação selecionada
		AgenciasBean ab = new AgenciasBean();

		campoNome = new JTextField(ab.getNomeAgencia());
		campoNome.setBounds(103, 23, 86, 20);
		construtor.getContentPane().add(campoNome);
		campoNome.setColumns(10);

		campoEndereco = new JTextField(ab.getEnderecoAgencia());
		campoEndereco.setColumns(10);
		campoEndereco.setBounds(103, 66, 86, 20);
		construtor.getContentPane().add(campoEndereco);

		campoTelefone = new JTextField(ab.getTelefoneAgencia());
		campoTelefone.setColumns(10);
		campoTelefone.setBounds(103, 105, 86, 20);
		construtor.getContentPane().add(campoTelefone);

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

				AgenciasView av = new AgenciasView();
				construtor.dispose();

			}
		});

		construtor.setVisible(true);

	}
}
