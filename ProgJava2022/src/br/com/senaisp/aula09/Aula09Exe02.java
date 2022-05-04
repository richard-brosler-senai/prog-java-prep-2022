package br.com.senaisp.aula09;

public class Aula09Exe02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int intLin = 1; intLin < 10; intLin++) {
			for (int intCol = 1; intCol < 10; intCol++) {
				if ( intCol>=intLin )
					System.out.print(intLin + "-" + intCol + " ");
				else
					System.out.print("    ");
			}
			System.out.println();
		}
	}

}
