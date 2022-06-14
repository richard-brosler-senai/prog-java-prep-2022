package br.com.senaisp.aula28.classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class FormTabelaTestes extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormTabelaTestes frame = new FormTabelaTestes();
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
	public FormTabelaTestes() {
		setTitle("Teste");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		String titulos[] = {"CheckBox", "Button", "Radio", "ComboBox"};
		DefaultTableModel tblMdl = new DefaultTableModel(titulos,0);
		table = new JTable(tblMdl) {
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component cmp = super.prepareRenderer(renderer, row, column);
				if (!isRowSelected(row))
					cmp.setBackground(row%2==0 ? Color.WHITE : Color.LIGHT_GRAY);
				return cmp;
			}
			@Override
			public TableCellRenderer getCellRenderer(int row, int column) {
				return new MeuTableCellRenderer();
			}
		};
		Object obj[] = {1,1,1,1};
		tblMdl.addRow(obj);
		table.setRowHeight(32);
		scrollPane.setViewportView(table);
	}
	
	class MeuTableCellRenderer extends JPanel implements TableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			switch (column) {
			case 0: this.add(new JCheckBox()); break;
			case 1: this.add(new JButton()); break;
			case 2: this.add(new JRadioButton()); break;
			case 3:
				String itens[] = {"Item 1", "Item 2", "Item 3"};
				this.add(new JComboBox<String>(itens)); 
				break;
			}
			return this;
		}
		
	}
}
