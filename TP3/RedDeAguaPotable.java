package TP3;

public class RedDeAguaPotable {
	private GeneralTree<Character> redDeAgua;
	
	public RedDeAguaPotable(GeneralTree<Character> arbol) {
		this.redDeAgua=arbol;
	}
	
	public double minimoCaudal(double caudal) {
		 if(redDeAgua!=null && !redDeAgua.isEmpty()) {
			 return minimoCaudal(caudal,this.redDeAgua,Integer.MAX_VALUE);
			 //return minimoCaudal(caudal,this.redDeAgua);
		 }
		 return -1;

	}
	
	private double minimoCaudal(double caudal, GeneralTree<Character> arbol, double minimo) {		
		if(arbol.isLeaf())
			return Math.min(minimo, caudal);
		//double min=9999;
		if(arbol.hasChildren()) {
			for(GeneralTree<Character> children: arbol.getChildren())
				minimo=minimoCaudal(caudal/arbol.getChildren().size(),children,minimo);
		}
		return minimo;
	}
	
//	private double minimoCaudal(double caudal, GeneralTree<Character> arbol) {
//		if(arbol.isLeaf())
//			return caudal;
//		else {
//			double caudalMin=caudal;
//			for(GeneralTree<Character> hijo: arbol.getChildren()) {
//				double caudalAct=minimoCaudal(caudal/arbol.getChildren().size(),hijo);
//				caudalMin=Math.min(caudalMin,caudalAct);
//			}
//			return caudalMin;
//		}
//	} //Comparar
	
	public static void main(String []args) {
		//Niveles 0 y 1
		GeneralTree<Character> arbolA=new GeneralTree<>('A');
		GeneralTree<Character> arbolB =new GeneralTree<>('B');
		GeneralTree<Character> arbolC=new GeneralTree<>('C');
		GeneralTree<Character> arbolD=new GeneralTree<>('D');
		GeneralTree<Character> arbolE=new GeneralTree<>('E');
		
		arbolA.addChild(arbolB);		
		arbolA.addChild(arbolC);		
		arbolA.addChild(arbolD);		
		arbolA.addChild(arbolE);
		
		//Nivel 2
		GeneralTree<Character> arbolF=new GeneralTree<>('F');
		GeneralTree<Character> arbolG=new GeneralTree<>('G');
		GeneralTree<Character> arbolH=new GeneralTree<>('H');
		GeneralTree<Character> arbolI=new GeneralTree<>('I');
		GeneralTree<Character> arbolJ=new GeneralTree<>('J');
		GeneralTree<Character> arbolK=new GeneralTree<>('K');
		GeneralTree<Character> arbolP=new GeneralTree<>('P');
		
		arbolC.addChild(arbolF);
		arbolC.addChild(arbolG);
		arbolD.addChild(arbolH);
		arbolD.addChild(arbolI);
		arbolD.addChild(arbolJ);
		arbolD.addChild(arbolK);
		arbolD.addChild(arbolP);
		
		//Nivel 3
		GeneralTree<Character> arbolL=new GeneralTree<>('L');
		GeneralTree<Character> arbolM=new GeneralTree<>('M');
		GeneralTree<Character> arbolN=new GeneralTree<>('N');
		
		arbolG.addChild(arbolL);
		arbolJ.addChild(arbolM);
		arbolJ.addChild(arbolN);
		
		RedDeAguaPotable red =new RedDeAguaPotable(arbolA);
		System.out.println(red.minimoCaudal(1000));
			
		}
		
	}

