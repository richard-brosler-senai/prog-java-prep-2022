package br.com.senaisp.aula20.classes;

import br.com.senaisp.aula20.interfaces.InFalantes;

public class Gato extends Felinos implements InFalantes{
	
	@Override
	public void falar() {
		// TODO Auto-generated method stub
		System.out.println("Miauuuu!");
	}

}
