package br.com.senaisp.aula17.classes;

public class Cachorros extends Mamiferos {
	private String Raca;
	public void Falar() {
		System.out.println("AU AU AU");
	}
	public String getRaca() {
		return Raca;
	}
	public void setRaca(String raca) {
		Raca = raca;
	}
}
