package br.com.kcol;

import static br.com.kcol.Cor.primeiraCor;
import static br.com.kcol.Cor.values;
import static java.lang.Integer.compare;
import static java.util.Collections.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KColAlgoritmo {

	@SuppressWarnings("unchecked")
	public static List<Vertice> coloracao(List<Vertice> verticesList) {
		List<Vertice> vertices = (List<Vertice>) new ArrayList<>(verticesList).clone();
		sort(vertices, (c1, c2) -> compare(c2.graus(), c1.graus()));
		for (int i = 0; i < vertices.size(); i++) {
			Vertice verticeAtual = vertices.get(i);
			if (i == 0) {
				verticeAtual.setCor(primeiraCor());
				continue;
			} else {
				if (!verticeAtual.temVizinhoColorido()) {
					verticeAtual.setCor(primeiraCor());
					continue;
				} else {
					int cont = 0;
					verticeAtual.setCor(values()[cont]);
					while (verticeAtual.causaConflitoDeColoracao()) {
						verticeAtual.setCor(values()[cont]);
						cont++;
					}
				}
			}
		}
		return vertices;
	}

	public static int classe(List<Vertice> vertices) {
		return Optional.ofNullable(vertices).map(List::stream)
				.orElse(Stream.empty()).map(Vertice::getCor).distinct()
				.collect(Collectors.toList()).size();
	}

}
