package br.com.banco.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.banco.bean.SaquesBean;
import br.com.banco.dao.SaquesDao;

public class SaquesView {

	private JTable tabela;
	private JTextField campoIdConta;
	private JTextField campoValor;
	private JTextField campoIdCaixa;

	public SaquesView() {

		JFrame construtor = new JFrame();
		construtor.setSize(527, 423);
		construtor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		construtor.setLocationRelativeTo(null);
		construtor.getContentPane().setLayout(null);

		JLabel labelIdConta = new JLabel("ID da conta");
		labelIdConta.setBounds(24, 26, 75, 14);
		construtor.getContentPane().add(labelIdConta);

		JLabel labelValor = new JLabel("Valor");
		labelValor.setBounds(225, 26, 71, 14);
		construtor.getContentPane().add(labelValor);

		JLabel labelIdCaixa = new JLabel("ID do caixa");
		labelIdCaixa.setBounds(24, 70, 126, 14);
		construtor.getContentPane().add(labelIdCaixa);

		campoIdConta = new JTextField();
		campoIdConta.setBounds(102, 23, 86, 20);
		construtor.getContentPane().add(campoIdConta);
		campoIdConta.setColumns(10);

		campoValor = new JTextField();
		campoValor.setColumns(10);
		campoValor.setBounds(289, 23, 86, 20);
		construtor.getContentPane().add(campoValor);

		campoIdCaixa = new JTextField();
		campoIdCaixa.setColumns(10);
		campoIdCaixa.setBounds(159, 67, 86, 20);
		construtor.getContentPane().add(campoIdCaixa);

		// Listar saques
		SaquesDao sd = new SaquesDao();

		// Criar tabela
		tabela = new JTable(sd.listarAgencias());

		// Ação da tabela
		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				// Obter a linha selecionada
				int linhaSelecionada = tabela.getSelectedRow();
				int idSaques= (int) tabela.getValueAt(linhaSelecionada, 0);

				// Fechar esse formulário
				construtor.dispose();

				// Instanciar outro formulário
				SaquesViewAlterar svc = new SaquesViewAlterar(idSaques);

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

				// Instanciar tempo do registro
				LocalDateTime tempo = LocalDateTime.now();

				// Obter momento
				int ano = tempo.getYear();
				int mes = tempo.getMonthValue();
				int dia = tempo.getDayOfMonth();

				int horas = tempo.getHour();
				int minutos = tempo.getMinute();
				int segundos = tempo.getSecond();

				// Obter dados
				SaquesBean sb = new SaquesBean();
				sb.setIdCaixa(Integer.parseInt(campoIdCaixa.getText()));
				sb.setIdConta(Integer.parseInt(campoIdConta.getText()));
				sb.setValorSacado(Double.parseDouble(campoValor.getText()));
				sb.setDataEHora(ano + "-" + mes + "-" + dia + " " + horas + ":" + minutos + ":" + segundos);

				// Enviar dados
				sd.cadastrarSaques(sb);

				// Atualizar lista
				tabela = new JTable(sd.listarAgencias());

				// Limpar campos
				campoIdCaixa.setText("");
				campoIdConta.setText("");
				campoValor.setText("");

				campoIdConta.requestFocus();

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
