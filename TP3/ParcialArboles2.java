package TP3;
import java.util.*;

public class ParcialArboles2 {
	
	/*private static void resolver(GeneralTree<Integer> arbol, List<Integer> lista,List<Integer> aux,double operacion,double maximo) {
		if(arbol.isEmpty())
			return Math.max(operacion,maximo);
		if(arbol.hasChildren()) {
			for(GeneralTree<Integer> children: arbol.getChildren()) {
				if(arbol.getData().equals(1))
					lista.add(arbol.getData());
				//aux.add(children.getData());
				operacion+=(aux.size()-1)*children.getData();
				resolver(children,lista,aux,operacion,maximo);
			}
		}			
	}*/
	
	//Haciendolo void, da lo mismo 
	private static int resolver(GeneralTree<Integer> arbol,List<Integer> resultado,List<Integer> camino,int contador,double nivel,int maxActual) {	
		if(arbol.getData().equals(1)) {
			camino.add(arbol.getData());
			contador+=nivel;
		}
	//	System.out.println("Nivel: "+nivel+ " Lista "+camino);
		//int maxActual=Integer.MIN_VALUE;
		if(arbol.isLeaf()) {
			if(contador>maxActual) {
				maxActual=contador;
				resultado.clear();
				resultado.addAll(camino);
				//System.out.println(resultado);
			}
			return maxActual;
		}
		if(arbol.hasChildren()) {
			for(GeneralTree<Integer> child: arbol.getChildren()) {
				maxActual=resolver(child,resultado,camino,contador,nivel+1,maxActual);
				if(camino.size()>1)
					camino.remove(camino.size()-1);
			}
		}
		
		return maxActual;
	}

	public static List<Integer> resolver(GeneralTree<Integer> arbol){
		List<Integer> lista=new LinkedList<>();
		if(arbol!=null && !arbol.isEmpty()) {
			resolver(arbol,lista,new LinkedList<>(),0,0,Integer.MIN_VALUE);
		}
		return lista;
	}
	
	public static void main (String []args) {
		//nivel 0 y 1
		GeneralTree<Integer> nivel0=new GeneralTree<>(1);
		GeneralTree<Integer> nivel1H1=new GeneralTree<>(0);
		GeneralTree<Integer> nivel1H2=new GeneralTree<>(1);
		GeneralTree<Integer> nivel1H3=new GeneralTree<>(1);
		
		nivel0.addChild(nivel1H1);
		nivel0.addChild(nivel1H2);
		nivel0.addChild(nivel1H3);
		
		//nivel 2
		GeneralTree<Integer> nivel2H1=new GeneralTree<>(1);
		GeneralTree<Integer> nivel2H2=new GeneralTree<>(1);
		GeneralTree<Integer> nivel2H3=new GeneralTree<>(1);
		GeneralTree<Integer> nivel2H4=new GeneralTree<>(0);
		GeneralTree<Integer> nivel2H5=new GeneralTree<>(0);
		
		nivel1H1.addChild(nivel2H1);
		nivel1H1.addChild(nivel2H2);
		nivel1H2.addChild(nivel2H3);
		nivel1H2.addChild(nivel2H4);
		nivel1H3.addChild(nivel2H5);
		
		//nivel 3
		GeneralTree<Integer> nivel3H1=new GeneralTree<>(1);
		GeneralTree<Integer> nivel3H2=new GeneralTree<>(1);
		GeneralTree<Integer> nivel3H3=new GeneralTree<>(1);
		GeneralTree<Integer> nivel3H4=new GeneralTree<>(0);
		GeneralTree<Integer> nivel3H5=new GeneralTree<>(0);
		
		nivel2H1.addChild(nivel3H1);
		nivel2H1.addChild(nivel3H2);
		nivel2H1.addChild(nivel3H3);
		nivel2H4.addChild(nivel3H4);
		nivel2H5.addChild(nivel3H5);
		
		//nivel 4
		GeneralTree<Integer> nivel4H1=new GeneralTree<>(1);
		GeneralTree<Integer> nivel4H2=new GeneralTree<>(0);
		GeneralTree<Integer> nivel4H3=new GeneralTree<>(0);
		
		nivel3H4.addChild(nivel4H1);
		nivel3H5.addChild(nivel4H2);
		nivel3H5.addChild(nivel4H3);
		
		nivel0.recorridoPorNiveles();
		
		System.out.println(resolver(nivel0));

	}
}
