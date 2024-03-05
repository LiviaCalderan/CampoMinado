package br.com.calderan.cm.visao;

import java.awt.GridLayout;

import javax.swing.JPanel;

import br.com.calderan.cm.modelo.Tabuleiro;

@SuppressWarnings("serial")
public class PainelTabuleiro extends JPanel {

	public PainelTabuleiro(Tabuleiro tabuleiro) {
		
		setLayout(new GridLayout(tabuleiro.getQtdLinhas(), tabuleiro.getQtdColunas()));
		
		tabuleiro.paraCadaCampo(c -> add(new BotaoCampo(c)));
		
		tabuleiro.registrarObservador(e -> {
			//TODO mostrar resultado para o usuario
		});
		
	}
}
