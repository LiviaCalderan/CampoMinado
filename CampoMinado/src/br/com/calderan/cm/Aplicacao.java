package br.com.calderan.cm;

import br.com.calderan.cm.modelo.Tabuleiro;
import br.com.calderan.cm.visao.TabuleiroConsole;

public class Aplicacao {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(5, 5, 10);
		
		new TabuleiroConsole(tabuleiro);
		
	}
}
