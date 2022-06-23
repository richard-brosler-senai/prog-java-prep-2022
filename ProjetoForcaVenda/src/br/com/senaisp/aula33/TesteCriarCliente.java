package br.com.senaisp.aula33;

import java.sql.SQLException;

import br.com.senaisp.aula33.classes.Cliente;

public class TesteCriarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente cli = new Cliente();
		cli.novo();
		cli.setNome("Richard Brosler");
		cli.setEndereco("Rua das ruas");
		cli.setNumero("15-15");
		cli.setBairro("Centro");
		cli.setCidade("Bauru");
		cli.setUf("SP");
		cli.setCpf("111.111.111-11");
		cli.setRg("11.111.111-1");
		cli.setCep("17054-220");
		cli.setData_nasc("1977-01-18");
		try {
			cli.createDireto();
			System.out.println(cli.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
