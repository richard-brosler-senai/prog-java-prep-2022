package br.com.senaisp.aula30;

import br.com.senaisp.aula30.classes.Cliente;
import br.com.senaisp.aula30.classes.Cliente.TipoArquivo;

public class TesteCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente cli = new Cliente();
		//cli.importarArquivo("C:\\Users\\richa\\Downloads\\convertcsv.csv");
		//cli.importarArquivo("C:\\Users\\richa\\Downloads\\data.json", TipoArquivo.JSON);
		cli.importarArquivo("C:\\Users\\richa\\Downloads\\convertjson.xml", TipoArquivo.XML);
		cli.serializarLista("C:\\Users\\richa\\Downloads\\listaObj.dat");
		for (Object[] item : cli.getLista()) {
			System.out.println(item[0]);
			item[0] += " - Alterado"; 
		}
		cli.exportarArquivo("C:\\Users\\richa\\Downloads\\arquivo.xml",TipoArquivo.XML);
		Cliente cli2 = new Cliente();
		cli2.deserializarLista("C:\\Users\\richa\\Downloads\\listaObj.dat");
		System.out.println("---------------------------------");
		for (Object[] item : cli2.getLista()) {
			System.out.println(item[0]);
		}
		cli2.exportarArquivo("C:\\Users\\richa\\Downloads\\arquivo2.xml", TipoArquivo.XML);
	}

}
