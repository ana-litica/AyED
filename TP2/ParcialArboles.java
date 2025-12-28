 package TP2;

public class ParcialArboles {
	private BinaryTree<Integer>arbol;
	
	public ParcialArboles(BinaryTree<Integer> arbol) {
		this.arbol=arbol;
	}
	
	private BinaryTree<Integer> buscar(BinaryTree<Integer> arbol,int num) {		
			if(arbol.getData()==num) {
				return arbol;
				
			}//else{
				BinaryTree<Integer>aux=new BinaryTree<>();

				if((arbol.hasLeftChild()))
					aux=buscar(arbol.getLeftChild(),num);
				if(aux.isEmpty() && arbol.hasRightChild())
					aux=buscar(arbol.getRightChild(),num);
			return aux;
			//}
	}
	
	private boolean contar(BinaryTree<Integer>arbol, int hi,int hd) {
		if(arbol.hasLeftChild() && !arbol.hasRightChild())
			contar(arbol.getLeftChild(),hi+1,hd);
		if(arbol.hasRightChild() && !arbol.hasLeftChild())
			contar(arbol.getRightChild(),hi,hd+1);
		return hi>hd;

	}
	
	
	public boolean isLeftTree(int num) {
		if(this.arbol==null)
			return false;
		else {
			BinaryTree<Integer> arbolNuevo=buscar(this.arbol,num);
			int HI=0,HD=0;
			if(!arbolNuevo.hasLeftChild())
				HI=-1;
			if(!arbolNuevo.hasRightChild())
				HD=-1;
			return contar(arbolNuevo,HI,HD);
		}
	}
	

	
	private boolean esPrefijoPrivado(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		if((arbol1.hasLeftChild() && !arbol2.hasLeftChild())||(arbol1.hasRightChild() && !arbol2.hasRightChild()))
			return false;
		if(!arbol1.getData().equals(arbol2.getData())) 
			return false;
		else {
			boolean verificar=true;
			if(arbol1.getData().equals(arbol2.getData())) {			
				if(arbol1.hasLeftChild()&& arbol2.hasLeftChild())
					verificar= esPrefijo(arbol1.getLeftChild(),arbol2.getLeftChild());
				if((verificar)&&(arbol1.hasRightChild() && arbol2.hasRightChild()))
					verificar= esPrefijo(arbol1.getRightChild(),arbol2.getRightChild());		
			}return verificar;
		}
	}
	
	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		if(arbol1==null && arbol2==null)
			return true;
		if(arbol1==null && arbol2!=null)
			return false;
		return esPrefijoPrivado(arbol1,arbol2);
	}

}
