package br.com.senaisp.aula21.classes;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private List<Produto> listProdutos;
	private String documentoCliente;
	
	public Pedido(String documentoCliente) {
		super();
		this.documentoCliente = documentoCliente;
		this.listProdutos = new ArrayList<Produto>();
	}
	
	public String getDocumentoCliente() {
		return documentoCliente;
	}
	public void setDocumentoCliente(String documentoCliente) {
		this.documentoCliente = documentoCliente;
	}
	
	public boolean adicionarProduto(Produto prod) {
		return this.listProdutos.add(prod);
	}
	
	public Produto removerProduto(int indProd) {
		return this.listProdutos.remove(indProd);
	}
	
	public double totalPedido() {
		double totPedido=0;
		for(int intI=0;intI<this.listProdutos.size();intI++) {
			totPedido+=this.listProdutos.get(intI).precoTotal();
		}
		return totPedido;
	}
	public void listarProdutos() {
		System.out.println("Listagem de produtos do pedido");
		System.out.println("------------------------------");
		for (int intI=0;intI<this.listProdutos.size();intI++) {
			Produto prod = this.listProdutos.get(intI);
			System.out.println(prod.getDescricao() + " - " +
				String.format("%6.2f", prod.precoTotal()));
		}
	}

	
}
