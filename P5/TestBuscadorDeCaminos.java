package P5;

import tp5.Graph;
import tp5.Vertex;
import tp5.adjList.AdjListGraph;

public class TestBuscadorDeCaminos {
	public static void main(String [] args) {
		Graph<String> grafo=new AdjListGraph<String>();
		
		Vertex<String> caperucita=grafo.createVertex("Casa Caperucita");
		Vertex<String> abuelita=grafo.createVertex("Casa Abuelita");
		Vertex<String> uno=grafo.createVertex("Claro 1");
		Vertex<String> dos=grafo.createVertex("Claro 2");
		Vertex<String> tres=grafo.createVertex("Claro 3");
		Vertex<String> cuatro=grafo.createVertex("Claro 4");
		Vertex<String> cinco=grafo.createVertex("Claro 5");
		
		grafo.connect(caperucita,tres,4);
		grafo.connect(tres, caperucita,4);
		grafo.connect(caperucita,uno,3);
		grafo.connect(uno,caperucita,3);
		grafo.connect(caperucita,dos,4);
		grafo.connect(dos ,caperucita,4);
		grafo.connect(tres,cinco,15);
		grafo.connect(cinco,tres,15);
		grafo.connect(uno,cinco,3);
		grafo.connect(cinco,uno,3);
		grafo.connect(uno,dos,4);
		grafo.connect(dos,uno,4);
		grafo.connect(dos,cinco,11);
		grafo.connect(cinco,dos,11);
		grafo.connect(dos,cuatro,10);
		grafo.connect(cuatro,dos,10);
		grafo.connect(cinco,abuelita,4);
		grafo.connect(abuelita,cinco,4);
		grafo.connect(cuatro,abuelita,9);
		grafo.connect(abuelita,cuatro,9);
		
		BuscadorDeCaminos buscador=new BuscadorDeCaminos(grafo);
		System.out.println(buscador.recorridosMasSeguros());
	}
}
