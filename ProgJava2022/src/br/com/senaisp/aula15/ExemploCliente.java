package br.com.senaisp.aula15;

import java.util.Scanner;

import br.com.senaisp.aula15.classes.Cliente;
import br.com.senaisp.aula15.classes.ParamentroInvalidoException;

public class ExemploCliente {
	
	public static final int TOTAL_CLIENTES = 10;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente vetorCliente[] = new Cliente[TOTAL_CLIENTES];
		Scanner sc = new Scanner(System.in);
		int intOpc;
		//Inicializando o vetor de clientes
		for (int intI=0;intI<TOTAL_CLIENTES;intI++) {
			vetorCliente[intI]=null;
		}
		
		do {
			System.out.println("Opções do Menu");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Consultar");
			System.out.println("3 - Alterar");
			System.out.println("4 - Excluir");
			System.out.println("5 - Listar");
			System.out.println("9 - Finalizar");
			System.out.println("Digite sua opção:");
			intOpc = sc.nextInt();
			sc.nextLine();
			switch(intOpc) {
			case 1:
				cadastrarCliente(vetorCliente,sc);
				break;
			case 2:
				consultarCliente(vetorCliente,sc);
				break;
			case 3:
				alterarCliente(vetorCliente,sc);
				break;
			case 4: 
				excluirCliente(vetorCliente,sc);
				break;
			case 5:
				listarCliente(vetorCliente);
				break;
			}
			System.out.println("Tecle enter para voltar ao menu");
			sc.nextLine();
		}while (intOpc!=9);
		sc.close();
	}
	
	private static int getClienteVago(Cliente vetor[]) {
		int ret=-1;
		for(int intI=0;intI<TOTAL_CLIENTES;intI++) {
			if (vetor[intI]==null) {
				ret=intI;
				break;
			}
		}
		return ret;
	}
	
	private static void manutencaoCliente(Cliente item, Scanner sc) {
		//cadastrando o código
		do {
			System.out.println("Digite o código:");
			try {
				item.setCodigo(sc.nextInt());
				sc.nextLine();
				break;
			} catch (ParamentroInvalidoException e) {
				System.out.println(e.getMessage());
			}
		}while(true);
		//Cadastrando nome
		do {
			System.out.println("Digite o nome:");
			try {
				item.setNome(sc.nextLine());
				break;
			} catch (ParamentroInvalidoException e) {
				System.out.println(e.getMessage());
			}
		}while (true);
		//Cadastrando endereço
		do {
			System.out.println("Digite o endereço:");
			try {
				item.setEndereco(sc.nextLine());
				break;
			} catch (ParamentroInvalidoException e) {
				System.out.println(e.getMessage());
			}
		}while (true);
	}
	
	private static void cadastrarCliente(Cliente vetor[], Scanner sc) {
		System.out.println("Cadastramento de clientes");
		int intVago=getClienteVago(vetor);
		if (intVago>-1) {
			//Criando o cliente
			vetor[intVago] = new Cliente();
			manutencaoCliente(vetor[intVago],sc);
			System.out.println("Cadastramento efetuado com sucesso!");
		} else {
			System.out.println("Banco de dados cheio!");
		}
	}

	private static int pesquisaCliente(Cliente vetor[], Scanner sc) {
		int ret=-1, intCod;
		System.out.println("Digite o código a ser pesquisado:");
		intCod = sc.nextInt();
		sc.nextLine();
		for (int intI=0;intI<TOTAL_CLIENTES;intI++) {
			if (vetor[intI]!=null && vetor[intI].getCodigo()==intCod) {
				ret=intI;
				break;
			}
		}
		if (ret!=-1) {
			System.out.println("Cliente encontrado!");
			System.out.println("Codigo...: " + vetor[ret].getCodigo());
			System.out.println("Nome.....: " + vetor[ret].getNome());
			System.out.println("Endereço.: " + vetor[ret].getEndereco());
		} else {
			System.out.println("Cliente não encontrado!");
		}
		return ret;
	}
	
	private static void consultarCliente(Cliente vetor[], Scanner sc) {
		System.out.println("Consultar Cliente");
		pesquisaCliente(vetor, sc);
	}
	
	private static void alterarCliente(Cliente vetor[], Scanner sc) {
		System.out.println("Alterar Cliente");
		int intCod=pesquisaCliente(vetor, sc);
		if (intCod>-1) {
			manutencaoCliente(vetor[intCod], sc);
			System.out.println("Registro alterado!");
		}
	}
	
	private static void excluirCliente(Cliente vetor[], Scanner sc) {
		System.out.println("Excluir Cliente");
		int intCod=pesquisaCliente(vetor, sc);
		if (intCod>-1) {
			System.out.println("Tem certeza que deseja excluir? (1-sim,2-não)");
			int intRes=sc.nextInt();
			sc.nextLine();
			if (intRes==1) {
				vetor[intCod]=null;
				System.out.println("Registro excluído!");
			}
		}
	}
	
	private static void listarCliente(Cliente vetor[]) {
		System.out.println("Listagem de clientes");
		System.out.println("#   - Cod - Nome");
		for (int intI=0; intI<TOTAL_CLIENTES;intI++) {
			if (vetor[intI]!=null) {
				System.out.println(String.format("%3s",intI+"") + " - " + String.format("%3s", vetor[intI].getCodigo()+"") + " - " + vetor[intI].getNome());
			}
		}
	}
}
