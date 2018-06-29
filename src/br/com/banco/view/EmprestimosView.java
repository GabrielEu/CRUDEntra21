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

import br.com.banco.bean.AgenciasBean;
import br.com.banco.bean.EmprestimosBean;
import br.com.banco.dao.EmprestimosDao;

public class EmprestimosView {

	private JTable tabela;
	private JTextField campoIdConta;
	private JTextField campoValorInicial;
	private JTextField campoValorProxParcela;
	private JTextField campoParcelasRestantes;
	private JTextField campoDataProxParcela;

	public EmprestimosView() {

		JFrame construtor = new JFrame();
		construtor.setSize(527, 423);
		construtor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		construtor.setLocationRelativeTo(null);
		construtor.getContentPane().setLayout(null);

		JLabel labelIdConta = new JLabel("ID da Conta");
		labelIdConta.setBounds(24, 26, 75, 14);
		construtor.getContentPane().add(labelIdConta);

		JLabel labelValorInicial = new JLabel("Valor inicial");
		labelValorInicial.setBounds(225, 26, 71, 14);
		construtor.getContentPane().add(labelValorInicial);

		JLabel labelValorProxParcela = new JLabel("Valor da pr\u00F3xima parcela");
		labelValorProxParcela.setBounds(24, 70, 126, 14);
		construtor.getContentPane().add(labelValorProxParcela);

		JLabel labelParcelasRestantes = new JLabel("Parcelas restantes");
		labelParcelasRestantes.setBounds(272, 70, 103, 14);
		construtor.getContentPane().add(labelParcelasRestantes);

		JLabel labelDataProxParcela = new JLabel("Data da pr\u00F3xima parcela");
		labelDataProxParcela.setBounds(24, 104, 126, 14);
		construtor.getContentPane().add(labelDataProxParcela);

		campoIdConta = new JTextField();
		campoIdConta.setBounds(102, 23, 86, 20);
		construtor.getContentPane().add(campoIdConta);
		campoIdConta.setColumns(10);

		campoValorInicial = new JTextField();
		campoValorInicial.setColumns(10);
		campoValorInicial.setBounds(289, 23, 86, 20);
		construtor.getContentPane().add(campoValorInicial);

		campoValorProxParcela = new JTextField();
		campoValorProxParcela.setColumns(10);
		campoValorProxParcela.setBounds(159, 67, 86, 20);
		construtor.getContentPane().add(campoValorProxParcela);

		campoParcelasRestantes = new JTextField();
		campoParcelasRestantes.setColumns(10);
		campoParcelasRestantes.setBounds(379, 67, 86, 20);
		construtor.getContentPane().add(campoParcelasRestantes);

		campoDataProxParcela = new JTextField();
		campoDataProxParcela.setColumns(10);
		campoDataProxParcela.setBounds(159, 101, 86, 20);
		construtor.getContentPane().add(campoDataProxParcela);

		// Listar Emprestimos
		EmprestimosDao ed = new EmprestimosDao();

		tabela = new JTable(ed.listarAgencias());

		JScrollPane barra = new JScrollPane(tabela);
		barra.setBounds(10, 202, 491, 137);
		construtor.getContentPane().add(barra);

		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoCadastrar.setBounds(139, 142, 220, 49);
		construtor.getContentPane().add(botaoCadastrar);

		botaoCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Obter dados
				EmprestimosBean eb = new EmprestimosBean();
				eb.setIdConta(Integer.parseInt(campoIdConta.getText()));
				eb.setDataProximaParcela(campoDataProxParcela.getText());
				eb.setParcelasRestantes(Integer.parseInt(campoParcelasRestantes.getText()));
				eb.setValorInicial(Double.parseDouble(campoValorInicial.getText()));
				eb.setValorProximaParcela(Double.parseDouble(campoValorProxParcela.getText()));

				// Enviar dados
				ed.cadastrarEmprestimos(eb);

				// Atualizar lista
				tabela = new JTable(ed.listarAgencias());

				// Limpar campos
				campoIdConta.setText("");
				campoDataProxParcela.setText("");
				campoParcelasRestantes.setText("");
				campoValorInicial.setText("");
				campoValorProxParcela.setText("");

			}
		});

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

		construtor.setVisible(true);

	}

}
