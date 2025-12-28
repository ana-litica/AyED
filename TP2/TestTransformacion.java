package TP2;

public class TestTransformacion {
	public static void main (String[] args) {
		//niveles 1 y 2
		BinaryTree<Integer> arbol=new BinaryTree<>(1);
		BinaryTree<Integer> hi=new BinaryTree<>(2);
		BinaryTree<Integer> hd=new BinaryTree<>(3);
		
		arbol.addLeftChild(hi);
		arbol.addRightChild(hd);
		
		//nivel 3
		BinaryTree<Integer> hid=new BinaryTree<>(4);
		BinaryTree<Integer> hdi=new BinaryTree<>(5);
		BinaryTree<Integer> hdd=new BinaryTree<>(6);
		
		hi.addRightChild(hid);
		hd.addLeftChild(hdi);
		hd.addRightChild(hdd);
		
		//nivel 4
		BinaryTree<Integer> hdii=new BinaryTree<>(7);
		BinaryTree<Integer> hdid=new BinaryTree<>(8);
		
		hdi.addLeftChild(hdii);
		hdi.addRightChild(hdid);
		
		Transformacion transformacion=new Transformacion(arbol);
		transformacion.suma();
		System.out.println(arbol.toString());
	}
}
