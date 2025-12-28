package ParcialesViejos;
import TP3.GeneralTree;
import java.util.*;

public class PT3F12025 {

	public static List<List<Integer>> caminosAlternantes(GeneralTree<Integer> arbol){
		List<List<Integer>> lista=new LinkedList<>();
		if(arbol!=null && !arbol.isEmpty())
			caminosAlternantes(arbol,lista,new LinkedList<Integer>());
		return lista;
	}
	
	private static void caminosAlternantes(GeneralTree<Integer> arbol, List<List<Integer>> resultado, List<Integer> camino) {
		camino.add(arbol.getData());		
		if(arbol.isLeaf()) {
			resultado.add(new LinkedList<Integer>(camino));
		}
		else {
			boolean restoPadre=arbol.getData()%3==0;
			for(GeneralTree<Integer> children : arbol.getChildren()) {
				if((children.getData()%3!=0 && restoPadre) || (children.getData()%3==0 && !restoPadre)) {
					caminosAlternantes(children, resultado,camino);
					camino.remove(camino.size()-1);
				}
			}
		}
	}

	
	public static void main (String []args) {
		//nivel 0 y 1
				GeneralTree<Integer> raiz = new GeneralTree<>(3);
				GeneralTree<Integer> niv1n1 = new GeneralTree<>(4);
				GeneralTree<Integer> niv1n2 = new GeneralTree<>(1);
				
				raiz.addChild(niv1n1);
				raiz.addChild(niv1n2);
				
				//nivel 2
				GeneralTree<Integer> niv2n1 = new GeneralTree<>(9);
				GeneralTree<Integer> niv2n2 = new GeneralTree<>(5);
				GeneralTree<Integer> niv2n3 = new GeneralTree<>(6);
				GeneralTree<Integer> niv2n4 = new GeneralTree<>(3);
				
				niv1n1.addChild(niv2n1);
				niv1n1.addChild(niv2n2);
				niv1n1.addChild(niv2n3);
				
				niv1n2.addChild(niv2n4);
				
				//nivel 3
				GeneralTree<Integer> niv3n1 = new GeneralTree<>(7);
				
				niv2n3.addChild(niv3n1);
		
		System.out.println(caminosAlternantes(raiz));
	}
}
