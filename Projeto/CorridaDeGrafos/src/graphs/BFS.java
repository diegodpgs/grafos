/*
 *CORRIDA DE GRAFOS
 *
 * Escrito por Diego Pedro para a disciplina de Teoria Dos Grafos 2009.2
 */

package graphs;
import config.DadosDeConfiguracao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BFS extends Graph{
	
	private int cor[];
	private int distancia[];
	private int father[];
	private final int  BRANCO  = 0;
	private final int  CINZA  = 1;
	private final int  PRETO = 2;
	private List verticesAdjacentes = new ArrayList<Integer>();
	
	public BFS(int numeroDeNodos)throws Exception{
		super(numeroDeNodos);
		cor = new int[numeroDeNodos];
		distancia = new int[numeroDeNodos];
		father = new int[numeroDeNodos];
		
	}
	
	public boolean bfs(int origem, int destino){
		iniciaBFS();
		distancia[origem] = 0;
		cor[origem] = CINZA;		
		father[origem] = OO;
		setDestino(destino);
		
		verticesAdjacentes.add(new Integer(origem));
		
		while(verticesAdjacentes.size() != 0){
			 Integer verticeDesfileirado = (Integer)verticesAdjacentes.remove(0);			
			 for(int vizinho = 0 ; vizinho < getNUMERO_DE_NODOS() ; vizinho++){
					Integer adjacente = getMatrizDePesos()[verticeDesfileirado][vizinho];					
					if(adjacente != 0
							&& adjacente != OO
							&& cor[vizinho] == BRANCO){
						
						cor[vizinho] =  CINZA;
						distancia[vizinho] = distancia[verticeDesfileirado] + 1;
						father[vizinho] = verticeDesfileirado;
						verticesAdjacentes.add(vizinho);
						//se ja leu o vertice de destino
						if(destino == vizinho){
							cor[verticeDesfileirado] = PRETO;
							return true;
						}
					}
					
						
			}		
			 
			cor[verticeDesfileirado] = PRETO;
		}
		if(father[destino] != OO) return true;
		else return false;
	}
	
        
        //utilizado para simular as erupcoes
        public Integer[][] getErupcoes(int origem, int ecentridade, Integer matriz[][]){               
                //System.out.println("BREAKPOINT-1----------------------------------------------------------------------------------");
                iniciaBFS();
                int linha  = origem / DadosDeConfiguracao.SIZE_COLUNA;
                int coluna = origem % DadosDeConfiguracao.SIZE_COLUNA;
		matriz[coluna][linha] = ecentridade*10;
                ecentridade -= 1;
		cor[origem] = CINZA;		
		//father[origem] = OO;
		System.out.println("Ecentridade no inicio : "+ecentridade);
		verticesAdjacentes.add(new Integer(origem));
		
		while(verticesAdjacentes.size() != 0){
                         ecentridade -= 1;    
			 if(ecentridade <= 0)
                                return matriz; 
			 Integer verticeDesfileirado = (Integer)verticesAdjacentes.remove(0);			
			 for(int vizinho = 0 ; vizinho < getNUMERO_DE_NODOS() ; vizinho++){
					Integer adjacente = this.getMatrizDePesos()[verticeDesfileirado][vizinho];					
					if(adjacente != 0
							&& adjacente != OO
							&& cor[vizinho] == BRANCO){
						
						cor[vizinho] =  CINZA;
						//distancia[vizinho] = distancia[verticeDesfileirado] + 1;
						//father[vizinho] = verticeDesfileirado;
						verticesAdjacentes.add(vizinho);
						
                                                 linha  = vizinho / DadosDeConfiguracao.SIZE_COLUNA;
                                                 coluna = vizinho % DadosDeConfiguracao.SIZE_COLUNA;
             
                                                //construi as erupções  
                                                //System.out.println("linha : "+linha+" coluna : "+coluna+" ecentridade "+ecentridade);
                                                matriz[coluna][linha] += (ecentridade*10);
                                                //System.out.println("MATRIZ["+coluna+"]["+linha+"] = "+matriz[coluna][linha]);
					}
                                        
			}
                        
			 
			cor[verticeDesfileirado] = PRETO;
		}
                
		return matriz;
	}
	
	public List<Integer> getPath()throws Exception{

		if(this.getFather()[this.getOrigem()]!=OO)
			throw new Exception("Nao foi executado o BFS ");
		List path = new ArrayList<Integer>();
		int i=0;
		path.add(getDestino());		


		for( i = getFather()[getDestino()]; i != getOrigem() ; i = getFather()[i]) 
			if(path.size() > (this.getNUMERO_DE_NODOS()*this.getNUMERO_DE_NODOS()))
				throw new java.lang.OutOfMemoryError();
			else
				path.add(i);


		path.add(i);
		return path;

	}	

	public void printPath(){
		Iterator<Integer>it;
		try{
			it = getPath().iterator();
			//System.out.println("Caminho de "+getOrigem()+" ate "+getDestino());
			while(it.hasNext())
				System.out.print("["+it.next()+"] ");  
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}


	}	
	
	public void printFather(){	
	   System.out.println(father[getDestino()]);
       for(int  i = 0 ; i < getNUMERO_DE_NODOS(); i++)
    	   System.out.print("["+father[i]+"] ");  
	}
	
	public void iniciaBFS(){
	    for(int i = 0 ; i < getNUMERO_DE_NODOS(); i++){
	    	cor[i] = BRANCO;
	    	distancia[i] = OO;
	    	father[i] = OO;
	    }	    
	    verticesAdjacentes.clear();
	}
	
	public int[] getCor() {
		return cor;
	}

	public void setCor(int[] cor) {
		this.cor = cor;
	}

	public int[] getDistancia() {
		return distancia;
	}

	public void setDistancia(int[] distancia) {
		this.distancia = distancia;
	}

	public int[] getFather() {
		return father;
	}

	public void setFather(int[] father) {
		this.father = father;
	}

	public List<Integer> getVerticesAdjacentes() {
		return verticesAdjacentes;
	}

	public void setVerticesAdjacentes(List verticesAdjacentes) {
		this.verticesAdjacentes = verticesAdjacentes;
	}

	private void printDistancias(){
		for(int i = 0 ; i < getNUMERO_DE_NODOS(); i++)
			System.out.print("["+distancia[i]+"] ");
		System.out.println();
	}
	
	public static void main(String args[]){
		try{
			BFS bfs = new BFS(9);
					
                        bfs.insertArc(1,0,1);                        
                        bfs.insertArc(0,1,1);
                        bfs.insertArc(0,3,1);                       
                        bfs.insertArc(3,0,1);
                        bfs.insertArc(1,2,1);
                        bfs.insertArc(2,1,1);
                        bfs.insertArc(1,4,1);
                        bfs.insertArc(4,1,1);
                        bfs.insertArc(2,5,1);
                        bfs.insertArc(5,2,1);
                        bfs.insertArc(3,4,1);
                        bfs.insertArc(4,3,1);
                        bfs.insertArc(4,5,1);
                        bfs.insertArc(5,4,1);
                        bfs.insertArc(3,6,1);
                        bfs.insertArc(6,3,1);
                        bfs.insertArc(4,7,1);
                        bfs.insertArc(7,4,1);
                        bfs.insertArc(5,8,1);
                        bfs.insertArc(8,5,1);
                        bfs.insertArc(6,7,1);
                        bfs.insertArc(7,6,1);
                        bfs.insertArc(8,7,1);
                        bfs.insertArc(7,8,1);
                        
			Integer matriz[][] = bfs.getErupcoes(4,7,bfs.criaMatrizInt(3,0));
                        for(int i = 0 ; i < 3 ; i++){
                            
                           for(int j = 0 ; j < 3 ; j++)
                                System.out.print("["+matriz[i][j]+"] ");
                           System.out.println();
                        }
                            
                        /*bfs.printMatriz();
			System.out.println(bfs.bfs(0, 5));
			bfs.printPath();*/
			//bfs.printDistancias();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
	}
	
	
}

