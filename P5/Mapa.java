package P5;
import tp5.Edge;
import tp5.Graph;
import tp5.Vertex;
import tp5.adjList.AdjListGraph;

import java.util.*;

public class Mapa {
	private Graph<String> mapaCiudades;
	
	public Mapa(Graph<String> grafo) {
		this.mapaCiudades=grafo;
	}
	
	//1.
	private boolean dfs(Graph<String> grafo,Vertex<String> ciudad1, String ciudad2,List<String> camino,boolean[]marca) {
		boolean finalizado=false;
		marca[ciudad1.getPosition()]=true;
		camino.add(ciudad1.getData());
		if(ciudad1.getData().equals(ciudad2))
			finalizado= true;
		else {
			Iterator<Edge<String>> iterador=grafo.getEdges(ciudad1).iterator();
			while(!finalizado && iterador.hasNext()) {
				Edge<String> edge=iterador.next();
				int pos=edge.getTarget().getPosition();
				if(!marca[pos])
					finalizado=dfs(grafo,edge.getTarget(),ciudad2,camino,marca);
			}
			if(!finalizado)
				camino.remove(camino.size()-1);
		}
		marca[ciudad1.getPosition()]=false;
		return finalizado;
	}
	
	public List<String> devolverCamino(String ciudad1, String ciudad2) {
		List<String> camino=new LinkedList<>();
		if(this.mapaCiudades!=null && !this.mapaCiudades.isEmpty()) {
			Vertex<String> inicio=this.mapaCiudades.search(ciudad1);
			boolean[] marca=new boolean[this.mapaCiudades.getSize()];//tendria que preguntar si estan las ciudades?
			dfs(this.mapaCiudades,inicio,ciudad2,camino,marca);
		}
		return camino;
	}
	
	//2.
	private void marcarCiudades(boolean[] marca,List<String> ciudades) {
		for(int i=0;i<ciudades.size();i++) {
			Vertex<String> vertice=this.mapaCiudades.search(ciudades.get(i));
			marca[vertice.getPosition()]=true;
		}
	}
	
	private boolean dfsExcepto(Graph<String> grafo,Vertex<String> ciudad1,String ciudad2,boolean[] marca,List<String> camino) {
		boolean encontrado=false;
		marca[ciudad1.getPosition()]=true;
		camino.add(ciudad1.getData());
		if(ciudad1.getData().equals(ciudad2))
			encontrado=true;
		else {
			Iterator<Edge<String>> iterador=grafo.getEdges(ciudad1).iterator();
			while(!encontrado && iterador.hasNext()) {
				Edge<String> edge=iterador.next();
				int pos=edge.getTarget().getPosition();
				if(!marca[pos])
					encontrado=dfsExcepto(grafo,edge.getTarget(),ciudad2,marca,camino);
			}
			if(!encontrado)
				camino.remove(camino.size()-1);
		}		marca[ciudad1.getPosition()]=false;
		return encontrado;
	}
	
