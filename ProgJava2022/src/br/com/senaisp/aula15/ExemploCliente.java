package br.com.senaisp.aula15;

import java.util.Scanner;

import br.com.senaisp.aula15.classes.Cliente;
import br.com.senaisp.aula15.classes.ParamentroInvalidoException;

public class ExemploCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente vetorCliente[] = new Cliente[10];
		Scanner sc = new Scanner(System.in);
		int intOpc;
		//Inicializando o vetor de clientes
		for (int intI=0;intI<10;intI++) {
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
				consultarCliente(vetorCliente);
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
		for(int intI=0;intI<10;intI++) {
			if (vetor[intI]==null) {
				ret=intI;
				break;
			}
		}
		return ret;
	}
	
	private static void cadastrarCliente(Cliente vetor[], Scanner sc) {
		System.out.println("Cadastramento de clientes");
		int intVago=getClienteVago(vetor);
		if (intVago>-1) {
			//Criando o cliente
			vetor[intVago] = new Cliente();
			//cadastrando o código
			do {
				System.out.println("Digite o código:");
				try {
					vetor[intVago].setCodigo(sc.nextInt());
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
					vetor[intVago].setNome(sc.nextLine());
					break;
				} catch (ParamentroInvalidoException e) {
					System.out.println(e.getMessage());
				}
			}while (true);
			//Cadastrando endereço
			do {
				System.out.println("Digite o endereço:");
				try {
					vetor[intVago].setEndereco(sc.nextLine());
					break;
				} catch (ParamentroInvalidoException e) {
					System.out.println(e.getMessage());
				}
			}while (true);
			System.out.println("Cadastramento efetuado com sucesso!");
		} else {
			System.out.println("Banco de dados cheio!");
		}
	}
	
	private static void consultarCliente(Cliente vetor[]) {
		
	}
	
	private static void alterarCliente(Cliente vetor[], Scanner sc) {
		
	}
	
	private static void excluirCliente(Cliente vetor[], Scanner sc) {
		
	}
	
	private static void listarCliente(Cliente vetor[]) {
		
	}
}
