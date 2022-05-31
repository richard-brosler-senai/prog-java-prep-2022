package br.com.senaisp.aula24.classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FormProdutos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormProdutos frame = new FormProdutos();
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
	public FormProdutos() {
		NumberFormat formatoDinheiro = NumberFormat.getNumberInstance();
		formatoDinheiro.setMinimumFractionDigits(2);
		formatoDinheiro.setMaximumFractionDigits(2);
		
		setTitle("Manuten\u00E7\u00E3o de Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelItens = new JPanel();
		contentPane.add(panelItens, BorderLayout.NORTH);
		panelItens.setLayout(new GridLayout(3, 1));
		
		JPanel panelCodigo = new JPanel();
		panelItens.add(panelCodigo);
		panelCodigo.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JPanel panelDescricao = new JPanel();
		panelItens.add(panelDescricao);
		panelDescricao.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JPanel panelPreco = new JPanel();
		panelItens.add(panelPreco);
		panelPreco.setLayout(new FlowLayout(FlowLayout.LEFT));

		JLabel lblCodigo = new JLabel("Código do Produto");
		panelCodigo.add(lblCodigo);
		
		JTextField txtCodigo = new JTextField();
		txtCodigo.setColumns(15);
		panelCodigo.add(txtCodigo);
		
		JLabel lblDescricao = new JLabel("Descrição do Produto");
		panelDescricao.add(lblDescricao);
		
		JTextField txtDescricao = new JTextField();
		txtDescricao.setColumns(40);
		panelDescricao.add(txtDescricao);

		JLabel lblPreco = new JLabel("Preço do Produto");
		panelPreco.add(lblPreco);
		
		JFormattedTextField formattedTextField = new JFormattedTextField(formatoDinheiro);
		formattedTextField.setColumns(20);
		panelPreco.add(formattedTextField);
		
	
		JPanel panelBotoes = new JPanel();
		contentPane.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new FlowLayout());
		
		JButton btnGravar = new JButton("Gravar");
		panelBotoes.add(btnGravar);
		
		JButton btnCancelar = new JButton("Cancelar");
		panelBotoes.add(btnCancelar);
	}

}
