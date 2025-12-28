package P5;
import java.util.*;

import tp5.Edge;
import tp5.Graph;
import tp5.Vertex;
import TP1.Queue;
import tp5.adjList.*;

public class Ejercicio5 {
	
	private static int buscarEmpleado(Graph<Persona> grafo,Persona empleado) {
		Vertex<Persona> encontrado=grafo.search(empleado);
		if(encontrado!=null)
			return encontrado.getPosition();
		return -1;
	}
	
	private static void marcarEmpleados(Graph<Persona> grafo, boolean[] marca) {
		for(int i=0;i<grafo.getSize();i++)
			if(!grafo.getVertex(i).getData().isJubilado())
				marca[i]=true;
	}
	
	private static void bfs(int pos,Graph<Persona> grafo, boolean[]marca,List<Persona> resultado,int distancia) {
		Queue<Vertex<Persona>> cola=new Queue<>();
		cola.enqueue(grafo.getVertex(pos));
		cola.enqueue(null);
		marca[pos]=true;
		int longLista=0;
		while(!cola.isEmpty() && distancia>0 && resultado.size()<=40) {
			Vertex<Persona> vertice=cola.dequeue();
			if(vertice!=null) {
				Iterator<Edge<Persona>> iterador= grafo.getEdges(vertice).iterator();
				while(longLista<=40 && iterador.hasNext()) {
					Edge<Persona> jubiladoProximo=iterador.next();	
					int posJubilado=jubiladoProximo.getTarget().getPosition();
					if(	!marca[posJubilado]) {
						marca[posJubilado]=true;
						cola.enqueue(jubiladoProximo.getTarget());
						resultado.add(jubiladoProximo.getTarget().getData());	
					}
				}			
			}
			else
				if(!cola.isEmpty()) {
					cola.enqueue(null);
					distancia--;
				}
		}
	}
	
	public static List<Persona> jubiladosCerca(Graph<Persona> grafo,Persona empleado,int distancia){
		List<Persona> jubilados=new LinkedList<>();
		if(grafo!=null && !grafo.isEmpty()) {
			int posEmpleado=buscarEmpleado(grafo,empleado);
			if(posEmpleado!=-1) {
				boolean[] marca=new boolean[grafo.getSize()];
				marcarEmpleados(grafo,marca);
				for(int i=0;i<grafo.getSize();i++) {
					if(!marca[i])
						bfs(posEmpleado,grafo,marca,jubilados,distancia);
				}
			}				
		}
		return jubilados;
	}
	
	public static void main (String [] args) {
		Graph<Persona> grafo=new AdjListGraph<Persona>();
		Persona empleada=new Persona("Graciela","111",false);
		
		grafo.createVertex(empleada);//0
		grafo.createVertex(new Persona("Roberto","222",true));//1
		grafo.createVertex(new Persona("Ana","333",true));//2
		grafo.createVertex(new Persona("Pabla","444",true));//3
		grafo.createVertex(new Persona("Lila","555",true));//4
		grafo.createVertex(new Persona("Julian","666",false));//5
		grafo.createVertex(new Persona("Maria","777",true));//6
		grafo.createVertex(new Persona("Juan","888",false));//7
		grafo.createVertex(new Persona("Carlos","999",false));//8
		
		grafo.connect(grafo.getVertex(0), grafo.getVertex(1));
		grafo.connect(grafo.getVertex(1), grafo.getVertex(0));
		grafo.connect(grafo.getVertex(1), grafo.getVertex(2));
		grafo.connect(grafo.getVertex(2), grafo.getVertex(1));
		
		grafo.connect(grafo.getVertex(0), grafo.getVertex(8));
		grafo.connect(grafo.getVertex(8), grafo.getVertex(0));
		grafo.connect(grafo.getVertex(8), grafo.getVertex(7));
		grafo.connect(grafo.getVertex(7), grafo.getVertex(8));

		grafo.connect(grafo.getVertex(0), grafo.getVertex(3));
		grafo.connect(grafo.getVertex(3), grafo.getVertex(1));
		grafo.connect(grafo.getVertex(5), grafo.getVertex(0));
		grafo.connect(grafo.getVertex(0), grafo.getVertex(5));
		grafo.connect(grafo.getVertex(3), grafo.getVertex(4));
		grafo.connect(grafo.getVertex(4), grafo.getVertex(3));
		grafo.connect(grafo.getVertex(4), grafo.getVertex(6));
		grafo.connect(grafo.getVertex(6), grafo.getVertex(4));
		
		System.out.println(jubiladosCerca(grafo,empleada,2));
		}
	
}
