package ParcialesViejos;
import TP2.BinaryTree;

public class EspejoAcumulado {
	
	private static BinaryTree<Integer> espejoAcumulado(BinaryTree<Integer> arbol,int suma){
		BinaryTree<Integer> arbolAux=new BinaryTree<Integer>(suma);
		if(arbol.hasLeftChild())
			arbolAux.addRightChild(espejoAcumulado(arbol.getLeftChild(),suma+arbol.getLeftChild().getData()));
		if(arbol.hasRightChild())
			arbolAux.addLeftChild(espejoAcumulado(arbol.getRightChild(),suma+arbol.getRightChild().getData()));
		return arbolAux;	
	}
	
	public static BinaryTree<Integer> espejadoAcumulado(BinaryTree<Integer> arbol){
		if(arbol!=null && !arbol.isEmpty())
			return espejoAcumulado(arbol,arbol.getData());
		return	null;
	}
	
	public static void main (String[] args) {
		//nivel 0 y 1
		BinaryTree<Integer> arbol = new BinaryTree<>(4);
		BinaryTree<Integer> niv1n1 = new BinaryTree<>(2);
		BinaryTree<Integer> niv1n2 = new BinaryTree<>(7);
		
		arbol.addLeftChild(niv1n1);
		arbol.addRightChild(niv1n2);
		
		//nivel 2
		BinaryTree<Integer> niv2n1 = new BinaryTree<>(3);
		BinaryTree<Integer> niv2n2 = new BinaryTree<>(6);
		
		niv1n1.addRightChild(niv2n1);
		niv1n2.addLeftChild(niv2n2);
		
		//nivel 3
		BinaryTree<Integer> niv3n1 = new BinaryTree<>(-5);
		BinaryTree<Integer> niv3n2 = new BinaryTree<>(1);
		
		niv2n1.addLeftChild(niv3n1);
		niv2n1.addRightChild(niv3n2);
		
		espejadoAcumulado(arbol).entreNiveles(0, 10);
	}
}
