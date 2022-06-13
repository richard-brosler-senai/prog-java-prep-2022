package br.com.senaisp.aula28.classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import br.com.senaisp.aula28.classes.FormCliente.EstadoCivil;

public class FormClienteManutencao extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JFormattedTextField fmtCodigo;
	
	private DefaultTableModel tblMdCliente;
	
	private int tipoOperacao;
	private int linhaSelecionada;
	private JFormattedTextField fmtDtNascimento;
	private DateFormat fmtDt;
	private JComboBox<EstadoCivil> cmbEstadoCivil;
	private DefaultComboBoxModel<EstadoCivil> cmbModel;
	private MaskFormatter maskCPF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormClienteManutencao frame = new FormClienteManutencao();
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
	public FormClienteManutencao() {
		setTitle("Manuten\u00E7\u00E3o de Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tipoOperacao==3) {
					tblMdCliente.setValueAt(fmtCodigo.getValue(), linhaSelecionada,0);
					tblMdCliente.setValueAt(txtNome.getText(), linhaSelecionada,1);
					tblMdCliente.setValueAt(txtTelefone.getText(), linhaSelecionada,2);
					tblMdCliente.setValueAt(fmtDt.format(fmtDtNascimento.getValue()), linhaSelecionada,3);
					tblMdCliente.setValueAt(cmbEstadoCivil.getSelectedItem(), linhaSelecionada,4);
				} else if (tipoOperacao==4) {
					tblMdCliente.removeRow(linhaSelecionada);
				}
				dispose();
			}
		});
		btnConfirmar.setMnemonic('C');
		panel.add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setMnemonic('r');
		panel.add(btnCancelar);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_2);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		panel_2.add(lblCodigo);
		
		NumberFormat fmt = NumberFormat.getInstance();
		NumberFormatter fmtt = new NumberFormatter(fmt);
		fmtt.setValueClass(Integer.class);
		fmtt.setMinimum(0);
		fmtt.setMaximum(Integer.MAX_VALUE);
		fmtt.setAllowsInvalid(false);
			
		fmtCodigo = new JFormattedTextField(fmtt);
		fmtCodigo.setValue(0);
		fmtCodigo.setColumns(10);
		panel_2.add(fmtCodigo);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_3);
		
		JLabel lbNome = new JLabel("Nome");
		panel_3.add(lbNome);
		
		txtNome = new JTextField();
		panel_3.add(txtNome);
		txtNome.setColumns(30);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_4.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_4);
		
		JLabel lblTelefone = new JLabel("Telefone");
		panel_4.add(lblTelefone);
		
		txtTelefone = new JTextField();
		panel_4.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_5.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_5);
		
		JLabel lblDtNasc = new JLabel("Data Nascimento");
		panel_5.add(lblDtNasc);
		
		fmtDt = new SimpleDateFormat("dd/MM/yyyy");
		DateFormatter fmtDtt = new DateFormatter(fmtDt);
		fmtDtt.setAllowsInvalid(false);
		fmtDtt.setOverwriteMode(true);
		
		fmtDtNascimento = new JFormattedTextField(fmtDtt);
		fmtDtNascimento.setColumns(10);
		panel_5.add(fmtDtNascimento);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_6.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_6);
		
		JLabel lblEstadoCivil = new JLabel("Estado Civil");
		panel_6.add(lblEstadoCivil);
		
		cmbModel = new DefaultComboBoxModel<EstadoCivil>(EstadoCivil.values());
		cmbEstadoCivil = new JComboBox<EstadoCivil>(cmbModel);

		panel_6.add(cmbEstadoCivil);
		
		JLabel lblCPF = new JLabel("CPF");
		panel_6.add(lblCPF);
		try {
			maskCPF = new MaskFormatter("###.###.###-##");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JFormattedTextField fmtCPF = new JFormattedTextField(maskCPF);
		fmtCPF.setColumns(10);
		panel_6.add(fmtCPF);
		
		ButtonGroup btnGrp = new ButtonGroup();
		JRadioButton rdg01 = new JRadioButton("CPF");
		JRadioButton rdg02 = new JRadioButton("CNPJ");
		btnGrp.add(rdg01);
		btnGrp.add(rdg02);
		panel_6.add(rdg01);
		panel_6.add(rdg02);
		
	}

	public void setTblMdCliente(DefaultTableModel tblMdCliente) {
		this.tblMdCliente = tblMdCliente;
	}

	public void setTipoOperacao(int tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
		switch (tipoOperacao) {
		case 2:
		case 3:
		case 4:
			fmtCodigo.setValue(tblMdCliente.getValueAt(linhaSelecionada, 0));
			txtNome.setText((String)tblMdCliente.getValueAt(linhaSelecionada, 1));
			txtTelefone.setText((String)tblMdCliente.getValueAt(linhaSelecionada, 2));
			try {
				Date dtNasc = fmtDt.parse((String)tblMdCliente.getValueAt(linhaSelecionada, 3));
				fmtDtNascimento.setValue(dtNasc);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cmbModel.setSelectedItem(tblMdCliente.getValueAt(linhaSelecionada, 4));
		}
	}

	public void setLinhaSelecionada(int linhaSelecionada) {
		this.linhaSelecionada = linhaSelecionada;
	}

}
