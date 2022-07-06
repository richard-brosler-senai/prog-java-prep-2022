package br.com.senaisp.aula33;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import br.com.senaisp.aula33.classes.Cliente;

public class TestarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente cli = new Cliente();
		//Criando um novo registro
		/*
		cli.novo();
		
		cli.setNome("Roberto");
		cli.setEndereco("Rua das Ruas");
		cli.setNumero("123");
		cli.setBairro("Centro");
		cli.setCidade("Bauru");
		cli.setUf("SP");
		cli.setCep("17054-220");
		cli.setCpf("111.111.111-11");
		cli.setRg("11.111.111-11");
		
		Calendar cal = Calendar.getInstance();
		cal.set(1977, 0, 18);
		cal.getTime();
		
		cli.setData_nasc(cal.getTime());
		try {
			cli.create();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		//Buscando um registro
		cli.setId(6);
		try {
			if (cli.read()) {
				System.out.println(cli.getNome() + " - " + cli.getData_nasc());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
