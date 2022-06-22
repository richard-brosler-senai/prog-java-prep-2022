package br.com.senaisp.aula31;

import java.sql.SQLException;

import br.com.senaisp.aula31.classes.ConexaoBD;

public class TesteBD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Conectando-se ao banco de dados!");
			ConexaoBD conn = ConexaoBD.getInstance();
			System.out.println("Criando as tabelas do banco de dados!");
			conn.inicializarBD();
			System.out.println("Banco de dados criado com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
