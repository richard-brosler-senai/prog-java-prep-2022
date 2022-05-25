package br.com.senaisp.aula21.classes;

public class TesteClientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente cli = new Cliente();
		for (int intI = 0; intI < 10; intI++) {
			cli.novo();
			cli.setCodigo(intI + 1);
			cli.setNome("Richard " + (intI + 1));
			cli.setEndereco("Rua das ruas");
			cli.adicionar();
		}
		cli.listarClientes();

		System.out.println("-------------------");
		
		cli.setCodigo(8);
		cli.consultar();
		System.out.println(cli.getCodigo());
		System.out.println(cli.getNome());
		System.out.println(cli.getEndereco());
		
		cli.setNome("Richard 8 - Alterado");
		cli.alterar();
		System.out.println("-------------------");
		cli.listarClientes();
		
		System.out.println("-------------------");
		System.out.println("Excluindo o Cliente 5");
		
		cli.setCodigo(5);
		cli.consultar();
		System.out.println(cli.getCodigo());
		System.out.println(cli.getNome());
		System.out.println(cli.getEndereco());
		cli.excluir();
		cli.listarClientes();		
	}

}
