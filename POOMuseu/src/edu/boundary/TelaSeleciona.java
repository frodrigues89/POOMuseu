package edu.boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.FlowLayout;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

import edu.control.ControlTelaSeleciona;
import edu.entity.Autor;
import edu.entity.Exposicao;
import edu.entity.Obra;

import javax.swing.JButton;

public class TelaSeleciona implements ActionListener{

	private JFrame frame = new JFrame();
	private JPanel panelGeral = new JPanel();
	
	private JLabel lblTitulo = new JLabel("Título");
	private JLabel lblEscolha = new JLabel("Escolha... ");
	private JLabel lblEscolhidos = new JLabel("Escolhidos");
	private JButton btnSelUnico = new JButton(">");
	private JButton btnDeselUnico = new JButton("<");
	private JButton btnSelTodos = new JButton("|>");
	private JButton btnDeselTodos = new JButton("<|");
	private JList<String> lstCarregados;
	private JList<String> lstSelecionados;
	private ArrayList listaCarregados;
	private DefaultListModel<String> lstModelCarregados  = new DefaultListModel<String>();
	private ArrayList listaSelecionados = new ArrayList();
	private DefaultListModel<String> lstModelSelecionados  = new DefaultListModel<String>();
	
	private JButton btnOk = new JButton("OK");
	private JButton btnCancelar = new JButton("Cancelar");
	
	private ControlTelaSeleciona controle = new ControlTelaSeleciona();
	
	
	public TelaSeleciona(int tipoDeSelecao) {
		customizaTela(tipoDeSelecao);
		criarForm();
		initializarTela();
	}
	
	private void customizaTela(int tipoDeSelecao){
		switch (tipoDeSelecao) {
		case 1:
			lblTitulo.setText("Selecione os Autores");
			lblEscolha.setText("Escolha os Autores da lista");
			lblEscolhidos.setText("Autores escolhidos");
			carregaValoresAutor();
			break;
		case 2:
			lblTitulo.setText("Selecione as Obras da Exposição");
			lblEscolha.setText("Escolha as Obras da lista");
			lblEscolhidos.setText("Obras escolhidas");
			carregaValoresExposicao();
			break;
		default:
			break;
		}
		
	}
	
 	private void carregaValoresExposicao() {
 		ArrayList<Obra> lista = new ArrayList<Obra>();
		lista = controle.getObras();
		String[] obras = new String[lista.size()];
		for (int i=0; i < lista.size(); i++){
			obras[i] = lista.get(i).getCodigoObra().toString();
			lstModelCarregados.addElement(lista.get(i).getTituloObra());
		}
		listaCarregados = lista;
	}

	private void carregaValoresAutor() {
		ArrayList<Autor> lista = new ArrayList<Autor>();
		lista = controle.getAutores();
		String[] nomes = new String[lista.size()];
		for (int i=0; i < lista.size(); i++){
			lstModelCarregados.addElement(lista.get(i).getNomePessoa());
		}
		listaCarregados = lista;
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
		JPanel panelCentral =                                                                                                                               new JPanel();
		panelCentral.setBounds(226, 57, 144, 261);
		panelGeral.add(panelCentral);
		panelCentral.setLayout(null);
		
		
		btnSelUnico.setBounds(27, 94, 89, 23);
		panelCentral.add(btnSelUnico);
		btnSelUnico.addActionListener(this);
		
		btnDeselUnico.setBounds(27, 193, 89, 23);
		panelCentral.add(btnDeselUnico);
		btnDeselUnico.addActionListener(this);
		
		btnSelTodos.setBounds(27, 128, 89, 23);
		panelCentral.add(btnSelTodos);
		btnSelTodos.addActionListener(this);
		
		btnDeselTodos.setBounds(27, 227, 89, 23);
		panelCentral.add(btnDeselTodos);
		btnDeselTodos.addActionListener(this);
		
	}

