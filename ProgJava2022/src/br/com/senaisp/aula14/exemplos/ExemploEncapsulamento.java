package br.com.senaisp.aula14.exemplos;

import br.com.senaisp.aula14.exemplos.classes.MamiferoEncapsulado;

public class ExemploEncapsulamento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MamiferoEncapsulado mamifero = new MamiferoEncapsulado();
		mamifero.setBoca("Pequena");
		mamifero.setPele("Amarela");
		mamifero.setPeso(85.00);
		mamifero.setOlhos("Vermelho");
		mamifero.Falar();
	}

}
