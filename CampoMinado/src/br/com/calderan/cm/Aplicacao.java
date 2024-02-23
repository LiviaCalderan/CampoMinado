package br.com.calderan.cm;

import br.com.calderan.cm.modelo.Tabuleiro;
import br.com.calderan.cm.visao.TabuleiroConsole;

public class Aplicacao {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
		
		new TabuleiroConsole(tabuleiro);
		
	}
}
