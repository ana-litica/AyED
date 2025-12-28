package P5;

import tp5.Edge;
import tp5.Graph;
import tp5.Vertex;

import java.util.*;

public class BuscadorDeCaminos {
	private Graph<String> bosque;
	
	public BuscadorDeCaminos(Graph<String> grafo) {
		this.bosque=grafo;
	}
	
	private void buscarRecorridos(Graph<String> grafo,Vertex<String>inicio,boolean[]marca,List<List<String>>caminos,List<String> aux) {
		marca[inicio.getPosition()]=true;
		aux.add(inicio.getData());
		
		if(inicio.getData().equals("Casa Abuelita")) {
			caminos.add(new ArrayList<String>(aux));
			System.out.println(aux);
		}
		else {
			for(Edge<String> edge: grafo.getEdges(inicio)) {
				int sigPos=edge.getTarget().getPosition();
				
				if(edge.getWeight()<=5 && !marca[sigPos])
					buscarRecorridos(grafo,edge.getTarget(),marca,caminos,aux);
			}
		}
		//aux.remove(inicio.getData());
		aux.remove(aux.size()-1);
		marca[inicio.getPosition()]=false;
	}
	
	public List<List<String>> recorridosMasSeguros(){
		List<List<String>> caminos=new ArrayList<>();
		
		if(this.bosque!=null && !this.bosque.isEmpty()) {
			Vertex<String>casaCaperucita=this.bosque.search("Casa Caperucita");
			Vertex<String>casaAbuela=this.bosque.search("Casa Abuelita");
		
			if(casaCaperucita!=null && casaAbuela!=null) {
				boolean[]marca=new boolean[this.bosque.getSize()];
				buscarRecorridos(this.bosque,casaCaperucita,marca,caminos,new ArrayList<String>());
			}
		}
		return caminos;
	}
	
}
