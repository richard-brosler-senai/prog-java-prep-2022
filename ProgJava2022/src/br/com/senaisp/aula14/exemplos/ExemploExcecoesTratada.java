package br.com.senaisp.aula14.exemplos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExemploExcecoesTratada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int intNr;
		do {
			System.out.println("Digite um número:");
			try {
				intNr = sc.nextInt();
			} catch(InputMismatchException e) {
				sc.nextLine();
				intNr=-1;
				System.out.println("Entrada de dados inválida, redigite!");
			}
		} while(intNr<0);
		System.out.println("Você digitou "+intNr);
		sc.close();
	}
}
