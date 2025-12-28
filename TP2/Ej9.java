package TP2;

public class Ej9 {

	private static BinaryTree<Operaciones> crearArbol(BinaryTree<Integer> arbol, int suma,int datoPadre){
		Operaciones op=new Operaciones(suma+arbol.getData(),arbol.getData()-datoPadre);
		BinaryTree<Operaciones> nodo=new BinaryTree<>(op);
		if(arbol.hasLeftChild())
			nodo.addLeftChild(crearArbol(arbol.getLeftChild(),suma+arbol.getData(),arbol.getData()));
		if(arbol.hasRightChild())
			nodo.addRightChild(crearArbol(arbol.getRightChild(),suma+arbol.getData(),arbol.getData()));
		return nodo;
	}
	
	public static BinaryTree<Operaciones> sumAndDif(BinaryTree<Integer> arbol){
		if(arbol!=null)
			return crearArbol(arbol,0,0);
		else
			return null;
	}
	
	public static void main (String [] args) {
		//nivel 1 y 2
		BinaryTree<Integer> arbol =new BinaryTree<>(20);
		BinaryTree<Integer> hi=new BinaryTree<>(5);
		BinaryTree<Integer> hd=new BinaryTree<>(30);
		
		arbol.addLeftChild(hi);
		arbol.addRightChild(hd);
		
		//nivel 3
		BinaryTree<Integer> hii=new BinaryTree<>(-5);
		BinaryTree<Integer> hid=new BinaryTree<>(10);
		BinaryTree<Integer> hdi=new BinaryTree<>(50);
		BinaryTree<Integer> hdd=new BinaryTree<>(-9);
		hi.addLeftChild(hii);
		hi.addRightChild(hid);
		hd.addLeftChild(hdi);
		hd.addRightChild(hdd);
		
		//nivel 4
		BinaryTree<Integer>hidi =new BinaryTree<>(1);
		BinaryTree<Integer> hdid=new BinaryTree<>(4);
		hid.addLeftChild(hidi);
		hdi.addRightChild(hdid);
		
		
		//nivel 5
		BinaryTree<Integer>hdidd =new BinaryTree<>(6);
		hdid.addRightChild(hdidd);
		
		BinaryTree<Operaciones> aux= sumAndDif(arbol);
		
		arbol.entreNiveles(0, 4);
		System.out.println("\n");
		aux.entreNiveles(0, 5);

		/*System.out.println(aux.getLeftChild().getData().toString());
		System.out.println(aux.getRightChild().getData().toString());*/
		System.out.println();
		
	}
}
