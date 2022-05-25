package br.com.senaisp.aula15;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.management.InvalidAttributeValueException;

import br.com.senaisp.aula15.classes.ConversorTemperatura;

public class ExemploTemperatura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConversorTemperatura conv = new ConversorTemperatura();
		Scanner sc = new Scanner(System.in);
		//Tratando a temperatura de origem
		do {
			System.out.println("Digite a origem de temperatura: (1 - Celsius, 2 - Fahnreith, 3 - Kelvin):");
			try {
				conv.setTipotempOri(sc.nextInt());
				break;
			} catch (InvalidAttributeValueException e) {
				System.out.println(e.getMessage());
			} catch(InputMismatchException e) {
				System.out.println("O valor deve ser inteiro!");
				sc.nextLine();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while(true);
		//Tratando a temperatura de destino
		do {
			System.out.println("Digite a origem de Destino: (1 - Celsius, 2 - Fahnreith, 3 - Kelvin):");
			try {
				conv.setTipotempDes(sc.nextInt());
				break;
			} catch (Exception e) {
				if (e instanceof InvalidAttributeValueException) {
					System.out.println(e.getMessage());
				} else if (e instanceof InputMismatchException) {
					System.out.println("O valor deve ser inteiro");
					sc.nextLine();
				}
			}
		}while (true);
		System.out.println("Digite a temperatura a ser convertida:");
		conv.setTemperatura(sc.nextDouble());
		System.out.println("A temperatura convertida foi " + conv.getTemperaturaConvertida());
		sc.close();
	}

}
