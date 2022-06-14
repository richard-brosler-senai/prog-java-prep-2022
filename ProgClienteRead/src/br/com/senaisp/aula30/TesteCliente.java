package br.com.senaisp.aula30;

import br.com.senaisp.aula30.classes.Cliente;
import br.com.senaisp.aula30.classes.Cliente.TipoArquivo;

public class TesteCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente cli = new Cliente();
		//cli.importarArquivo("C:\\Users\\richa\\Downloads\\convertcsv.csv");
		//cli.importarArquivo("C:\\Users\\richard\\Downloads\\data.json", TipoArquivo.JSON);
		cli.importarArquivo("C:\\Users\\richard\\Downloads\\convertjson.xml", TipoArquivo.XML);
		for (Object[] item : cli.getLista()) {
			System.out.println(item[0]);
		}
	}

}
