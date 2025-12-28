package P5;
import java.util.*;

import tp5.Edge;
import tp5.Graph;
import tp5.Vertex;
import tp5.adjList.AdjListGraph;

public class VisitaOslo {
	
	private static void marcarRestringidos(boolean[]marca,Graph<String> lugares,List<String> restringidos) {
		for(int i=0;i<restringidos.size();i++) {
			Vertex<String>vertice=lugares.search(restringidos.get(i));
			marca[vertice.getPosition()]=true;
		}			
	}
	
	private static boolean dfs(Graph<String> grafo,String destino,int maxTiempo,int tiempoTranscurrido,boolean[]marca,Vertex<String>lugarActual,List<String>paseo) {
		boolean finalizado=false;
		//Si no es lugar restringido
		marca[lugarActual.getPosition()]=true;
		paseo.add(lugarActual.getData());
		if(lugarActual.getData().equals(destino))
			finalizado=true;
		else {
			Iterator<Edge<String>>iterador=grafo.getEdges(lugarActual).iterator();
			while(!finalizado && iterador.hasNext()) {
				Edge<String> edge=iterador.next();
				int sig=edge.getTarget().getPosition();
				if(!marca[sig] && (tiempoTranscurrido+edge.getWeight())<maxTiempo) {
					finalizado=dfs(grafo,destino,maxTiempo,tiempoTranscurrido+edge.getWeight(),marca,edge.getTarget(),paseo);
				}	
			}
			if(!finalizado)
				paseo.remove(paseo.size()-1);
		}
		marca[lugarActual.getPosition()]=false;
		
		return finalizado;
	}
	
	public static List<String> paseoEnBici(Graph<String>lugares,String destino,int maxTiempo,List<String>lugaresRestringidos){
		Vertex<String> ayuntamiento=lugares.search("Ayuntamiento");
		boolean[]marca=new boolean[lugares.getSize()];		
		List<String> paseo=new LinkedList<>();
		marcarRestringidos(marca,lugares,lugaresRestringidos);
		if(ayuntamiento!=null) {
			dfs(lugares,destino,maxTiempo,0,marca,ayuntamiento,paseo);
		}
		return paseo;
	}
	
	public static void main(String[] args) {
		Graph<String> lugares=new AdjListGraph<>();
		
		Vertex<String> holmenkollen=lugares.createVertex("Holmenkollen");
		Vertex<String> parqueVigeland=lugares.createVertex("Parque Vigeland");
		Vertex<String> folkMuseum=lugares.createVertex("FolkMuseum");
		Vertex<String> museoFram=lugares.createVertex("Mueso Fram");
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
