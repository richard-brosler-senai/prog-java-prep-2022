package br.com.senaisp.aula25.classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class DemonstracaoEventos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemonstracaoEventos frame = new DemonstracaoEventos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DemonstracaoEventos() {
		EventoClick evt = new EventoClick();
		EventoFocus evtFocus = new EventoFocus();
		EventoGanhoFocus evtGanFocus = new EventoGanhoFocus();
		
		setTitle("Formulario Demonstra\u00E7\u00E3o de Eventos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 459);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCliente = new JMenu("Clientes");
		menuBar.add(mnCliente);
		mnCliente.addActionListener(evt);
		mnCliente.addFocusListener(evtFocus);
		
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mnCliente.add(mntmCadastrar);
		
		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mnCliente.add(mntmConsultar);
		mntmConsultar.addActionListener(evt);
		
		JMenu mnListagens = new JMenu("Listagens");
		mnCliente.add(mnListagens);
		mnListagens.addActionListener(evt);
		
		JMenuItem mntmLstClientes = new JMenuItem("Clientes por Regi\u00E3o");
		mnListagens.add(mntmLstClientes);
		mntmLstClientes.addActionListener(evt);
		
		JMenu mnVendas = new JMenu("Vendas");
		mnListagens.add(mnVendas);
		mnVendas.addActionListener(evt);
		
		JMenuItem mntmAbcVendas = new JMenuItem("Abc de Vendas");
		mnVendas.add(mntmAbcVendas);
		mntmAbcVendas.addActionListener(evt);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		
		textField.setColumns(10);
		panel_1.add(textField);
		textField.addActionListener(evt);
		textField.addFocusListener(evtFocus);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Item 1", "Item 2", "Item 3"}));
		panel_1.add(comboBox);
		comboBox.addActionListener(evt);
		comboBox.addFocusListener(evtFocus);
		
		JButton btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(evt);
		btnNewButton.addFocusListener(evtFocus);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		panel_1.add(chckbxNewCheckBox);
		chckbxNewCheckBox.addActionListener(evt);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		panel_1.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(evt);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		panel_2.add(tglbtnNewToggleButton);
		tglbtnNewToggleButton.addActionListener(evt);
		
		JTextArea textArea = new JTextArea();
		textArea.setColumns(40);
		textArea.setRows(3);
		panel_2.add(textArea);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setColumns(20);
		panel_3.add(formattedTextField);
		formattedTextField.addActionListener(evt);
		
		JEditorPane editorPane = new JEditorPane();
		panel_3.add(editorPane);
		
	}
	//Classe para eventos de click
	class EventoClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			DemonstracaoEventos.logEvento(obj,"Foi clicado");			
		}
		
	}
	//Classe para eventos de recepção de foco
	class EventoFocus implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
			Object obj = e.getSource();
			DemonstracaoEventos.logEvento(obj,"Recebeu focus");			
		}

		@Override
		public void focusLost(FocusEvent e) {
			Object obj = e.getSource();
			DemonstracaoEventos.logEvento(obj,"Perdeu focus");			
		}
		
	}
	class EventoGanhoFocus extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			Object obj = e.getSource();
			DemonstracaoEventos.logEvento(obj,"Recebeu focus");			
		}
	}
	
	public static void logEvento(Object obj, String mensagem) {
		System.out.println(obj.getClass().getName() + " " + mensagem);
	}
	
}
