package br.com.kcol;

import org.junit.Assert;
import org.junit.Test;

import br.com.kcol.Cor;

public class CorTeste {

	@Test
	public void deveRetornarAProximaCor() {
		Cor primeiraCor = Cor.primeiraCor();
		int indice = Cor.indiceDaCor(primeiraCor);
		Cor proximaCor = Cor.corPorIndice(indice + 1);
		Assert.assertEquals(proximaCor, Cor.proximaCor(primeiraCor));
	}

}
