package TP5V2;

import tp5.Graph;
import tp5.Edge;
import tp5.Vertex;
import tp5.adjList.AdjListGraph;

import java.util.*;

public class Mapa {
	private Graph<String> mapaCiudades;
	
	public Mapa(Graph<String>grafo) {
		this.mapaCiudades=grafo;
	}
	
	private boolean devolverCamino(Vertex<String> ciudad1,Vertex<String> ciudad2,boolean[]marca,List<String> lista) {
		boolean finalizar=false;
		marca[ciudad1.getPosition()]=true;
		lista.add(ciudad1.getData());
		if(ciudad1.getData().equals(ciudad2.getData())) {
			finalizar=true;
		}else {
			Iterator<Edge<String>> iterador=mapaCiudades.getEdges(ciudad1).iterator();
			while(!finalizar && iterador.hasNext()) {
				Edge<String> sig=iterador.next();
				if(!marca[sig.getTarget().getPosition()])
					finalizar=devolverCamino(sig.getTarget(),ciudad2,marca,lista);
			}
			if(!finalizar)
				lista.remove(lista.size()-1);
		}
		marca[ciudad1.getPosition()]=false;
		return finalizar;
	}
	
	public List<String> devolverCamino(String ciudad1, String ciudad2){
		List<String> resultado=new ArrayList<>();
		if(this.mapaCiudades!=null && !this.mapaCiudades.isEmpty()) {
			Vertex<String> origen=mapaCiudades.search(ciudad1);
			Vertex<String> destino=mapaCiudades.search(ciudad2);
			if(origen!=null && destino!=null)
				devolverCamino(origen,destino,new boolean[mapaCiudades.getSize()],resultado);
			
		}
		return resultado;
	}
	
	private boolean devolverCaminosExceptuando(Vertex<String> ciudad1,Vertex<String> ciudad2, List<String> ciudades, boolean[]marca,List<String> resultado) {
		boolean encontrado=false;
		marca[ciudad1.getPosition()]=true;
		if(ciudades.contains(ciudad1.getData())) { 
			resultado.add(ciudad1.getData());
			if(ciudad1.getData().equals(ciudad2.getData()))
				encontrado=true;
			else {
				Iterator<Edge<String>> iterador=mapaCiudades.getEdges(ciudad1).iterator();
				while(!encontrado && iterador.hasNext()) {
					Edge<String> edge=iterador.next();
					if(!marca[edge.getTarget().getPosition()] && !ciudades.contains(ciudad1.getData()))
						encontrado=devolverCaminosExceptuando(edge.getTarget(),ciudad2,ciudades,marca,resultado);
					}
				if(!encontrado)
					resultado.remove(resultado.size()-1);
				}
				marca[ciudad1.getPosition()]=false;
		}
		return encontrado;
	}
	
	public List<String> devolverCaminoExceptuando(String ciudad1,String ciudad2,List<String> ciudades){
		List<String> resultado=new ArrayList<>();
		if(this.mapaCiudades!=null && !this.mapaCiudades.isEmpty()) {
			Vertex<String> origen=mapaCiudades.search(ciudad1);
			Vertex<String> destino=mapaCiudades.search(ciudad2);
			if(origen!=null && destino!=null) {
				devolverCaminosExceptuando(origen,destino,ciudades,new boolean [mapaCiudades.getSize()],resultado);
			}
		}
		return resultado;
	}
	/*
	private void marcarCiudades(List<String> ciudades,boolean[] marcas) {
		for(int i=0;i<this.mapaCiudades.getSize();i++) {
			if(ciudades.contains(this.mapaCiudades.getVertex(i).getData()))
				marcas[i]=true;
		}
	}
	
	private boolean devolverCaminoExceptuando(Vertex<String> ciudad1,Vertex<String> ciudad2,boolean[]marca,List<String>lista) {
		boolean encontrado=false;
		marca[ciudad1.getPosition()]=true;
		lista.add(ciudad1.getData());
		if(ciudad1.getData().equals(ciudad2.getData()))
			encontrado=true;
		else {
			Iterator<Edge<String>> iterador=mapaCiudades.getEdges(ciudad1).iterator();
			while(!encontrado && iterador.hasNext()) {
				Edge<String> edge=iterador.next();
				if(!marca[edge.getTarget().getPosition()])
					encontrado=devolverCaminoExceptuando(edge.getTarget(),ciudad2,marca,lista);
			}
			if(!encontrado)
				lista.remove(lista.size()-1);
		}
		marca[ciudad1.getPosition()]=false;
		return encontrado;
	}
	
	public List<String> devolverCaminoExceptuando(String ciudad1,String ciudad2,List<String> ciudades){
		List<String> resultado=new ArrayList<>();
		if(this.mapaCiudades!=null && !this.mapaCiudades.isEmpty()) {
			boolean []marcas=new boolean[mapaCiudades.getSize()];
			Vertex<String> origen=mapaCiudades.search(ciudad1);
			Vertex<String> destino=mapaCiudades.search(ciudad2);	
			if(origen!=null && destino!=null) {
				marcarCiudades(ciudades,marcas);
				if(!marcas[origen.getPosition()])
				devolverCaminoExceptuando(origen,destino,marcas,resultado);	
			}
		}
		return resultado;
	}*/
	
