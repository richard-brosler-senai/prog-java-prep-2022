package br.com.senaisp.aula26.classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class FormListarProduto extends JFrame {

	private JPanel contentPane;
	private JTable tblProdutos;
	private DefaultTableModel tblMdlProd;
	private Produto prod;

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
		setBounds(100, 100, 674, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelBotoes = new JPanel();
		contentPane.add(panelBotoes, BorderLayout.SOUTH);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panelBotoes.add(btnFechar);
		
		JScrollPane scrTabela = new JScrollPane();
		contentPane.add(scrTabela, BorderLayout.CENTER);
		
		String titulos[] = {"Código", "Descrição", "Preço"};
		tblMdlProd = new DefaultTableModel(titulos,0);
		
		tblProdutos = new JTable(tblMdlProd) {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				Color color1 = new Color(220,220,220);
				Color color2 = Color.white;
				if (!c.getBackground().equals(getSelectionBackground())) {
					Color coleur = (row % 2 == 0 ? color1 : color2);
					c.setBackground(coleur);
					coleur = null;
				}
				return c;
			}
		};
		
		tblProdutos.setIntercellSpacing(new Dimension(10, 1));
		
		scrTabela.setViewportView(tblProdutos);
	}
	
	public void setProd(Produto value) {
		prod = value;
		for (int i=0;i<value.getListaSize();i++) {
			Produto it = value.getListaProdutos().get(i);
			Object linha[]= {it.getCodigo(), it.getDescricao(), it.getPreco()};
			tblMdlProd.addRow(linha);
		}
		DefaultTableCellRenderer rightRender = new DefaultTableCellRenderer();
		rightRender.setHorizontalAlignment(SwingConstants.RIGHT);
		tblProdutos.getColumnModel().getColumn(0).setCellRenderer(rightRender);
		tblProdutos.getColumnModel().getColumn(2).setCellRenderer(rightRender);
	}

}
