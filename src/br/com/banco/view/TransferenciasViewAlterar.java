package br.com.banco.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TransferenciasViewAlterar {
	private JTextField campoRemetente;
	private JTextField campoDestinatario;
	private JTextField campoValor;
	private JTextField campoIdCaixa;

	public TransferenciasViewAlterar(int idTransferencia) {

		JFrame construtor = new JFrame();
		construtor.setSize(411, 317);
		construtor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		construtor.getContentPane().setLayout(null);

		JLabel labelRemetente = new JLabel("Remetente");
		labelRemetente.setBounds(23, 26, 70, 14);
		construtor.getContentPane().add(labelRemetente);

		JLabel labelDestinatario = new JLabel("Destinat\u00E1rio");
		labelDestinatario.setBounds(23, 69, 70, 14);
		construtor.getContentPane().add(labelDestinatario);

		JLabel labelValor = new JLabel("Valor");
		labelValor.setBounds(23, 108, 46, 14);
		construtor.getContentPane().add(labelValor);

		campoRemetente = new JTextField();
		campoRemetente.setBounds(103, 23, 86, 20);
		construtor.getContentPane().add(campoRemetente);
		campoRemetente.setColumns(10);

		campoDestinatario = new JTextField();
		campoDestinatario.setColumns(10);
		campoDestinatario.setBounds(103, 66, 86, 20);
		construtor.getContentPane().add(campoDestinatario);

		campoValor = new JTextField();
		campoValor.setColumns(10);
		campoValor.setBounds(103, 105, 86, 20);
		construtor.getContentPane().add(campoValor);

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

				TransferenciasView tv = new TransferenciasView();
				construtor.dispose();

			}
		});

		JLabel labelIdCaixa = new JLabel("ID do caixa");
		labelIdCaixa.setBounds(23, 144, 70, 17);
		construtor.getContentPane().add(labelIdCaixa);

		campoIdCaixa = new JTextField();
		campoIdCaixa.setColumns(10);
		campoIdCaixa.setBounds(103, 141, 86, 20);
		construtor.getContentPane().add(campoIdCaixa);
		construtor.setLocationRelativeTo(null);

		construtor.setVisible(true);

	}

}
