package TP5V2;
import java.util.*;

import tp5.Edge;
import tp5.Graph;
import tp5.Vertex;
import tp5.adjList.AdjListGraph;

public class Parcial130724 {
	
	private static void buscarRecorrido(Graph<String>grafo,Vertex<String>actual,Vertex<String> destino,List<String>camino,List<String>aux,boolean[]marca,int maxFrutales,int maximo,int cantidadActual) {
		marca[actual.getPosition()]=true;
		aux.add(actual.getData());
		if(actual.getData().equals(destino.getData()) && maximo<=cantidadActual) {
			camino.clear();
			camino.addAll(aux);
		}
		else {
			for(Edge<String> edge: grafo.getEdges(actual)) {
				if(!marca[edge.getTarget().getPosition()] && edge.getWeight()<=maxFrutales)
					buscarRecorrido(grafo,edge.getTarget(),destino,camino,aux,marca,maxFrutales,maximo,cantidadActual+edge.getWeight());
			}
		}
		marca[actual.getPosition()]=false;
		aux.remove(aux.size()-1);
	}
	
	public static List<String> recorridoSeguroMaxFrutales(Graph<String> bosque, String caperucita, String abuelita, int maxFrutales){
		List<String> camino=new ArrayList<>();
		if(bosque!=null && !bosque.isEmpty()) {
			Vertex<String> origen=bosque.search(caperucita);
			Vertex<String> destino=bosque.search(abuelita);
			if(origen !=null && destino!=null) {
				buscarRecorrido(bosque, origen,destino,camino,new ArrayList<String>(),new boolean[bosque.getSize()],maxFrutales,Integer.MIN_VALUE,0);
			}
		}
		return camino;
	}
	
	public static void main (String []args) {
		Graph<String> grafo=new AdjListGraph<>();
		
		Vertex<String> caperucita=grafo.createVertex("Casa de caperucita");
		Vertex<String> claro1=grafo.createVertex("Claro 1");
		Vertex<String> claro2=grafo.createVertex("Claro 2");
		Vertex<String> claro3=grafo.createVertex("Claro 3");
		Vertex<String> claro4=grafo.createVertex("Claro 4");
		Vertex<String> claro5=grafo.createVertex("Claro 5");
		Vertex<String> claro6=grafo.createVertex("Claro 6");
		Vertex<String> abuelita=grafo.createVertex("Casa de la abuelita");
		
		grafo.connect(caperucita,claro1,10);
		grafo.connect(claro1,caperucita,10);
		grafo.connect(caperucita,claro4,8);
		grafo.connect(claro4,caperucita,8);
		grafo.connect(caperucita,claro2,15);
		grafo.connect(claro2,caperucita,15);
		grafo.connect(caperucita,claro3,20);
		grafo.connect(claro3,caperucita,20);
		grafo.connect(claro1,claro3,5);
		grafo.connect(claro3,claro1,5);
		grafo.connect(claro3,claro5,3);
		grafo.connect(claro5,claro3,3);
		grafo.connect(claro2,claro6,30);
		grafo.connect(claro6,claro2,30);
		grafo.connect(claro2,claro4,38);
		grafo.connect(claro4,claro2,38);
		grafo.connect(claro5,claro6,7);
		grafo.connect(claro6,claro5,7);
		grafo.connect(claro5,abuelita,35);
		grafo.connect(abuelita,claro5,35);
		grafo.connect(claro4,claro6,45);
		grafo.connect(claro6,claro4,45);
		grafo.connect(claro6,abuelita,15);
		grafo.connect(abuelita,claro6,15);
		
		System.out.println(recorridoSeguroMaxFrutales(grafo,"Casa de caperucita","Casa de la abuelita",30));
	}
}
