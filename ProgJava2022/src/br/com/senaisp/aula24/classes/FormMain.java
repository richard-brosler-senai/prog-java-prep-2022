package br.com.senaisp.aula24.classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class FormMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Produto prd;
	private JMenuBar menuBar;
	private JMenu mnProdutos;
	private JMenuItem mntmCadastrar;
	private JMenuItem mntmConsultar;
	private JMenuItem mntmAlterar;
	private JMenuItem mntmExcluir;
	private JMenuItem mntmListar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMain frame = new FormMain();
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
	public FormMain() {
		AcoesMenu act = new AcoesMenu();
		setTitle("Formul\u00E1rio Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnProdutos = new JMenu("Produtos");
		menuBar.add(mnProdutos);
		
		mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(act);
		mnProdutos.add(mntmCadastrar);
		
		mntmConsultar = new JMenuItem("Consultar");
		mnProdutos.add(mntmConsultar);
		
		mntmAlterar = new JMenuItem("Alterar");
		mnProdutos.add(mntmAlterar);
		
		mntmExcluir = new JMenuItem("Excluir");
		mnProdutos.add(mntmExcluir);
		
		JSeparator separator = new JSeparator();
		mnProdutos.add(separator);
		
		mntmListar = new JMenuItem("Listar");
		mnProdutos.add(mntmListar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	public void setProduto(Produto value) {
		prd = value;
	}
	
	class AcoesMenu implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource()==mntmCadastrar) {
				FormProdutos frm = new FormProdutos();
				prd.novo();
				frm.setProduto(prd);
				frm.setVisible(true);
			}
		}
		
	}
}
