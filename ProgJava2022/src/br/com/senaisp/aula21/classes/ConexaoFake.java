package br.com.senaisp.aula21.classes;

import java.util.ArrayList;
import java.util.List;

public class ConexaoFake {
	private static ConexaoFake instancia;
	//Constructor Privado
	private List<Cliente> listaCliente;
	
	private ConexaoFake() {
		listaCliente = new ArrayList<Cliente>();
	}
	
	public List<Cliente> getListaCliente(){
		return listaCliente;
	}
	
	public static synchronized ConexaoFake getInstance() {
		if (instancia == null) {
			instancia = new ConexaoFake();
		}
		return instancia;
	}
}
