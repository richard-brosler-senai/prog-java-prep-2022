package br.com.senaisp.aula20.classes;

import br.com.senaisp.aula20.interfaces.InFalantes;

public class SuperMaquina extends Veiculo 
					implements InFalantes {

	@Override
	public void falar() {
		System.out.println("Pois n�o, "
		+ "o que deseja que eu fa�a?");
	}

	@Override
	public void ligarVeiculo() {
		System.out.println("Ligando a "
				+ "Super Maquina");
	}

}
