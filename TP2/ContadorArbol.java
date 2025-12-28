package TP2;
import java.util.*;

public class ContadorArbol {
	private BinaryTree<Integer> arbol;

	private void verificarPares(List<Integer>lista,BinaryTree<Integer>arbol) {
		if(arbol.hasLeftChild())
			verificarPares(lista,arbol.getLeftChild());
		if(arbol.getData()% 2== 0)
			lista.add(this.arbol.getData());
		if(arbol.hasRightChild())
			verificarPares(lista,arbol.getRightChild());
	}
	
	public List<Integer> numerosParesInOrden(){
		List<Integer> lista=new ArrayList<>();
		verificarPares(lista,this.arbol);
		return lista;
	}
	
	private void verificarPostOrden(List<Integer> lista, BinaryTree<Integer>arbol) {
		if(arbol.hasLeftChild())
			verificarPostOrden(lista,arbol.getLeftChild());
		if(arbol.hasRightChild())
			verificarPostOrden(lista,arbol.getRightChild());
		if(arbol.getData() % 2 ==0)
			lista.add(arbol.getData());
			
	}
	
	public List<Integer> numeroParesPostOrden(){
		List<Integer>lista= new ArrayList<>();
		verificarPostOrden(lista,this.arbol);
		return lista;
	}
	
	
}
