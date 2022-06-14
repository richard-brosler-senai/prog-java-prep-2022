package br.com.senaisp.aula30;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.filechooser.FileNameExtensionFilter;

import br.com.senaisp.aula30.classes.Cliente;
import br.com.senaisp.aula30.classes.Cliente.TipoArquivo;

public class AppCliente {

	private JFrame frmMain;
	private Cliente cli;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppCliente window = new AppCliente();
					window.frmMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		cli = new Cliente();
		EventoClick evt = new EventoClick();
		
		frmMain = new JFrame();
		frmMain.setTitle("Formul\u00E1rio Principal");
		frmMain.setBounds(100, 100, 700, 450);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmMain.setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivos");
		menuBar.add(mnArquivo);
		
		JMenu mnClientes = new JMenu("Clientes");
		mnArquivo.add(mnClientes);
		
		JMenuItem mntmImport = new JMenuItem("Importar dados");
		mnClientes.add(mntmImport);
		mntmImport.addActionListener(evt);
		
		JSeparator separator_1 = new JSeparator();
		mnClientes.add(separator_1);
		
		JMenuItem mntmManutencao = new JMenuItem("Manutenção");
		mnClientes.add(mntmManutencao);
		mntmManutencao.addActionListener(evt);
		
		JSeparator separator = new JSeparator();
		mnArquivo.add(separator);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mnArquivo.add(mntmSair);
		mntmSair.addActionListener(evt);
		
	}
	
	class EventoClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object cmp = e.getSource();
			switch(((JMenuItem) cmp).getText()) {
			case "Importar dados" : 
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filterCSV = new FileNameExtensionFilter("CSV Files","csv");
				FileNameExtensionFilter filterJSON = new FileNameExtensionFilter("JSON Files","json");
				FileNameExtensionFilter filterXML = new FileNameExtensionFilter("XML Files","xml");

				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				
				chooser.setFileFilter(filterCSV);
				chooser.setFileFilter(filterXML);
				chooser.setFileFilter(filterJSON);
				
				int retVal = chooser.showOpenDialog(null);
				if (retVal == JFileChooser.APPROVE_OPTION) {
					String arq = chooser.getSelectedFile().getAbsolutePath();
					if (arq.toLowerCase().contains(".xml")) {
						cli.importarArquivo(arq,TipoArquivo.XML);
					} else if (arq.toLowerCase().contains(".json")) {
						cli.importarArquivo(arq,TipoArquivo.JSON);
					} else {
						cli.importarArquivo(arq);
					}
				}
				JOptionPane.showMessageDialog(frmMain, "Arquivo Importado!");
				break;
			case "Manutenção" :
				FormClientes fmcli = new FormClientes();
				fmcli.setCli(cli);
				fmcli.setVisible(true);
				break;
			case "Sair": 
				frmMain.dispose(); 
				break;
			}
		}
	}

}
