/*
 *CORRIDA DE GRAFOS
 *
 * Escrito por Diego Pedro para a disciplina de Teoria Dos Grafos 2009.2
 */

package graphs;
import config.DadosDeConfiguracao;
import java.util.List;
import java.util.ArrayList;
public class Graph extends Object{
	public final int NUMERO_DE_NODOS;
	public final int OO = 2147483647;//infinito
        public final int SEM_ARCO = 2147483646;//para indicar que nao existe arco entre dois vertices
	private Integer[][]matrizDePesos;
	private int origem;
	private int destino;
		
	public Graph(int numeroDeNodos)throws Exception{
		
		if(numeroDeNodos <= 0)
			throw new Exception("o numero de nodos deve ser maior que 0");
		NUMERO_DE_NODOS = numeroDeNodos;	
		try{
			setMatrizDePesos(criaMatrizInt(numeroDeNodos,0));				
		}catch(Exception ex){
			if(ex.getMessage() == null)
			      System.out.println("Ocorreu um erro de "+ex+" no construtor");
			else
				System.out.println(ex.getMessage());
		}
		
	}	
	

	public Integer[][] criaMatrizInt(int tamanho, Integer valorPadrao)throws Exception{		

		if(tamanho <=1 )
			throw new Exception("o tamanho deve ser maior que 1");
        //como o grafo vai considerar valores de 1-n
		Integer matriz[][] = new Integer[tamanho+1][];
        try{
        	for(int i = 0 ; i < tamanho ; i++){
        		matriz[i] = new Integer[tamanho+1];			
        		for(int j = 0 ; j < tamanho ; j++){
        			matriz[i][j] = valorPadrao;
        		}
        	}
        }catch(Exception ex){
        	if(ex.getMessage() == null)
			      System.out.println("Ocorreu um erro de "+ex+" em criaMatrizInt");
			else
				System.out.println("Erro ao criar a matriz");
        }
		return matriz;
	}
	
	public void printMatriz()throws Exception{
		
		if(matrizDePesos == null) 
			throw new Exception("a matriz e nula"); 
		
		if(matrizDePesos[0] == null) 
			throw new Exception("a matriz nao foi inicializada");
		
			int tamanho = getNUMERO_DE_NODOS();
        
			for(int i = 0 ; i < tamanho ; i++){
				for(int j = 0 ; j < tamanho ; j++)
                                        if(matrizDePesos[i][j]==0)
                                            System.out.printf(i+":"+j+"[oo] ");
                                        else if(matrizDePesos[i][j]==OO)
                                            System.out.printf(i+":"+j+"[INF] ");
                                        else	
                                           System.out.printf(i+":"+j+"["+matrizDePesos[i][j]+"] ");
				System.out.printf("\n");
			}		
        
	}
    
	public void insertArc(int A, int B, int peso)throws Exception{
                 /*
                 * Esta condição será utilizado para evitar 
                 * que o algoritmo de dijkistra execute nodos aos quais já foram
                 * percorridos pelo jogador por isso tem que si diferenciar de
                 * infinito ja que so existe este metodo para adicionar arcos.
                 *
                if(matrizDePesos[A][B]==SEM_ARCO)return;*/
                if(A < 0 || B < 0)
                    throw new Exception("Erro na insercao de Arco : Vertice menore que o permitido "
                                        +" A : "+A+" B : "+B);
                
                if(A >= getNUMERO_DE_NODOS() || B >= getNUMERO_DE_NODOS())
                    throw new Exception("Erro na insercao de Arco : Vertice maior que o permitido "
                                        +" A : "+A+" B : "+B); 
                        
		if(peso <= 0)
			throw new Exception("Erro na insercao de Arco : nao eh permitido peso negativo");
                
		try{
			matrizDePesos[A][B] = peso;
                        
		}catch(NullPointerException ex){
                    System.out.println("Erro na insercao de Arco : Ocorreu um erro de estouro de vetor "
                                       +" nos indeces ["+A+"]["+B+"] com o peso : "+peso+"\n"
                                       +" ja que o tamanho da matriz = "+matrizDePesos.length);               
                }catch(Exception ex){
			if(ex.getMessage() == null)
			    System.out.println("Erro na insercao de Arco : Ocorreu um erro de "+ex+" insertArc");
			else
				System.out.println("Erro na insecao de arco");
		}
	}
	
	
        
        public void insereAdjacentes(Graph graph, int linha, int coluna, int peso){
        
           try{            
             //  # @ #
             //  # . #
             //  # # #^^
             
            if(linha > 0)
                graph.insertArc(DadosDeConfiguracao.matTOlin(linha,coluna),
                              DadosDeConfiguracao.matTOlin(linha-1,coluna),
                              peso);
             //  # # #
             //  # . @
             //  # # #->
            
            if(coluna < DadosDeConfiguracao.SIZE_COLUNA-1)
                graph.insertArc(DadosDeConfiguracao.matTOlin(linha,coluna),
                              DadosDeConfiguracao.matTOlin(linha,coluna+1),
                              peso);
             //  # # #
             //  # . #
             //  # @ #
            if(linha < DadosDeConfiguracao.SIZE_LINHA-1)
                graph.insertArc(DadosDeConfiguracao.matTOlin(linha,coluna),
                              DadosDeConfiguracao.matTOlin(linha+1,coluna),
                              peso);
             //  # # #
             //  @ . #
             //  # # #
        
            if(coluna > 0)
                graph.insertArc(DadosDeConfiguracao.matTOlin(linha,coluna),
                              DadosDeConfiguracao.matTOlin(linha,coluna-1),
                              peso);        
           }catch(Exception ex){
               System.out.println(ex.getMessage());
           }
        
        }
        
        
        public Integer[][] getMatrizDePesos() {		
		return this.matrizDePesos;
	}

	public void setMatrizDePesos(Integer[][] pesos) {		
		this.matrizDePesos = pesos;		
	}

	public int getNUMERO_DE_NODOS() {
		return NUMERO_DE_NODOS;
	}
	
	public int getOrigem() {
		return origem;
	}
	
	public void setOrigem(int origem) {
		this.origem = origem;
	}
	
	public int getDestino() {
		return destino;
	}
	

	public void setDestino(int destino) {
		this.destino = destino;
	}
	
		
	public static void main (String args[]){		
		try{
			Graph teste = new Graph(5);			
			teste.printMatriz();
		}catch(Exception ex){
			if(ex.getMessage() == null)
			      System.out.println("Ocorreu um erro de "+ex+" no main");
			else 
				System.out.println(ex.getMessage());
		}
	}
	

}
