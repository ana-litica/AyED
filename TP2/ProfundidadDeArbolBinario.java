package TP2;
import TP1.Queue;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer>	enteros;
	
	public ProfundidadDeArbolBinario(BinaryTree<Integer> arbol) {
		this.enteros=arbol;
	}
	
	public int sumaElementosProfundidad(int p) {
		boolean seguir=true;
		BinaryTree<Integer> arbol;
		Queue<BinaryTree<Integer>> cola= new Queue<>();
		int nivel=0,suma=0;	
		cola.enqueue(this.enteros);
		cola.enqueue(null);
		
		while((!cola.isEmpty())&& (seguir)) {	
			if(nivel<=p) {	
				arbol=cola.dequeue();
				if(arbol!=null) {
					if(nivel == p){
						suma+=arbol.getData();
					}
					if(arbol.hasLeftChild())
						cola.enqueue(arbol.getLeftChild());
					if(arbol.hasRightChild())
						cola.enqueue(arbol.getRightChild());	
				}
				else {
					if(!cola.isEmpty()) {
						cola.enqueue(null);
						nivel++;
					}
					
				}if(nivel>p)
					seguir=false;
			}
		}			
		return suma;
	}
}
