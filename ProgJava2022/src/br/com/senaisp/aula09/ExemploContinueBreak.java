package br.com.senaisp.aula09;

import java.util.Scanner;

public class ExemploContinueBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		while (true) {
			System.out.println("Ol�, usu�rio. Voc� est� preso em um la�o");
			System.out.println("Deseja Sair? (1-sim,2-n�o)");
			int intResp = sc.nextInt();
			//Isso for�a uma sa�da do la�o de repeti��o
			if (intResp == 1) break;
		}
		System.out.println("Ufaaa! Consegui sair.");
		for (int intCont=0;intCont<10;intCont++) {
			/* 
			 * Isso causa um desvio para o teste de condi��o
			 * (Seja for, do while ou while) 
			 * sem ir para a pr�xima linha
			 * 
			 */
			if (intCont>=4 && intCont<=6) continue;
			System.out.println("Numero " + intCont);
		}
		sc.close();
	}

}
