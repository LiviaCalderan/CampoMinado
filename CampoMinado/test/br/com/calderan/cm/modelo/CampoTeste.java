package br.com.calderan.cm.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CampoTeste {
	
	private Campo campo;
	
	@BeforeEach
	void iniciarCampo() {
		campo = new Campo(3,3);
	}
	
	@Test
	void testeVizinhoDistancia1Esquerda() {
		Campo vizinho = new Campo(3, 2);
		boolean result = campo.addVizinho(vizinho);
		
		assertTrue(result);
	}
	
	@Test
	void testeVizinhoDistancia1Direita() {
		Campo vizinho = new Campo(3, 4);
		boolean result = campo.addVizinho(vizinho);
		
		assertTrue(result);
	}
	
	@Test
	void testeVizinhoDistancia1Emcima() {
		Campo vizinho = new Campo(2, 3);
		boolean result = campo.addVizinho(vizinho);
		
		assertTrue(result);
	}
	
	@Test
	void testeVizinhoDistancia1Embaixo() {
		Campo vizinho = new Campo(4, 3);
		boolean result = campo.addVizinho(vizinho);
		
		assertTrue(result);
	}
	
	@Test
	void testeVizinhoDistancia2() { //DIAGONAL
		Campo vizinho = new Campo(2, 2);
		boolean result = campo.addVizinho(vizinho);
		
		assertTrue(result);
	}
	
	@Test
	void testeNaoVizinho() { 
		Campo vizinho = new Campo(1, 1);
		boolean result = campo.addVizinho(vizinho);
		
		assertFalse(result);
		
	}
}
