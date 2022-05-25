package br.com.senaisp.aula13;

import java.util.Scanner;

public class Aula13Exe03Alterado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String strDados[][] = new String[10][2];
		int intOpc;
		//inicializando a matriz
		for (int intI=0;intI<10;intI++) { 
			strDados[intI][0] = ""; //nome
			strDados[intI][1] = "*";//controle
		}
		//
		do {
			//mostrando o menu de op�oes
			montarMenu();
			intOpc = sc.nextInt();
			//
			int intDisponivel;
			switch(intOpc) {
			case 1: 
				System.out.println("Cadastramento de Pessoas");
				intDisponivel=-1;
				for(int intI=0; intI<10;intI++) {
					if (strDados[intI][1].equals("*")) {
						intDisponivel = intI;
						break; //quebrando o la�o de repeti��o
					}
				}
				sc.nextLine(); //para evitar o enter do menu de op�oes;
				if (intDisponivel>-1) {
					System.out.println("Digite o nome a ser cadastrado:");
					strDados[intDisponivel][0] = sc.nextLine();
					strDados[intDisponivel][1] = ""; //n�o esquecer de tirar o *
					System.out.println("Castrado com sucesso! Seu id � " + intDisponivel);
				} else {
					System.out.println("Sem espa�o para cadastramento!");
				}
				
				break; //break do case
			case 5: //Listagem
				sc.nextLine();//para evitar o enter das op�oes;
				System.out.println("Listagem de cadastros");
				for (int intI=0;intI<10;intI++) {
					if (strDados[intI][1].equals("")) {
						System.out.println(intI + " - " + strDados[intI][0]);
					}
				}
				
				break;
			case 2: //consulta do cliente
				System.out.println("Consultar o Nome pelo Id");
				sc.nextLine(); //para pegar o enter do menu;
				intDisponivel = pesquisaCliente(strDados,sc);
				sc.nextLine(); //para pegar o enter do id buscar
				
				break;
			case 3: //Altera��o
				System.out.println("Altera��o pelo Id");
				sc.nextLine(); //para pegar o enter do menu;
				//Buscando o cliente
				intDisponivel=pesquisaCliente(strDados, sc);
				sc.nextLine(); //para pegar o enter do id buscar
				//Processo de altera��o
				if (intDisponivel>-1) {
					System.out.println("Digite o nome para substituir o atual:");
					strDados[intDisponivel][0]=sc.nextLine();
				}
				
				
				break;
			case 4: //Exclus�o
				System.out.println("Exclus�o pelo Id");
				sc.nextLine(); //para pegar o enter do menu;
				//Buscando o cliente
				intDisponivel=pesquisaCliente(strDados, sc);
				//Processo de exclus�o
				if (intDisponivel>-1) {
					System.out.println("Confirma a exclus�o?(1-sim,2-n�o):");
					int intOpcExcl = sc.nextInt();
					if (intOpcExcl==1) {
						strDados[intDisponivel][1]="*";
					}
					sc.nextLine(); //para pegar o enter do id buscar
				}
				
				break;

			}
			System.out.println("Digite enter para voltar ao menu");
			sc.nextLine();
		}while(intOpc!=9);

	}
	/**
	 * Fun��o que pesquisa o cliente na matriz informada e retorna o id se encontrou
	 * caso contr�rio, retorna -1
	 * @param strMatriz Deve-se passar a matriz a ser pesquisada
	 * @param sc Deve-se passar o objeto scanner para ser utilizado
	 * @return Retorna o id pesquisado ou -1 se n�o encontrou o cadastro
	 */
	public static int pesquisaCliente(String strMatriz[][],Scanner sc) {
		int intRet;
		
		System.out.println("Digite o ID do nome a ser Pesquisado:");
		intRet=sc.nextInt(); //digitar o id a ser buscado
		if (intRet>=0 && intRet<10 && 
				strMatriz[intRet][1].equals("") ) {
			System.out.println("Nome encontrado!");
			System.out.println("Nome: " + strMatriz[intRet][0]);
		} else {
			System.out.println("Nome n�o encontrado!");
			intRet=-1; //N�o encontrei
		}		
		return intRet;
	}
	/**
	 * Procedimento de montagem do menu
	 */
	public static void montarMenu() {
		System.out.println("Menu de Op��es");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Consultar pelo Id");
		System.out.println("3 - Alterar pelo Id");
		System.out.println("4 - Excluir pelo Id");
		System.out.println("5 - Listar em ordem de Id");
		System.out.println("9 - Fim do programa");
		System.out.println("Escolha uma das op��es:");	
	}

}
