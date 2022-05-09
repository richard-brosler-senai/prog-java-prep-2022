package br.com.senaisp.aula14.exemplos;

import java.util.Scanner;

public class ExemploEnumeradores {
	//definindo o enumerador de estado civil
	public enum EstadoCivil {
		CASADO, SOLTEIRO, DIVORCIADO, VIUVO;
		public static EstadoCivil getEnumByString(String valor) {
			EstadoCivil ret=null;
			for(EstadoCivil enuIt : EstadoCivil.values()) {
				if (enuIt.name().equalsIgnoreCase(valor)) {
					ret=enuIt;
					break;
				}
			}
			return ret;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite seu nome:");
		String strNome = sc.nextLine();
		String strEstadoCivil;
		EstadoCivil enuEstadoCivil;
		do {
			System.out.println("Digite seu estado civil:");
			strEstadoCivil = sc.nextLine();
			enuEstadoCivil=EstadoCivil.getEnumByString(strEstadoCivil);
		} while (enuEstadoCivil==null);
		System.out.println("Ol� "+ strNome + " voc� � " + enuEstadoCivil);
		sc.close();
	}

}
