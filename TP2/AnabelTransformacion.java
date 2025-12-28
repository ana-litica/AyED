package TP2;

public class AnabelTransformacion {
		BinaryTree<Integer> arbol;
		
		public AnabelTransformacion(BinaryTree<Integer> arbol) {
			this.arbol = arbol;
		}
		
		private int recorridoSuma(BinaryTree<Integer> arbol) {
			if (arbol.isLeaf()) {
				int aux = arbol.getData();
				arbol.setData(0);
				return aux;
			}
			else {
				int total = 0;
				if (arbol.hasLeftChild())
					total+= recorridoSuma(arbol.getLeftChild());			
				if (arbol.hasRightChild()) 
					total = recorridoSuma(arbol.getRightChild());
				int cant = arbol.getData();
				arbol.setData(total);
				return total + cant;
			}
				
		}
		
		public BinaryTree<Integer>suma(){
			int aux= recorridoSuma(arbol);
			return arbol;
		}

		
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

