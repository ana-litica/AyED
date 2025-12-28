package P5;

import tp5.Graph;
import tp5.Vertex;
import tp5.adjList.AdjListGraph;

public class Prueba {
	public static void main(String []args) {
		Graph<Integer> grafo1=new AdjListGraph<>();
		
		Vertex<Integer> vertice1=grafo1.createVertex(1);
		Vertex<Integer> vertice2=grafo1.createVertex(2);
		Vertex<Integer> vertice4=grafo1.createVertex(4);
		Vertex<Integer> vertice5=grafo1.createVertex(5);
		Vertex<Integer> vertice3=grafo1.createVertex(3);
		Vertex<Integer> vertice6=grafo1.createVertex(6);
		
		grafo1.connect(vertice1, vertice2);
		grafo1.connect(vertice1, vertice4);
		grafo1.connect(vertice2, vertice5);
		grafo1.connect(vertice4, vertice2);
		grafo1.connect(vertice5, vertice4);
		grafo1.connect(vertice3, vertice5);
		grafo1.connect(vertice3, vertice6);
		grafo1.connect(vertice6, vertice6);
		
		Recorridos<Integer> teoria1= new Recorridos<>();
		System.out.println(teoria1.dfs(grafo1));
		System.out.println(teoria1.bfs(grafo1));
		
		Graph<String> grafo2=new AdjListGraph<>();
		
		Vertex<String> verticeR=grafo2.createVertex("R");
		Vertex<String> verticeM=grafo2.createVertex("M");
		Vertex<String> verticeQ=grafo2.createVertex("Q");
		Vertex<String> verticeN=grafo2.createVertex("N");
		Vertex<String> verticeP=grafo2.createVertex("P");
		Vertex<String> verticeO=grafo2.createVertex("O");
		
		grafo2.connect(verticeQ, verticeM);
		grafo2.connect(verticeM, verticeQ);
		grafo2.connect(verticeQ, verticeN);
		grafo2.connect(verticeN, verticeQ);
		grafo2.connect(verticeQ, verticeP);
		grafo2.connect(verticeP, verticeQ);
		grafo2.connect(verticeM, verticeR);
		grafo2.connect(verticeR, verticeM);
		grafo2.connect(verticeM, verticeN);
		grafo2.connect(verticeN, verticeM);
		grafo2.connect(verticeN, verticeO);
		grafo2.connect(verticeO, verticeN);
		grafo2.connect(verticeO, verticeP);
		grafo2.connect(verticeP, verticeO);
		
		Recorridos<String> teoria2=new Recorridos<>();
		System.out.println(teoria2.bfs(grafo2));
	}
}
