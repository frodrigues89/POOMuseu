package edu.boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.FlowLayout;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class TelaSeleciona implements ActionListener{

	private JFrame frame = new JFrame();
	private JPanel panelGeral = new JPanel();
	
	private JLabel lblTitulo = new JLabel("Título");
	private JButton btnSelUnico = new JButton(">>>>>>>>");
	private JButton btnDeselUnico = new JButton("<<<<<<<<");
	private JButton btnSelTodos = new JButton("> todos");
	private JButton btnDeselTodos = new JButton("< todos");
	
	private JButton btnSalvar = new JButton("OK");
	private JButton btnCancelar = new JButton("Cancelar");

	private ArrayList lista = new ArrayList();
	
	public ArrayList selecionaItens(int i){
		criarForm();
		initializarTela();
		return lista;
	}
	
 	private void criarForm(){
		panelGeral.setBounds(0, 0, 602, 415);
		panelEscolher();
		panelEscolhidos();
		panelTitulo();
		panelCentral();
		criarPanelBotoes();		
	}
	
	private void initializarTela() {
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(panelGeral);
		panelGeral.setLayout(null);
		frame.setBounds(100, 100, 618, 454);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
	}

	private void panelTitulo() {
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBounds(49, 11, 495, 47);
		panelGeral.add(panelTitulo);
		panelTitulo.add(lblTitulo);
	}

	private void panelCentral() {
		JPanel panelCentral = new JPanel();
		panelCentral.setBounds(226, 57, 144, 261);
		panelGeral.add(panelCentral);
		panelCentral.setLayout(null);
		
		
		btnSelUnico.setBounds(27, 37, 89, 23);
		panelCentral.add(btnSelUnico);
		
		btnDeselUnico.setBounds(27, 140, 89, 23);
		panelCentral.add(btnDeselUnico);
		
		btnSelTodos.setBounds(27, 76, 89, 23);
		panelCentral.add(btnSelTodos);
		
		btnDeselTodos.setBounds(27, 174, 89, 23);
		panelCentral.add(btnDeselTodos);
		
	}

	private void panelEscolher(){
		JPanel panelEscolher = new JPanel();
		panelEscolher.setBounds(49, 57, 175, 261);
		panelGeral.add(panelEscolher);
		panelEscolher.setLayout(null);
		
		JLabel lblEscolha = new JLabel("Escolha... ");
		lblEscolha.setBounds(48, 11, 69, 21);
		panelEscolher.add(lblEscolha);
		
		
		
		
		String[] values = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "213", "23", "12", "312", "312", "3123", "123", "123", "123", "123", "123", "1"};
			
		
		JList list = new JList(values);
		list.setBounds(0, 0, 175, 204);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(0, 57, 175, 204);
		
		panelEscolher.add(scrollPane);	
	}
	

	private void panelEscolhidos(){
		JPanel panelEscolhidos = new JPanel();
		panelEscolhidos.setBounds(369, 57, 175, 261);
		panelGeral.add(panelEscolhidos);
		panelEscolhidos.setLayout(null);
		
		JLabel lblEscolhidos = new JLabel("Escolhidos");
		lblEscolhidos.setBounds(60, 5, 49, 14);
		panelEscolhidos.add(lblEscolhidos);

		
		
		
		String[] values = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "213", "23", "12", "312", "312", "3123", "123", "123", "123", "123", "123", "1"};
			
		
		JList list = new JList(values);
		list.setBounds(0, 0, 175, 204);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(0, 57, 175, 204);
		panelEscolhidos.add(scrollPane);
	}
	
	private void criarPanelBotoes(){
		JPanel panelBotoes = new JPanel();
		
		panelBotoes.setBounds(49, 318, 495, 86);
		panelGeral.add(panelBotoes);
		panelBotoes.setLayout(new FlowLayout(FlowLayout.CENTER, 80, 30));
		
		panelBotoes.add(btnCancelar);
		btnCancelar.addActionListener(this);
		
		panelBotoes.add(btnSalvar);
		btnSalvar.addActionListener(this);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if ( e.getSource() == btnSalvar ){
			
		}
	}
	
	
}
		