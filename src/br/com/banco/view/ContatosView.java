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
import br.com.banco.bean.ContatosBean;
import br.com.banco.dao.ContatosDao;

public class ContatosView {

	private JTable tabela;
	private JTextField campoIdPessoa;
	private JTextField campoContato;

	public ContatosView() {

		JFrame construtor = new JFrame();
		construtor.setSize(527, 423);
		construtor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		construtor.setLocationRelativeTo(null);
		construtor.getContentPane().setLayout(null);

		JLabel labelId = new JLabel("ID");
		labelId.setBounds(24, 26, 75, 14);
		construtor.getContentPane().add(labelId);

		JLabel lblContato = new JLabel("Contato");
		lblContato.setBounds(225, 26, 71, 14);
		construtor.getContentPane().add(lblContato);

		campoIdPessoa = new JTextField();
		campoIdPessoa.setBounds(105, 23, 86, 20);
		construtor.getContentPane().add(campoIdPessoa);
		campoIdPessoa.setColumns(10);

		campoContato = new JTextField();
		campoContato.setColumns(10);
		campoContato.setBounds(306, 23, 86, 20);
		construtor.getContentPane().add(campoContato);

		ContatosDao cd = new ContatosDao();

		tabela = new JTable(cd.listarAgencias());

		// Ação da tabela
		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				// Obter a linha selecionada
				int linhaSelecionada = tabela.getSelectedRow();
				int idContato = (int) tabela.getValueAt(linhaSelecionada, 0);

				// Fechar esse formulário
				construtor.dispose();

				// Instanciar outro formulário
				ContatosViewAlterar cvc = new ContatosViewAlterar(idContato);

			}
		});
		
		JScrollPane barra = new JScrollPane(tabela);
		barra.setBounds(10, 180, 491, 159);
		construtor.getContentPane().add(barra);
		
		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botaoCadastrar.setBounds(138, 119, 220, 49);
		construtor.getContentPane().add(botaoCadastrar);

		botaoCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Obter dados
				ContatosBean cb = new ContatosBean();
				cb.setContato(campoContato.getText());
				cb.setIdPessoa(Integer.parseInt(campoIdPessoa.getText()));

				// Enviar dados
				cd.cadastrarContatos(cb);

				// Atualizar lista
				tabela = new JTable(cd.listarAgencias());

				// Limpar campos
				campoContato.setText("");
				campoIdPessoa.setText("");

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
