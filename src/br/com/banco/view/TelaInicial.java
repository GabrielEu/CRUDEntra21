package br.com.banco.view;

import javax.swing.JFrame;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial {

	public TelaInicial() {

		JFrame construtor = new JFrame();
		construtor.setSize(450, 476);
		construtor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		construtor.setLocationRelativeTo(null);
		construtor.getContentPane().setLayout(null);

		// Botões e ações
		JButton botaoAgencias = new JButton("Ag\u00EAncias");
		botaoAgencias.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botaoAgencias.setBounds(10, 11, 201, 60);
		construtor.getContentPane().add(botaoAgencias);

		botaoAgencias.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				AgenciasView ad = new AgenciasView();
				construtor.dispose();
			}
		});

		JButton botaoCaixasEletronicos = new JButton("Caixas eletr\u00F4nicos");
		botaoCaixasEletronicos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botaoCaixasEletronicos.setBounds(221, 11, 201, 60);
		construtor.getContentPane().add(botaoCaixasEletronicos);

		botaoCaixasEletronicos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				CaixasEletronicosView ce = new CaixasEletronicosView();
				construtor.dispose();

			}
		});

		JButton botaoContas = new JButton("Contas");
		botaoContas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botaoContas.setBounds(10, 82, 201, 60);
		construtor.getContentPane().add(botaoContas);

		botaoContas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ContasView con = new ContasView();
				construtor.dispose();

			}
		});

		JButton botaoContatos = new JButton("Contatos");
		botaoContatos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botaoContatos.setBounds(221, 82, 201, 60);
		construtor.getContentPane().add(botaoContatos);

		botaoContatos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ContatosView con = new ContatosView();
				construtor.dispose();

			}
		});

		JButton botaoEmprestimos = new JButton("Empr\u00E9stimos");
		botaoEmprestimos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botaoEmprestimos.setBounds(221, 224, 201, 60);
		construtor.getContentPane().add(botaoEmprestimos);

		botaoEmprestimos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				EmprestimosView emp = new EmprestimosView();
				construtor.dispose();

			}
		});

		JButton botaoDepositos = new JButton("Dep\u00F3sitos");
		botaoDepositos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botaoDepositos.setBounds(10, 295, 201, 60);
		construtor.getContentPane().add(botaoDepositos);

		botaoDepositos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				DepositosView dep = new DepositosView();
				construtor.dispose();

			}
		});

		JButton botaoFuncionarios = new JButton("Funcionarios");
		botaoFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botaoFuncionarios.setBounds(221, 153, 201, 60);
		construtor.getContentPane().add(botaoFuncionarios);

		botaoFuncionarios.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				FuncionariosView fun = new FuncionariosView();
				construtor.dispose();

			}
		});

		JButton botaoEnderecos = new JButton("Endere\u00E7os");
		botaoEnderecos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botaoEnderecos.setBounds(10, 224, 201, 60);
		construtor.getContentPane().add(botaoEnderecos);

		botaoEnderecos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				EnderecosView end = new EnderecosView();
				construtor.dispose();

			}
		});

		JButton botaoClientes = new JButton("Clientes");
		botaoClientes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botaoClientes.setBounds(10, 153, 201, 60);
		construtor.getContentPane().add(botaoClientes);

		botaoClientes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				PessoasView con = new PessoasView();
				construtor.dispose();

			}
		});

		JButton botaoSaques = new JButton("Saques");
		botaoSaques.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botaoSaques.setBounds(221, 295, 201, 60);
		construtor.getContentPane().add(botaoSaques);

		botaoSaques.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				SaquesView saq = new SaquesView();
				construtor.dispose();

			}
		});

		JButton botaoTransferencias = new JButton("Transfer\u00EAncias");
		botaoTransferencias.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botaoTransferencias.setBounds(221, 366, 201, 60);
		construtor.getContentPane().add(botaoTransferencias);

		botaoTransferencias.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				TransferenciasView tra = new TransferenciasView();
				construtor.dispose();

			}
		});

		JButton botaoSair = new JButton("Sair");
		botaoSair.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoSair.setBounds(10, 389, 132, 37);
		construtor.getContentPane().add(botaoSair);

		botaoSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				construtor.dispose();

			}
		});

		construtor.setVisible(true);

	}
}
