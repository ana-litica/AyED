package TP3;

public class TestRecorridosAG {
	public static void main (String []args) {
		GeneralTree<Integer> arbolA =new GeneralTree<Integer>(4);
		GeneralTree<Integer> arbolB =new GeneralTree<Integer>(2);
		GeneralTree<Integer> arbolC =new GeneralTree<Integer>(5);
		GeneralTree<Integer> arbolD =new GeneralTree<Integer>(-5);
		GeneralTree<Integer> arbolE =new GeneralTree<Integer>(6);
		GeneralTree<Integer> arbolF =new GeneralTree<Integer>(3);
		GeneralTree<Integer> arbolG =new GeneralTree<Integer>(9);
		GeneralTree<Integer> arbolH =new GeneralTree<Integer>(7);
		
		arbolA.addChild(arbolB);
		arbolA.addChild(arbolC);
		arbolA.addChild(arbolD);
		

		arbolB.addChild(arbolE);
		arbolB.addChild(arbolF);
		arbolB.addChild(arbolG);
		

		GeneralTree<Integer> arbolI =new GeneralTree<Integer>(12);
		
		arbolF.addChild(arbolI);
		
		arbolD.addChild(arbolH);
		
		arbolA.recorridoPorNiveles();
		
		RecorridosAG recorrido= new RecorridosAG();
		System.out.println("Recorrido pre orden: "+recorrido.numerosImparesMayoresQuePreOrden(arbolA, 2));
		
		System.out.println("Recorrido post orden: "+recorrido.numerosImparesMayoresQuePostOrden(arbolA, 2));
		
		System.out.println("Recorrido por niveles: "+recorrido.numerosImparesMayoresQuePorNiveles(arbolA, 2));
		
		System.out.println("Recorrido in orden:"+recorrido.numerosImparesMayoresQueInOrden(arbolA, 2));
		
		System.out.println("Altura: "+arbolA.altura());
		System.out.println("Nivel: "+arbolA.nivel(12));
		System.out.println("Ancho: "+arbolA.ancho());
		System.out.println(arbolA.esAncestro(2, 6) );
		
		
	}
}
