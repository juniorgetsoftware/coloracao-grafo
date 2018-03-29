package br.com.kcol;

import java.util.Arrays;
import java.util.List;

public class Dataset {

	public static List<Vertice> dataset1() {

		Vertice a = new Vertice("A");
		Vertice b = new Vertice("B");
		Vertice c = new Vertice("C");
		Vertice d = new Vertice("D");
		Vertice e = new Vertice("E");
		Vertice f = new Vertice("F");

		a.comVizinhosBidirecional(b);
		b.comVizinhosBidirecional(c);
		b.comVizinhosBidirecional(d);
		d.comVizinhosBidirecional(f);
		f.comVizinhosBidirecional(a);
		e.comVizinhosBidirecional(a);
		return Arrays.asList(a, b, c, d, e, f);
	}

	public static List<Vertice> dataset2() {

		Vertice a = new Vertice("A");
		Vertice b = new Vertice("B");
		Vertice c = new Vertice("C");
		Vertice d = new Vertice("D");
		Vertice e = new Vertice("E");
		Vertice f = new Vertice("F");
		Vertice g = new Vertice("G");
		Vertice h = new Vertice("H");

		a.comVizinhosBidirecional(b);
		b.comVizinhosBidirecional(c);
		c.comVizinhosBidirecional(d);
		d.comVizinhosBidirecional(e);
		e.comVizinhosBidirecional(f, h);
		f.comVizinhosBidirecional(g);
		g.comVizinhosBidirecional(b);
		return Arrays.asList(a, b, c, d, e, f, g, h);

	}

	public static List<Vertice> dataset3() {

		Vertice a = new Vertice("A");
		Vertice b = new Vertice("B");
		Vertice c = new Vertice("C");
		Vertice d = new Vertice("D");
		Vertice e = new Vertice("E");

		a.comVizinhosBidirecional(b, c, d, e);
		b.comVizinhosBidirecional(c);
		c.comVizinhosBidirecional(d, e);
		d.comVizinhosBidirecional(e);

		return Arrays.asList(a, b, c, d, e);

	}

	public static List<Vertice> dataset4() {
		Vertice a = new Vertice("A");
		Vertice b = new Vertice("B");
		Vertice c = new Vertice("C");
		Vertice d = new Vertice("D");
		Vertice e = new Vertice("E");
		Vertice f = new Vertice("F");
		Vertice x = new Vertice("X");

		a.comVizinhosBidirecional(b, c, x);
		b.comVizinhosBidirecional(c, x);
		c.comVizinhosBidirecional(x);

		a.comVizinhosBidirecional(f, d);
		f.comVizinhosBidirecional(d);

		e.comVizinhosBidirecional(f, d);

		return Arrays.asList(a, b, c, d, e, f, x);
	}
	
	public static List<Vertice> dataset5(){
		Vertice a = new Vertice("A");
		Vertice b = new Vertice("B");
		Vertice c = new Vertice("C");
		Vertice d = new Vertice("D");
		Vertice e = new Vertice("E");
		Vertice f = new Vertice("F");
		
		a.comVizinhosBidirecional(b, e, f);
		b.comVizinhosBidirecional(c, d);
		d.comVizinhosBidirecional(f);
		
		return Arrays.asList(a, b, c, d, e, f);
	}
	
	/*
	 * A------B
	 * | \  / |
	 * |  \/  |
	 * |  /\  | 
	 * | /  \ |
	 * C------D
	 * 
	 */
	public static List<Vertice> dataset6(){
		Vertice a = new Vertice("A");
		Vertice b = new Vertice("B");
		Vertice c = new Vertice("C");
		Vertice d = new Vertice("D");
		
		a.comVizinhosBidirecional(b, c, d);
		b.comVizinhosBidirecional(c, d);
		c.comVizinhosBidirecional(d);
		
		return Arrays.asList(a, b, c, d);
	}

}
