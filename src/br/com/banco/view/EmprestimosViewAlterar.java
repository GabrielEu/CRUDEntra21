package br.com.banco.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EmprestimosViewAlterar {
	private JTextField campoIdConta;
	private JTextField campoValorInicial;
	private JTextField campoValorProximaParcela;
	private JTextField campoDataProximaParcela;
	private JTextField campoParcelasRestantes;

	public EmprestimosViewAlterar(int idEmprestimo) {
		JFrame construtor = new JFrame();
		construtor.setSize(411, 317);
		construtor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		construtor.getContentPane().setLayout(null);

		JLabel labelIdConta = new JLabel("ID da conta");
		labelIdConta.setBounds(23, 26, 70, 14);
		construtor.getContentPane().add(labelIdConta);

		JLabel labelValorInicial = new JLabel("Valor inicial");
		labelValorInicial.setBounds(23, 69, 70, 14);
		construtor.getContentPane().add(labelValorInicial);

		JLabel labelValorProximaParcela = new JLabel("Valor da pr\u00F3xima parcela");
		labelValorProximaParcela.setBounds(23, 108, 129, 14);
		construtor.getContentPane().add(labelValorProximaParcela);

		campoIdConta = new JTextField();
		campoIdConta.setBounds(103, 23, 86, 20);
		construtor.getContentPane().add(campoIdConta);
		campoIdConta.setColumns(10);

		campoValorInicial = new JTextField();
		campoValorInicial.setColumns(10);
		campoValorInicial.setBounds(103, 66, 86, 20);
		construtor.getContentPane().add(campoValorInicial);

		campoValorProximaParcela = new JTextField();
		campoValorProximaParcela.setColumns(10);
		campoValorProximaParcela.setBounds(162, 105, 86, 20);
		construtor.getContentPane().add(campoValorProximaParcela);

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

				EmprestimosView ev = new EmprestimosView();
				construtor.dispose();

			}
		});

		JLabel labelDataProximaParcela = new JLabel("Data da pr\u00F3xima parcela");
		labelDataProximaParcela.setBounds(23, 146, 117, 14);
		construtor.getContentPane().add(labelDataProximaParcela);

		JLabel labelParcelasRestantes = new JLabel("Parcelas restantes");
		labelParcelasRestantes.setBounds(23, 184, 92, 14);
		construtor.getContentPane().add(labelParcelasRestantes);

		campoDataProximaParcela = new JTextField();
		campoDataProximaParcela.setColumns(10);
		campoDataProximaParcela.setBounds(162, 143, 86, 20);
		construtor.getContentPane().add(campoDataProximaParcela);

		campoParcelasRestantes = new JTextField();
		campoParcelasRestantes.setColumns(10);
		campoParcelasRestantes.setBounds(134, 181, 86, 20);
		construtor.getContentPane().add(campoParcelasRestantes);
		construtor.setLocationRelativeTo(null);

		construtor.setVisible(true);

	}

}
