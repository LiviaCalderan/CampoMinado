package br.com.calderan.cm.modelo;

import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {
	
	private int qtdLinhas;
	private int qtdColunas;
	private int qtdMinas;
	
	private final List<Campo> campos = new ArrayList<Campo>();

	public Tabuleiro(int qtdLinhas, int qtdColunas, int qtdMinas) {
		this.qtdLinhas = qtdLinhas;
		this.qtdColunas = qtdColunas;
		this.qtdMinas = qtdMinas;
		
		gerarCampos();
		associarVizinhos();
		sortearMinas();
	}


	private void gerarCampos() {
		for (int i = 0; i < qtdLinhas; i++) {
			for (int j = 0; j < qtdColunas; j++) {
				campos.add(new Campo(i, j));
			}
		}
	}
	
	private void associarVizinhos() {
		for(Campo c1: campos) {
			for(Campo c2: campos) {
				c1.addVizinho(c2);
			}
		}
	}
	
	private void sortearMinas() {
	
	}
	
}
