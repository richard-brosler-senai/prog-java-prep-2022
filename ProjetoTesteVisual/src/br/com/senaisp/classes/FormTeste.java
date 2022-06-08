package br.com.senaisp.classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;
import javax.swing.text.NumberFormatter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class FormTeste extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField textCodigo;
	private JFormattedTextField formattedDtValidade;
	private JFormattedTextField formattedPreco;
	private Date locDtNascimento;
	private int intCodigo;
	private double dblPreco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormTeste frame = new FormTeste();
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
	public FormTeste() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnProdutos = new JMenu("Produtos");
		mnProdutos.setMnemonic('P');
		menuBar.add(mnProdutos);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Inclus\u00E3o");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Inclusão Apertado");
			}
		});
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_DOWN_MASK));
		mnProdutos.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(4, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		panel_1.add(lblCodigo);
		
		NumberFormat fmt = NumberFormat.getInstance();
		NumberFormatter fmtt = new NumberFormatter(fmt);
		fmtt.setValueClass(Integer.class);
		fmtt.setMinimum(0);
		fmtt.setMaximum(Integer.MAX_VALUE);
		fmtt.setAllowsInvalid(false);
		fmtt.setCommitsOnValidEdit(true);
		
		textCodigo = new JFormattedTextField(fmtt);
		panel_1.add(textCodigo);
		textCodigo.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Pre\u00E7o");
		panel_2.add(lblNewLabel);

		NumberFormat fmtP = NumberFormat.getCurrencyInstance();
		NumberFormatter fmttp = new NumberFormatter(fmtP);
		fmttp.setMinimum(0.00);
		fmttp.setMaximum(9999999999.99);
		fmttp.setAllowsInvalid(false);
		
			
		formattedPreco = new JFormattedTextField(fmttp);
		formattedPreco.setColumns(10);
		formattedPreco.setValue(0.00);
		panel_2.add(formattedPreco);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JLabel lblDtValidade = new JLabel("Data Validade");
		panel_3.add(lblDtValidade);
		
		DateFormat fmtD = new SimpleDateFormat("dd/MM/yyyy");
		DateFormatter fmttD = new DateFormatter(fmtD);

		formattedDtValidade = new JFormattedTextField(fmttD);
		formattedDtValidade.setColumns(10);

		panel_3.add(formattedDtValidade);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JButton btnNewButton = new JButton("Gravar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				locDtNascimento = ((Date) formattedDtValidade.getValue());
				System.out.println(locDtNascimento);
				intCodigo = ((int) textCodigo.getValue());
				System.out.println(intCodigo);
				dblPreco =  ((double) formattedPreco.getValue());
				System.out.println(dblPreco);				
			}
		});
		panel_4.add(btnNewButton);
	}

}
