package br.com.senaisp.aula30;

import br.com.senaisp.aula30.classes.Cliente;

public class TesteCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente cli = new Cliente();
		cli.importarArquivo("C:\\Users\\richa\\Downloads\\convertcsv.csv");
		for (Object[] item : cli.getLista()) {
			System.out.println(item[0]);
		}
	}

}
