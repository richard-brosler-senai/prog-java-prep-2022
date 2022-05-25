package br.com.senaisp.aula20.classes;

import br.com.senaisp.aula20.interfaces.InFalantes;

public class SuperMaquina extends Veiculo 
					implements InFalantes {

	@Override
	public void falar() {
		System.out.println("Pois não, "
		+ "o que deseja que eu faça?");
	}

	@Override
	public void ligarVeiculo() {
		System.out.println("Ligando a "
				+ "Super Maquina");
	}

}
