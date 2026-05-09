import Arbol.GeneralTree;
import java.util.*;

public class CaminoParidadAlternante {

	public static List<Integer> caminoParidadAlternante(GeneralTree<Integer> arbol){
		List<Integer> resultado= new ArrayList<>();
		if(arbol!=null && !arbol.isEmpty())
			caminoAlternante(arbol,resultado,new ArrayList<>());
		return resultado;
	}
	
	private static void caminoAlternante(GeneralTree<Integer> arbol,List<Integer> resultado,List<Integer>aux) {
		aux.add(arbol.getData());
		if(arbol.isLeaf() && (resultado.size()<aux.size())) {
			resultado.clear();
			resultado.addAll(aux);
		}
		else {
			boolean restoPadre= arbol.getData() % 2==0;
			for(GeneralTree<Integer> child: arbol.getChildren()) {
				if((restoPadre && child.getData()% 2 != 0) || (!restoPadre && child.getData()% 2==0)) {
					caminoAlternante(child,resultado,aux);
					aux.remove(aux.size()-1);
				}
			}
		}
	}
	
	public static void main(String[]args) {
		GeneralTree<Integer> raiz=new GeneralTree<Integer>(2); 
		
		GeneralTree<Integer> nodo1=new GeneralTree<Integer>(3);
		GeneralTree<Integer> nodo2=new GeneralTree<Integer>(5);
		
		raiz.addChild(nodo1);
		raiz.addChild(nodo2);
		
		GeneralTree<Integer> nodo3=new GeneralTree<Integer>(1);
		GeneralTree<Integer> nodo4=new GeneralTree<Integer>(4);
		GeneralTree<Integer> nodo5=new GeneralTree<Integer>(6);
		GeneralTree<Integer> nodo6=new GeneralTree<Integer>(6);
		
		nodo1.addChild(nodo3);
		nodo1.addChild(nodo4);
		nodo1.addChild(nodo5);
		
		nodo2.addChild(nodo6);

		
		GeneralTree<Integer> nodo7=new GeneralTree<Integer>(8);
		
		nodo5.addChild(nodo7);
		
		System.out.println(caminoParidadAlternante(raiz));
	}
	
}
