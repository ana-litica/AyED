package TP2;

public class Prueba {
	public static void traverse(BinaryTree<Character> a) {
		if(!a.isEmpty()) {
			System.out.print(a.getData()+" ");
			if(a.hasLeftChild())
				traverse(a.getLeftChild());
			if(a.hasRightChild())
				traverse(a.getRightChild());
			System.out.print(a.getData()+" ");
		}
	}

	public static void main (String []args) {
		BinaryTree<Character>raiz =new BinaryTree<>('c');
		BinaryTree<Character> hi=new BinaryTree<>('a');
		BinaryTree<Character> hd=new BinaryTree<>('e');
		raiz.addLeftChild(hi);
		raiz.addRightChild(hd);
		
		BinaryTree<Character> hid=new BinaryTree<>('b');
		BinaryTree<Character> hdi=new BinaryTree<>('d');
		BinaryTree<Character> hdd=new BinaryTree<>('f');
		hi.addRightChild(hid);
		hd.addLeftChild(hdi);
		hd.addRightChild(hdd);
		
		traverse(raiz);
	}
}
