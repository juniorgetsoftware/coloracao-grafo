package br.com.kcol;

import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Vertice> list = Dataset.dataset5();

		KColAlgoritmo.coloracao(list);
		int classe = KColAlgoritmo.classe(list);
		System.out.println("CLASSE: " + classe);
		System.out.println(list);

	}

}
