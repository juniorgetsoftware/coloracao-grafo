package br.com.kcol;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Vertice {

	private String descricao;
	private Cor cor;
	private List<Vertice> vizinhos;

	public Vertice() {
		this.vizinhos = new ArrayList<>();
	}

	public Vertice(String descricao) {
		this();
		this.descricao = descricao;
	}

	/**/

	public boolean isVizinho(Vertice v) {
		return this.vizinhos.contains(v);
	}

	public boolean isColorido() {
		return this.getCor() == (null) ? false : true;
	}

	public Vertice comDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}

	public Vertice comVizinhos(Vertice... v) {
		this.adicionar(v);
		return this;
	}

	public Vertice comVizinhosBidirecional(Vertice... v) {
		this.adicionarBidirecional(v);
		return this;
	}

	public void adicionar(Vertice v) {
		this.getVizinhos().add(v);
	}

	public void adicionarBidirecional(Vertice v) {
		this.getVizinhos().add(v);
		v.getVizinhos().add(this);
	}

	public void remover(Vertice v) {
		this.getVizinhos().remove(v);
	}

	public void removerBidirecional(Vertice v) {
		this.getVizinhos().remove(v);
		v.getVizinhos().remove(this);
	}

	public void adicionar(Vertice... v) {
		Stream.of(v).forEach(vizinhos::add);
	}

	public void adicionarBidirecional(Vertice... v) {
		Stream.of(v).forEach(vizinhos::add);
		Stream.of(v).forEach(c -> c.getVizinhos().add(this));
	}

	public void remover(Vertice... v) {
		Stream.of(v).forEach(vizinhos::remove);
	}

	public void removerBidirecional(Vertice... v) {
		Stream.of(v).forEach(vizinhos::remove);
		Stream.of(v).forEach(c -> c.getVizinhos().remove(this));
	}

	public int graus() {
		return this.vizinhos.size();
	}

	/**/

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Vertice> getVizinhos() {
		return vizinhos;
	}

	public void setVizinhos(List<Vertice> vizinhos) {
		this.vizinhos = vizinhos;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertice other = (Vertice) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\n[" + descricao + " {" + getCor() + ", " + graus() + "}]";
	}

	public boolean temVizinhoColorido() {
		return !getVizinhos().stream().filter(c -> c.isColorido()).collect(Collectors.toList()).isEmpty();
	}

	public boolean causaConflitoDeColoracao() {
		return !getVizinhos().stream().filter(c -> c.getCor() == (this.cor)).collect(Collectors.toList()).isEmpty();
	}

}
