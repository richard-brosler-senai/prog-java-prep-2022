package br.com.senaisp.aula06;

public class ExemplosComandoWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Exemplo utilizando While
		int intValores = 10;
		//Mostrando os valores de 10 � 1 decrescente
		//e Classificando em par ou impar
		while ( intValores > 0 ) {
			if (intValores%2==0)
				System.out.println("O valor " + intValores + " � par.");
			else 
				System.out.println("O valor " + intValores + " � impar.");
			intValores--;
		}
	}

}
