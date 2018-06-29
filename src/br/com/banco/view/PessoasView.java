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
import br.com.banco.bean.PessoasBean;
import br.com.banco.dao.PessoasDao;

public class PessoasView {

	private JTable tabela;
	private JTextField campoIdAgencia;
	private JTextField campoNome;
	private JTextField campoCodigo;

	public PessoasView() {

		JFrame construtor = new JFrame();
		construtor.setSize(527, 423);
		construtor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		construtor.setLocationRelativeTo(null);
		construtor.getContentPane().setLayout(null);

		JLabel labelNome = new JLabel("Nome");
		labelNome.setBounds(225, 26, 71, 14);
		construtor.getContentPane().add(labelNome);

		JLabel labelCodigo = new JLabel("C\u00F3digo");
		labelCodigo.setBounds(24, 70, 126, 14);
		construtor.getContentPane().add(labelCodigo);

		JLabel labelIdAgencia = new JLabel("ID da ag\u00EAncia");
		labelIdAgencia.setBounds(24, 26, 83, 14);
		construtor.getContentPane().add(labelIdAgencia);

		campoIdAgencia = new JTextField();
		campoIdAgencia.setBounds(117, 23, 86, 20);
		construtor.getContentPane().add(campoIdAgencia);
		campoIdAgencia.setColumns(10);

		campoNome = new JTextField();
		campoNome.setColumns(10);
		campoNome.setBounds(289, 23, 86, 20);
		construtor.getContentPane().add(campoNome);

		campoCodigo = new JTextField();
		campoCodigo.setColumns(10);
		campoCodigo.setBounds(159, 67, 86, 20);
		construtor.getContentPane().add(campoCodigo);

		// Listar pessoas
		PessoasDao pd = new PessoasDao();

		// Criar tabela
		tabela = new JTable(pd.listarAgencias());

		// Ação da tabela
		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				// Obter a linha selecionada
				int linhaSelecionada = tabela.getSelectedRow();
				int idPessoa = (int) tabela.getValueAt(linhaSelecionada, 0);

				// Fechar esse formulário
				construtor.dispose();

				// Instanciar outro formulário
				PessoasViewAlterar pvc = new PessoasViewAlterar(idPessoa);

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
				PessoasBean pb = new PessoasBean();
				pb.setCodigo(campoCodigo.getText());
				pb.setIdAgencia(Integer.parseInt(campoIdAgencia.getText()));
				pb.setNome(campoNome.getText());

				// Enviar dados
				pd.cadastrarPessoas(pb);

				// Atualizar lista
				tabela = new JTable(pd.listarAgencias());

				// Limpar campos
				campoCodigo.setText("");
				campoIdAgencia.setText("");
				campoNome.setText("");

				campoNome.requestFocus();

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
