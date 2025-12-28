package ParcialesViejosGrafos;

import java.util.LinkedList;
import java.util.List;
import tp5.Graph;
import tp5.Vertex;
import tp5.adjList.AdjListGraph;
import tp5.Edge;

public class Flotante0724 {
	
	private static void dfs(Graph<String> bosque, Vertex<String> caperucita,String abuelita,int maxFrutales,List<String>resultado,List<String>aux,boolean[]marca,int frutasTotales,int frutasAct) {
		marca[caperucita.getPosition()]=true;
		aux.add(caperucita.getData());
		if(caperucita.getData().equals(abuelita)) {
				resultado.clear();
				resultado.addAll(aux);
		}
		else {
			for(Edge<String> edge:bosque.getEdges(caperucita)) {
				int sigPos=edge.getTarget().getPosition();
				if(!marca[sigPos] && frutasAct+edge.getWeight()<maxFrutales)
					dfs(bosque,edge.getTarget(),abuelita,maxFrutales,resultado,aux,marca,frutasTotales,frutasAct);
			}
		}
		aux.remove(aux.size()-1);
		marca[caperucita.getPosition()]=false;
	}

	public static List<String> recorridoSeguroMaxFrutales(Graph<String> bosque, String caperucita,String abuelita,int maxFrutales){
		List<String> caminoSeguro=new LinkedList<>();
		if(bosque!=null && !bosque.isEmpty()) {
			Vertex<String> casaCaperucita=bosque.search(caperucita);
			Vertex<String> casaAbuelita=bosque.search(abuelita);
			if(casaCaperucita!=null && casaAbuelita!=null) {
				dfs(bosque,casaCaperucita,abuelita,maxFrutales,caminoSeguro,new LinkedList<String>(),new boolean[bosque.getSize()],0,0);
			}
		}
		return caminoSeguro;
	}
	
	public static void main(String[]args) {
		Graph<String> bosque=new AdjListGraph<>();
		
		Vertex<String> caperucita=bosque.createVertex("Casa de caperucita");
		Vertex<String> abuelita=bosque.createVertex("Casa de la abuelita");
		Vertex<String> uno=bosque.createVertex("Claro 1");
		Vertex<String> dos=bosque.createVertex("Claro 2");
		Vertex<String> tres=bosque.createVertex("Claro 3");
		Vertex<String> cuatro=bosque.createVertex("Claro 4");
		Vertex<String> cinco=bosque.createVertex("Claro 5");
		Vertex<String> seis=bosque.createVertex("Claro 6");
		
		bosque.connect(caperucita,uno,10);
		bosque.connect(uno,caperucita,10);
		bosque.connect(caperucita,tres,20);
		bosque.connect(tres,caperucita,20);
		bosque.connect(caperucita,dos,15);
		bosque.connect(dos,caperucita,15);
		bosque.connect(caperucita,cuatro,8);
		bosque.connect(cuatro,caperucita,8);
		bosque.connect(uno,tres,5);
		bosque.connect(tres,uno,5);
		bosque.connect(tres,cinco,3);
		bosque.connect(cinco,tres,3);
		bosque.connect(dos,cuatro,38);
		bosque.connect(cuatro,dos,38);
		bosque.connect(dos,seis,30);
		bosque.connect(seis,dos,30);
		bosque.connect(cinco,seis,7);
		bosque.connect(seis,cinco,7);
		bosque.connect(cuatro,seis,45);
		bosque.connect(seis,cuatro,45);
		bosque.connect(cinco,abuelita,35);
		bosque.connect(abuelita,cinco,35);
		bosque.connect(seis,abuelita,15);
		bosque.connect(abuelita,seis,15);
		
		System.out.println(recorridoSeguroMaxFrutales(bosque,"Casa de caperucita","Casa de la abuelita",30));
	}
}
