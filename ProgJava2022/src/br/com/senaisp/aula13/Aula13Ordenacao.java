package br.com.senaisp.aula13;

import java.util.Arrays;
import java.util.Scanner;

public class Aula13Ordenacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strNome[] = new String[10];
		Scanner sc = new Scanner(System.in);
		for (int intI=0; intI<10; intI++) {
			System.out.println("Digite o nome da pessoa "+(intI + 1)+":");
			strNome[intI] = sc.nextLine();
		}
		//Ordenando os valores
		String strApoio;
		for (int intI=0;intI<9;intI++) {
			for (int intF=intI; intF<10;intF++) {
				if (strNome[intI].compareToIgnoreCase(strNome[intF])>0) {
					strApoio = strNome[intI];
					strNome[intI] = strNome[intF];
					strNome[intF] = strApoio;
				}
			}
		}
		//Arrays.sort(strNome);
		//
		for (int intI=0; intI<10; intI++) {
			System.out.println(strNome[intI]);
		}
		sc.close();
	}

}
