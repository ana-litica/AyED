package TP2;

public class TestEsPrefijo {
	public static void main (String [] args) {
		//arbol1 nivel 1 y 2
		BinaryTree<Integer> arbol1=new BinaryTree<>(65);
		BinaryTree<Integer> hi =new BinaryTree<>(300);
		BinaryTree<Integer> hd=new BinaryTree<>(81);
		
		arbol1.addLeftChild(hi);
		arbol1.addRightChild(hd);
		
		//arbol1 nivel 3
		BinaryTree<Integer> hid =new BinaryTree<>(47);
		BinaryTree<Integer> hdd=new BinaryTree<>(93);
		
		hi.addRightChild(hid);
		hd.addRightChild(hdd);
		
		//arbol 2 nivel 1 y 2
		BinaryTree<Integer> arbol2=new BinaryTree<>(65);
		BinaryTree<Integer> hi2 =new BinaryTree<>(300);
		BinaryTree<Integer> hd2=new BinaryTree<>(81);
		
		arbol2.addLeftChild(hi2);
		arbol2.addRightChild(hd2);
		
		//nivel 3
		BinaryTree<Integer> hii2=new BinaryTree<>(22);
		BinaryTree<Integer> hid2 =new BinaryTree<>(47);
		BinaryTree<Integer> hdi2=new BinaryTree<>(76);
		BinaryTree<Integer> hdd2 =new BinaryTree<>(93);
		
		hi2.addLeftChild(hii2);
		hi2.addRightChild(hid2);
		hd2.addLeftChild(hdi2);
		hd2.addRightChild(hdd2);
		
		arbol1.entreNiveles(0, 4);
		System.out.println("\n");
		
		arbol2.entreNiveles(0, 4);
		ParcialArboles parcial=new ParcialArboles(arbol1);
		BinaryTree<Integer> arbol3=new BinaryTree<Integer>(65);
		
		System.out.println(parcial.esPrefijo(arbol3, arbol2));
	}
}
