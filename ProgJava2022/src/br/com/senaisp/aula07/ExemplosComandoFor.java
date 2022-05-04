package br.com.senaisp.aula07;

public class ExemplosComandoFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Lembra do exemplo do while? olhe agora no for
		int intValor;
		//for (int intValor = 10; intValor > 0; intValor--) {
		for (intValor = 10; intValor > 0; intValor--) {
			if (intValor % 2 == 0)
				System.out.println("O número " + intValor + " é Par");
			else
				System.out.println("O número " + intValor + " é Impar");
		}
		System.out.println("Valor depois do for " + intValor);
	}

}
