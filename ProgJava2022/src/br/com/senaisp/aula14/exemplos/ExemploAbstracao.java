package br.com.senaisp.aula14.exemplos;

import br.com.senaisp.aula14.exemplos.classes.Mamifero;

public class ExemploAbstracao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mamifero mamifero = new Mamifero();
		mamifero.Pele = "Amarela";
		mamifero.Boca = "Pequena";
		mamifero.Olhos = "Azuis";
		mamifero.Peso = 80.0;
		mamifero.Falar();
	}

}
