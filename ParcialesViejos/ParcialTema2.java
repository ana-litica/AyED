package ParcialesViejos;
import TP3.GeneralTree;
import java.util.*;

public class ParcialTema2 {
	
	private static int buscarCamino(GeneralTree<Integer> arbol,List<Integer> resultado,List<Integer> camino,int sumaActual,int maximo) {
		sumaActual+=arbol.getData();
		camino.add(arbol.getData());
		if(arbol.isLeaf()) {
			if(maximo<sumaActual) {
				maximo=sumaActual;
				resultado.clear();
				resultado.addAll(camino);
			}
		}
		else{
			boolean signoPositivo=arbol.getData()>0;
			for(GeneralTree<Integer> children: arbol.getChildren()) {
				if((children.getData()<0 && signoPositivo) || (children.getData()>0 && !signoPositivo)) {
					maximo=buscarCamino(children,resultado,camino,sumaActual,maximo);
					camino.remove(camino.size()-1);
				}
			}
		}
		return maximo;
	}

	public static List<Integer> caminoSignoAlternante(GeneralTree<Integer> arbol){
		List<Integer> lista=new LinkedList<>();
		if(arbol!=null && !arbol.isEmpty())
			buscarCamino(arbol,lista,new LinkedList<Integer>(), 0,Integer.MIN_VALUE);
		return lista;
	}
	
	public static void main (String [] args) {
		GeneralTree<Integer> raiz=new GeneralTree<>(5); 
		GeneralTree<Integer> hijo1=new GeneralTree<>(-2); 
		GeneralTree<Integer> hijo2=new GeneralTree<>(-4);
		
		raiz.addChild(hijo1);
		raiz.addChild(hijo2);
		
		GeneralTree<Integer> hijo11=new GeneralTree<>(7); 
		GeneralTree<Integer> hijo12=new GeneralTree<>(-5); 
		GeneralTree<Integer> hijo13=new GeneralTree<>(8); 
		GeneralTree<Integer> hijo21=new GeneralTree<>(6); 
		
		hijo1.addChild(hijo11);
		hijo1.addChild(hijo12);
		hijo1.addChild(hijo13);
		hijo2.addChild(hijo21);
		
		GeneralTree<Integer> hijo131=new GeneralTree<>(-1); 
		
		hijo13.addChild(hijo131);
		
		raiz.recorridoPorNiveles();
		System.out.println(caminoSignoAlternante(raiz));
	}
}
