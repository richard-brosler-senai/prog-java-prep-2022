package br.com.senaisp.aula28.classes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class AppDatePicker {

	private JFrame frmFormulrioPrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppDatePicker window = new AppDatePicker();
					window.frmFormulrioPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppDatePicker() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFormulrioPrincipal = new JFrame();
		frmFormulrioPrincipal.setTitle("Formul\u00E1rio Principal");
		frmFormulrioPrincipal.setBounds(100, 100, 600, 382);
		frmFormulrioPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmFormulrioPrincipal.setJMenuBar(menuBar);
		
		JMenu mnCadastros = new JMenu("Cadastros");
		mnCadastros.setMnemonic('C');
		menuBar.add(mnCadastros);
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mnCadastros.add(mntmClientes);
		
		JSeparator separator = new JSeparator();
		mnCadastros.add(separator);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mnCadastros.add(mntmSair);
	}

}
