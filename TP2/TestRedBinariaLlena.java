package TP2;

public class TestRedBinariaLlena {
	public static void main (String[] args) {
		//niveles 1 y 2 
		BinaryTree<Integer> arbol=new BinaryTree<>(10);//Raiz
		BinaryTree<Integer> hi=new BinaryTree<>(2);//HI de la raiz
		BinaryTree<Integer> hd= new BinaryTree<>(3);//hd de la raiz
		arbol.addLeftChild(hi);
		arbol.addRightChild(hd);
		
		//nivel 3
		BinaryTree<Integer> hijoi2=new BinaryTree<>(5);
		BinaryTree<Integer> hijod2=new BinaryTree<>(4);
		BinaryTree<Integer> hijoi3=new BinaryTree<>(9);
		BinaryTree<Integer> hijod3=new BinaryTree<>(8);
		
		hi.addLeftChild(hijoi2);
		hi.addRightChild(hijod2);
		hd.addLeftChild(hijoi3);
		hd.addRightChild(hijod3);
		
		//nivel 4
		BinaryTree<Integer> hijoi5=new BinaryTree<>(7);
		BinaryTree<Integer> hijod5=new BinaryTree<>(8);
		BinaryTree<Integer> hijoi4=new BinaryTree<>(5);
		BinaryTree<Integer> hijod4=new BinaryTree<>(6);
		
		hijoi2.addLeftChild(hijoi5);
		hijoi2.addRightChild(hijod5);
		hijod2.addLeftChild(hijoi4);
		hijod2.addRightChild(hijod4);
		
		BinaryTree<Integer> hijoi9=new BinaryTree<>(12);
		BinaryTree<Integer> hijod9=new BinaryTree<>(8);
		BinaryTree<Integer> hijoi8=new BinaryTree<>(2);
		BinaryTree<Integer> hijod8=new BinaryTree<>(1);
		
		hijoi3.addLeftChild(hijoi9);
		hijoi3.addRightChild(hijod9);
		hijod3.addLeftChild(hijoi8);
		hijod3.addRightChild(hijod8);
		
		
		RedBinariaLlena red=new RedBinariaLlena(arbol);
		
		System.out.println(red.retardoReenvio());
		
		ProfundidadDeArbolBinario prof=new ProfundidadDeArbolBinario(arbol);
		
		System.out.println(prof.sumaElementosProfundidad(0));
	}
}
