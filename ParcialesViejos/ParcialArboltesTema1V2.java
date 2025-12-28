package ParcialesViejos;
import java.util.*;
import TP3.GeneralTree;

public class ParcialArboltesTema1V2 {
	
	private static void buscarCamino(GeneralTree<Integer> arbol,List<Integer> resultado, List<Integer> caminoActual) {
		caminoActual.add(arbol.getData());
		if(arbol.isLeaf()) {
			if(resultado.size()<caminoActual.size()) {
				resultado.clear();
				resultado.addAll(caminoActual);
			}
		}else {
		//if(arbol.hasChildren()) {
			int resto=arbol.getData()%2;
			for(GeneralTree<Integer> children: arbol.getChildren())
				if(children.getData()%2 !=resto) {
					buscarCamino(children,resultado,caminoActual);
					caminoActual.remove(caminoActual.size()-1);
				}
		}
	}
	
	public static List<Integer> caminoParidadAlternante(GeneralTree<Integer> arbol){
		List<Integer> lista=new LinkedList<>();
		if(arbol!=null && !arbol.isEmpty())
			buscarCamino(arbol,lista,new LinkedList<Integer>());
		return lista;
	}
	
	public static void main (String [] args) {
		//nivel 0 y 1 
		GeneralTree<Integer> raiz=new GeneralTree<>(2);
		GeneralTree<Integer> hijoRaiz1=new GeneralTree<>(3);
		GeneralTree<Integer> hijoRaiz2=new GeneralTree<>(5);
		
		raiz.addChild(hijoRaiz1);
		raiz.addChild(hijoRaiz2);
		
		GeneralTree<Integer> hijo11=new GeneralTree<>(1);
		GeneralTree<Integer> hijo12=new GeneralTree<>(4);
		GeneralTree<Integer> hijo13=new GeneralTree<>(6);
		GeneralTree<Integer> hijo2=new GeneralTree<>(6);
		
		hijoRaiz1.addChild(hijo11);
		hijoRaiz1.addChild(hijo12);
		hijoRaiz1.addChild(hijo13);
		hijoRaiz2.addChild(hijo2);
		
		GeneralTree<Integer> ultimoHijo=new GeneralTree<>(6);
		hijo13.addChild(ultimoHijo);
		
		System.out.println(caminoParidadAlternante(raiz));
	}
}
