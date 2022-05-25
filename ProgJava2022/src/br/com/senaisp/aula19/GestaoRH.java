package br.com.senaisp.aula19;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import br.com.senaisp.aula17.classes.ImpostoInss;
import br.com.senaisp.aula18.classes.Funcionario;
import br.com.senaisp.aula18.classes.ImpostoIrrf;
import br.com.senaisp.aula19.classes.FolhaPagamento;

public class GestaoRH {
	public static final int LIMITE_FUNCIONARIOS = 10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in).useLocale(Locale.ENGLISH);
		int intOpc=0;
		Funcionario listaFuncionario[] = new Funcionario[LIMITE_FUNCIONARIOS];
		FolhaPagamento listaFolha[] = new FolhaPagamento[LIMITE_FUNCIONARIOS];
		
		do {
			System.out.println("Menu de op��es");
			System.out.println("1 - Cadastramento Funcion�rios");
			System.out.println("2 - Lista de Funcion�rios");
			System.out.println("3 - Altera��o de Funcion�rios");
			System.out.println("4 - Exclus�o de Funcion�rios");
			System.out.println("5 - Lan�amento na Folha");
			System.out.println("6 - Listagem da Folha");
			System.out.println("7 - Exclus�o Lan�amento da Folha");
			System.out.println("9 - Fim");
			intOpc = sc.nextInt();
			sc.nextLine();
			switch (intOpc) {
			case 1: 
				cadastrarFuncionario(listaFuncionario,sc);
				break;
			case 2:
				listagemFuncionario(listaFuncionario);
				break;
			case 3:
				alteracaoFuncionario(listaFuncionario,sc);
				break;
			case 4:
				exclusaoFuncionario(listaFuncionario,sc);
				break;
			case 5:
				lancamentoFolha(listaFolha, listaFuncionario, sc);
				break;
			case 6:
				listagemFolha(listaFolha);
				break;
			}
			System.out.println("Pressione enter para voltar ao menu");
			sc.nextLine();
		} while(intOpc != 9);

	}
	/**
	 * M�todo de listagem da folha de pagamento
	 * @param listaFolha Deve ser informada a lista da folha de pagamento
	 */
	private static void listagemFolha(FolhaPagamento[] listaFolha) {
		System.out.println("Listagem da folha");
		System.out.println("# - Chapa - Sal�rio L�quido");
		for (int intI=0;intI<LIMITE_FUNCIONARIOS;intI++) {
			if (listaFolha[intI]!=null) {
				System.out.println(intI + " - " +
						listaFolha[intI].getChapaFuncionario() + " - " + 
						listaFolha[intI].valorSalarioLiquido());
			}
		}
	}
	/**
	 * M�todo que far� o lan�amento na folha de pagamento
	 * @param listaFolha Deve ser informada a lista da folha de pagamento
	 * @param listaFuncionario Deve ser informada a lista de funcion�rios para pesquisa de funcion�rios
	 * @param sc Deve ser informado o objeto scanner para digita��o via teclado.
	 */
	private static void lancamentoFolha(FolhaPagamento[] listaFolha, Funcionario[] listaFuncionario, Scanner sc) {
		System.out.println("Lan�amento na folha");
		//pesquisando o item disponivel
		int intDisp = -1;
		for (int intI=0; intI<LIMITE_FUNCIONARIOS;intI++) {
			if (listaFolha[intI]==null) {
				intDisp = intI;
				break;
			}
		}
		if (intDisp>-1) {
			listaFolha[intDisp] = new FolhaPagamento();
			manutencaoFolhaPagamento(listaFolha[intDisp],sc,
						listaFuncionario, listaFolha);
		} else {
			System.out.println("Folha de pagamento cheia!");
		}
	}
	/**
	 * M�todo auxiliar para cadastramento na folha de pagamento
	 * @param folhaPagamento Deve ser informado o objeto da folha de pagamento para manuten��o
	 * @param sc Deve ser informado o objeto Scanner para entrada de dados via teclado
	 * @param listaFuncionario Deve ser informada a lista de funcion�rios para pesquisa do funcion�rio
	 * @param listaFolha Deve ser informada a lista da folha para pesquisa se existe lan�amento do funcion�rio na
	 * listagem da folha
	 */
	private static void manutencaoFolhaPagamento(FolhaPagamento folhaPagamento, Scanner sc,
			Funcionario[] listaFuncionario, FolhaPagamento[] listaFolha) {
		int intIdFunc=-1;
		do {
			System.out.println("Digite a chapa do funcion�rio:");
			int intChapa=sc.nextInt();
			sc.nextLine();
			//Funcion�rio deve existir para lan��-lo na folha
			intIdFunc = pesqFunc(listaFuncionario, intChapa);
			if (intIdFunc==-1) {
				System.out.println("Funcion�rio n�o existe!");
				continue;
			}
			if (pesqLancto(listaFolha, intChapa)>-1) {
				System.out.println("Lan�amento da folha do funcion�rio j� existe!");
				continue;
			}
			try {
				folhaPagamento.setChapaFuncionario(intChapa);
				//Colocando o sal�rio bruto atrav�s do sal�rio do funcion�rio
				//cadastrado
				folhaPagamento.setSalarioBruto(listaFuncionario[intIdFunc].getSalario());
				//Criando os objetos de impostos para serem calculados
				ImpostoInss inss = new ImpostoInss();
				ImpostoIrrf irrf = new ImpostoIrrf();
				//Setando a base de calculo do inss pelo sal�rio bruto informado
				inss.setBaseCalculo(folhaPagamento.getSalarioBruto());
				//Setando o valor do inss na folha de pagamento
				folhaPagamento.setValorInss(inss.calcularImposto());
				//Setando a base de calculo do IRRF atrav�s do sal�rio
				//bruto na folha - o valor do inss calculado
				irrf.setBaseCalculo(folhaPagamento.getSalarioBruto() - 
									folhaPagamento.getValorInss());
				//Informando o numero de dependentes do funcion�rio.
				irrf.setNrDependentes(
						listaFuncionario[intIdFunc].getNrDependentes());
				//setando o irrf calculado na folha
				folhaPagamento.setValorIrrf(irrf.calcularImposto());
				//mostrando o sal�rio l�quido
				System.out.println("Sal�rio L�quido: " + 
						folhaPagamento.valorSalarioLiquido());
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}while (true);
	}
	/**
	 * Fun��o para pesquisa do lan�amento na folha
	 * @param listaFolha Deve ser informada a lista da folha para ser pesquisada
	 * @param intChapa Deve ser informada a chapa do funcion�rio para ser pesquisada
	 * na lista da folha
	 * @return Retorna o id de lan�amento na lista da folha
	 */
	private static int pesqLancto(FolhaPagamento[] listaFolha, int intChapa) {
		int intRet = -1;
		for (int intI=0;intI<LIMITE_FUNCIONARIOS;intI++) {
			if (listaFolha[intI]!=null && 
				listaFolha[intI].getChapaFuncionario() == intChapa) {
				intRet = intI;
				break;
			}
		}
		return intRet;
	}
	/**
	 * M�todo de exclus�o de funcion�rios da lista de funcion�rios.
	 * @param listaFuncionario Deve ser informada a lista de funcion�rios
	 * para que possa ser pesquisado e exclu�do o funcion�rio.
	 * @param sc Deve ser informado o objeto Scanner para entrada de dados
	 * via teclado.
	 */
	private static void exclusaoFuncionario(Funcionario[] listaFuncionario, Scanner sc) {
		System.out.println("Exclus�o do Funcion�rio");
		int intFun = pesquisarFuncionario(listaFuncionario,sc);
		if (intFun>-1) {
			mostrarCliente(listaFuncionario[intFun]);
			System.out.println("-----------------------------");
			System.out.println("Deseja mesmo excluir? 1-sim, 2-n�o");
			int intOpc=sc.nextInt();
			if (intOpc==1) { 
				listaFuncionario[intFun] = null;
			}
			sc.nextLine();
		} else {
			System.out.println("Funcion�rio n�o encontrado!");
		}
	}
	/**
	 * M�todo de altera��o de funcion�rios
	 * @param listaFuncionario Deve ser informada a lista de funcion�rios
	 * para ser pesquisada e alterado o funcion�rio.
	 * @param sc Deve ser informado o objeto Scanner para que possa ser
	 * dado entrada de dados via teclado.
	 */
	private static void alteracaoFuncionario(Funcionario[] listaFuncionario, Scanner sc) {
		System.out.println("Altera��o do Funcion�rio");
		int intFun = pesquisarFuncionario(listaFuncionario,sc);
		if (intFun>-1) {
			mostrarCliente(listaFuncionario[intFun]);
			System.out.println("-----------------------------");
			manutencaoFuncionario(listaFuncionario[intFun], sc, listaFuncionario);
		} else {
			System.out.println("Funcion�rio n�o encontrado!");
		}
	}
	/**
	 * Mostra os dados do funcion�rio
	 * @param funcionario Deve ser informado o objeto funcion�rio a ser
	 * impresso os dados.
	 */
	private static void mostrarCliente(Funcionario funcionario) {
		System.out.println("Chapa do funcion�rio....: " +funcionario.getChapa());
		System.out.println("Nome do funcion�rio.....: " +funcionario.getNome());
		System.out.println("Endere�o do funcion�rio.: " +funcionario.getEndereco());
		System.out.println("Nr. Dep. do funcion�rio.: " +funcionario.getNrDependentes());
		System.out.println("Sal�rio do funcion�rio..: " +funcionario.getSalario());
	}
	/**
	 * M�todo de pesquisa de funcion�rios
	 * @param listaFuncionario Deve ser informada a lista de funcion�rios para ser pesquisada.
	 * @param sc Deve ser informado o objeto Scanner para entrada de dados via teclado.
	 * @return Retorna o id de lan�amento na lista de funcion�rios ou -1 se n�o encontrou.
	 */
	private static int pesquisarFuncionario(Funcionario[] listaFuncionario, Scanner sc) {
		System.out.println("Digite o n�mero da chapa ser pesquisada:");
		int intChapa=sc.nextInt();
		sc.nextLine();
		return pesqFunc(listaFuncionario, intChapa);
	}
	/**
	 * Fun��o para pesquisar se encontra uma chapa na lista de funcion�rios
	 * @param listaFuncionario Deve-se passar a lista de funcion�rios
	 * @param intChapa Deve-se passar a chapa a ser pesquisada
	 * @return Retorna o �ndice onde se encontra a chapa ou -1 se n�o
	 * encontrou o funcion�rio com a chapa informada
	 */
	private static int pesqFunc(Funcionario[] listaFuncionario, 
									int intChapa) {
		int intRet = -1;
		for (int intI=0;intI<LIMITE_FUNCIONARIOS;intI++) {
			if (listaFuncionario[intI]!=null && 
					listaFuncionario[intI].getChapa() == intChapa) {
				intRet = intI;
				break;
			}
		}
		return intRet;
	}
	
	private static void listagemFuncionario(Funcionario[] listaFuncionario) {
		System.out.println("Listagem de Funcion�rios");
		System.out.println("# - Chapa - Nome");
		System.out.println("----------------------------------");
		for (int intI=0;intI<LIMITE_FUNCIONARIOS;intI++) {
			if (listaFuncionario[intI]!=null) {
				System.out.print(intI+" - ");
				System.out.print(listaFuncionario[intI].getChapa()+ " - ");
				System.out.println(listaFuncionario[intI].getNome());
			}
		}	
	}

	private static void cadastrarFuncionario(Funcionario[] listaFuncionario, Scanner sc) {
		//Encontrando o item livre da lista para cadastrar o funcion�rio
		int intDisp=-1;
		for (int intI=0;intI<listaFuncionario.length;intI++) {
			if (listaFuncionario[intI]==null) {
				intDisp = intI;
				break;
			}
		}
		//In�cio do cadastro
		System.out.println("Cadastramento do Funcion�rio");
		if (intDisp>-1) {
			//Criando o objeto do funcion�rio
			listaFuncionario[intDisp] = new Funcionario();
			//Chamando o m�todo de cadastramento
			manutencaoFuncionario(listaFuncionario[intDisp],sc,listaFuncionario);
		} else {
			System.out.println("N�o h� espa�o para cadastrar funcion�rio");
		}
	}

	private static void manutencaoFuncionario(Funcionario funcionario, Scanner sc, 
											  Funcionario[] listaFuncionario) {
		do {
			System.out.println("Digite a Chapa do funcion�rio:");
			try {
				int intNrChapa = sc.nextInt();
				//se a chapa digitada for diferente da chapa que o funcion�rio
				//tem no objeto posicionado, tenho que pesquisar
				//se j� existe um funcion�rio com essa chapa
				//Se existir, dever� usar outra chapa
				if (intNrChapa!=funcionario.getChapa()) {
					if (pesqFunc(listaFuncionario, intNrChapa)!=-1) {
						System.out.println("Chapa j� existe para um funcion�rio! Redigite.");
						continue;
					}
				}
				funcionario.setChapa(intNrChapa);
				sc.nextLine();
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				if (e instanceof InputMismatchException) sc.nextLine();
			}
		} while(true);
		//Nome do funcion�rio
		do {
			System.out.println("Digite o nome do funcion�rio:");
			try {
				funcionario.setNome(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}while (true);
		//Endere�o do funcion�rio
		do {
			System.out.println("Digite o endere�o do funcion�rio:");
			try {
				funcionario.setEndereco(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}while (true);
		//N�mero de dependentes do funcion�rio
		do {
			System.out.println("Digite o N�mero de dependentes do funcion�rio:");
			try {
				funcionario.setNrDependentes(sc.nextInt());
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				if (e instanceof InputMismatchException) 
					sc.nextLine();
			}
		}while (true);
		//Sal�rio do Funcion�rio
		do {
			System.out.println("Digite o Sal�rio do funcion�rio:");
			try {
				funcionario.setSalario(sc.nextDouble());
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				if (e instanceof InputMismatchException) 
					sc.nextLine();
			}
		}while (true);
		sc.nextLine();
	}

}
