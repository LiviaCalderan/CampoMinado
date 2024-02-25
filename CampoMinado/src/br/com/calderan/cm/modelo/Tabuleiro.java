package br.com.calderan.cm.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import br.com.calderan.cm.excecao.ExplosaoException;

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
	
	public void abrir(int linha, int coluna) {
		try {
			campos.parallelStream()
			.filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
			.findFirst()
			.ifPresent(c -> c.abrir());
		} catch (ExplosaoException e) {
			campos.forEach(c -> c.setAberto(true));
			throw e;
		}
	}
	
	public void alterarMarcacao(int linha, int coluna) {
		campos.parallelStream()
			.filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
			.findFirst()
			.ifPresent(c -> c.alternarMarcacao());
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
		long minasArmadas = 0;
		Predicate<Campo> minado = c -> c.isMinado();
		
		do {
			int aleatorio = (int) (Math.random() * campos.size());
			campos.get(aleatorio).minar();
			minasArmadas = campos.stream().filter(minado).count();
		} while (minasArmadas < qtdMinas);
	}
	
	public boolean objetivoAlcancado() {
		return campos.stream().allMatch( c -> c.objetivoAlcancado());
	}
	
	public void reiniciar() {
		campos.stream().forEach(c -> c.reiniciar());
		sortearMinas();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		int i = 0;
		for (int l = 0; l < qtdLinhas; l++) {
			for (int q = 0; q < qtdColunas; q++) {
				sb.append(" ");
				sb.append(campos.get(i));
				sb.append(" ");
				i++;
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
