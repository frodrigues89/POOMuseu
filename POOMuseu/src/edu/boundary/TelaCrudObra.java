package edu.boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.BrokenBarrierException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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

import edu.control.ControlObra;
import edu.entity.Autor;
import edu.entity.Obra;

import com.jgoodies.forms.layout.FormSpecs;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JScrollPane;

public class TelaCrudObra implements ActionListener{

	private JFrame frame = new JFrame();
	private JPanel panelGeral = new JPanel();
	
	private JTextField txtCod = new JTextField();
	private JButton btnPesquisarCod = new JButton();
	private JTextField txtNomeObra = new JTextField();
	private JButton btnPesquisarNome = new JButton();
	private JTextField txtNomeAutor = new JTextField();
	private JButton btnPesquisarAutor = new JButton();
	
	private UtilDateModel model;
	private JDatePickerImpl datePicker;
	private JTextField txtAltura = new JTextField();
	private JTextField txtLargura = new JTextField();
	private JTextField txtProfundidade = new JTextField();
	private JTextField txtPeso = new JTextField();
	private JTextArea txtInfoAdicionais = new JTextArea();
	
	private JButton btnSalvar = new JButton("Salvar");
	private JButton btnExcluir = new JButton("Excluir");
	private JButton btnLimpar = new JButton("Limpar");
	
	private ArrayList listaDeAutores;
	
	private ControlObra control = new ControlObra();
	
	public TelaCrudObra() {
		criarMenu();
		criarForm();
		inicializarTela();
	}
	
	private void criarMenu(){

		Menu menuBar = new Menu();
		frame.setJMenuBar(menuBar.setMenu(this.frame));
	}
	
	private void criarForm() {
		panelGeral.setBounds(0, 0, 602, 394);
		panelGeral.setLayout(null);
		
		criarPanelNomeObra();
		criarPanelInformacoes();
		criarPanelBotoes();		
		
	}
	
