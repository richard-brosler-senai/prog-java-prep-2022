package br.com.senaisp.aula20.classes;

public class Moto extends Veiculo {
	private String manopla;
	@Override
	public void ligarVeiculo() {
		System.out.println("Ligando a moto");
	}
	public String getManopla() {
		return manopla;
	}
	public void setManopla(String manopla) {
		this.manopla = manopla;
	}

}
