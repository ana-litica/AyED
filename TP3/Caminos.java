package TP3;
import java.util.*;

public class Caminos {
	private GeneralTree<Integer> arbol;
	
	public Caminos(GeneralTree<Integer> arbol) {
		this.arbol=arbol;
	}
	
	private void caminoAHojaMasLejana(GeneralTree<Integer> arbol,List<Integer> lista,List<Integer> resultado) {
		if(arbol.isLeaf())
			if(lista.size()>resultado.size()) {
				resultado.clear();
				resultado.addAll(lista);
			}
		if(arbol.hasChildren()) {
			for(GeneralTree<Integer> child: arbol.getChildren()) {
				lista.add(child.getData());
				caminoAHojaMasLejana(child,lista,resultado);
				lista.remove(lista.size()-1);
			}
		}
	}
	
	public List<Integer> caminoAHojaMasLejana(){
		List<Integer> lista=new LinkedList<>();
		List<Integer> resultado=new LinkedList<>();
		if(this.arbol!=null && !this.arbol.isEmpty()) {
			lista.add(this.arbol.getData());
			caminoAHojaMasLejana(this.arbol,lista,resultado);
		}
		return resultado;
	}	
	
	public static void main (String []args ) {
		GeneralTree<Integer> nivel0 = new GeneralTree<>(12);
		GeneralTree<Integer> nivel1n1 = new GeneralTree<>(17);
		GeneralTree<Integer> nivel1n2 = new GeneralTree<>(9);
		GeneralTree<Integer> nivel1n3 = new GeneralTree<>(15);
		
		nivel0.addChild(nivel1n1);
		nivel0.addChild(nivel1n2);
		nivel0.addChild(nivel1n3);
		
		GeneralTree<Integer> nivel2n1 = new GeneralTree<>(10);
		GeneralTree<Integer> nivel2n2 = new GeneralTree<>(6);
		GeneralTree<Integer> nivel2n3 = new GeneralTree<>(8);
		GeneralTree<Integer> nivel2n4 = new GeneralTree<>(14);
		GeneralTree<Integer> nivel2n5 = new GeneralTree<>(18);
		
		nivel1n1.addChild(nivel2n1);
		nivel1n1.addChild(nivel2n2);
		
		nivel1n2.addChild(nivel2n3);
		
		nivel1n3.addChild(nivel2n4);
		nivel1n3.addChild(nivel2n5);
		
		GeneralTree<Integer> nivel3n1 = new GeneralTree<>(1);
		GeneralTree<Integer> nivel3n2 = new GeneralTree<>(16);
		GeneralTree<Integer> nivel3n3 = new GeneralTree<>(7);
		
		nivel2n2.addChild(nivel3n1);
		
		nivel2n4.addChild(nivel3n2);
		nivel2n4.addChild(nivel3n3);
		
		Caminos caminoMaximo= new Caminos(nivel0);
		System.out.println(caminoMaximo.caminoAHojaMasLejana());
	}
}
