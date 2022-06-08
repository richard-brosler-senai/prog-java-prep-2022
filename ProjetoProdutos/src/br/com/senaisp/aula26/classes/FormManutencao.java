package br.com.senaisp.aula26.classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;
import javax.swing.text.NumberFormatter;

public class FormManutencao extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField fmtCodigo;
	private JTextField textDescricao;
	private int tipoEdicao;
	private JFormattedTextField fmtPreco;
	private Produto prod;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormManutencao frame = new FormManutencao();
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
	public FormManutencao() {
		EventoClick evtClick = new EventoClick();
		EventoFocus evtFocus = new EventoFocus();
		
		setTitle("Manuten\u00E7\u00E3o de Produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 629, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBotoes = new JPanel();
		contentPane.add(panelBotoes, BorderLayout.SOUTH);
		
		JButton btnGravar = new JButton("Gravar");
		panelBotoes.add(btnGravar);
		btnGravar.addActionListener(evtClick);
		
		JButton btnCancelar = new JButton("Cancelar");
		panelBotoes.add(btnCancelar);
		btnCancelar.addActionListener(evtClick);
		
		JPanel panelCorpo = new JPanel();
		contentPane.add(panelCorpo, BorderLayout.NORTH);
		panelCorpo.setLayout(new GridLayout(4, 0, 0, 0));
		
		JPanel panelCodigo = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelCodigo.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelCorpo.add(panelCodigo);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		panelCodigo.add(lblCodigo);
		
		NumberFormat fmtI = NumberFormat.getInstance();
		NumberFormatter fmttI = new NumberFormatter(fmtI);
		fmttI.setValueClass(Integer.class);
		fmttI.setMinimum(0);
		fmttI.setMaximum(Integer.MAX_VALUE);
		fmttI.setAllowsInvalid(false);
		fmttI.setOverwriteMode(true);
		
		fmtCodigo = new JFormattedTextField(fmttI);
		panelCodigo.add(fmtCodigo);
		fmtCodigo.setColumns(10);
		fmtCodigo.setValue(0);
		fmtCodigo.addFocusListener(evtFocus);
		
		JPanel panelDescricao = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelDescricao.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panelCorpo.add(panelDescricao);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		panelDescricao.add(lblDescricao);
		
		textDescricao = new JTextField();
		panelDescricao.add(textDescricao);
		textDescricao.setColumns(30);
		textDescricao.addFocusListener(evtFocus);
		
		JPanel panelPreco = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panelPreco.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panelCorpo.add(panelPreco);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o");
		panelPreco.add(lblPreco);
		
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		NumberFormatter fmtt = new NumberFormatter(fmt);
		fmtt.setMinimum(0.00);
		fmtt.setAllowsInvalid(false);
		fmtt.setOverwriteMode(true);
		
		fmtPreco = new JFormattedTextField(fmtt);
		fmtPreco.setColumns(10);
		fmtPreco.setValue(0.00);
		panelPreco.add(fmtPreco);
		fmtPreco.addFocusListener(evtFocus);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panelCorpo.add(panel);
		
		JLabel lblDtValidade = new JLabel("Data Validade");
		panel.add(lblDtValidade);
		
		DateFormat dtfmt = new SimpleDateFormat("dd/MM/yyyy");
		DateFormatter dtfmtt = new DateFormatter(dtfmt);
		dtfmtt.setAllowsInvalid(false);
		dtfmtt.setOverwriteMode(true);
		
		JFormattedTextField fmtDtValidade = new JFormattedTextField(dtfmtt);
		fmtDtValidade.setColumns(10);
		fmtDtValidade.setValue(new Date());
		panel.add(fmtDtValidade);
		fmtDtValidade.addFocusListener(evtFocus);
		
	}

	public void setTipoEdicao(int tipoEdicao) {
		this.tipoEdicao = tipoEdicao;
		//operacao 1 - Cadastrar, 2 - Consultar, 3 - Alterar, 4 - Excluir
		switch(tipoEdicao) {
		case 1 :
			fmtCodigo.setValue(prod.getCodigo());
			textDescricao.setText(prod.getDescricao());
			fmtPreco.setValue(prod.getPreco());
			break;
		}
	}

	public void setProd(Produto prod) {
		this.prod = prod;
	}
	
	class EventoClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object cmp = e.getSource();
			if ( ((JButton)cmp).getText()=="Gravar" ) {
				prod.setCodigo((int)fmtCodigo.getValue());
				prod.setDescricao(textDescricao.getText());
				prod.setPreco((double)fmtPreco.getValue());
				switch(tipoEdicao) {
				case 1: prod.adicionar(); break;
				case 3: prod.alterar(); break;
				case 4: 
					int dialogResult = JOptionPane.showConfirmDialog (null, "Deseja mesmo excluir?","Warning",JOptionPane.YES_NO_OPTION);
					if(dialogResult == JOptionPane.YES_OPTION){
					  prod.excluir();
					}
				}
				
				dispose();
			} else {
				dispose();
			}
		}
	}
	class EventoFocus implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
			Object cmp = e.getSource();
			if (cmp instanceof JFormattedTextField) {
				System.out.println("Entrei no focus do JFormattedTextField");
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						((JFormattedTextField) cmp).selectAll();
					}
				});
			} else if (cmp instanceof JTextField) {
				((JTextField) cmp).selectAll();
				System.out.println("Entrei no focus do JTextField");
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			
		}
		
	}
}
