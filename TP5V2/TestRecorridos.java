package TP5V2;

import tp5.Graph;
import tp5.Vertex;
import tp5.adjList.AdjListGraph;

public class TestRecorridos {
	public static void main (String[]args) {
		Graph<String> grafo=new AdjListGraph<>();
		
		Vertex<String> casaCaperucita =grafo.createVertex("Casa caperucita");
		Vertex<String> claro1 =grafo.createVertex("claro1");
		Vertex<String> claro2 =grafo.createVertex("claro2");
		Vertex<String> claro3 =grafo.createVertex("claro3");
		Vertex<String> claro4 =grafo.createVertex("claro4");
		Vertex<String> claro5 =grafo.createVertex("claro5");
		Vertex<String> casaAbuelita=grafo.createVertex("Casa Abuelita");
		
		grafo.connect(casaCaperucita,claro2);
		grafo.connect(claro2,casaCaperucita);
		grafo.connect(casaCaperucita,claro1);
		grafo.connect(claro1,casaCaperucita);
		grafo.connect(casaCaperucita,claro3);
		grafo.connect(claro3,casaCaperucita);
		grafo.connect(claro1,claro2);
		grafo.connect(claro2,claro1);
		grafo.connect(claro3,claro5);
		grafo.connect(claro5,claro3);
		grafo.connect(claro1,claro5);
		grafo.connect(claro5,claro1);
		grafo.connect(claro2,claro5);
		grafo.connect(claro5,claro2);
		grafo.connect(claro4,claro2);
		grafo.connect(claro2,claro4);
		grafo.connect(claro5,casaAbuelita);
		grafo.connect(casaAbuelita,claro5);
		grafo.connect(claro4,casaAbuelita);
		grafo.connect(casaAbuelita,claro4);
		
		Recorridos<String> recorridos=new Recorridos<>();
		System.out.println("Recorrido dfs: "+recorridos.dfs(grafo));
		System.out.println("Recorrido bfs: "+recorridos.bfs(grafo));
	}
}
