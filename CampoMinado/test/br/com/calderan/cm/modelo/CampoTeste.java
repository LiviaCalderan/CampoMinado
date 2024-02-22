package br.com.calderan.cm.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.calderan.cm.excecao.ExplosaoException;

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
	
	@Test
	void testeValorPadraoAtributoMarcado() {
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacaoDuasChamadas() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void abrirNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}
	
	@Test
	void abrirNaoMinadoMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void abrirMinadoMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	
	@Test
	void abrirMinadoNaoMarcado() {
		campo.minar();
		
		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();
		});
		assertFalse(campo.abrir());
	}
	
	@Test
	void abrirComVizinhos() {
		Campo campo11 = new Campo(1, 1);
		Campo campo12 = new Campo(1, 2);
		campo12.minar();
		
		Campo campo22 = new Campo(2, 2);
		campo22.addVizinho(campo11);
		campo22.addVizinho(campo12);
		
		campo.addVizinho(campo22);
		
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isFechado());
	}
}
