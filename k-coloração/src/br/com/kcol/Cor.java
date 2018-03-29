package br.com.kcol;

public enum Cor {

	AMARELO, PRETO, AZUL, BRANCO, VERDE, ROSA, LARANJA, CINZA, VERMELHO, ROXO, MARROM;
	
	public static Cor proximaCor(Cor cor) {
		return Cor.values()[indiceDaCor(cor)+1];
	}
	
	public static Cor corPorIndice(int indice) {
		return Cor.values()[indice];
	}
	
	public static int indiceDaCor(Cor cor) {
		for (int i = 0; i < Cor.values().length; i++) {
			if(Cor.values()[i]==cor) {
				return i;
			}
		}
		return -1;
	}
	
	public static Cor primeiraCor() {
		return Cor.values()[0];
	}
}

