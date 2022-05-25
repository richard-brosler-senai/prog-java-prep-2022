package br.com.senaisp.aula20;

import java.util.ArrayList;
import java.util.List;

import br.com.senaisp.aula20.classes.Humano;
import br.com.senaisp.aula20.classes.Mamiferos;

public class ExemploArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Mamiferos> lstMamiferos = new ArrayList<Mamiferos>();
		Humano hum = new Humano();
		//Adicionando elemento
		lstMamiferos.add(hum);
		hum.setCorPelo("Loiros");
		hum.setIdade(35);
		hum.setEtnia("Branca");
		//removendo elemento
		lstMamiferos.remove(0);
		//Quantidade de elementos
		System.out.println(lstMamiferos.size());
	}

}
