package br.com.senaisp.aula24.classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class FormListarProduto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tblModel;
	private Produto produto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormListarProduto frame = new FormListarProduto();
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
	public FormListarProduto() {
		setTitle("Listagem Produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Fechar");
		panel.add(btnNewButton);
		
		String tblTitulo[] = { "Código", "Descrição", "Preço" }; 
		
		tblModel = new DefaultTableModel(tblTitulo,0); 
		
		table = new JTable(tblModel);

		JScrollPane pnlScroll = new JScrollPane(table);
		
		contentPane.add(pnlScroll, BorderLayout.CENTER);
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
		List<Produto> lstPrd = this.produto.getListaProdutos();
		//Limpando os dados
		if (tblModel.getRowCount()>0) {
			for (int intI=tblModel.getRowCount()-1;intI>0;intI--) {
				tblModel.removeRow(intI);
			}
		}
		//Adicionando os dados
		for (int intI=0;intI<lstPrd.size();intI++) {
			Produto prd = lstPrd.get(intI);
			Object it[] = {prd.getCodigo(),prd.getDescricao(),prd.getPreco()};
			tblModel.addRow(it);
		}
	}
	
}
