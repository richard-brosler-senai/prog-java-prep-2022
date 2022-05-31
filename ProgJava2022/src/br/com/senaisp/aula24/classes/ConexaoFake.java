package br.com.senaisp.aula24.classes;

import java.util.ArrayList;
import java.util.List;

public class ConexaoFake {
	private static ConexaoFake instancia;
	//Constructor Privado
	private List<Produto> listaProduto;
	
	private ConexaoFake() {
		listaProduto = new ArrayList<Produto>();
	}
	
	public List<Produto> getListaProduto(){
		return listaProduto;
	}
	
	public static synchronized ConexaoFake getInstance() {
		if (instancia == null) {
			instancia = new ConexaoFake();
		}
		return instancia;
	}
}
