package br.com.senaisp.aula05;

import java.util.Scanner;

public class ExemploComandoSwitch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Menu principal");
		System.out.println("1 - Calcular Soma");
		System.out.println("2 - Calcular Subtração");
		System.out.println("3 - Calcular Multiplicação");
		System.out.println("4 - Calcular Divisão");
		System.out.println("Digite sua opção:");
		Scanner sc = new Scanner(System.in);
		int intVlr1, intVlr2, intRes;
		int intOpcao = sc.nextInt();
		switch(intOpcao) {
		case 1: 
			System.out.println("Digite o primeiro valor:");
			intVlr1 = sc.nextInt();
			System.out.println("Digite o segundo valor:");
			intVlr2 = sc.nextInt();
			intRes = intVlr1 + intVlr2;
			System.out.println("O resultado será: "+ intRes);
			break;
		case 2:
			System.out.println("Digite o primeiro valor:");
			intVlr1 = sc.nextInt();
			System.out.println("Digite o segundo valor:");
			intVlr2 = sc.nextInt();
			intRes = intVlr1 - intVlr2;
			System.out.println("O resultado será: "+ intRes);
			break;
			
		}
	}

}
