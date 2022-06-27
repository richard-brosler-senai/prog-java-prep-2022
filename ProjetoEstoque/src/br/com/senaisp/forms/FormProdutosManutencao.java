package br.com.senaisp.forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FormProdutosManutencao extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtProduto;
	private JTextField textField_2;
	private JTextField txtR;
	private JTextField txtPrateleiraEsquerda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormProdutosManutencao frame = new FormProdutosManutencao();
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
	public FormProdutosManutencao() {
		setTitle("Produtos - Manuten\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlBotoes = new JPanel();
		contentPane.add(pnlBotoes, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Confirmar");
		pnlBotoes.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		pnlBotoes.add(btnNewButton_1);
		
		JPanel pnlCorpo = new JPanel();
		contentPane.add(pnlCorpo, BorderLayout.NORTH);
		pnlCorpo.setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel pnlId = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlId.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		pnlCorpo.add(pnlId);
		
		JLabel lblNewLabel = new JLabel("Id");
		pnlId.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setText("1");
		pnlId.add(textField);
		textField.setColumns(10);
		
		JPanel pnlDescricao = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnlDescricao.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		pnlCorpo.add(pnlDescricao);
		
		JLabel lblNewLabel_1 = new JLabel("Descri\u00E7\u00E3o");
		pnlDescricao.add(lblNewLabel_1);
		
		txtProduto = new JTextField();
		txtProduto.setText("Produto 1");
		pnlDescricao.add(txtProduto);
		txtProduto.setColumns(50);
		
		JPanel pnlSaldo = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) pnlSaldo.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		pnlCorpo.add(pnlSaldo);
		
		JLabel lblNewLabel_2 = new JLabel("Saldo");
		pnlSaldo.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setText("15");
		pnlSaldo.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel pnlPreco = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) pnlPreco.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		pnlCorpo.add(pnlPreco);
		
		JLabel lblNewLabel_3 = new JLabel("Pre\u00E7o");
		pnlPreco.add(lblNewLabel_3);
		
		txtR = new JTextField();
		txtR.setText("R$ 15,00");
		pnlPreco.add(txtR);
		txtR.setColumns(10);
		
		JPanel pnlLocalEstoque = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) pnlLocalEstoque.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		pnlCorpo.add(pnlLocalEstoque);
		
		JLabel lblNewLabel_4 = new JLabel("Local Estoque");
		pnlLocalEstoque.add(lblNewLabel_4);
		
		txtPrateleiraEsquerda = new JTextField();
		lblNewLabel_4.setLabelFor(txtPrateleiraEsquerda);
		txtPrateleiraEsquerda.setText("Prateleira 1 Esquerda 2");
		pnlLocalEstoque.add(txtPrateleiraEsquerda);
		txtPrateleiraEsquerda.setColumns(30);
	}

}
