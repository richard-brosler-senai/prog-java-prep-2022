package br.com.senaisp.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class AppSenaiEstoque {

	private JFrame frmSistemaDeEstoque;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppSenaiEstoque window = new AppSenaiEstoque();
					window.frmSistemaDeEstoque.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppSenaiEstoque() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSistemaDeEstoque = new JFrame();
		frmSistemaDeEstoque.setTitle("Sistema de Estoque - Senai");
		frmSistemaDeEstoque.setBounds(100, 100, 610, 460);
		frmSistemaDeEstoque.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmSistemaDeEstoque.setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastros");
		menuBar.add(mnCadastro);
		
		JMenuItem mntmProdutos = new JMenuItem("Produtos");
		mnCadastro.add(mntmProdutos);
		
		JSeparator separator = new JSeparator();
		mnCadastro.add(separator);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mnCadastro.add(mntmSair);
	}

}
