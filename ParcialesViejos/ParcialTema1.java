package ParcialesViejos;
import java.util.*;

import TP3.GeneralTree;
public class ParcialTema1 {

	private static void caminoParidadPrivado(GeneralTree<Integer> arbol,List<Integer> resultado,List<Integer> listaAux) {
		listaAux.add(arbol.getData());
		if(arbol.isLeaf()) {
			if(resultado.size()<listaAux.size()) {
				resultado.clear();
				resultado.addAll(listaAux);
			}
		}
		if(arbol.hasChildren()) {
			int restoDatoPadre= arbol.getData()%2;
			for(GeneralTree<Integer> children:arbol.getChildren()) {
				if((children.getData()%2)!=restoDatoPadre) {
						caminoParidadPrivado(children,resultado,listaAux);
						listaAux.remove(listaAux.size()-1);		
				}
			}				
		}
	}
	
	public static List<Integer> caminoParidadAlternante(GeneralTree<Integer> arbol){
		List<Integer> lista= new LinkedList<>();
		if(arbol!=null && !arbol.isEmpty())
			caminoParidadPrivado(arbol,lista,new LinkedList<Integer>());
		return lista;
	}
	
	public static void main (String []args) {
		//nivel 0 y 1
		GeneralTree<Integer> raiz=new GeneralTree<>(2);
		GeneralTree<Integer> PhijoDe2=new GeneralTree<>(3);
		GeneralTree<Integer> ShijoDe2=new GeneralTree<>(5);
		
		raiz.addChild(PhijoDe2);
		raiz.addChild(ShijoDe2);
		
		
		//nivel 2
		GeneralTree<Integer> hijo31=new GeneralTree<>(1);
		GeneralTree<Integer> hijo32=new GeneralTree<>(4);
		GeneralTree<Integer> hijo33=new GeneralTree<>(6);
		GeneralTree<Integer> hijo54=new GeneralTree<>(6);
		
		PhijoDe2.addChild(hijo31);
		PhijoDe2.addChild(hijo32);
		PhijoDe2.addChild(hijo33);
		ShijoDe2.addChild(hijo54);
		
		//nivel 3
		GeneralTree<Integer> hijoDe6=new GeneralTree<>(8);
		
		hijo33.addChild(hijoDe6);
		
		System.out.println(caminoParidadAlternante(raiz));
	}
}
