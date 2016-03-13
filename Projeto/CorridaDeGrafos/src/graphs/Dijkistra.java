/*
 *CORRIDA DE GRAFOS
 *
 * Escrito por Diego Pedro para a disciplina de Teoria Dos Grafos 2009.2
 */

package graphs;

import config.DadosDeConfiguracao;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import config.DadosDeConfiguracao;
import javax.swing.JOptionPane;

public class Dijkistra extends Graph{
    
	private boolean nodosVisitados[];
	private int distancias[];
	private int father[];
	private List filaDePrioridade = new ArrayList<Integer>();
	private DadosDeConfiguracao config = new DadosDeConfiguracao();
        private final int NUMERO_MAXIMO_REPETICOES;
        private FordFulkerson ford;
        private String  nivel =  "FACIL";
        private int DosadorDificil = 0;
	
	/*
	 * Construtor : recebe o numero de nodos do grafo
	 */
	public Dijkistra(int numeroDeNodos)throws Exception{
		super(numeroDeNodos);
		//como sera considerado de 1- n entao e acrescentado + 1
		nodosVisitados = new boolean[numeroDeNodos];
		//como sera considerado de 1- n entao e acrescentado + 1
		distancias = new int[numeroDeNodos];
		//antecesor do vertice
		setFather(new int[numeroDeNodos]);
                //considerando algoritmo n4
                this.NUMERO_MAXIMO_REPETICOES = numeroDeNodos*numeroDeNodos*numeroDeNodos*numeroDeNodos;
               
                
                //executa o fordfulkerson
                ford = new FordFulkerson(numeroDeNodos);
                ford.setMatrizDePesos(this.getMatrizDePesos());
                ford.fordFulkerson(0,numeroDeNodos-1);
                  
	}
        
        public Dijkistra(int numeroDeNodos, Integer MatrizDePesos[][]) throws Exception{
            super(numeroDeNodos);
            
            //executa o fordfulkerson
            ford = new FordFulkerson(numeroDeNodos);
            ford.setMatrizDePesos(this.getMatrizDePesos());
            ford.fordFulkerson(0,numeroDeNodos-1);
            
            
           //como sera considerado de 1- n entao e acrescentado + 1
            nodosVisitados = new boolean[numeroDeNodos];
            //como sera considerado de 1- n entao e acrescentado + 1
            distancias = new int[numeroDeNodos];
            //antecesor do vertice
            setFather(new int[numeroDeNodos]);
            this.NUMERO_MAXIMO_REPETICOES = numeroDeNodos*numeroDeNodos*numeroDeNodos*numeroDeNodos;
            Integer matrizCopia[][] = new Integer[numeroDeNodos+1][];
            try{
                    for(int i = 0 ; i < numeroDeNodos ; i++){
                            matrizCopia[i] = new Integer[numeroDeNodos+1];			
                            for(int j = 0 ; j < numeroDeNodos ; j++){
                                    matrizCopia[i][j] = MatrizDePesos[i][j];
                            }
                    }
            }catch(Exception ex){
                    if(ex.getMessage() == null)
                                  System.out.println("Ocorreu um erro de "+ex+" em criaMatrizInt");
                            else
                                    System.out.println("Erro ao criar a matriz");
            }
                 
             this.setMatrizDePesos(matrizCopia);
        }   
	
	public int dijkistra(int origem, int destino, BFS erupcoes)throws Exception{

		if(origem < 0 || destino > getNUMERO_DE_NODOS())
			throw new Exception("origem eh menor que 0 ou destino nao existe");
		
		this.setOrigem(origem);
		this.setDestino(destino);
		
		try{
		    this.iniciaMenorCaminho(origem);
		}catch(Exception ex){
			System.out.println("Erro ao iniciar os dados "+ex);
		}
                
		int loops = 0;
		while(!filaDePrioridade.isEmpty()){			
			Integer verticeMenorPeso = extraiMenor();	
                        DosadorDificil += 1;
                        
			for(int i = 0 ; i < getNUMERO_DE_NODOS() ; i++){
				
				if(getMatrizDePesos()[verticeMenorPeso][i] > 0 && getMatrizDePesos()[verticeMenorPeso][i] < OO)					
					relaxa(verticeMenorPeso,i,erupcoes);	
			}
                        loops += 1;
                        if(loops > NUMERO_MAXIMO_REPETICOES)
                            throw new Exception("Nao foi possivel achar o caminho "
                                                +"algoritmo encerrado com o tamanho da fila :"
                                                +" "+filaDePrioridade.size());
                       
		}
		//printDistancias();
		return distancias[destino];		                  
	}
	/*
	 * Inicia dados do algoritmo
	 */
	private void iniciaMenorCaminho(int origem)throws Exception{
            int i=0;
            try{
		for(i = 0 ; i < getNUMERO_DE_NODOS(); i++){
			distancias[i] = OO;
			nodosVisitados[i] = false;	
			this.getFather()[i] = OO;
			filaDePrioridade.add(new Integer(i));//adiciona a aresta na fila
		}
		distancias[origem] = 0;//inicia o vetor de distancias
            }catch(Exception ex){
                throw new Exception("Indice "+i);
            }
		
	}
	
