package ParcialesViejosGrafos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import TP1.Queue;
import tp5.Edge;
import tp5.Graph;
import tp5.Vertex;
import tp5.adjList.AdjListGraph;

public class invitacionMasterClass {

	public static List<Usuario> invitacionMasterClass(Graph<String> red,String usuario,int distancia,int limite){
		List<Usuario> resultado=new ArrayList<>();
		if(red!=null && !red.isEmpty()) {
			Vertex<String>user=red.search(usuario);
			if(user!=null) {
				Queue<Vertex<String>> cola=new Queue<>();
				cola.enqueue(user);
				cola.enqueue(null);
				int distanciaAct=1;
				boolean []marca=new boolean[red.getSize()];
				
				while(!cola.isEmpty() && distancia>=distanciaAct && resultado.size()<limite) {
					Vertex<String> vertice=cola.dequeue();
					
					if(vertice!=null) {
						Iterator<Edge<String>> iterador=red.getEdges(vertice).iterator();
						while(iterador.hasNext() && resultado.size()<=limite ) {
							Edge<String> sig=iterador.next();
							if(!marca[sig.getTarget().getPosition()]) {
								resultado.add(new Usuario(sig.getTarget().getData(),distanciaAct));
								marca[sig.getTarget().getPosition()]=true;
								cola.enqueue(vertice);
							}
						}
					}
					else {
						if(!cola.isEmpty()) {
							cola.enqueue(null);
							distanciaAct++;							
						}
					}
				}
			}
		}
		return resultado;
	}
	
	public static void main(String[] args) {
		Graph<String> red=new AdjListGraph<>();
		
		Vertex<String> lionel=red.createVertex("Lionel");
		Vertex<String> rodrigo=red.createVertex("Rodrigo");
		Vertex<String> emiliano=red.createVertex("Emiliano");
		Vertex<String> angel=red.createVertex("Angel");
		Vertex<String> julian=red.createVertex("Julian");
		Vertex<String> lautaro=red.createVertex("Lautaro");
		Vertex<String> diego=red.createVertex("Diego");
		Vertex<String> enzo=red.createVertex("Enzo");

		red.connect(lionel,rodrigo);
		red.connect(lionel,rodrigo);
		red.connect(rodrigo,emiliano);
		red.connect(emiliano,rodrigo);
		red.connect(lautaro,emiliano);
		red.connect(emiliano,lautaro);
		red.connect(emiliano,enzo);
		red.connect(enzo,emiliano);
		red.connect(rodrigo,julian);
		red.connect(julian,rodrigo);
		red.connect(lionel,angel);
		red.connect(angel,lionel);
		red.connect(angel,julian);
		red.connect(julian,angel);
		red.connect(julian,lautaro);
		red.connect(lautaro,julian);
		red.connect(angel,enzo);
		red.connect(enzo,angel);
		red.connect(diego,lautaro);
		red.connect(lautaro,diego);
		red.connect(angel,diego);
		red.connect(diego,angel);
		red.connect(enzo,diego);
		red.connect(diego,enzo);
		
		System.out.println(invitacionMasterClass(red,"Lionel",2,4));
		
	}

}
