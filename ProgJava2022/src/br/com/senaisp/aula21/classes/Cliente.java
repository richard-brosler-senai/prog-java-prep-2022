package br.com.senaisp.aula21.classes;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private List<Cliente> listaClientes;
	private int codigo;
	private String nome;
	private String endereco;
	
	public Cliente() {
		super();
		ConexaoFake conn = ConexaoFake.getInstance();
		listaClientes = conn.getListaCliente();
		//listaClientes = new ArrayList<Cliente>();
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
	
	public void adicionar() {
		int intId = pesqCliente(this.codigo);
		if (intId==-1) {
			//Necess�rio criar o cliente
			Cliente cli = new Cliente();
			cli.setCodigo(codigo);
			cli.setEndereco(endereco);
			cli.setNome(nome);
			//Adicionando o cliente
			listaClientes.add(cli);
		} else {
			System.out.println("J� existe esse cliente!");
		}
	}

	private int pesqCliente(int codigo2) {
		int intRet = -1;
		for (int intI=0;intI<listaClientes.size();intI++) {
			if (listaClientes.get(intI).getCodigo()==codigo2) {
				intRet=intI;
				break;
			}
		}
		return intRet;
	}
	
	public void alterar() {
		int intId=pesqCliente(codigo);
		if (intId>-1) {
			Cliente cli = listaClientes.get(intId);
			cli.setCodigo(codigo);
			cli.setNome(nome);
			cli.setEndereco(endereco);
		} else {
			System.out.println("Cliente n�o existe!");
		}
	}
	
	public void consultar() {
		int intId=pesqCliente(codigo);
		if (intId>-1) {
			Cliente cli = listaClientes.get(intId);
			this.setCodigo(cli.getCodigo());
			this.setNome(cli.getNome());
			this.setEndereco(cli.getEndereco());
		} else {
			System.out.println("Cliente n�o existe!");
		}
	}
	
	public void excluir() {
		int intId=pesqCliente(codigo);
		if (intId>-1) {
			listaClientes.remove(intId);
		} else {
			System.out.println("Cliente n�o existe!");
		}		
	}
	
	public void novo() {
		codigo = 0;
		nome = "";
		endereco = "";
	}
	
	public void listarClientes() {
		System.out.println("Listagem de Clientes");
		System.out.println(" # - Cod - Nome Cliente");
		System.out.println("--------------------------------------");
		for (int intI=0;intI<listaClientes.size();intI++) {
			Cliente cli = listaClientes.get(intI);
			System.out.print(String.format("%2d", intI) + " - ");
			System.out.print(String.format("%3d", cli.getCodigo()));
			System.out.print(" - " + cli.getNome());
			System.out.println(" - " + cli.getListaCount());
		}
	}

	private int getListaCount() {
		// TODO Auto-generated method stub
		return listaClientes.size();
	}
}
