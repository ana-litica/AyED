package P5;

import TP1.Queue;
import tp5.Edge;
import tp5.Graph;
import tp5.Vertex;
import tp5.adjList.AdjListGraph;

public class Sinapsis {

	public static int neuronasActivadas(Graph<String> grafo,String inicio,int impulso) {
		if(grafo!=null && !grafo.isEmpty()) {
			int neuronas=1;
			Vertex<String> comienzo=grafo.search(inicio);
			boolean[] marca=new boolean[grafo.getSize()];
			Queue <Vertex<String>> cola=new Queue<>();
			marca[comienzo.getPosition()]=true;
			cola.enqueue(comienzo);
			cola.enqueue(null);
			impulso-=impulso*0.1;
			while(!cola.isEmpty() && impulso>0) {
				Vertex<String> vertice=cola.dequeue();
				if(vertice!=null) {
					for(Edge<String> edge:grafo.getEdges(vertice)) {
						int targetPos=edge.getTarget().getPosition();
						if(edge.getWeight()>impulso && !marca[targetPos]) {
							System.out.println(impulso);
							marca[targetPos]=true;
							neuronas++;
							cola.enqueue(edge.getTarget());
							System.out.println(edge.getTarget().getData());
						}
					}
				}
				else {
					if(!cola.isEmpty()) {
						impulso-=impulso*0.1;
						cola.enqueue(null);
					}
				}
			}
			return neuronas;
		}	
		return 0;
	}
	
	public static void main(String[]args) {
		Graph<String> grafo=new AdjListGraph<>();
		
		Vertex<String> N1=grafo.createVertex("N1");
		Vertex<String> N2=grafo.createVertex("N2");
		Vertex<String> N3=grafo.createVertex("N3");
		Vertex<String> N4=grafo.createVertex("N4");
		Vertex<String> N5=grafo.createVertex("N5");
		Vertex<String> N6=grafo.createVertex("N6");
		Vertex<String> N7=grafo.createVertex("N7");
		Vertex<String> N8=grafo.createVertex("N8");
		Vertex<String> N9=grafo.createVertex("N9");
		
		grafo.connect(N1, N2,200 );
		grafo.connect(N1, N3,80 );
		grafo.connect(N1, N7, 100);
		grafo.connect(N3, N2, 20);
		grafo.connect(N3, N4, 1000);
		grafo.connect(N3, N5, 5);
		grafo.connect(N3, N6, 100);
		grafo.connect(N7, N8,90 );
		grafo.connect(N8, N9,70 );
		grafo.connect(N7, N9, 10);
		
		System.out.println(neuronasActivadas(grafo,"N1",100));
		
//		Graph<String> grafoVacio=new AdjListGraph<>();
//		System.out.println(neuronasActivadas(grafoVacio,"N2",100));
		
		
	}
}
