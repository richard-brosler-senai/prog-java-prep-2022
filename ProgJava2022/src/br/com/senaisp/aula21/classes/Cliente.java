package br.com.senaisp.aula21.classes;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private List<Cliente> lstCliente;
	private int codigo;
	private String nome;
	private String endereco;
	private String telefone;
	
	public Cliente() {
		this.lstCliente = new ArrayList<Cliente>();
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void adicionar() {
		int intPos=existeCodigo(codigo);
		if (intPos==-1) {
			this.lstCliente.add(this);
		} else {
			System.out.println("Cliente já está cadastrado!");
			Cliente cli = this.lstCliente.get(intPos);
			carregaDados(cli);
		}
	}
	
	private void carregaDados(Cliente cli) {
		this.setCodigo(cli.getCodigo());
		this.setEndereco(cli.getEndereco());
		this.setNome(cli.getNome());
		this.setTelefone(cli.getTelefone());
	}
	
	public void alterar() {
		int intPos=existeCodigo(codigo);
		if (intPos>-1) {
			Cliente cli = this.lstCliente.get(intPos);
			cli.setCodigo(this.getCodigo());
			cli.setEndereco(this.getEndereco());
			cli.setNome(this.getNome());
			cli.setTelefone(this.getTelefone());
		} else {
			System.out.println("Cliente não já está cadastrado!");
		}
	}
	
	public void excluir() {
		int intPos=existeCodigo(codigo);
		if (intPos>-1) {
			this.lstCliente.remove(intPos);
		} else {
			System.out.println("Cliente não já está cadastrado!");
		}
	}
	
	public void consultar() {
		int intPos=existeCodigo(codigo);
		if (intPos>-1) {
			Cliente cli = this.lstCliente.get(intPos);
			carregaDados(cli);
		} else {
			System.out.println("Cliente não já está cadastrado!");
		}	
	}
	
	public void listar() {
		
	}
	
	private int existeCodigo(int pCodigo) {
		int intRet = -1;
		for (int intI=0;intI < this.lstCliente.size();intI++) {
			if (this.lstCliente.get(intI).getCodigo()==pCodigo) {
				intRet = intI;
				break;
			}
		}
		return intRet;
	}
}
