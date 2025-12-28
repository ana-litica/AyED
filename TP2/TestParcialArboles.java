package TP2;

public class TestParcialArboles {
	public static void main (String []args) {
		//nivel 1 y 2
		BinaryTree<Integer> arbol=new BinaryTree<>(2);
		BinaryTree<Integer> hi=new BinaryTree<>(7);
		BinaryTree<Integer> hd=new BinaryTree<>(-5);
		
		arbol.addLeftChild(hi);
		arbol.addRightChild(hd);
		
		//nivel 3
		BinaryTree<Integer> hii=new BinaryTree<>(23);
		BinaryTree<Integer> hid=new BinaryTree<>(6);
		BinaryTree<Integer> hdi=new BinaryTree<>(19);
		
		hi.addLeftChild(hii);
		hi.addLeftChild(hid);
		hd.addLeftChild(hdi);
		
		//nivel 4
		BinaryTree<Integer> hiii=new BinaryTree<>(-3);
		BinaryTree<Integer> hidi=new BinaryTree<>(55);
		BinaryTree<Integer> hidd=new BinaryTree<>(11);
		BinaryTree<Integer> hdid=new BinaryTree<>(4);
		
		hii.addLeftChild(hiii);
		hid.addLeftChild(hidi);
		hid.addRightChild(hidd);
		hdi.addRightChild(hdid);
		
		//nivel 5
		BinaryTree<Integer> hdidi=new BinaryTree<>(18);
		
		hdid.addLeftChild(hdidi);
		
		ParcialArboles parcial=new ParcialArboles(arbol);
		
		System.out.println("Tiene que dar true: "+parcial.isLeftTree(7));
		System.out.println("Tiene que dar false: "+parcial.isLeftTree(2));
		System.out.println("Tiene que dar true: "+parcial.isLeftTree(-5));
		System.out.println("Tiene que dar false: "+parcial.isLeftTree(19));
		System.out.println("Tiene que dar false: "+parcial.isLeftTree(-3));
		
	}
}
