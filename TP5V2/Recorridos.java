package TP5V2;
import tp5.Graph;
import tp5.Edge;
import tp5.Vertex;
import tp5.adjList.AdjListGraph;
import TP1.Queue;

import java.util.*;

public class Recorridos<T> {
	
	private void dfs(Graph<T> grafo, int i, boolean[] marca, List<T> lista) {
		marca[i]=true;
		Vertex<T> vertice= grafo.getVertex(i);
		lista.add(vertice.getData());
		for(Edge edge: grafo.getEdges(vertice)) {
			int pos=edge.getTarget().getPosition();
			if(!marca[pos])
				dfs(grafo,pos,marca,lista);
		}
	}
	
	public List<T> dfs(Graph<T> grafo){
		List<T> lista=new ArrayList<>();
		if(grafo!=null && !grafo.isEmpty()) {
			boolean[] marca=new boolean[grafo.getSize()];
			for(int i=0; i<grafo.getSize();i++) {
				if(!marca[i])
					dfs(grafo,i,marca,lista);
			}
		}
		return lista;
	}
	
	private void bfs(Graph<T> grafo, int indice, List<T> lista, boolean[]marca) {
		Queue<Vertex<T>> cola=new Queue<>();
		cola.enqueue(grafo.getVertex(indice));
		cola.enqueue(null);
		marca[indice]=true;
		while(!cola.isEmpty()) {
			Vertex<T> vertice=cola.dequeue();
			if(vertice!=null) {
				lista.add(vertice.getData());
				for(Edge edge: grafo.getEdges(vertice)) {
					int pos=edge.getTarget().getPosition();
					if(!marca[pos]) {
						marca[pos]=true;
						cola.enqueue(edge.getTarget());
					}
				}
			}
			else if(cola.isEmpty()) 
				cola.enqueue(null);
		}
	}
	
	public List<T> bfs(Graph<T> grafo){
		List<T> lista=new ArrayList<>();
		if(grafo!=null && !grafo.isEmpty()) {
			boolean []marca=new boolean[grafo.getSize()];
			for(int i=0;i<grafo.getSize();i++) {
				if(!marca[i])
					bfs(grafo,i,lista,marca);
			}
		}
		return lista;
	}
}
