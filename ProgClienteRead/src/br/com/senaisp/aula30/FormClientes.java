package br.com.senaisp.aula30;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.senaisp.aula30.classes.Cliente;

public class FormClientes extends JFrame {

	private JPanel contentPane;
	private JTable tblClientes;
	private DefaultTableModel modTable;
	private Cliente cli;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormClientes frame = new FormClientes();
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
	public FormClientes() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlBotoes = new JPanel();
		contentPane.add(pnlBotoes, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("New button");
		pnlBotoes.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		pnlBotoes.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		pnlBotoes.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		pnlBotoes.add(btnNewButton_3);
		
		JScrollPane scrClientes = new JScrollPane();
		contentPane.add(scrClientes, BorderLayout.CENTER);
		
		String titulos[] = {"nome", "idade", "cpf", "rg", "data_nasc", "sexo",
				"signo", "mae", "pai", "email", "senha", "cep", "endereco",
				"numero", "bairro", "cidade", "estado", "telefone_fixo", 
				"celular", "altura", "peso", "tipo_sanguineo", "cor" };
		
		modTable = new DefaultTableModel(titulos,0); 
		
		tblClientes = new JTable(modTable);
		scrClientes.setViewportView(tblClientes);
	}

	public void setCli(Cliente cli) {
		this.cli = cli;
		for (Object[] itens : cli.getLista()) {
			modTable.addRow(itens);
		}
	}

}
