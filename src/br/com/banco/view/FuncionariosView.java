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
import br.com.banco.bean.FuncionariosBean;
import br.com.banco.dao.FuncionariosDao;

public class FuncionariosView {

	private JTable tabela;
	private JTextField campoIdPessoa;
	private JTextField campoSalario;
	private JTextField campoNivelDePermissao;
	private JTextField campoSenha;

	public FuncionariosView() {

		JFrame construtor = new JFrame();
		construtor.setSize(527, 423);
		construtor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		construtor.setLocationRelativeTo(null);
		construtor.getContentPane().setLayout(null);

		JLabel labelIdPessoa = new JLabel("ID da pessoa");
		labelIdPessoa.setBounds(24, 26, 75, 14);
		construtor.getContentPane().add(labelIdPessoa);

		JLabel labelRua = new JLabel("Rua");
		labelRua.setBounds(225, 26, 71, 14);
		construtor.getContentPane().add(labelRua);

		JLabel labelSenha = new JLabel("Senha");
		labelSenha.setBounds(272, 70, 103, 14);
		construtor.getContentPane().add(labelSenha);

		JLabel labelNivelPermissao = new JLabel("N\u00EDvel de permiss\u00E3o");
		labelNivelPermissao.setBounds(24, 70, 126, 14);
		construtor.getContentPane().add(labelNivelPermissao);

		campoNivelDePermissao = new JTextField();
		campoNivelDePermissao.setColumns(10);
		campoNivelDePermissao.setBounds(159, 67, 86, 20);
		construtor.getContentPane().add(campoNivelDePermissao);

		campoIdPessoa = new JTextField();
		campoIdPessoa.setBounds(102, 23, 86, 20);
		construtor.getContentPane().add(campoIdPessoa);
		campoIdPessoa.setColumns(10);

		campoSalario = new JTextField();
		campoSalario.setColumns(10);
		campoSalario.setBounds(289, 23, 86, 20);
		construtor.getContentPane().add(campoSalario);

		campoSenha = new JTextField();
		campoSenha.setColumns(10);
		campoSenha.setBounds(379, 67, 86, 20);
		construtor.getContentPane().add(campoSenha);

		// Listar funcionarios
		FuncionariosDao fd = new FuncionariosDao();

		// Criar tabela
		tabela = new JTable(fd.listarAgencias());

		// Barra de rolagem
		JScrollPane barra = new JScrollPane(tabela);
		barra.setBounds(10, 202, 491, 137);
		construtor.getContentPane().add(barra);

		JButton botaoApagarTudo = new JButton("Apagar todos os registros");
		botaoApagarTudo.setBounds(336, 350, 165, 23);
		construtor.getContentPane().add(botaoApagarTudo);

		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoCadastrar.setBounds(139, 142, 220, 49);
		construtor.getContentPane().add(botaoCadastrar);

		botaoCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Obter dados
				FuncionariosBean fb = new FuncionariosBean();
				fb.setIdPessoa(Integer.parseInt(campoIdPessoa.getText()));
				fb.setNivelDePermissao(Integer.parseInt(campoNivelDePermissao.getText()));
				fb.setSalario(Double.parseDouble(campoSalario.getText()));
				fb.setSenha(campoSenha.getText());

				// Enviar dados
				fd.cadastrarFuncionarios(fb);

				// Atualizar lista
				tabela = new JTable(fd.listarAgencias());

				// Limpar campos
				campoIdPessoa.setText("");
				campoNivelDePermissao.setText("");
				campoSalario.setText("");
				campoSenha.setText("");

				// campoNomeAgencia.requestFocus();

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