	/*
	 * Relaxa arestas no grafo
         * Esta e o metodo mais importante do jogo
         * Nele e devinido o nivel do computador do jogo         
	 */
	private void relaxa(int u, int v, BFS erupcoes){
		int fluxo=0;
                int erupcao=0;
                int numeroGerado = new Random().nextInt(10);
                
                 //se o fluxo e baixo desconsidere
                 if(ford.getMatrizDePesos()[u][v] >= 18//DadosDeConfiguracao.AGUA_RASA
                    && erupcoes.getMatrizDePesos()[u][v] == 0)
                    fluxo = ford.getMatrizDePesos()[u][v];
                 if(erupcoes != null){
                         erupcao = erupcoes.getMatrizDePesos()[u][v];
                         if(erupcao == 0)
                             fluxo = 0;
                 }
                
                //utiliza o relaxamento normal porem desconsidera o fluxo
                //---------------------------FACIL---------------------------
                if(getNivel().equals("FACIL")){
                   if (distancias[v] > distancias[u]+this.getMatrizDePesos()[u][v]){				
                        distancias[v] = distancias[u]+this.getMatrizDePesos()[u][v];
                        getFather()[v] = u;	
                   }
                } 
                //--------------------------NORMAL---------------------------
                //considera o fluxo mais em apenas 30% das vezes 
                //considera erupcao mais em apenas 30% das vezes 
                else  if(getNivel().equals("NORMAL")){ 
                   
                   
                   if(numeroGerado % 3 == 0){
                       if (distancias[v] > distancias[u]+this.getMatrizDePesos()[u][v]+fluxo+erupcao){				
                            distancias[v] = distancias[u]+this.getMatrizDePesos()[u][v]+fluxo+erupcao;
                            getFather()[v] = u;	
                       }
                   }
                   //relaxamento normal
                   else {
                       if (distancias[v] > distancias[u]+this.getMatrizDePesos()[u][v]){				
                        distancias[v] = distancias[u]+this.getMatrizDePesos()[u][v];
                        getFather()[v] = u;
                      }
                   }
                } 
                
                //--------------------------DIFICIL---------------------------
                //considera o fluxo e erupcao             
                else if(getNivel().equals("DIFICIL")){                    
                     
                     if (distancias[v] > distancias[u]+this.getMatrizDePesos()[u][v]+fluxo+erupcao){				
                            distancias[v] = distancias[u]+this.getMatrizDePesos()[u][v]+fluxo+erupcao;
                            getFather()[v] = u;	
                       }
                 }
                
              
	}
	
	private int extraiMenor(){
		int menorValor = OO;   
		int verticeDeMenorPeso=0;
		
		Iterator<Integer>it = filaDePrioridade.iterator();
                if(it.hasNext())
                    verticeDeMenorPeso = it.next();
		while(it.hasNext()){
			int verticeAtual = it.next();			
			if(distancias[verticeAtual] < menorValor){				
				menorValor = distancias[verticeAtual];
				verticeDeMenorPeso = verticeAtual;
			}
		}
		
		filaDePrioridade.remove(new Integer(verticeDeMenorPeso));		
		
		return verticeDeMenorPeso;
	}
	
	public List<Integer> getPath()throws Exception{
                
                if(this.getFather()[this.getOrigem()]!=OO)
                    throw new Exception("Nao foi executado o menor caminho partindo da origem :"
                                        +this.getOrigem()+" com destino a "+this.getDestino()
                                        +" porque pai do nodo "+this.getOrigem()+" = "+getFather()[this.getOrigem()]);
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
               System.out.println("Caminho de "+getOrigem()+" ate "+getDestino());
               while(it.hasNext())
                    System.out.print("["+it.next()+"] ");  
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }


        }		
	             /**
         *Converte uma posicao em uma matriz para uma posicao em um vetor.     
         */
         
	public List getFilaDePrioridade() {
		return filaDePrioridade;
	}

	public void setFilaDePrioridade(List filaDePrioridade) {
		this.filaDePrioridade = filaDePrioridade;
	}
	
	private void printDistancias(){
		for(int i = 0 ; i < getNUMERO_DE_NODOS(); i++)
			System.out.print("["+distancias[i]+"] ");
		System.out.println();
	}
        
        public int[] getFather() {
                return father;
        }

        public void setFather(int[] father) {
                 this.father = father;
        }
        
        public void setNivel(String nivel){
            if(!nivel.equals("FACIL")
              && !nivel.equals("NORMAL")
              && !nivel.equals("DIFICIL")){
                JOptionPane.showMessageDialog(null,"deve ser informado FACIL, NORMAL ou DIFICIL",
                                             "Nivel invalido",2);
                return;
            }
            this.nivel = nivel;
        }
        
         public String getNivel(){
             return nivel;
        }
        
	public static void main(String args[]){
		
		
		try{
			Dijkistra dij = new Dijkistra(5);
			dij.insertArc(0, 1, 10);
			dij.insertArc(0, 2, 5);
			dij.insertArc(1, 2, 2);
			dij.insertArc(1, 3, 1);
			dij.insertArc(2, 1, 3);
			dij.insertArc(2, 3, 9);
			dij.insertArc(2, 4, 2);
			dij.insertArc(3, 4, 4);		
			dij.insertArc(4, 3, 6);
			dij.insertArc(4, 0, 7);			
			//System.out.println("Menor caminho entre 0 e 4 "+dij.dijkistra(0,4 )+"\n");			
			dij.printPath();
                       // System.out.println("Menor caminho entre 0 e 3 "+dij.dijkistra(0,3 )+"\n");			
			dij.printPath();
                        
		}catch(Exception ex){
			if(ex.getMessage() == null)
			      System.out.println("Ocorreu um erro de "+ex+" no main");
			else 
				System.out.println(ex.getMessage()+"XXX");
		}
		
	}
        

   
}
