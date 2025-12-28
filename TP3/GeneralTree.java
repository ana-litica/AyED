package TP3;

import TP1.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	private int calcularAltura(GeneralTree<T> arbol,int suma, int maximo) {
		if(arbol.isLeaf()) {
			if(suma>maximo) 
				maximo=suma;
			suma=0;
			return maximo;
		}
		int resultado=0;
		if(arbol.hasChildren()) {
			List<GeneralTree<T>>hijos =arbol.getChildren();
			for(GeneralTree<T> children: hijos)
				resultado=calcularAltura(children,suma+1,maximo);
		}return resultado;		
	}
	
	public int altura() {	 
		if(this!=null && this.isEmpty())
			return -1;
		return calcularAltura(this,0,0);
	}
	
	public int nivel(T dato){
		GeneralTree<T> arbolAux;
		Queue<GeneralTree<T>> cola=new Queue<>();
		
		cola.enqueue(this);
		cola.enqueue(null);
		int nivel=0;
		
		while(!cola.isEmpty()) {
			arbolAux=cola.dequeue();
			if(arbolAux!=null) {
				if(arbolAux.getData().equals(dato))
					return nivel;
				if(arbolAux.hasChildren()) {
					List<GeneralTree<T>> children=arbolAux.getChildren();
					for(GeneralTree<T> hijo: children)
						cola.enqueue(hijo); 
				}
			}
			else
				if(!cola.isEmpty()) {
					nivel++;
					cola.enqueue(null);
				}				
		}	
		return -1;
	}


	public int ancho(){
		if(this != null && !this.isEmpty()) {
			GeneralTree<T> arbolAux;
			Queue<GeneralTree<T>> cola=new Queue <>();
			cola.enqueue(this);
			cola.enqueue(null);
			int cantNodos=0,max=-1;
			
			while(!cola.isEmpty()) {
				arbolAux=cola.dequeue();
				if(arbolAux!=null) {
					if(arbolAux.hasChildren()) {
						List<GeneralTree<T>> children= arbolAux.getChildren();
						for(GeneralTree<T> child: children) {
							cola.enqueue(child);
							cantNodos++;
						}
					}
				}
				else
					if(!cola.isEmpty()) {
						cola.enqueue(null);
						max=Math.max(cantNodos, max);
						cantNodos=0;
					}
			}
			
			return max;
		}else
			return -1;
		
	}
	
	
	public void recorridoPorNiveles() {
		Queue<GeneralTree<T>> c=new Queue<GeneralTree<T>>();
		if(!this.isEmpty()) {
			c.enqueue(this);
			c.enqueue(null);
			while(!c.isEmpty()) {
				GeneralTree<T> e=c.dequeue();
				if(e!=null) {
					System.out.print(e.getData()+" ");
					List<GeneralTree<T>> hijos =e.getChildren();
					for(GeneralTree<T> h:hijos)
						c.enqueue(h);
				}else
					if(!c.isEmpty()) {
						c.enqueue(null);
						System.out.println();//cambio de nivel	
					}
			}
		}
		System.out.println("\n");
	}
	
	private GeneralTree<T> buscarDato(GeneralTree<T> arbol,T dato){
		GeneralTree<T> aux=new GeneralTree<T> ();
		if(arbol.getData().equals(dato)) {
			aux=arbol;
		}
		if(arbol.hasChildren()) {
			List<GeneralTree<T>> hijos=arbol.getChildren();
			Iterator<GeneralTree<T>> iterador=hijos.iterator();
			while(aux==null && iterador.hasNext()) {
				aux=buscarDato(iterador.next(),dato);
			}
		}
		return aux;
		
	}
	
	public boolean esAncestro(T a, T b){
		if(this != null && !this.isEmpty()){
			GeneralTree<T> aux= buscarDato(this,a);
			if(aux!=null) {
				aux=buscarDato(this,b);
				if(aux!=null)
					return true;
			}
		}
		return false;
	}
	
}