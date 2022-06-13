package br.com.senaisp.aula28.classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class FormCliente extends JFrame {

	private JPanel contentPane;
	private JTable tblClientes;
	private DefaultTableModel dtmClientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormCliente frame = new FormCliente();
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
	public FormCliente() {
		setTitle("Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnAdicionar = new JButton("Adicionar");
		panel.add(btnAdicionar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int lin = tblClientes.getSelectedRow();
				int codigo = (int) tblClientes.getValueAt(lin,0);
				JOptionPane.showMessageDialog(null, "Voc� escolheu o cliente " + codigo);
			}
		});
		panel.add(btnConsultar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormClienteManutencao fmt = new FormClienteManutencao();
				fmt.setTblMdCliente(dtmClientes);
				fmt.setLinhaSelecionada(tblClientes.getSelectedRow());
				fmt.setTipoOperacao(3);
				fmt.setVisible(true);
			}
		});
		panel.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormClienteManutencao fmt = new FormClienteManutencao();
				fmt.setTblMdCliente(dtmClientes);
				fmt.setLinhaSelecionada(tblClientes.getSelectedRow());
				fmt.setTipoOperacao(4);
				fmt.setVisible(true);
			}
		});
		panel.add(btnExcluir);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		String titulos[] = {"C�digo", "Nome", "Telefone", "Data de Nascimento", "Estado Civil" };
		
		dtmClientes = new DefaultTableModel(titulos,0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tblClientes = new JTable(dtmClientes) {
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component cmp = super.prepareRenderer(renderer, row, column);
				Color cor1 = Color.WHITE;
				Color cor2 = Color.LIGHT_GRAY;
				if (!isRowSelected(row)) {
					cmp.setBackground(row % 2 == 0 ? cor1 : cor2);
				}
				((JLabel) cmp).setHorizontalAlignment(column==0 ? SwingConstants.RIGHT : SwingConstants.LEFT);
				((JLabel) cmp).setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
				return cmp;
			}
		};
		tblClientes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblClientes.getColumnModel().getColumn(0).setPreferredWidth(50);
		tblClientes.getColumnModel().getColumn(1).setPreferredWidth(300);
		tblClientes.getColumnModel().getColumn(2).setPreferredWidth(100);
		tblClientes.getColumnModel().getColumn(3).setPreferredWidth(100);
		tblClientes.getColumnModel().getColumn(4).setPreferredWidth(100);
		Calendar cal = Calendar.getInstance();
		DateFormat fmtDate = new SimpleDateFormat("dd/MM/yyyy");
		Random rdm = new Random();
		cal.set(1977,01,18);
		for (int i=0;i<100;i++) {
			cal.add(Calendar.DATE, i);
			Date dtnasc = cal.getTime();
			Object itens[] = {i + 1, "Roberto " + (i + 1), "14 98765-4321", 
							  fmtDate.format(dtnasc),
							  EstadoCivil.values()[rdm.nextInt(5)]};
			dtmClientes.addRow(itens);
		}

		scrollPane.setViewportView(tblClientes);
	}
	
	public enum EstadoCivil {
		Solteiro,
		Casado,
		Separado,
		Divorciado,
		Viuvo
	}
}
