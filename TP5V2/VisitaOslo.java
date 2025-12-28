package TP5V2;
import java.util.*;

import tp5.Edge;
import tp5.Graph;
import tp5.Vertex;
import tp5.adjList.AdjListGraph;

public class VisitaOslo {
	
	private static void dfs(Graph<String> grafo,Vertex<String> origen,String destino,List<String>paseo,boolean[]marca,int maxTiempo,List<String> lugaresRestringidos,int tiempoActual,int minimo,List<String>aux) {
		marca[origen.getPosition()]=true;
		if(!lugaresRestringidos.contains(origen.getData())) {
			aux.add(origen.getData());
			if(origen.getData().equals(destino) && tiempoActual<minimo) {
				paseo.clear();
				paseo.addAll(aux);
				tiempoActual=minimo;
			}
			else {
				for(Edge<String>edge: grafo.getEdges(origen)) {
					int tiempo=tiempoActual+edge.getWeight();
					if(!marca[edge.getTarget().getPosition()] && tiempo<maxTiempo)
						dfs(grafo,edge.getTarget(),destino,paseo,marca,maxTiempo,lugaresRestringidos,tiempo,minimo,aux);
				}
			}
			aux.remove(aux.size()-1);
			marca[origen.getPosition()]=false;
		}
	}
	
	public static List<String> paseoEnBici(Graph<String> lugares,String destino,int maxTiempo,List<String> lugaresRestringidos){
		List<String> paseo=new ArrayList<>();
		if(lugares!=null && !lugares.isEmpty()) {
			Vertex<String> ayuntamiento=lugares.search("Ayuntamiento");
			Vertex<String> ultimo=lugares.search(destino);
			if(ayuntamiento!=null & ultimo!=null)
				dfs(lugares,ayuntamiento,destino,paseo,new boolean[lugares.getSize()],maxTiempo,lugaresRestringidos,0,Integer.MAX_VALUE,new ArrayList<String>());
			
		}
		return paseo;
	}
	
	public static void main(String []args) {
Graph<String> lugares=new AdjListGraph<>();
		
		Vertex<String> holmenkollen=lugares.createVertex("Holmenkollen");
		Vertex<String> parqueVigeland=lugares.createVertex("Parque Vigeland");
		Vertex<String> folkMuseum=lugares.createVertex("FolkMuseum");
		Vertex<String> museoFram=lugares.createVertex("Museo Fram");
		Vertex<String> barcoPolar=lugares.createVertex("Museo del Barco Polar");
		Vertex<String> museoVikingo=lugares.createVertex("Museo Vikingo");
		Vertex<String> akkerBrigge=lugares.createVertex("Akker Brigge");
		Vertex<String> palacioReal=lugares.createVertex("Palacio Real");
		Vertex<String> galeriaNacional=lugares.createVertex("Galeria Nacional");
		Vertex<String> parqueBotanico=lugares.createVertex("Parque Botanico");
		Vertex<String> ayuntamiento=lugares.createVertex("Ayuntamiento");
		Vertex<String> museoMunch=lugares.createVertex("Museo Munch");
		Vertex<String> elTigre=lugares.createVertex("El tigre");
		Vertex<String> laOpera=lugares.createVertex("La Opera");
		Vertex<String> fortaleza=lugares.createVertex("Fortaleza Akershus");
		
		 lugares.connect(holmenkollen, parqueVigeland,30);
		 lugares.connect(parqueVigeland,galeriaNacional ,10);
		 lugares.connect(galeriaNacional,parqueVigeland ,10);
		 lugares.connect(parqueVigeland,holmenkollen,30);
		 lugares.connect(parqueVigeland,folkMuseum ,20);
		 lugares.connect(folkMuseum, parqueVigeland,20);
		 lugares.connect(museoFram,folkMuseum,5);
		 lugares.connect(folkMuseum,museoFram ,5);
		 lugares.connect(folkMuseum,palacioReal, 5);
		 lugares.connect(palacioReal,folkMuseum,5 );
		 lugares.connect(folkMuseum,akkerBrigge ,30);
		 lugares.connect(akkerBrigge,folkMuseum ,30);
		 lugares.connect(museoFram,barcoPolar ,5);
		 lugares.connect(barcoPolar, museoFram,5);
		 lugares.connect(barcoPolar,museoVikingo ,5);
		 lugares.connect(museoVikingo,barcoPolar,5);
		 lugares.connect(museoVikingo,akkerBrigge,30);
		 lugares.connect(akkerBrigge,museoVikingo,30);
		 lugares.connect(akkerBrigge,ayuntamiento,20);
		 lugares.connect(ayuntamiento,akkerBrigge,20);
		 lugares.connect(palacioReal,ayuntamiento,5);
		 lugares.connect(ayuntamiento,palacioReal,5);
		 lugares.connect(galeriaNacional,parqueBotanico,15);
		 lugares.connect(parqueBotanico,galeriaNacional,15);
		 lugares.connect(ayuntamiento,parqueBotanico,10);
		 lugares.connect(parqueBotanico,ayuntamiento,10);
		 lugares.connect(parqueBotanico,museoMunch,1);
		 lugares.connect(museoMunch,parqueBotanico,1);
		 lugares.connect(museoMunch,elTigre,15);
		 lugares.connect(elTigre,museoMunch,15);
		 lugares.connect(ayuntamiento,elTigre,15);
		 lugares.connect(elTigre,ayuntamiento,15);
		 lugares.connect(elTigre,laOpera,5);
		 lugares.connect(laOpera,elTigre,5);
		 lugares.connect(laOpera,fortaleza,10);
		 lugares.connect(fortaleza,laOpera,10);
		 
		 List<String> lugaresRestringidos=new LinkedList<>();
		 lugaresRestringidos.add("Akker Brigge");
		 lugaresRestringidos.add("Palacio Real");
		 
		 System.out.println(paseoEnBici(lugares,"Museo Vikingo",120,lugaresRestringidos));
	}
}
