package edu.boundary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu implements ActionListener{
	private JMenu menuAdm = new JMenu("Administrativo");
	private JMenu menuCadastros = new JMenu("Cadastros");
	private JMenu mnVisitantes = new JMenu("Visitantes");
	private JMenuItem menuAutores = new JMenuItem("Autores");
	private JMenuItem menuExposicoes = new JMenuItem("Exposi\u00E7\u00F5es");
	private JMenuItem menuObras = new JMenuItem("Obras");
	
	
	public JMenuBar setMenu(){
		JMenuBar menuBar = new JMenuBar();
			
		menuBar.add(menuAdm);
		
		menuBar.add(menuCadastros);
			
			menuCadastros.add(menuAutores);
			menuAutores.addActionListener(this);
			menuCadastros.add(menuExposicoes);
			
			menuCadastros.add(menuObras);			
			menuObras.addActionListener( this );
			
		menuBar.add(mnVisitantes);
		return menuBar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menuObras){
			new TelaCrudObra();
		}
	}
}
