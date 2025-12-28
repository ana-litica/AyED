package ParcialesViejos;
import TP2.BinaryTree;

public class PT1F22024 {
	private BinaryTree<Integer> arbol;
	
	public PT1F22024 (BinaryTree<Integer> arbol) {
		this.arbol=arbol;
	}
	
	private BinaryTree<Integer> nuevoTree(BinaryTree<Integer>arbol,int dato) {
		BinaryTree<Integer> arbolAux=new BinaryTree<Integer>(dato);
		if(arbol.hasLeftChild()) 
			arbolAux.addLeftChild(nuevoTree(arbol.getLeftChild(),arbol.getData()+arbol.getLeftChild().getData()));
		if(arbol.hasRightChild())
			arbolAux.addRightChild(nuevoTree(arbol.getRightChild(),arbol.getRightChild().getData()));
		return arbolAux;
	}
	
	public BinaryTree<Integer> nuevoTree(){
		if(arbol!=null && !arbol.isEmpty())
			return nuevoTree(arbol,arbol.getData());
		return null;
	}
	
	public static void main (String [] args) {
		BinaryTree<Integer> raiz=new BinaryTree<>(1);
		BinaryTree<Integer> hi=new BinaryTree<>(2);
		BinaryTree<Integer> hd=new BinaryTree<>(3);
		
		raiz.addLeftChild(hi);
		raiz.addRightChild(hd);
		
		BinaryTree<Integer> hii=new BinaryTree<>(4);
		BinaryTree<Integer> hdi=new BinaryTree<>(5);
		BinaryTree<Integer> hdd=new BinaryTree<>(6);
		
		hi.addLeftChild(hii);
		hd.addLeftChild(hdi);
		hd.addRightChild(hdd);
		
		BinaryTree<Integer> hdid=new BinaryTree<>(7);
		hdi.addLeftChild(hdid);
		
		PT1F22024 parcial= new PT1F22024(raiz);
		
		parcial.nuevoTree().entreNiveles(0, 10);
	}
}
