package br.com.banco.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.banco.bean.AgenciasBean;
import br.com.banco.bean.EnderecosBean;
import br.com.banco.dao.EnderecosDao;

public class EnderecosView {

	private JTable tabela;
	private JTextField campoIdPessoa;
	private JTextField campoRua;
	private JTextField campoNumero;
	private JTextField campoBairro;
	private JTextField campoComplemento;

	public EnderecosView() {

		JFrame construtor = new JFrame();
		construtor.setSize(527, 423);
		construtor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		construtor.setLocationRelativeTo(null);
		construtor.getContentPane().setLayout(null);

		JLabel labelIdPessoa = new JLabel("ID da pessoa");
		labelIdPessoa.setBounds(24, 26, 75, 14);
		construtor.getContentPane().add(labelIdPessoa);

		JLabel labelNumero = new JLabel("N\u00FAmero");
		labelNumero.setBounds(24, 70, 126, 14);
		construtor.getContentPane().add(labelNumero);

		JLabel labelRua = new JLabel("Rua");
		labelRua.setBounds(225, 26, 71, 14);
		construtor.getContentPane().add(labelRua);

		JLabel labelBairro = new JLabel("Bairro");
		labelBairro.setBounds(272, 70, 103, 14);
		construtor.getContentPane().add(labelBairro);

		JLabel labelComplemento = new JLabel("Complemento");
		labelComplemento.setBounds(24, 104, 126, 14);
		construtor.getContentPane().add(labelComplemento);

		campoIdPessoa = new JTextField();
		campoIdPessoa.setBounds(102, 23, 86, 20);
		construtor.getContentPane().add(campoIdPessoa);
		campoIdPessoa.setColumns(10);

		campoRua = new JTextField();
		campoRua.setColumns(10);
		campoRua.setBounds(289, 23, 86, 20);
		construtor.getContentPane().add(campoRua);

		campoNumero = new JTextField();
		campoNumero.setColumns(10);
		campoNumero.setBounds(159, 67, 86, 20);
		construtor.getContentPane().add(campoNumero);

		campoBairro = new JTextField();
		campoBairro.setColumns(10);
		campoBairro.setBounds(379, 67, 86, 20);
		construtor.getContentPane().add(campoBairro);

		campoComplemento = new JTextField();
		campoComplemento.setColumns(10);
		campoComplemento.setBounds(159, 101, 86, 20);
		construtor.getContentPane().add(campoComplemento);

		// Listar Endereços
		EnderecosDao dd = new EnderecosDao();

		// Criar tabela
		tabela = new JTable(dd.listarAgencias());

		// Ação da tabela
		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				// Obter a linha selecionada
				int linhaSelecionada = tabela.getSelectedRow();
				int idEndereco= (int) tabela.getValueAt(linhaSelecionada, 0);

				// Fechar esse formulário
				construtor.dispose();

				// Instanciar outro formulário
				EnderecosViewAlterar evc = new EnderecosViewAlterar(idEndereco);

			}
		});
		
		// Barra de rolagem
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
				EnderecosBean db = new EnderecosBean();
				db.setBairro(campoBairro.getText());
				db.setComplemento(campoComplemento.getText());
				db.setIdPessoa(Integer.parseInt(campoIdPessoa.getText()));
				db.setNumero(Integer.parseInt(campoNumero.getText()));
				db.setRua(campoRua.getText());
				
				// Enviar dados
				dd.cadastrarEnderecos(db);

				// Atualizar lista
				tabela = new JTable(dd.listarAgencias());

				// Limpar campos
				campoBairro.setText("");
				campoComplemento.setText("");
				campoIdPessoa.setText("");
				campoNumero.setText("");
				campoRua.setText("");
				
				campoIdPessoa.requestFocus();

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
