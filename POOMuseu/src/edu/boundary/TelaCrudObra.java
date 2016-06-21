package edu.boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.GridLayout;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

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
import java.awt.Component;
import javax.swing.JDesktopPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JScrollPane;

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

	private UtilDateModel model;
	private JDatePickerImpl datePicker;
	private JTextField txtAltura = new JTextField();
	private JTextField txtLargura = new JTextField();
	private JTextField txtProfundidade = new JTextField();
	private JTextField txtPeso = new JTextField();
	private JTextArea txtInfoAdicionais = new JTextArea();

	
	private JLabel lblImagem = new JLabel();
	
	public TelaCrudObra() {
		
		
		criarMenu();
		criarForm();
		inicializarTela();
	}

	private void criarForm() {
		// TODO Auto-generated method stub
		panelGeral.setBounds(0, 0, 602, 394);
		panelGeral.setLayout(null);
		
		JPanel panelNomeObra = new JPanel();
		panelNomeObra.setBounds(0, 0, 602, 99);
		panelNomeObra.setAlignmentY(Component.TOP_ALIGNMENT);
		panelNomeObra.setLayout(null);
		
		JLabel lblCod = new JLabel("Cod:");
		lblCod.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCod.setBounds(10, 15, 100, 14);
		panelNomeObra.add(lblCod);
		
		txtCod.setBounds(120, 15, 74, 18);
		panelNomeObra.add(txtCod);
		
		
		JLabel lblNomeDaObra = new JLabel("Nome da Obra:");
		lblNomeDaObra.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNomeDaObra.setBounds(10, 40, 100, 14);
		panelNomeObra.add(lblNomeDaObra);
		
		txtNomeObra.setBounds(120, 40, 347, 20);
		panelNomeObra.add(txtNomeObra);

	
		JLabel lblAutorAutores = new JLabel("Autor/ Autores:");
		lblAutorAutores.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAutorAutores.setBounds(10, 65, 100, 14);
		panelNomeObra.add(lblAutorAutores);

		txtNomeAutores.setBounds(120, 65, 347, 20);
		panelNomeObra.add(txtNomeAutores);
		
		panelGeral.add(panelNomeObra);
		
		
		
		JPanel panelInformacoes = new JPanel();
		panelInformacoes.setBounds(0, 99, 301, 295);
		
		
		JLabel lblDataObra = new JLabel("Data da Obra:");
		lblDataObra.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDataObra.setBounds(10, 15, 100, 14);
		panelInformacoes.add(lblDataObra);
		
		model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Hoje");
		p.put("text.month", "Mês");
		p.put("text.year", "Ano");		
		JDatePanelImpl datePanel = new JDatePanelImpl(model,p);
		model.setDate(1900, 10, 31);
		model.setSelected(true);
		datePicker = new JDatePickerImpl(datePanel,new DateLabelFormatter());
		datePicker.setBounds(120, 11, 150, 30);
		panelInformacoes.add(datePicker);
		
		
		JLabel lblDimensoes = new JLabel("Dimensoes da Obra:");
		lblDimensoes.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDimensoes.setBounds(10, 54, 130, 14);
		panelInformacoes.add(lblDimensoes);
		
		
		JLabel lblAltura = new JLabel("Altura(cm):");
		lblAltura.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAltura.setBounds(10, 80, 130, 14);
		panelInformacoes.add(lblAltura);
		
		txtAltura.setBounds(150, 77, 47, 20);
		panelInformacoes.add(txtAltura);
		
		
		JLabel lblLargura = new JLabel("Largura(cm):");
		lblLargura.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLargura.setBounds(10, 105, 130, 14);
		panelInformacoes.add(lblLargura);
		
		txtLargura.setBounds(150, 102, 47, 20);
		panelInformacoes.add(txtLargura);
		
		
		JLabel lblProfundidade = new JLabel("Profundidade(cm):");
		lblProfundidade.setHorizontalAlignment(SwingConstants.TRAILING);
		lblProfundidade.setBounds(10, 130, 130, 14);
		panelInformacoes.add(lblProfundidade);
		
		txtProfundidade.setBounds(150, 128, 47, 20);
		panelInformacoes.add(txtProfundidade);
		
		
		JLabel lblPeso = new JLabel("Peso(Kg):");
		lblPeso.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPeso.setBounds(10, 155, 130, 14);
		panelInformacoes.add(lblPeso);

		txtPeso.setBounds(150, 153, 47, 20);
		panelInformacoes.add(txtPeso);
		
		
		JLabel lblInfoAdicionais = new JLabel("Informações Adicionais:");
		lblInfoAdicionais.setBounds(10, 180, 281, 14);
		panelInformacoes.add(lblInfoAdicionais);
		
		panelGeral.add(panelInformacoes);
		panelInformacoes.setLayout(null);
		txtInfoAdicionais.setBorder(UIManager.getBorder("Button.border"));
		
		txtInfoAdicionais.setRows(5);
		txtInfoAdicionais.setBounds(10, 200, 281, 84);
		panelInformacoes.add(txtInfoAdicionais);
		

		
		JPanel panelImagem = new JPanel();
		panelImagem.setBounds(301, 99, 301, 295);
		
		panelGeral.add(panelImagem);
		panelImagem.setLayout(null);
	}

	private void criarMenu(){
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
			
		menuBar.add(menuAdm);
		
		menuBar.add(menuCadastros);
			
			menuCadastros.add(menuAutores);
			menuAutores.addActionListener(this);
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