	private void caminoMasCorto(Vertex<String> ciudad1,Vertex<String> ciudad2,boolean[]marca,List<String>caminoMinimo,List<String>aux, int minimo, int recorrido) {
		marca[ciudad1.getPosition()]=true;
		aux.add(ciudad1.getData());
		if(ciudad1.getData().equals(ciudad2.getData()) && recorrido<minimo){
			minimo=recorrido;
			caminoMinimo.clear();
			caminoMinimo.addAll(aux);
		}
		else {
			for(Edge<String> edge: mapaCiudades.getEdges(ciudad1)) {
				int distancia= recorrido+edge.getWeight();
				if(!marca[edge.getTarget().getPosition()] && distancia<minimo)
					caminoMasCorto(edge.getTarget(),ciudad2,marca,caminoMinimo,aux,minimo,distancia);
			}
		}
		aux.remove(aux.size()-1);
		marca[ciudad1.getPosition()]=false;
	}
	
	public List<String> caminoMasCorto(String ciudad1,String ciudad2) {
		List<String> resultado=new ArrayList<>();
		if(this.mapaCiudades!=null && !this.mapaCiudades.isEmpty()) {
			Vertex<String> origen=mapaCiudades.search(ciudad1);
			Vertex<String> destino=mapaCiudades.search(ciudad2);	
			if(origen!=null && destino!=null) {
				caminoMasCorto(origen,destino,new boolean[mapaCiudades.getSize()],resultado,new ArrayList<String>(),Integer.MAX_VALUE,0);
			}
		}
		return resultado;
	}
	
	private boolean caminoSinCargarCombustible(Vertex<String> ciudad1,Vertex<String> ciudad2,int tanqueAuto,List<String> camino,boolean[]marca,int consumido) {
		boolean listo=false;
		marca[ciudad1.getPosition()]=true;
		camino.add(ciudad1.getData());
		if(ciudad1.getData().equals(ciudad2.getData()))
			listo=true;
		else {
			Iterator<Edge<String>> iterador=mapaCiudades.getEdges(ciudad1).iterator();
			while(!listo && iterador.hasNext()) {
				Edge<String> edge=iterador.next();
				int tanqueActual=consumido+edge.getWeight();
				if(!marca[edge.getTarget().getPosition()] && tanqueActual<tanqueAuto) {
					listo=caminoSinCargarCombustible(edge.getTarget(),ciudad2,tanqueAuto,camino,marca,tanqueActual);
				}
			}
			if(!listo)
				camino.remove(camino.size()-1);
		}
		marca[ciudad1.getPosition()]=false;
		return listo;
	}
	
	public List<String> caminoSinCargarCombustible(String ciudad1,String ciudad2,int tanqueAuto){
		List<String> resultado=new ArrayList<>();
		if(this.mapaCiudades!=null && !this.mapaCiudades.isEmpty()) {
			Vertex<String> origen=mapaCiudades.search(ciudad1);
			Vertex<String> destino=mapaCiudades.search(ciudad2);
			if(origen!=null && destino!=null) {
				caminoSinCargarCombustible(origen,destino,tanqueAuto,resultado,new boolean[mapaCiudades.getSize()],0);
			}
		}
		return resultado;
	}
	
