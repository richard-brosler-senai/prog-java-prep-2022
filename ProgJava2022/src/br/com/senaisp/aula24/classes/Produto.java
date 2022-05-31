package br.com.senaisp.aula24.classes;

import java.util.List;

public class Produto {
	private int codigo;
	private String descricao;
	private double preco;
	private List<Produto> lstProdutos;
	
	public Produto() {
		super();
		ConexaoFake conn = ConexaoFake.getInstance();
		lstProdutos = conn.getListaProduto();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public List<Produto> getListaProdutos() {
		return lstProdutos;
	}
	
	public void novo() {
		codigo = 0;
		descricao = "";
		preco = 0.00;
	}
	
	public void adicionar() {
		
	}
	
	public void consultar() {
		
	}
	
	public void alterar() {
		
	}
	
	public void excluir() {
		
	}
	
	public boolean hasCodigo(int value) {
		boolean ret=false;
		
		return ret;
	}
	
	protected void mostrar() {
		
	}
	
}
