package ParcialesViejosGrafos;
import java.util.*;
import tp5.Graph;
import tp5.Vertex;
import tp5.adjList.AdjListGraph;
import TP1.Queue;
import tp5.Edge;


public class Parcial0624 {
	
	public static Nivel nivelPopularidad(Graph<String> red,String usuario, int distancia, int umbral){
		if(red !=null && !red.isEmpty()) {
			Vertex<String> user=red.search(usuario);
			if(user!=null) {
				Queue<Vertex<String>> cola=new Queue<>();
				boolean []marca=new boolean[red.getSize()];
				int distanciaActual=1;
				int popularidad=0;
				cola.enqueue(user);
				cola.enqueue(null);
				marca[user.getPosition()]=true;
				
				while(!cola.isEmpty() && distanciaActual<=distancia) {
					Vertex<String> vertice=cola.dequeue();				
					if(vertice!=null) {
						Iterator<Edge<String>> iterador=red.getEdges(vertice).iterator();
						while(iterador.hasNext() && distanciaActual<=distancia) {
							Edge<String> siguiente=iterador.next();
							if(!marca[siguiente.getTarget().getPosition()]) {
								marca[siguiente.getTarget().getPosition()]=true;
								cola.enqueue(siguiente.getTarget());
								if(distanciaActual==distancia)
									popularidad++;
							}
						}
					}
					else
						if(!cola.isEmpty()) {
							cola.enqueue(null);
							distanciaActual++;
						}
				}
				Nivel nivel=new Nivel(popularidad);
				if(popularidad>=umbral)
					nivel.setPopularidad(true);
				else
					nivel.setPopularidad(false);
				return nivel;
			}
		}
		return null;
	}
	
	public static void main (String [] args) {
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
		red.connect(rodrigo,lionel);
		red.connect(rodrigo,emiliano);
		red.connect(emiliano,rodrigo);
		red.connect(lautaro,emiliano);
		red.connect(emiliano,lautaro);
		red.connect(emiliano,enzo);
		red.connect(enzo,emiliano);
		red.connect(lautaro,julian);
		red.connect(julian,lautaro);
		red.connect(rodrigo,julian);
		red.connect(julian,rodrigo);
		red.connect(lionel,angel);
		red.connect(angel,lionel);
		red.connect(angel,julian);
		red.connect(julian,angel);
		red.connect(diego,angel);
		red.connect(angel,diego);
		red.connect(diego,lautaro);
		red.connect(lautaro,diego);
		red.connect(diego,enzo);
		red.connect(enzo,diego);
		
		System.out.println(nivelPopularidad(red,"Lionel",2,3));
	}
}
