package br.com.senaisp.aula14.exemplos.classes;

public class MamiferoEncapsulado {
	private String Pele;
	private String Olhos;
	private String Boca;
	private double Peso;
	public void Falar() {
		System.out.println("Mamífero falando!");
	}
	public String getPele() {
		return Pele;
	}
	public void setPele(String pele) {
		Pele = pele;
	}
	public String getOlhos() {
		return Olhos;
	}
	public void setOlhos(String olhos) {
		if (!olhos.equalsIgnoreCase("azul") && 
			!olhos.equalsIgnoreCase("verde") &&
			!olhos.equalsIgnoreCase("castanho") &&
			!olhos.equalsIgnoreCase("negro")) {
			throw new IllegalArgumentException("Cor de olhos inválidos!");
		}
		Olhos = olhos;
	}
	public String getBoca() {
		return Boca;
	}
	public void setBoca(String boca) {
		Boca = boca;
	}
	public double getPeso() {
		return Peso;
	}
	public void setPeso(double peso) {
		Peso = peso;
	}

}
