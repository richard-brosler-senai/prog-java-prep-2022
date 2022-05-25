package br.com.senaisp.aula21;

import br.com.senaisp.aula21.classes.Pedido;
import br.com.senaisp.aula21.classes.Produto;

public class ExemploPedido {
	public static void main(String[] args) {
		Pedido pedi = new Pedido("MeuCPF");
		pedi.adicionarProduto(new Produto("Produto 1",10,0.50));
		pedi.adicionarProduto(new Produto("Produto 2",20,1.50));
		pedi.adicionarProduto(new Produto("Produto 3",30,2.50));
		pedi.adicionarProduto(new Produto("Produto 4",40,3.50));
		pedi.adicionarProduto(new Produto("Produto 5",50,4.50));
		pedi.listarProdutos();
		System.out.println("----------------------------");
		System.out.println("Total " + pedi.totalPedido());
	}
}
