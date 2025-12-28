	package P5;
import TP1.Queue;
import tp5.Edge;
import tp5.Graph;
import tp5.Vertex;
import java.util.*;

public class Recorridos<T> {
	
	private void dfs(int i, Graph<T> grafo, boolean[]marca,List<T> resultado) {
		marca[i]=true;
		Vertex<T> v=grafo.getVertex(i);
		resultado.add(v.getData());
		for(Edge<T> edge: grafo.getEdges(v)) {
			int j=edge.getTarget().getPosition();
			if(!marca[j])
				dfs(j,grafo,marca,resultado);
		}
	}

	public List<T> dfs(Graph<T> grafo){
		List<T> lista=new LinkedList<T>();
		if (grafo!=null) {
			boolean [] marca=new boolean[grafo.getSize()];
			for(int i=0; i<grafo.getSize();i++) {
				if(!marca[i])
					dfs(i,grafo,marca,lista);
			}
		}
		return lista;
	}
	
	private void bfs(int i, Graph<T> grafo,boolean[]marca,List<T> resultado) {
		Queue<Vertex<T>> cola=new Queue<Vertex<T>>();
		cola.enqueue(grafo.getVertex(i));
		marca[i]=true;
		while(!cola.isEmpty()) {
			Vertex<T> vertice=cola.dequeue();
			resultado.add(vertice.getData());
			for(Edge<T> edge:grafo.getEdges(vertice)) {
				int j=edge.getTarget().getPosition();
				if(!marca[j]) {
					marca[j]=true;
					cola.enqueue(edge.getTarget());
				}
			}
		}
	}
	
	public List<T> bfs(Graph<T> grafo) {
		List<T> lista=new LinkedList<T>();
		if(grafo!=null) {
			boolean[] marca= new boolean[grafo.getSize()];
			for(int i=0; i<grafo.getSize();i++) 
				if(!marca[i])
					bfs(i,grafo,marca,lista);	
		}
		return lista;
	}
}
