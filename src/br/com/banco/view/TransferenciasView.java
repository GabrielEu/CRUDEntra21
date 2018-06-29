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

import br.com.banco.dao.TransferenciasDao;

public class TransferenciasView {

	private JTable tabela;
	private JTextField campoIdRemetente;
	private JTextField campoDestinatario;
	private JTextField campoIdCaixa;

	public TransferenciasView() {

		JFrame construtor = new JFrame();
		construtor.setSize(527, 423);
		construtor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		construtor.setLocationRelativeTo(null);
		construtor.getContentPane().setLayout(null);

		JLabel labelIdRemetente = new JLabel("ID do Remetente");
		labelIdRemetente.setBounds(24, 26, 83, 14);
		construtor.getContentPane().add(labelIdRemetente);

		JLabel labelDestinatario = new JLabel("Destinat\u00E1rio");
		labelDestinatario.setBounds(225, 26, 71, 14);
		construtor.getContentPane().add(labelDestinatario);

		JLabel labelValor = new JLabel("Valor");
		labelValor.setBounds(24, 70, 126, 14);
		construtor.getContentPane().add(labelValor);

		campoIdRemetente = new JTextField();
		campoIdRemetente.setBounds(117, 23, 86, 20);
		construtor.getContentPane().add(campoIdRemetente);
		campoIdRemetente.setColumns(10);

		campoDestinatario = new JTextField();
		campoDestinatario.setColumns(10);
		campoDestinatario.setBounds(289, 23, 86, 20);
		construtor.getContentPane().add(campoDestinatario);

		campoIdCaixa = new JTextField();
		campoIdCaixa.setColumns(10);
		campoIdCaixa.setBounds(159, 67, 86, 20);
		construtor.getContentPane().add(campoIdCaixa);

		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoCadastrar.setBounds(139, 142, 220, 49);
		construtor.getContentPane().add(botaoCadastrar);

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

		TransferenciasDao t = new TransferenciasDao();

		tabela = new JTable(t.listarAgencias());

		JScrollPane barra = new JScrollPane(tabela);
		barra.setBounds(10, 202, 491, 137);
		construtor.getContentPane().add(barra);

		construtor.setVisible(true);

	}

}
