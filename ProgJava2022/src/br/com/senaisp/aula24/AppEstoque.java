package br.com.senaisp.aula24;

import br.com.senaisp.aula24.classes.FormMain;
import br.com.senaisp.aula24.classes.Produto;

public class AppEstoque {
	
	public static void main(String[] args) {
		Produto prd = new Produto();
		FormMain frmMain = new FormMain();
		frmMain.setProduto(prd);
		frmMain.setVisible(true);
	}

}
