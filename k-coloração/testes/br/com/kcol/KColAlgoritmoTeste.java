package br.com.kcol;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class KColAlgoritmoTeste {

	private List<Vertice> dataset1 = Dataset.dataset1();
	private List<Vertice> dataset2 = Dataset.dataset2();
	private List<Vertice> dataset3 = Dataset.dataset3();
	private List<Vertice> dataset4 = Dataset.dataset4();

	@Before
	public void setup() {

	}

	@Test
	public void deveVerificarSeVerticesVizinhosTemCoresDiferentes() {

		KColAlgoritmo.coloracao(dataset2);

		for (int i = 0; i < dataset2.size(); i++) {
			Vertice atual = dataset2.get(i);
			assertEquals(0, atual.getVizinhos().stream().filter(c -> c.getCor() == atual.getCor())
					.collect(Collectors.toList()).size());
		}

	}

	@Test
	public void deveVerificarAClasseDaColoracao() {
		List<Vertice> dt1 = KColAlgoritmo.coloracao(dataset1);
		List<Vertice> dt2 = KColAlgoritmo.coloracao(dataset2);
		List<Vertice> dt3 = KColAlgoritmo.coloracao(dataset3);
		List<Vertice> dt4 = KColAlgoritmo.coloracao(dataset4);

		assertEquals(2, KColAlgoritmo.classe(dt1));
		assertEquals(3, KColAlgoritmo.classe(dt2));
		assertEquals(4, KColAlgoritmo.classe(dt3));
		assertEquals(4, KColAlgoritmo.classe(dt4));
	}
}
