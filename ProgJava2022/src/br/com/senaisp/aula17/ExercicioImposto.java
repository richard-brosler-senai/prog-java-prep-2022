package br.com.senaisp.aula17;

import br.com.senaisp.aula17.classes.ImpostoInss;

public class ExercicioImposto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImpostoInss imp = new ImpostoInss();
		try {
			imp.setBaseCalculo(10125.00);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(imp.calcularImposto());
	}

}