	private void panelEscolher(){
		JPanel panelEscolher = new JPanel();
		panelEscolher.setBounds(49, 57, 175, 261);
		panelGeral.add(panelEscolher);
		panelEscolher.setLayout(null);
		
		lblEscolha.setBounds(0, 11, 175, 21);
		panelEscolher.add(lblEscolha);
		
		lstCarregados = new JList(lstModelCarregados);
		lstCarregados.setBounds(0, 0, 175, 204);
		
		JScrollPane scrollPane = new JScrollPane(lstCarregados);
		scrollPane.setBounds(0, 57, 175, 204);
		
		panelEscolher.add(scrollPane);	
	}
	
	private void panelEscolhidos(){
		JPanel panelEscolhidos = new JPanel();
		panelEscolhidos.setBounds(369, 57, 175, 261);
		panelGeral.add(panelEscolhidos);
		panelEscolhidos.setLayout(null);
		
		lblEscolhidos.setBounds(0, 11, 175, 14);
		panelEscolhidos.add(lblEscolhidos);

		String[] valores = new String[100];
		
		lstSelecionados = new JList(valores);
		lstSelecionados.setBounds(0, 0, 175, 204);
		
		JScrollPane scrollPane = new JScrollPane(lstSelecionados);
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
		
		panelBotoes.add(btnOk);
		btnOk.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if ( e.getSource() == btnSelUnico ){
			carregadosToSelecionados();
		}
		if ( e.getSource() == btnSelTodos ){
			todosCarregadosToSelecionados();
		}
		if ( e.getSource() == btnDeselUnico ){
			selecionadosToCarregados();
		}
		if ( e.getSource() == btnDeselTodos ){
			TodosSelecionadosToCarregados();
		}
		if ( e.getSource() == btnOk ){
			controle.setList(listaSelecionados);
			frame.dispose();	
		}
		if ( e.getSource() == btnCancelar ){frame.dispose();}
	}

	private void selecionadosToCarregados() {
		int[] vetorDeSelecionados = lstSelecionados.getSelectedIndices();
		if (vetorDeSelecionados.length > 0){
			for ( int i=0 ; i<=vetorDeSelecionados.length ; i++){
				listaCarregados.add(listaSelecionados.get(vetorDeSelecionados[i]));
				lstModelCarregados.addElement(lstModelSelecionados.get(vetorDeSelecionados[i]));
				lstModelSelecionados.remove(vetorDeSelecionados[i]);
				listaSelecionados.remove((listaCarregados.get(vetorDeSelecionados[i])));
				lstCarregados.setModel(lstModelCarregados);
			}
			
		}else{
			JOptionPane.showMessageDialog(null, "Selecione um item");
		}
	}

	private void TodosSelecionadosToCarregados() {
		// TODO Auto-generated method stub
		
	}

	private void carregadosToSelecionados() {
		int[] vetorDeSelecionados = lstCarregados.getSelectedIndices();
		if (vetorDeSelecionados.length > 0){
			for ( int i=0 ; i<vetorDeSelecionados.length ; i++){
				listaSelecionados.add(listaCarregados.get(vetorDeSelecionados[i]));
				lstModelSelecionados.addElement(lstModelCarregados.get(vetorDeSelecionados[i]));
				lstModelCarregados.remove(vetorDeSelecionados[i]);
				listaCarregados.remove((listaCarregados.get(vetorDeSelecionados[i])));
				lstSelecionados.setModel(lstModelSelecionados);
			}
		}else{
			JOptionPane.showMessageDialog(null, "Selecione um item");
		}
	}
	
	private void todosCarregadosToSelecionados() {
		for ( int i=0 ; i < listaCarregados.size() ; i++ ){
			listaSelecionados.add(listaCarregados.get(i));
			lstModelSelecionados.addElement(lstModelCarregados.get(i));
			lstModelCarregados.remove(i);
			lstSelecionados.setModel(lstModelSelecionados);
		}
		
	}
	
}
		