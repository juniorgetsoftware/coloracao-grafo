package br.com.kcol;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.kcol.Vertice;

public class VerticeTeste {

	/*
	  (V1)\--------(V2)
	  	|	\		|
	  	|	(V3)	|
	  	|	/		|
	  	| /			|
	  (V4)---------(V5)
	  
	 */
	
	private Vertice v1;
	private Vertice v2;
	private Vertice v3;
	private Vertice v4;
	private Vertice v5;
	
	@Before
	public void setup() {
		v1 = new Vertice("V1");
		v2 = new Vertice("V2");
		v3 = new Vertice("V3");
		v4 = new Vertice("V4");
		v5 = new Vertice("V5");
		
		v1.comVizinhos(v2,v3, v4);
		v2.comVizinhos(v1, v5);
		v3.comVizinhos(v1, v4);
		v4.comVizinhos(v1, v3, v5);
		v5.comVizinhos(v2, v4);
	}
	
	@Test
	public void deveVerificarSeV1EVizinhoDeV2() {
		Assert.assertTrue(v1.isVizinho(v2));
	}

	@Test
	public void deveVerificarGraus() {
		Assert.assertEquals(3, v1.graus());
		Assert.assertEquals(2, v2.graus());
		Assert.assertEquals(2, v3.graus());
		Assert.assertEquals(3, v4.graus());
		Assert.assertEquals(2, v5.graus());
	}
	
	@Test
	public void deveAdicionarUmVizinho() {
		v1.adicionar(new Vertice());
		Assert.assertEquals(4, v1.graus());
	}

	@Test
	public void deveRemoverUmVizinho() {
		v1.remover(v2);
		Assert.assertEquals(2, v1.graus());
	}

	@Test
	public void deveAdicionarMaisDeUmVizinho() {
		v2.adicionar(new Vertice(), new Vertice(), new Vertice());
		Assert.assertEquals(5, v2.graus());
	}

	@Test
	public void deveRemoverMaisDeUmVizinho() {
		v2.remover(v1, v5);
		Assert.assertEquals(0, v2.graus());
	}
}
