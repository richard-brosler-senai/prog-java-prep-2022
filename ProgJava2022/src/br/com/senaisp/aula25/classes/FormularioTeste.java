package br.com.senaisp.aula25.classes;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FormularioTeste extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JLabel labelNome;
	private JTextField textNome;
	
	public FormularioTeste() {
		super("Título do Formulário");
	}
	
	public void exibir() {
		setSize(700,500);
		setLocation(300, 300);
		labelNome = new JLabel("Nome do Cliente");
		textNome = new JTextField("Digite aqui o conteudo");
		getContentPane().add(labelNome);
		getContentPane().add(textNome);
		setVisible(true);
	}
}
