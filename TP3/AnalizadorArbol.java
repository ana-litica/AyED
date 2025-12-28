package TP3;
import TP1.Queue;

public class AnalizadorArbol {
	
	public double devolverMaximoPromedio (GeneralTree<AreaEmpresa>arbol) {
		if(arbol==null)
			return -1;
		else {
			GeneralTree<AreaEmpresa> arbolAux=new GeneralTree<>();
			Queue<GeneralTree<AreaEmpresa>> cola=new Queue <>();
			cola.enqueue(arbol);
			cola.enqueue(null);
			double promedio=0,max=-1;
			int tiemposTotales=0,cantNodos=0;
			
			while(!cola.isEmpty()) {
				arbolAux=cola.dequeue();
				if(arbolAux!=null) {
					cantNodos++;
					tiemposTotales+=arbolAux.getData().getTiempo();
					if(arbolAux.hasChildren()) {
						for(GeneralTree<AreaEmpresa> child: arbolAux.getChildren()) {
							cola.enqueue(child);
						}
					}	
				}
				else {
					promedio=(double)tiemposTotales/cantNodos;
					max=Math.max(max, promedio);
					if(!cola.isEmpty()) {
						cola.enqueue(null);
						tiemposTotales=0;
						cantNodos=0;
					}
				}
			}
			return max;			
		}		
	}
}
