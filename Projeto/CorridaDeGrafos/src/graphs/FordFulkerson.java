/*
 *CORRIDA DE GRAFOS
 *
 * Escrito por Diego Pedro para a disciplina de Teoria Dos Grafos 2009.2
 */

package graphs;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import config.DadosDeConfiguracao;

public class FordFulkerson extends Graph{    
    BFS bfs;
	public FordFulkerson(int numeroDeNodos)throws Exception{
		super(numeroDeNodos);
	}
	
	public Integer fordFulkerson(int fonte, int sorvedouro){
		try{
			bfs = new BFS(getNUMERO_DE_NODOS());
		
			bfs.setMatrizDePesos(this.getMatrizDePesos());	
                        
			int loops = 0;
			while(bfs.bfs(fonte, sorvedouro)){
				
				bfs.printPath();
				//System.out.println(" : valor Extraído  : "+ extraiMenor());
				loops += 1;				
				mudaFluxo(extraiMenor());
			}
		
			Integer fluxoMaximo = 0;
			for(int i = 0 ; i < this.getNUMERO_DE_NODOS(); i++)
				if(bfs.getMatrizDePesos()[sorvedouro][i] != OO)
				   fluxoMaximo += bfs.getMatrizDePesos()[sorvedouro][i];
			
			return fluxoMaximo;
		}catch(Exception ex){
			System.out.println(ex);
			return null;
		}
	}
	
	private int extraiMenor()throws Exception {			
		List path = bfs.getPath();		
		Iterator<Integer>it = path.iterator();
		Integer arestaDeMenorPeso = OO;
		Integer verticeA = it.next();
		Integer verticeB;
		while(it.hasNext()){			
			verticeB = it.next();
			//System.out.println("verticeB "+verticeB+" verticeA "+verticeA);
			if(verticeA == 0 || verticeB == 0)
				return arestaDeMenorPeso;
			
			if(arestaDeMenorPeso > bfs.getMatrizDePesos()[verticeB][verticeA])
				arestaDeMenorPeso = bfs.getMatrizDePesos()[verticeB][verticeA];
			//System.out.println("Aresta de menor peso  : "+arestaDeMenorPeso);
			verticeA = verticeB;			
			
		}
		return -arestaDeMenorPeso;
	}
	
	public void mudaFluxo(int menorValor)throws Exception{
		
		List path = bfs.getPath();
		
		Iterator<Integer>it = path.iterator();
		Integer arestaDeMenorPeso = OO;
		Integer V = it.next();
		Integer U;

		while(it.hasNext()){			
			U = it.next();
			
			if(V == 0)
				break;
						
			this.getMatrizDePesos()[U][V] -= menorValor;			
			this.getMatrizDePesos()[V][U] += menorValor;			
			V = U;
			
		}
		
	}
       
	public static void main(String args[]){
		
		try{
			FordFulkerson flowMax = new FordFulkerson(6);
			flowMax.insertArc(0, 1, 16);
			flowMax.insertArc(0, 2, 13);
			flowMax.insertArc(1, 3, 12);
			flowMax.insertArc(1, 2, 10);
			flowMax.insertArc(2, 1, 4);
			flowMax.insertArc(3, 2, 9);
			flowMax.insertArc(2, 4, 14);
			flowMax.insertArc(4, 3, 7);
			flowMax.insertArc(4, 5, 4);
			flowMax.insertArc(3, 5, 20);
			
			System.out.println("Fluxo maximo = "+flowMax.fordFulkerson(0, 5));
			//flowMax.printMatriz();
			
		}catch(Exception ex){
			
		}
		
	}
	
	
}
 