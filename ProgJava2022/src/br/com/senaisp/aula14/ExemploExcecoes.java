package br.com.senaisp.aula14;

import java.util.Scanner;

public class ExemploExcecoes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Digite um n�mero:");
			int intNr = sc.nextInt();
			System.out.println("Voc� digitou "+intNr);
		} while(true);
		//sc.close();
	}

}
