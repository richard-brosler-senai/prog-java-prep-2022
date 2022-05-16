package br.com.senaisp.aula17;

import br.com.senaisp.aula17.classes.Cachorros;
import br.com.senaisp.aula17.classes.Mamiferos;

public class TestandoMamiferos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mamiferos mam[] = new Mamiferos[2];
		mam[0] = new Mamiferos();
		mam[1] = new Cachorros();
		
		mam[0].setNome("Mamifero");
		mam[0].setCorPelo("Pretos");
		mam[0].setIdade(30);
		
		mam[1].setNome("Roberto");
		mam[1].setCorPelo("Loiros");
		mam[1].setIdade(45);
		
		for (int intI=0;intI<2;intI++)
			mam[intI].Falar();
	}

}
