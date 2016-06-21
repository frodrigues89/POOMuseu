package edu.boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class TelaCrudObra implements ActionListener{

	private JFrame frame = new JFrame();
	private JPanel panelGeral = new JPanel();
	
	private JMenu menuAdm = new JMenu("Administrativo");
	private JMenu menuCadastros = new JMenu("Cadastros");
	private JMenu mnVisitantes = new JMenu("Visitantes");
	private JMenuItem menuAutores = new JMenuItem("Autores");
	private JMenuItem menuExposicoes = new JMenuItem("Exposi\u00E7\u00F5es");
	private JMenuItem menuObras = new JMenuItem("Obras");
	
	private  JTextField txtCod = new JTextField();
	private JTextField txtNomeObra = new JTextField();
	private JTextField txtNomeAutores = new JTextField();

	public TelaCrudObra() {
		
		
		criarMenu();
		criarForm();
		inicializarTela();
	}

	private void criarForm() {
		// TODO Auto-generated method stub
		panelGeral.setBounds(0, 0, 602, 394);
		panelGeral.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNomeObra = new JPanel();
		panelNomeObra.setLayout(null);
		
		JLabel lblCod = new JLabel("Cod.");
		lblCod.setBounds(63, 15, 23, 14);
		panelNomeObra.add(lblCod);
		
		txtCod.setBounds(96, 12, 74, 18);
		txtCod.setColumns(10);
		panelNomeObra.add(txtCod);
		
		
		JLabel lblNomeDaObra = new JLabel("Nome da Obra");
		lblNomeDaObra.setBounds(17, 40, 69, 14);
		panelNomeObra.add(lblNomeDaObra);
		
		txtNomeObra.setBounds(96, 37, 371, 20);
		txtNomeObra.setColumns(35);
		panelNomeObra.add(txtNomeObra);

	
		JLabel lblAutorAutores = new JLabel("Autor/ Autores");
		lblAutorAutores.setBounds(14, 65, 72, 14);
		panelNomeObra.add(lblAutorAutores);
				
		txtNomeAutores = new JTextField();
		txtNomeAutores.setBounds(96, 62, 371, 20);
		txtNomeAutores.setColumns(100);
		panelNomeObra.add(txtNomeAutores);
		
		panelGeral.add(panelNomeObra);
	}

	private void criarMenu(){
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
			
		menuBar.add(menuAdm);
		
		menuBar.add(menuCadastros);
			
			menuCadastros.add(menuAutores);
			menuCadastros.add(menuExposicoes);
			
			menuCadastros.add(menuObras);			
			menuObras.addActionListener( this );
			
		menuBar.add(mnVisitantes);
	}
	
	private void inicializarTela() {
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(panelGeral);
		frame.setBounds(100, 100, 618, 454);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menuObras){
			frame.dispose();
			new TelaCrudObra();
		}
	}
}