	private void inicializarTela() {
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(panelGeral);
		frame.setBounds(100, 100, 618, 454);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);		
	}

	private void criarPanelNomeObra(){
		JPanel panelNomeObra = new JPanel();
		panelNomeObra.setBounds(0, 0, 602, 99);
		panelNomeObra.setAlignmentY(Component.TOP_ALIGNMENT);
		panelNomeObra.setLayout(null);
		
		JLabel lblCod = new JLabel("Cod:");
		lblCod.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCod.setBounds(10, 17, 100, 14);
		panelNomeObra.add(lblCod);
		
		txtCod.setBounds(120, 15, 74, 18);
		panelNomeObra.add(txtCod);
		
		
		JLabel lblNomeDaObra = new JLabel("Nome da Obra:");
		lblNomeDaObra.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNomeDaObra.setBounds(10, 43, 100, 14);
		panelNomeObra.add(lblNomeDaObra);
		
		txtNomeObra.setBounds(120, 40, 347, 20);
		panelNomeObra.add(txtNomeObra);

	
		JLabel lblAutorAutor = new JLabel("Autor:");
		lblAutorAutor.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAutorAutor.setBounds(10, 71, 100, 14);
		panelNomeObra.add(lblAutorAutor);

		txtNomeAutor.setBounds(120, 71, 347, 20);
		panelNomeObra.add(txtNomeAutor);
		
		panelGeral.add(panelNomeObra);
		
		
		btnPesquisarCod.setBounds(204, 5, 30, 30);
		btnPesquisarCod.setIcon(new ImageIcon(TelaCrudObra.class.getResource("/edu/imageRepository/lupaIcon.png")));
		panelNomeObra.add(btnPesquisarCod);
		btnPesquisarCod.addActionListener(this);
		
		
		btnPesquisarNome.setBounds(479, 30, 30, 30);
		btnPesquisarNome.setIcon(new ImageIcon(TelaCrudObra.class.getResource("/edu/imageRepository/lupaIcon.png")));
		panelNomeObra.add(btnPesquisarNome);
		btnPesquisarNome.addActionListener(this);
		
		btnPesquisarAutor.setBounds(479, 64, 30, 30);
		btnPesquisarAutor.setIcon(new ImageIcon(TelaCrudObra.class.getResource("/edu/imageRepository/lupaIcon.png")));
		panelNomeObra.add(btnPesquisarAutor);
		btnPesquisarAutor.addActionListener(this);
	}
	
	private void criarPanelInformacoes(){
		JPanel panelInformacoes = new JPanel();
		panelInformacoes.setBounds(0, 99, 602, 211);
		
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
		lblInfoAdicionais.setBounds(296, 54, 281, 14);
		panelInformacoes.add(lblInfoAdicionais);
		
		panelGeral.add(panelInformacoes);
		panelInformacoes.setLayout(null);
		txtInfoAdicionais.setBorder(UIManager.getBorder("Button.border"));
		
		txtInfoAdicionais.setRows(5);
		txtInfoAdicionais.setBounds(296, 85, 281, 84);
		panelInformacoes.add(txtInfoAdicionais);
	}
	
	private void criarPanelBotoes(){
		JPanel panelBotoes = new JPanel();
		
		panelBotoes.setBounds(0, 308, 602, 86);
		panelGeral.add(panelBotoes);
		panelBotoes.setLayout(new FlowLayout(FlowLayout.CENTER, 80, 30));
		
		panelBotoes.add(btnExcluir);
		btnExcluir.addActionListener(this);
		
		panelBotoes.add(btnLimpar);
		btnLimpar.addActionListener(this);
		
		panelBotoes.add(btnSalvar);
		btnSalvar.addActionListener(this);
	}
	
	private void limparTela(){
		txtCod.setText("");
		txtNomeObra.setText("");
		txtNomeAutor.setText("");
		txtAltura.setText("");
		txtLargura.setText("");
		txtPeso.setText("");
		txtProfundidade.setText("");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalvar){
			if (control.pesquisarPorCod(Integer.parseInt(txtCod.getText())) == null){
				control.addObra(formToObra());
			}else{
				if (JOptionPane.showConfirmDialog(null, 
						"Esta Obra já existe, tem certeza que deseja fazer as alterações?",
						"Confirmação",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE) == 0){
					control.updateObra(formToObra());
				}else{
					JOptionPane.showMessageDialog(null,
							"Você optou por não realizar as alterações",
							"Alteração não confirmada",
							JOptionPane.WARNING_MESSAGE);
				}				
			}
		}
		if( e.getSource() == btnLimpar ){
			limparTela();
		}
		if( e.getSource() == btnExcluir ){
			control.excluirObra(formToObra());
		}
		if( e.getSource() == btnPesquisarCod ){
			obraToForm( control.pesquisarPorCod( Integer.parseInt( txtCod.getText() ) ) );			
		}
		if( e.getSource() == btnPesquisarNome ){
			obraToForm( control.pesquisarPorNome( txtNomeObra.getText() ) );
		}
		if ( e.getSource() == btnPesquisarAutor ){
			TelaSeleciona telaSel = new TelaSeleciona(1);
		}
		
		
	}
	
	private void obraToForm(Obra o){
		txtCod.setText(o.getCodigoObra().toString());
		txtNomeObra.setText(o.getTituloObra());
		String nomesAutores = new String();
		for (int i= 0; i < o.getAutoresObra().size(); i++){
			nomesAutores += (", "+ o.getAutoresObra().get(i).getNomePessoa());
		}
		txtNomeAutor.setText(nomesAutores);
		
		model.setDate(o.getDataObra().getYear(), (o.getDataObra().getMonth()-1), o.getDataObra().getDay());
		model.setSelected(true);
		txtAltura.setText(o.getAlturaObra().toString());
		txtLargura.setText(o.getLarguraObra().toString());
		txtProfundidade.setText(o.getProfundidadeObra().toString());
		txtPeso.setText(o.getPesoObra().toString());
		txtInfoAdicionais.setText(o.getInfoAdicionais());
	}
	
	private Obra formToObra (){
		Obra o = new Obra();
		o.setCodigoObra( Integer.parseInt( txtCod.getText() ) );
		o.setTituloObra( txtNomeObra.getText() );
		o.setDataObra( (Date) datePicker.getModel().getValue() );
		o.setAlturaObra( Double.parseDouble(txtAltura.getText() ) );
		o.setLarguraObra( Double.parseDouble(txtLargura.getText() ) );
		o.setProfundidadeObra( Double.parseDouble(txtProfundidade.getText() ) );
		o.setPesoObra(Double.parseDouble( txtPeso.getText() ) );
		o.setInfoAdicionais( txtInfoAdicionais.getText() );
		
		return o;
	}
}
