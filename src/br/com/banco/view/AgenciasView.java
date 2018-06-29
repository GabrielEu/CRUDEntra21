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
import br.com.banco.dao.AgenciasDao;

public class AgenciasView {

	private JTable tabela;
	private JTextField campoNomeAgencia;
	private JTextField campoEndereco;
	private JTextField campoTelefone;

	public AgenciasView() {

		JFrame construtor = new JFrame();
		construtor.setSize(527, 423);
		construtor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		construtor.setLocationRelativeTo(null);
		construtor.getContentPane().setLayout(null);

		JLabel labelNome = new JLabel("Nome");
		labelNome.setBounds(24, 26, 46, 14);
		construtor.getContentPane().add(labelNome);

		JLabel labelEndereco = new JLabel("Endere\u00E7o");
		labelEndereco.setBounds(24, 68, 46, 14);
		construtor.getContentPane().add(labelEndereco);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(239, 26, 46, 14);
		construtor.getContentPane().add(lblTelefone);

		campoNomeAgencia = new JTextField();
		campoNomeAgencia.setBounds(105, 23, 86, 20);
		construtor.getContentPane().add(campoNomeAgencia);
		campoNomeAgencia.setColumns(10);

		campoEndereco = new JTextField();
		campoEndereco.setColumns(10);
		campoEndereco.setBounds(105, 65, 86, 20);
		construtor.getContentPane().add(campoEndereco);

		campoTelefone = new JTextField();
		campoTelefone.setColumns(10);
		campoTelefone.setBounds(306, 23, 86, 20);
		construtor.getContentPane().add(campoTelefone);

		// Instanciar listagem
		AgenciasDao ad = new AgenciasDao();

		tabela = new JTable(ad.listarAgencias());

		JScrollPane barra = new JScrollPane(tabela);
		barra.setBounds(10, 180, 491, 159);
		construtor.getContentPane().add(barra);

		JButton botaoApagarTudo = new JButton("Apagar todos os registros");
		botaoApagarTudo.setBounds(336, 350, 165, 23);
		construtor.getContentPane().add(botaoApagarTudo);

		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoCadastrar.setBounds(138, 119, 220, 49);
		construtor.getContentPane().add(botaoCadastrar);

		botaoCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Obter dados
				AgenciasBean ab = new AgenciasBean();
				ab.setNomeAgencia(campoNomeAgencia.getText());
				ab.setEnderecoAgencia(campoEndereco.getText());
				ab.setTelefoneAgencia(Integer.parseInt(campoTelefone.getText()));

				// Enviar dados
				ad.cadastrarAgencias(ab);

				// Atualizar lista
				tabela = new JTable(ad.listarAgencias());

				// Limpar campos
				campoNomeAgencia.setText("");
				campoEndereco.setText("");
				campoTelefone.setText("");

				campoNomeAgencia.requestFocus();

			}
		});

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
