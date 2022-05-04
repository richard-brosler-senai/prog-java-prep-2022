package br.com.senaisp.aula08;

import java.time.LocalDate;
import java.util.Scanner;

public class ExemplosComandoDoWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intResp; //(1 - Sim e 2 - Não)
		Scanner sc=new Scanner(System.in);
		//Iniciando o laço de repetição. Note que ele entra sem testes.
		do {
			System.out.println("Programa de calculo de idade");
			System.out.println("Digite o ano de seu nascimento:");
			int intAnoNascimento = sc.nextInt();
			//Obtendo o Ano atual
			int intAnoAtual = LocalDate.now().getYear();
			int intIdade = intAnoAtual - intAnoNascimento;
			System.out.println("Sua idade é " + intIdade);
			System.out.println("Deseja Continuar? (1-sim,2-não):");
			intResp = sc.nextInt();
		//Aqui no final somente que testamos a condição
		} while(intResp != 2);
		sc.close(); //Fechando o Scanner
	}
}
