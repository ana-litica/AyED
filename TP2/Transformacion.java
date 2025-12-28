package TP2;

public class Transformacion {
	private BinaryTree<Integer> arbol;
	
	public Transformacion(BinaryTree<Integer> arbol) {
		this.arbol=arbol;
	}
	
	private int suma(BinaryTree<Integer> arbol) {
		if(this.arbol.isLeaf()) {
			int aux=arbol.getData();
			this.arbol.setData(0);
			return aux;
		}else {
			int total=0;
			if(arbol.hasLeftChild())
				total+=suma(arbol.getLeftChild());
			if(arbol.hasRightChild())
				total+=suma(arbol.getRightChild());
			int cant=arbol.getData();
			arbol.setData(total);
			total+=cant;
			return total;
		}
	}
	
	public BinaryTree<Integer>suma(){
		int aux=suma(this.arbol);
		return arbol;
	}


}
