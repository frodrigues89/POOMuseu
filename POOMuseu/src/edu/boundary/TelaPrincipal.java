package edu.boundary;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class TelaPrincipal implements ActionListener {

	private JFrame frame = new JFrame();
	private JMenu menuAdm = new JMenu("Administrativo");
	private JMenu menuCadastros = new JMenu("Cadastros");
	private JMenu mnVisitantes = new JMenu("Visitantes");
	private JMenuItem menuAutores = new JMenuItem("Autores");
	private JMenuItem menuExposicoes = new JMenuItem("Exposi\u00E7\u00F5es");
	private JMenuItem menuObras = new JMenuItem("Obras");

	public TelaPrincipal() {		
		criarTela();
		inicializarTela();
	}
	
	private void criarTela(){
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
			
		menuBar.add(menuAdm);
		
		menuBar.add(menuCadastros);
			
			menuCadastros.add(menuAutores);
			menuCadastros.add(menuExposicoes);
			
			menuCadastros.add(menuObras);			
			menuObras.addActionListener( this );
			
		menuBar.add(mnVisitantes);
		
		
		JLabel labelImagem = new JLabel("");
		labelImagem.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/edu/imageRepository/masp-1.jpeg")));
		frame.getContentPane().add(labelImagem, BorderLayout.CENTER);
	}
	
	private void inicializarTela() {
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