	public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades){
		List<String> camino=new LinkedList<>();
		if(this.mapaCiudades!=null && !this.mapaCiudades.isEmpty()) {	
			Vertex<String> inicio=this.mapaCiudades.search(ciudad1);
			Vertex<String> fin=this.mapaCiudades.search(ciudad2);
			if(inicio!=null &&fin!=null) {
				boolean [] marca=new boolean [this.mapaCiudades.getSize()];
				marcarCiudades(marca,ciudades);
				dfsExcepto(this.mapaCiudades,inicio,ciudad2,marca,camino);
			}
		}
		return camino;
	}
	
	//3.
	private double dfsMasCorto(Graph<String> grafo, Vertex<String> ciudad1,String ciudad2,boolean[]marca,List<String>camino,List<String>aux,double minimo,double distanciaRecorrida) {	
		marca[ciudad1.getPosition()]=true;
		aux.add(ciudad1.getData());
		if(ciudad1.getData().equals(ciudad2) && (distanciaRecorrida<minimo)) {
			camino.clear();
			camino.addAll(aux);
			distanciaRecorrida=minimo;
		}
		else {
			for(Edge<String> edge: grafo.getEdges(ciudad1)) {
				int sig=edge.getTarget().getPosition();
				if(!marca[sig]) {
					double distancia=distanciaRecorrida+edge.getWeight();
					if(distancia<minimo)
						minimo=dfsMasCorto(grafo,edge.getTarget(),ciudad2,marca,camino,aux,minimo,distancia);
				}
			}	
		}
		aux.remove(aux.size()-1);
		marca[ciudad1.getPosition()]=false;
		return minimo;
	}
	
	public List<String> caminoMasCorto(String ciudad1, String ciudad2){
		List<String> camino =new LinkedList<>();
		if(this.mapaCiudades!=null && !this.mapaCiudades.isEmpty()) {
			Vertex<String> inicio=this.mapaCiudades.search(ciudad1);
			Vertex<String> fin=this.mapaCiudades.search(ciudad2);
			if(inicio!=null && fin!=null) {
				boolean [] marca= new boolean[this.mapaCiudades.getSize()];
				dfsMasCorto(this.mapaCiudades,inicio,ciudad2,marca,camino,new LinkedList<String>(),Integer.MAX_VALUE,0);
			}
		}
		return camino;
	}
	
	//4.
	private boolean dfsSinCargar(Graph<String> grafo,Vertex<String> ciudad1,String ciudad2,int tanqueAuto,List<String> camino,boolean[]marca,int tanqueActual) {
		boolean encontrado=false;
		marca[ciudad1.getPosition()]=true;
		camino.add(ciudad1.getData());
		if(ciudad1.getData().equals(ciudad2))
			encontrado=true;
		else {
			Iterator<Edge<String>> iterador=grafo.getEdges(ciudad1).iterator();
			while(!encontrado && iterador.hasNext()) {
				Edge<String> sig=iterador.next();
				int sigPos=sig.getTarget().getPosition();
				int tanque=tanqueActual+sig.getWeight();
				if(!marca[sigPos] && (tanque<tanqueAuto))
					dfsSinCargar(grafo,sig.getTarget(),ciudad2,tanqueAuto,camino,marca,tanque);
			}
			if(!encontrado)
				camino.remove(camino.size()-1);
		}
		marca[ciudad1.getPosition()]=false;
		return encontrado;
	}
	
	public List<String> caminoSinCargarCombustible(String ciudad1,String ciudad2,int tanqueAuto){
		List<String> camino=new LinkedList<String>();
		if(this.mapaCiudades!=null && !this.mapaCiudades.isEmpty()) {
			this.mapaCiudades.search(ciudad1);
			Vertex<String> inicio=this.mapaCiudades.search(ciudad1);
			Vertex<String> fin=this.mapaCiudades.search(ciudad2);
			if(inicio!=null && fin!=null) {
				boolean [] marca=new boolean[this.mapaCiudades.getSize()];
				dfsSinCargar(this.mapaCiudades,inicio,ciudad2,tanqueAuto,camino,marca,0);
			}
		}
		return camino;
	}
	
	//5.
	private void menorCarga(Vertex<String> ciudad1, String ciudad2, int tanqueAuto,int tanqueActual,int cantCargas,int cargasActuales,boolean[]marca,List<String>camino,List<String>aux) {
		marca[ciudad1.getPosition()]=true;
		aux.add(ciudad1.getData());
		if(ciudad1.getData().equals(ciudad2))
			if(cargasActuales<cantCargas) {
				camino.clear();
				camino.addAll(aux);
				cargasActuales=cantCargas;
			}
		else {
			for(Edge<String> edge:this.mapaCiudades.getEdges(ciudad1)) {
				int posSig=edge.getTarget().getPosition();
				if(!marca[posSig]) {
					if(tanqueAuto<tanqueActual-edge.getWeight()) {
						tanqueActual=tanqueAuto;
						cantCargas++;
					}
					menorCarga(edge.getTarget(),ciudad2,tanqueAuto,tanqueActual-edge.getWeight(),cantCargas,cargasActuales,marca,camino,aux);
				}
			}
		}
		aux.remove(aux.size()-1);
		marca[ciudad1.getPosition()]=false;
	}
	
	public List<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		List<String> resultado=new LinkedList<String>();
		if(this.mapaCiudades!=null && !this.mapaCiudades.isEmpty()) {
			Vertex<String> inicio=this.mapaCiudades.search(ciudad1);
			Vertex<String> fin=this.mapaCiudades.search(ciudad2);
			if(inicio!=null && fin!=null) {
				menorCarga(inicio,ciudad2,tanqueAuto,tanqueAuto,0,0,new boolean[this.mapaCiudades.getSize()],resultado,new LinkedList<String>());
			}
		}
		return resultado;
	}
	
	
	public static void main (String [] args) {
		Graph<String> grafo = new AdjListGraph <>();
		grafo.createVertex( "Buenos Aires" ); // 0
		grafo.createVertex( "Santiago" ); // 1
		grafo.createVertex( "Asunción" ); // 2
		grafo.createVertex( "Roma"); // 3
		grafo.createVertex( "Madrid"); // 4
		grafo.createVertex( "Caracas"); // 5
		grafo.createVertex( "París"); // 6
		grafo.createVertex( "Tokio"); // 7
		grafo.connect(grafo.getVertex( 0), grafo.getVertex( 1),3);
		grafo.connect(grafo.getVertex( 0), grafo.getVertex( 2),6);
		grafo.connect(grafo.getVertex( 1), grafo.getVertex( 3),4);
		grafo.connect(grafo.getVertex( 2), grafo.getVertex( 4),10);
		grafo.connect(grafo.getVertex( 2), grafo.getVertex( 5),2);
		grafo.connect(grafo.getVertex( 3), grafo.getVertex( 7),80);
		grafo.connect(grafo.getVertex( 4), grafo.getVertex( 7),60);
		grafo.connect(grafo.getVertex( 5), grafo.getVertex( 4),2);
		grafo.connect(grafo.getVertex( 5), grafo.getVertex( 7),20);
		grafo.connect(grafo.getVertex( 6), grafo.getVertex( 3),4);
		grafo.connect(grafo.getVertex( 6), grafo.getVertex( 4),65);
		grafo.connect(grafo.getVertex( 6), grafo.getVertex( 7),35);
		grafo.connect(grafo.getVertex( 7), grafo.getVertex( 0), 10);
		
		Mapa mapa=new Mapa(grafo);
		
		//1.
		System.out.println(mapa.devolverCamino("Buenos Aires", "Tokio"));
		
		//2.
		List<String> ciudadesProhibidas=new LinkedList<>();
		ciudadesProhibidas.add("Roma");
		System.out.println(mapa.devolverCaminoExceptuando("Buenos Aires", "Tokio", ciudadesProhibidas));
		
		//3.
		System.out.println(mapa.caminoMasCorto("Buenos Aires", "Tokio"));
		
		//4.
		System.out.println(mapa.caminoSinCargarCombustible("Buenos Aires", "Tokio", 30));//Preguntar
		
		//5.
		System.out.println(mapa.caminoConMenorCargaDeCombustible("Bueno Aires", "Tokio", 50));
	}
}
