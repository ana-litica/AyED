package TP3;

public class TestAreaEmpresa {
	public static void main (String []args) {
		GeneralTree<AreaEmpresa> M = new GeneralTree<>(new AreaEmpresa("M", 14));
		GeneralTree<AreaEmpresa> J = new GeneralTree<>(new AreaEmpresa("J", 13));
		GeneralTree<AreaEmpresa> K = new GeneralTree<>(new AreaEmpresa("K", 25));
		GeneralTree<AreaEmpresa> L = new GeneralTree<>(new AreaEmpresa("L", 10));
		
		M.addChild(J);
		M.addChild(K);
		M.addChild(L);
		
		GeneralTree<AreaEmpresa> A = new GeneralTree<>(new AreaEmpresa("A", 4));
		GeneralTree<AreaEmpresa> B = new GeneralTree<>(new AreaEmpresa("B", 7));
		GeneralTree<AreaEmpresa> C = new GeneralTree<>(new AreaEmpresa("C", 5));
		
		J.addChild(A);
		J.addChild(B);
		J.addChild(C);
		
		GeneralTree<AreaEmpresa> D = new GeneralTree<>(new AreaEmpresa("D", 6));
		GeneralTree<AreaEmpresa> E = new GeneralTree<>(new AreaEmpresa("E", 10));
		GeneralTree<AreaEmpresa> F = new GeneralTree<>(new AreaEmpresa("F", 18));
		
		K.addChild(D);
		K.addChild(E);
		K.addChild(F);
		
		GeneralTree<AreaEmpresa> G = new GeneralTree<>(new AreaEmpresa("G", 9));
		GeneralTree<AreaEmpresa> H = new GeneralTree<>(new AreaEmpresa("H", 12));
		GeneralTree<AreaEmpresa> I = new GeneralTree<>(new AreaEmpresa("I", 19));
		
		L.addChild(G);
		L.addChild(H);
		L.addChild(I);
		
		AnalizadorArbol analizador= new AnalizadorArbol();
		System.out.println("Mayor promedio: "+analizador.devolverMaximoPromedio(M));
	}
}
