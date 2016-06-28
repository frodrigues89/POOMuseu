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

	public TelaPrincipal() {		
		criarTela();
		inicializarTela();
	}
	
	private void criarTela(){
		Menu menuBar = new Menu();
		frame.setJMenuBar(menuBar.setMenu(this.frame));
		
		
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
		
	}

}