	private void caminoConMenorCargaDeCombustible(Vertex<String> ciudad1,Vertex<String> ciudad2,List<String> camino,boolean[]marca,int tanqueAuto,int combustibleActual,int veces,int minimo,List<String>aux){
		marca[ciudad1.getPosition()]=true;
		aux.add(ciudad1.getData());
		if(ciudad1.getData().equals(ciudad2.getData()) ) {
			if(veces<minimo) {
				camino.clear();
				camino.addAll(aux);
				minimo=veces;				
			}
		}
		else {
			for(Edge<String> edge:this.mapaCiudades.getEdges(ciudad1)) {
				if(!marca[edge.getTarget().getPosition()]) {
					if(combustibleActual-edge.getWeight()<0) {
						combustibleActual=tanqueAuto;
						veces++;
					}
					caminoConMenorCargaDeCombustible(edge.getTarget(),ciudad2,camino,marca,tanqueAuto,tanqueAuto-edge.getWeight(),veces,minimo,aux);				
				}
			}
		}
		aux.remove(aux.size()-1);
		marca[ciudad1.getPosition()]=false;
	}
	
	public List<String> caminoConMenorCargaDeCombustible(String ciudad1,String ciudad2,int tanqueAuto){
		List<String> camino=new ArrayList<>();
		if(this.mapaCiudades!=null && !this.mapaCiudades.isEmpty()) {
			Vertex<String> origen=mapaCiudades.search(ciudad1);
			Vertex<String> destino=mapaCiudades.search(ciudad2);
			if(origen!=null && destino !=null)
				caminoConMenorCargaDeCombustible(origen,destino,camino,new boolean[mapaCiudades.getSize()],tanqueAuto,tanqueAuto,0,Integer.MAX_VALUE,new ArrayList<String>());
		}
		return camino;
	}
	
	public static void main(String[]args) {
		Graph<String> grafo=new AdjListGraph<>();
		
		Vertex<String> casaCaperucita =grafo.createVertex("Casa caperucita");
		Vertex<String> claro1 =grafo.createVertex("claro1");
		Vertex<String> claro2 =grafo.createVertex("claro2");
		Vertex<String> claro3 =grafo.createVertex("claro3");
		Vertex<String> claro4 =grafo.createVertex("claro4");
		Vertex<String> claro5 =grafo.createVertex("claro5");
		Vertex<String> casaAbuelita=grafo.createVertex("Casa Abuelita");
		
		grafo.connect(casaCaperucita,claro2,4);
		grafo.connect(claro2,casaCaperucita,4);
		grafo.connect(casaCaperucita,claro1,3);
		grafo.connect(claro1,casaCaperucita,3);
		grafo.connect(casaCaperucita,claro3,4);
		grafo.connect(claro3,casaCaperucita,4);
		grafo.connect(claro1,claro2,4);
		grafo.connect(claro2,claro1,4);
		grafo.connect(claro3,claro5,15);
		grafo.connect(claro5,claro3,15);
		grafo.connect(claro1,claro5,3);
		grafo.connect(claro5,claro1,3);
		grafo.connect(claro2,claro5,11);
		grafo.connect(claro5,claro2,11);
		grafo.connect(claro4,claro2,10);
		grafo.connect(claro2,claro4,10);
		grafo.connect(claro5,casaAbuelita,4);
		grafo.connect(casaAbuelita,claro5,4);
		grafo.connect(claro4,casaAbuelita,9);
		grafo.connect(casaAbuelita,claro4,9);
		
		Mapa mapa=new Mapa(grafo);
		System.out.println("Devolver camino: "+mapa.devolverCamino("claro1", "Casa Abuelita"));
		
		List<String> prohibidas=new ArrayList<>();
		prohibidas.add("Casa caperucita");
		prohibidas.add("claro2");
		System.out.println("Devolver camino exceptuando: "+mapa.devolverCaminoExceptuando("claro1", "Casa Abuelita", prohibidas));
	
		System.out.println("Camino mas corto: "+mapa.caminoMasCorto("claro1", "Casa Abuelita"));
		
		System.out.println("Camino sin cargar combustible: "+mapa.caminoSinCargarCombustible("claro1", "Casa Abuelita",20));
		
		System.out.println("Camino con menor carga de combustible: "+mapa.caminoConMenorCargaDeCombustible("claro1", "Casa Abuelita",20));
	}
}
