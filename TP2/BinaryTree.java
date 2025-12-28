package TP2;
import java.util.*;
import TP1.Queue;


public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {
	   int suma=0;
	   if(this.isLeaf())
		   return 1;
	   if(this.hasLeftChild())
		   suma+=this.getLeftChild().contarHojas();
	   if(this.hasRightChild())
		   suma+=this.getRightChild().contarHojas();
		return suma;
	   
	}
		
    public BinaryTree<T> espejo(){
    		BinaryTree<T> arbolEspejado=new BinaryTree<T>(this.getData());
    		
    		if(this.hasLeftChild()) {
    			arbolEspejado.addRightChild(this.getLeftChild());
    			this.getLeftChild().espejo();
    		}
    			
    		if(this.hasRightChild()) {
    			arbolEspejado.addLeftChild(this.getLeftChild());
    			this.getRightChild().espejo();
    		}
    		return arbolEspejado;  				
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		BinaryTree<T> arbol;
		Queue<BinaryTree<T>> cola= new Queue <BinaryTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		int nivel=0;

		while((!cola.isEmpty())&&(nivel<=m)) {
			arbol=cola.dequeue();
			if(arbol!=null) {
				if(nivel>=n)
					System.out.print(arbol.getData()+" ");
				if(arbol.hasLeftChild())
					cola.enqueue(arbol.getLeftChild());
				if(arbol.hasRightChild())
					cola.enqueue(arbol.getRightChild());
			}else
				if(!cola.isEmpty()) {
					cola.enqueue(null);
					nivel++;
					System.out.println();
				}
		}
	}
		
}

