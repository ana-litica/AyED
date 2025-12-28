package ParcialesViejosGrafos;

import java.util.ArrayList;
import java.util.List;

import TP1.Queue;
import tp5.Edge;
import tp5.Graph;
import tp5.Vertex;
import tp5.adjList.AdjListGraph;

public class Prueba {
	
	private static void aplicar (Graph<Integer>grafo,Vertex<Integer>inicio,boolean[]marca,List<Integer> lista) {
		marca[inicio.getPosition()]=true;
		lista.add(inicio.getData());
		for(Edge<Integer> edge: grafo.getEdges(inicio)) {
			if(!marca[edge.getTarget().getPosition()])
				aplicar(grafo,edge.getTarget(),marca,lista);
		}
		//marca[inicio.getPosition()]=false;
		//lista.remove(lista.size()-1);
	}
	
	public static List<Integer> dfs(Graph<Integer> grafo,Vertex<Integer> inicio){
		List<Integer> resultado=new ArrayList<Integer>();
		aplicar(grafo,inicio,new boolean[grafo.getSize()],resultado);
		return resultado;
	}
	
	public static List<Integer> bfs(Graph<Integer> grafo,Vertex<Integer>inicio){
		List<Integer> lista=new ArrayList<>();
		Queue<Vertex<Integer>> cola= new Queue<>();
		boolean[]marca=new boolean[grafo.getSize()];
		marca[inicio.getPosition()]=true;
		lista.add(inicio.getData());
		cola.enqueue(inicio);
		cola.enqueue(null);
		while(!cola.isEmpty()) {
			Vertex<Integer> vertice=cola.dequeue();
			if(vertice !=null) {
				for(Edge<Integer> edge: grafo.getEdges(vertice)) {
					if(!marca[edge.getTarget().getPosition()]) {
						lista.add(edge.getTarget().getData());
						marca[edge.getTarget().getPosition()]=true;
						cola.enqueue(vertice);
					}
				}
			}
			else
				if(!cola.isEmpty())
					cola.enqueue(null);
		}
		return lista;
	}
	
	public static void main (String []args) {
		Graph<Integer> grafo1=new AdjListGraph<>();
		
		Vertex<Integer> uno=grafo1.createVertex(1);
		Vertex<Integer> dos=grafo1.createVertex(2);
		Vertex<Integer> tres=grafo1.createVertex(3);
		Vertex<Integer> cuatro=grafo1.createVertex(4);
		Vertex<Integer> cinco=grafo1.createVertex(5);
		Vertex<Integer> seis=grafo1.createVertex(6);
		
		grafo1.connect(uno, cuatro);
		grafo1.connect(uno,dos);
		grafo1.connect(cuatro,dos);
		grafo1.connect(dos,cinco);
		grafo1.connect(cinco,cuatro);
		grafo1.connect(tres,cinco);
		grafo1.connect(tres,seis);
		grafo1.connect(seis,seis);
		
		System.out.println(dfs(grafo1,uno));
		System.out.println(bfs(grafo1,uno));
	}
}
