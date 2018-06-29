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

import br.com.banco.bean.TransferenciasBean;
import br.com.banco.dao.TransferenciasDao;

public class TransferenciasView {

	private JTable tabela;
	private JTextField campoIdRemetente;
	private JTextField campoDestinatario;
	private JTextField campoIdCaixa;

	public TransferenciasView() {

		JFrame construtor = new JFrame();
		construtor.setSize(527, 423);
		construtor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		construtor.setLocationRelativeTo(null);
		construtor.getContentPane().setLayout(null);

		JLabel labelIdRemetente = new JLabel("ID do Remetente");
		labelIdRemetente.setBounds(24, 26, 83, 14);
		construtor.getContentPane().add(labelIdRemetente);

		JLabel labelDestinatario = new JLabel("Destinat\u00E1rio");
		labelDestinatario.setBounds(225, 26, 71, 14);
		construtor.getContentPane().add(labelDestinatario);

		JLabel labelValor = new JLabel("Valor");
		labelValor.setBounds(24, 70, 126, 14);
		construtor.getContentPane().add(labelValor);

		campoIdRemetente = new JTextField();
		campoIdRemetente.setBounds(117, 23, 86, 20);
		construtor.getContentPane().add(campoIdRemetente);
		campoIdRemetente.setColumns(10);

		campoDestinatario = new JTextField();
		campoDestinatario.setColumns(10);
		campoDestinatario.setBounds(289, 23, 86, 20);
		construtor.getContentPane().add(campoDestinatario);

		campoIdCaixa = new JTextField();
		campoIdCaixa.setColumns(10);
		campoIdCaixa.setBounds(159, 67, 86, 20);
		construtor.getContentPane().add(campoIdCaixa);

		// Listar tabela
		TransferenciasDao td = new TransferenciasDao();

		// Criar tabela
		tabela = new JTable(td.listarAgencias());

		// Ação da tabela
		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				// Obter a linha selecionada
				int linhaSelecionada = tabela.getSelectedRow();
				int idTransferencia = (int) tabela.getValueAt(linhaSelecionada, 0);

				// Fechar esse formulário
				construtor.dispose();

				// Instanciar outro formulário
				TransferenciasViewAlterar tvc = new TransferenciasViewAlterar(idTransferencia);

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
				TransferenciasBean tb = new TransferenciasBean();
				tb.setDestinatario(Integer.parseInt(campoDestinatario.getText()));
				tb.setIdCaixa(Integer.parseInt(campoIdCaixa.getText()));
				tb.setRemetente(Integer.parseInt(campoIdRemetente.getText()));
				tb.setDataEHora(ano + "-" + mes + "-" + dia + " " + horas + ":" + minutos + ":" + segundos);
				
				// Enviar dados
				td.cadastrarTransferencias(tb);

				// Atualizar lista
				tabela = new JTable(td.listarAgencias());

				// Limpar campos
				campoDestinatario.setText("");
				campoIdCaixa.setText("");
				campoIdRemetente.setText("");

				campoIdRemetente.requestFocus();

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
