package TP2;
import TP1.Queue;

public class RedBinariaLlena {
	private BinaryTree<Integer> red;	
	
	public RedBinariaLlena(BinaryTree<Integer> arbol) {
		this.red=arbol;
	}
	
	private int retardoReenvio(BinaryTree<Integer> arbol,int suma) {
		int HI=0, HD=0;
		if(arbol.isLeaf())
			return suma+arbol.getData();
		else {
			if(arbol.hasLeftChild())
				HI=retardoReenvio(arbol.getLeftChild(),suma+arbol.getData());
			if(arbol.hasRightChild())
				HD=retardoReenvio(arbol.getRightChild(),suma+arbol.getData());
		}return Math.max(HI,HD);
	}
	
	public int retardoReenvio() {
		if(this.red.isEmpty())
			return -1;
		else
			return this.retardoReenvio(this.red,0);
	}
}
