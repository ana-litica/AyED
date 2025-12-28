package TP3;
import java.util.*;
import TP1.Queue;

public class RecorridosAG {
	
	private void numerosImparesMayoresQuePreOrden(GeneralTree <Integer> arbol,List<Integer> lista,Integer numero) {
		if(arbol.getData()>numero && arbol.getData()%2!=0) 
			lista.add(arbol.getData());
		if(arbol.hasChildren())
			for(GeneralTree<Integer> hijos: arbol.getChildren())
				numerosImparesMayoresQuePreOrden(hijos,lista,numero);
	}

	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a,Integer n){
		List<Integer> lista=new LinkedList<>();
		if(a!=null && !a.isEmpty())
			numerosImparesMayoresQuePreOrden(a,lista,n);
		return lista;
	}
	
	private void numerosImparesMayoresQueInOrden(GeneralTree <Integer> arbol,Integer numero,List<Integer> lista) {	
		
		if(arbol.hasChildren()) 
			numerosImparesMayoresQueInOrden(arbol.getChildren().get(0),numero,lista);			
		if(arbol.getData()>numero && arbol.getData()%2!=0)
			lista.add(arbol.getData());
		if(arbol.getChildren().size()>1)
			for(int i=1;i<arbol.getChildren().size();i++)
				numerosImparesMayoresQueInOrden(arbol.getChildren().get(i),numero,lista);			
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a,Integer n){
		List<Integer> lista=new LinkedList<>();
		if(a!=null && !a.isEmpty())
			numerosImparesMayoresQueInOrden(a,n,lista);
		return lista;
	}
	
	private void numerosImparesMayoresQuePostOrden(GeneralTree <Integer> arbol,List<Integer> lista,Integer numero) {
		if(arbol.hasChildren()) {
			for(GeneralTree<Integer> hijos: arbol.getChildren()) {
				numerosImparesMayoresQuePostOrden(hijos,lista,numero);
			}
		}
		if(arbol.getData()% 2!=0 && arbol.getData()>numero)
			lista.add(arbol.getData());
	}
	
	public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a,Integer n){
		List<Integer> lista=new LinkedList<>();
		if(a!=null && !a.isEmpty())
			numerosImparesMayoresQuePostOrden(a,lista,n);
		return lista;
	}
	
	private void numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> arbol,Integer numero,List<Integer> lista) {
		GeneralTree<Integer> arbolAux;
		Queue<GeneralTree<Integer>> cola=new Queue<>();
		
		cola.enqueue(arbol);
		
		while(!cola.isEmpty()) {
			arbolAux=cola.dequeue();
			if(arbolAux.getData()%2!=0 && arbolAux.getData()>numero)
				lista.add(arbolAux.getData());
			for(GeneralTree<Integer> child:arbolAux.getChildren() )
				cola.enqueue(child);
			}
	}

	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a,Integer n){
		List<Integer> lista=new ArrayList<>();
		if(a!=null && !a.isEmpty())
			numerosImparesMayoresQuePorNiveles(a,n,lista);
		return lista;
	}
}
