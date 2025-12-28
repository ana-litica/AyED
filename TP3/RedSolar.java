package TP3;
import TP3.GeneralTree;
import ParcialesViejos.Panel;

public class RedSolar {
	private GeneralTree<Panel> red;
	
	public RedSolar(GeneralTree<Panel> arbol) {
		this.red=arbol;
	}
	
	private double buscar(GeneralTree<Panel> arbol,GeneralTree<Panel> aux,String panelInicial,double energia) {
		if(arbol.getData().getIdentificador().equals(panelInicial) && arbol.getData().isEstado()) {
			aux=arbol;
			return energia;
		}
		else
			if(!arbol.getData().isEstado())
				return -1;
		double energiaMin=Integer.MAX_VALUE;
		if(arbol.hasChildren()) {
			for(GeneralTree<Panel> child:arbol.getChildren())
				energiaMin=buscar(child,aux,panelInicial,energia/arbol.getChildren().size());
		}
		return energiaMin;
	}
	
//	private double calcularEnergia(GeneralTree<Panel> arbol,double energia,double energiaMinima) {
//		if(arbol.isLeaf())
//			return Math.min(energia, energiaMinima);
//		else { double min=Integer.MAX_VALUE;
//			for(GeneralTree<Panel> child:arbol.getChildren())
//				min=calcularEnergia(child,energia/arbol.getChildren().size(),energiaMinima);
//			return min;
//		}
//	}
	
	private double calcularEnergia(GeneralTree<Panel> arbol,double energia) {
		if(arbol.isLeaf())
			return energia;
		else {
			double energiaMin=energia;
			for(GeneralTree<Panel> child:arbol.getChildren()){
				energia=calcularEnergia(child,energia/arbol.getChildren().size());
				energiaMin=Math.min(energia, energiaMin);
			}
			return energiaMin;
		}
	}
	
	public double minimoSuministroEnergia(double energiaTotal, String panelInicial) {
		double energia=-1;
		if(red!=null && !red.isEmpty()) {
			GeneralTree<Panel> arbolAux=new GeneralTree<>();
			energia=buscar(red,arbolAux,panelInicial,energiaTotal);
			if(arbolAux!=null && arbolAux.hasChildren())
				energia=calcularEnergia(arbolAux,energia/*,Integer.MAX_VALUE*/);
		}
		return energia;
	}
	
	public static void main(String [] args) {
		//nivel 0 y nivel 1
		GeneralTree<Panel> raiz = new GeneralTree<>(new Panel(true, "Panel 1"));
		GeneralTree<Panel> niv1n1 = new GeneralTree<>(new Panel(true, "Nodo A"));
		GeneralTree<Panel> niv1n2 = new GeneralTree<>(new Panel(false, "Nodo B"));
		GeneralTree<Panel> niv1n3 = new GeneralTree<>(new Panel(true, "Nodo C"));
		
		raiz.addChild(niv1n1);
		raiz.addChild(niv1n2);
		raiz.addChild(niv1n3);
		
		//nivel 2
		GeneralTree<Panel> niv2n1 = new GeneralTree<>(new Panel(true, "Mod 1"));
		GeneralTree<Panel> niv2n2 = new GeneralTree<>(new Panel(true, "Mod 2"));
		GeneralTree<Panel> niv2n3 = new GeneralTree<>(new Panel(true, "Nodo D"));
		
		niv1n1.addChild(niv2n1);
		niv1n1.addChild(niv2n2);
		
		//nivel 3
		GeneralTree<Panel> niv3n1 = new GeneralTree<>(new Panel(true, "Mod 3"));
		GeneralTree<Panel> niv3n2 = new GeneralTree<>(new Panel(true, "Mod 4"));
		
		niv2n3.addChild(niv3n1);
		niv2n3.addChild(niv3n2);
		
		RedSolar arbol = new RedSolar(raiz);
		
		System.out.println(arbol.minimoSuministroEnergia(1200, "Nodo C"));
	}
}
