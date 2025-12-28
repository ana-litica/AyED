package TP3;
import java.util.*;

public class ParcialArboles {
	
	public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
		if(arbol!=null && !arbol.isEmpty())
			return esDeSeleccionRecursivo(arbol);
		return false;
	}
	
	private static boolean esDeSeleccionRecursivo (GeneralTree<Integer> arbol) {
		if(arbol.isLeaf())
			return true;
		else {
			boolean continuar=true;
			int minimo=Integer.MAX_VALUE;
			Iterator <GeneralTree<Integer>> iterador=arbol.getChildren().iterator();
			while(continuar && iterador.hasNext()) {
				GeneralTree<Integer> it =iterador.next();
				minimo=Math.min(minimo, it.getData());
				continuar=esDeSeleccion(it);
			}
			return arbol.getData().equals(minimo) && continuar;
		}
	}
	
	/*private static boolean esDeSeleccion(GeneralTree<Integer> arbol,int datoPadre) {
		if(arbol.hasChildren()) {
			boolean seguir=true;
			Iterator<GeneralTree<Integer>> iterador=arbol.getChildren().iterator();
			while(seguir && iterador.hasNext()) {
				seguir= esDeSeleccion(iterador.next(),arbol.getData());				
			}
			return seguir;
		}
		if(arbol.getData()>=datoPadre) {
			return true;
		}
		else 
			return false;
		//System.out.print(arbol.getData()+" ");
		//Me falta el caso en que haya un valor en que no esté en ningún hijo
	}*/
	
	
	public static void main (String [] args) {
		//Niveles 0 y 1
		GeneralTree<Integer> raiz=new GeneralTree<Integer>(35);
		GeneralTree<Integer> nivel1H1=new GeneralTree<Integer>(12);
		GeneralTree<Integer> nivel1H2=new GeneralTree<Integer>(25);
		
		raiz.addChild(nivel1H1);
		raiz.addChild(nivel1H2);
		
		//nivel 2
		GeneralTree<Integer> nivel2H1=new GeneralTree<Integer>(35);
		GeneralTree<Integer> nivel2H2=new GeneralTree<Integer>(12);
		GeneralTree<Integer> nivel2H3=new GeneralTree<Integer>(25);
		
		nivel1H1.addChild(nivel2H1);
		nivel1H1.addChild(nivel2H2);
		nivel1H2.addChild(nivel2H3);
		
		//nivel 3
		GeneralTree<Integer> nivel3H1=new GeneralTree<Integer>(35);
		GeneralTree<Integer> nivel3H2=new GeneralTree<Integer>(14);
		GeneralTree<Integer> nivel3H3=new GeneralTree<Integer>(12);
		GeneralTree<Integer> nivel3H4=new GeneralTree<Integer>(33);
		
		nivel2H1.addChild(nivel3H1);
		nivel2H2.addChild(nivel3H2);
		nivel2H2.addChild(nivel3H3);
		nivel2H2.addChild(nivel3H4);
		
		//nivel 4
		GeneralTree<Integer> nivel4H1=new GeneralTree<Integer>(35);
		GeneralTree<Integer> nivel4H2=new GeneralTree<Integer>(35);
		GeneralTree<Integer> nivel4H3=new GeneralTree<Integer>(83);
		GeneralTree<Integer> nivel4H4=new GeneralTree<Integer>(90);
		GeneralTree<Integer> nivel4H5=new GeneralTree<Integer>(33);
		
		nivel3H1.addChild(nivel4H1);
		nivel3H4.addChild(nivel4H2);		
		nivel3H4.addChild(nivel4H3);		
		nivel3H4.addChild(nivel4H4);		
		nivel3H4.addChild(nivel4H5);		
		
		System.out.println(esDeSeleccion(raiz));
	}
}
