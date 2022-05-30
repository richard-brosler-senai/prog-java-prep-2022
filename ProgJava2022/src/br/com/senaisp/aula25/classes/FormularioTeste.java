package br.com.senaisp.aula25.classes;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FormularioTeste extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JLabel labelNome;
	private JTextField textNome;
	private JLabel labelEndereco;
	private JTextField textEndereco;
	private JButton btnSair;
	
	public FormularioTeste() {
		super("Título do Formulário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void exibir() {
		setSize(700,500);
		setLocation(300, 300);
		labelNome = new JLabel("Nome do Cliente");
		textNome = new JTextField("Digite aqui o conteudo");
		labelEndereco = new JLabel("Endereço do Cliente");
		textEndereco = new JTextField("Digite aqui o conteudo");
		btnSair = new JButton("Sair");
		
		textNome.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int key = e.getKeyCode();
				Object obj = e.getSource();
		        if (key == KeyEvent.VK_ENTER) {
		        	System.out.println("Enter foi teclado");
		          ((JTextField) obj).transferFocus();
		        }				
			}
		});
		
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(labelNome);
		getContentPane().add(textNome);
		getContentPane().add(labelEndereco);
		getContentPane().add(textEndereco);
		getContentPane().add(btnSair);
		setVisible(true);
	}
}
