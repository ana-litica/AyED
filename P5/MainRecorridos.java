package P5;
import tp5.Graph;
import tp5.Vertex;
import tp5.adjList.*;

public class MainRecorridos {
	public static void main (String []args) {
		Graph<Integer> grafo=new AdjListGraph<>();
		
//		Vertex<Integer> vertice1=grafo.createVertex(1);
//		Vertex<Integer> vertice2=grafo.createVertex(4);
//		Vertex<Integer> vertice3=grafo.createVertex(6);
//		Vertex<Integer> vertice4=grafo.createVertex(7);
//		Vertex<Integer> vertice5=grafo.createVertex(3);
//		Vertex<Integer> vertice6=grafo.createVertex(5);
//		Vertex<Integer> vertice7=grafo.createVertex(2);
//		
//		grafo.connect(vertice1, vertice2);
//		grafo.connect(vertice1, vertice5);
//		grafo.connect(vertice1, vertice7);
//		grafo.connect(vertice2, vertice7);
//		grafo.connect(vertice2, vertice6);
//		grafo.connect(vertice2, vertice3);
//		grafo.connect(vertice2, vertice5);
//		grafo.connect(vertice3, vertice4);
//		grafo.connect(vertice3, vertice5);
//		grafo.connect(vertice5, vertice6);
//		grafo.connect(vertice6, vertice4);
//		grafo.connect(vertice7, vertice5);
		
		grafo.createVertex(1);//0
		grafo.createVertex(4);//1
		grafo.createVertex(6);//2
		grafo.createVertex(7);//3
		grafo.createVertex(3);//4
		grafo.createVertex(5);//5
		grafo.createVertex(2);//6
	
		grafo.connect(grafo.getVertex(0), grafo.getVertex(1));
		grafo.connect(grafo.getVertex(0), grafo.getVertex(6));
		grafo.connect(grafo.getVertex(0), grafo.getVertex(4));
		grafo.connect(grafo.getVertex(1), grafo.getVertex(6));
		grafo.connect(grafo.getVertex(1), grafo.getVertex(5));
		grafo.connect(grafo.getVertex(1), grafo.getVertex(2));
		grafo.connect(grafo.getVertex(1), grafo.getVertex(4));
		grafo.connect(grafo.getVertex(6), grafo.getVertex(5));
		grafo.connect(grafo.getVertex(4), grafo.getVertex(5));
		grafo.connect(grafo.getVertex(5), grafo.getVertex(3));
		grafo.connect(grafo.getVertex(2), grafo.getVertex(4));
		grafo.connect(grafo.getVertex(2), grafo.getVertex(3));
		
		Recorridos<Integer> rec=new Recorridos<Integer>();
		System.out.println(rec.dfs(grafo));
		System.out.println(rec.bfs(grafo));
	}
}
