package TP5V2;
import java.util.*;

import tp5.Edge;
import tp5.Graph;
import tp5.Vertex;
import tp5.adjList.AdjListGraph;

public class Parcial181123 {
	
	private static void buscador(Graph<String> grafo, String origen, Vertex<String>inicio,List<String> camino,List<String>aux,boolean[]marca) {
		marca[inicio.getPosition()]=true;		
		aux.add(inicio.getData());
		if(inicio.getData().equals(origen) && aux.size()>camino.size()) {
			camino.clear();
			camino.add(origen);
			camino.addAll(aux);
		}
		else {			
			for(Edge<String> edge:grafo.getEdges(inicio)){
				if(!marca[edge.getTarget().getPosition()])
					buscador(grafo,origen,edge.getTarget(),camino,aux,marca);
			}
		}
		aux.remove(aux.size()-1);
		marca[inicio.getPosition()]=false;
	}
	
	public static List<String> resolver(Graph<String> ciudades, String origen){
		List<String> caminoMasLargo=new ArrayList<>();
		if(ciudades!=null && !ciudades.isEmpty()) {
			Vertex<String> inicio=ciudades.search(origen);
			if(inicio!=null) {
				for(Edge<String> edge: ciudades.getEdges(inicio)) {
					buscador(ciudades,origen,edge.getTarget(),caminoMasLargo,new ArrayList<>(),new boolean[ciudades.getSize()]);
				}
			}
		}
		return caminoMasLargo;
	}
	
	public static void main (String[]args) {
		Graph<String> ciudades=new AdjListGraph<>();
		
		Vertex<String> paris=ciudades.createVertex("Paris");
		Vertex<String> barcelona=ciudades.createVertex("Barcelona");
		Vertex<String> valencia=ciudades.createVertex("Valencia");
		Vertex<String> bruselas=ciudades.createVertex("Bruselas");
		Vertex<String> montpellier=ciudades.createVertex("Montpellier");
		Vertex<String> amsterdam=ciudades.createVertex("Amsterdam");
		Vertex<String> milan=ciudades.createVertex("Milan");
		Vertex<String> bologna=ciudades.createVertex("Bologna");
		
		ciudades.connect(paris,barcelona);
		ciudades.connect(barcelona,paris);
		ciudades.connect(barcelona,valencia);
		ciudades.connect(barcelona,valencia);
		ciudades.connect(paris,valencia);
		ciudades.connect(valencia,paris);
		ciudades.connect(paris,bruselas);
		ciudades.connect(bruselas,paris);
		ciudades.connect(paris,amsterdam);
		ciudades.connect(amsterdam,paris);
		ciudades.connect(bruselas,amsterdam);
		ciudades.connect(amsterdam,bruselas);
		ciudades.connect(valencia,montpellier);
		ciudades.connect(montpellier,valencia);
		ciudades.connect(montpellier,milan);
		ciudades.connect(milan,montpellier);
		ciudades.connect(amsterdam,milan);
		ciudades.connect(milan,amsterdam);
		ciudades.connect(milan,bologna);
		ciudades.connect(bologna,milan);
		
		System.out.println(resolver(ciudades,"Paris"));
	}
}
