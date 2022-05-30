package br.com.senaisp.aula21.classes;

public class Produto {
	private String descricao;
	private int qtde;
	private double preco;
	
	public Produto(String descricao, int qtde, double preco) {
		super();
		this.descricao = descricao;
		this.qtde = qtde;
		this.preco = preco;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public double precoTotal() {
		return this.preco * this.qtde;
	}
}
