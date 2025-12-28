package TP3;
import TP1.Queue;

public class ParcialArboles3 {
	
	public static boolean resolver (GeneralTree<Integer> arbol) {
		if(arbol!=null && !arbol.isEmpty()) {
			GeneralTree<Integer> arbolAux;
			Queue <GeneralTree<Integer>> cola=new Queue<>();
			cola.enqueue(arbol);
			cola.enqueue(null);
			int nodosAnteriores=1;
			int cantNodos=0;
			
			while(!cola.isEmpty()){
				arbolAux=cola.dequeue();
				if(arbolAux!=null) {
					if(arbolAux.hasChildren()) {
						cantNodos=0;
						for(GeneralTree<Integer> child: arbolAux.getChildren()) {
							cola.enqueue(child);
							cantNodos++;
						}
					}
				else {
					if(!cola.isEmpty()) {
						if(cantNodos!=nodosAnteriores+1)
							return false;
						nodosAnteriores=cantNodos;					
						cola.enqueue(null);
					}
					}
				}
				
			}
			return true;
		}
			
		return false;
	}
	
	/*public static void main (String []args) {
		//nivel 0 y 1 
		GeneralTree<Integer> raiz=new GeneralTree<Integer>(2);
		GeneralTree<Integer> nivel1H1=new GeneralTree<Integer>(1);
		GeneralTree<Integer> nivel1H2=new GeneralTree<Integer>(25);
		
		raiz.addChild(nivel1H1);
		raiz.addChild(nivel1H2);
		
		GeneralTree<Integer> nivel2H1=new GeneralTree<Integer>(5);
		GeneralTree<Integer> nivel2H2=new GeneralTree<Integer>(4);
		GeneralTree<Integer> nivel2H3=new GeneralTree<Integer>(13);
		
		nivel1H1.addChild(nivel2H1);
		nivel1H1.addChild(nivel2H2);
		nivel1H2.addChild(nivel2H3);
		
		GeneralTree<Integer> nivel3H1=new GeneralTree<Integer>(18);
		GeneralTree<Integer> nivel3H2=new GeneralTree<Integer>(7);
		GeneralTree<Integer> nivel3H3=new GeneralTree<Integer>(11);
		GeneralTree<Integer> nivel3H4=new GeneralTree<Integer>(3);
		
		nivel2H1.addChild(nivel3H1);
		nivel2H2.addChild(nivel3H2);
		nivel2H2.addChild(nivel3H3);
		nivel2H2.addChild(nivel3H4);
		
		GeneralTree<Integer> nivel4H1=new GeneralTree<Integer>(83);
		GeneralTree<Integer> nivel4H2=new GeneralTree<Integer>(33);
		GeneralTree<Integer> nivel4H3=new GeneralTree<Integer>(12);
		GeneralTree<Integer> nivel4H4=new GeneralTree<Integer>(17);
		GeneralTree<Integer> nivel4H5=new GeneralTree<Integer>(9);
		
		nivel3H1.addChild(nivel4H1);
		nivel3H4.addChild(nivel4H2);
		nivel3H4.addChild(nivel4H3);
		nivel3H4.addChild(nivel4H4);
		nivel3H4.addChild(nivel4H5);
		
		System.out.println(resolver(raiz));
	}*/
	
	public static void main (String [] args) {
		//nivel 0
				GeneralTree<Integer> arbol = new GeneralTree<>(2);
		//nivel 1
				GeneralTree<Integer> niv1n1 = new GeneralTree<>(1);
				GeneralTree<Integer> niv1n2 = new GeneralTree<>(25);
				
				arbol.addChild(niv1n1);
				arbol.addChild(niv1n2);
				
				//nivel 2
				GeneralTree<Integer> niv2n1 = new GeneralTree<>(5);
				GeneralTree<Integer> niv2n2 = new GeneralTree<>(4);
				GeneralTree<Integer> niv2n3 = new GeneralTree<>(13);
				
				niv1n1.addChild(niv2n1);
				niv1n1.addChild(niv2n2);
				
				niv1n2.addChild(niv2n3);
				
				//nivel 3
				GeneralTree<Integer> niv3n1 = new GeneralTree<>(18);
				GeneralTree<Integer> niv3n2 = new GeneralTree<>(7);
				GeneralTree<Integer> niv3n3 = new GeneralTree<>(11);
				GeneralTree<Integer> niv3n4 = new GeneralTree<>(3);
				
				niv2n1.addChild(niv3n1);
				
				niv2n2.addChild(niv3n2);	//comentar esta línea para que resolver retorne falso
				niv2n2.addChild(niv3n3);
				niv2n2.addChild(niv3n4);
				
				//nivel 4
				GeneralTree<Integer> niv4n1 = new GeneralTree<>(83);
				GeneralTree<Integer> niv4n2 = new GeneralTree<>(33);
				GeneralTree<Integer> niv4n3 = new GeneralTree<>(12);
				GeneralTree<Integer> niv4n4 = new GeneralTree<>(17);
				GeneralTree<Integer> niv4n5 = new GeneralTree<>(9);
				
				niv3n1.addChild(niv4n1);
				
				niv3n4.addChild(niv4n2);
				niv3n4.addChild(niv4n3);
				niv3n4.addChild(niv4n4);
				niv3n4.addChild(niv4n5);
				
				System.out.println(resolver(arbol));
	}
}
