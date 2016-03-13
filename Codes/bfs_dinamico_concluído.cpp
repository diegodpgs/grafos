#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<stdio.h>
#include<stdlib.h>

#define WHITE 0
#define CRAY  1
#define BLACK 2
#define INFINITE 214748367

using namespace std;
vector<int>distancia(101);

typedef struct lista *Lista;
struct lista{
       int vertice;       
       struct lista *proximo;   
       struct lista *anterior;    
};

typedef struct nodo Nodo;
struct nodo{
       int vertice;
       Lista adjacents;
};

typedef struct digrafo Digrafo;
struct digrafo{
       int numeroDeVertices;
       int numeroDeArcos;
       vector<Nodo>listaAdj;
};

Lista inicio = NULL;

int buscaLinear(Digrafo G, int vertice){
    int i = 0;
    while(i < G.numeroDeVertices && G.listaAdj[i].vertice != vertice)
      i++;

    
    if(i == G.numeroDeVertices ) return -1;
    
    return i;
}

//cria um grafo
Digrafo initDigrafo(){
        Digrafo G;
        vector<Nodo>lista;   
        G.numeroDeVertices = 0;
        G.numeroDeArcos = 0;  
        G.listaAdj = lista;  
        return G;
}
    

void printDigrafo(Digrafo G){
     printf("Numero de Vertices : %d\n",G.numeroDeVertices);
     printf("Numero de Arcos : %d\n",G.numeroDeArcos);
     for(int i= 0; i < G.numeroDeVertices ; i++){ 
             Lista aux;
             aux = G.listaAdj[i].adjacents;   
             printf("\nVertice %d\n",G.listaAdj[i].vertice);
             if(aux != NULL) {
                     while(aux->anterior != NULL)
                       aux = aux->anterior;                
                                    
                     while(aux != NULL){                           
                          printf(" [%d]",aux->vertice);
                          aux= aux->proximo;              
                     }
             }
             else printf("A lista esta vazia");
            
     }
}

Digrafo insertVertice(Digrafo G, int vertice){         
     Nodo nodoNovo;         
     nodoNovo.adjacents = NULL;
     nodoNovo.vertice = vertice;
       
     if(buscaLinear(G,vertice)!= -1)        
         return G;
     
     G.listaAdj.push_back(nodoNovo);     
     G.numeroDeVertices += 1;
     
     return G;
}
//retorna 1 para verdadeiro
Digrafo insertArc(Digrafo G, int verticeA, int verticeVizinho){
     Lista vizinho=(Lista)malloc(sizeof(Lista));
     vizinho->vertice = verticeVizinho;
     vizinho->proximo = NULL;    
     vizinho->anterior = NULL; 
     
     
     for(int i= 0 ; i < G.numeroDeVertices ; i++){             
             if(G.listaAdj[i].vertice == verticeA){ 

                                                        
                    while(G.listaAdj[i].adjacents != NULL && 
                          G.listaAdj[i].adjacents->anterior != NULL){	
                          G.listaAdj[i].adjacents = G.listaAdj[i].adjacents->anterior;
				    }
                                        
                    while(G.listaAdj[i].adjacents != NULL && 
                          G.listaAdj[i].adjacents->proximo != NULL && 
                          G.listaAdj[i].adjacents->vertice != verticeVizinho){ 
					      G.listaAdj[i].adjacents = G.listaAdj[i].adjacents->proximo;
                    } 
                           
                    if(G.listaAdj[i].adjacents == NULL){
                                 G.listaAdj[i].adjacents = vizinho;
                                 return G;
                    }
                    else if(G.listaAdj[i].adjacents->proximo == NULL){
					   vizinho->anterior = G.listaAdj[i].adjacents;
                       G.listaAdj[i].adjacents->proximo = vizinho;                       
                       
                       G.listaAdj[i].adjacents = G.listaAdj[i].adjacents->proximo;                                     
                       G.numeroDeArcos += 1;                     
                       return G;
                    }else  return G;                   
                  
             }
             
     }
     
     return G;
}

Digrafo insertArco(Digrafo G, int verticeA, int verticeB){
        G=insertArc(G,verticeA,verticeB);
        G=insertArc(G,verticeB,verticeA);
        return G;
}

void BFS(Digrafo G, int inicio){
     vector<int>cores(G.numeroDeVertices);     
     queue<int>fila;
	 map<int,int>lvertices;
     int s;
     int u;
     int buscaU;
     int busca;
     //pinta vertices de branco
     for(int i = 0 ; i < G.numeroDeVertices ; i++){
             cores[i] = WHITE;
             distancia[i] = INFINITE;
			 lvertices[G.listaAdj[i].vertice] = i;
             if(inicio == G.listaAdj[i].vertice)
                s=i;
     }
     distancia[lvertices[inicio]] = 0;
     cores[s] = CRAY;
     
     fila.push(inicio);
     while(fila.empty() != true){
          //int tamanho;
		  Lista aux;
          u = fila.front();

          fila.pop();
          buscaU = lvertices[u];//busca o indice na lista
          

          aux = G.listaAdj[buscaU].adjacents;		  

		  while(aux->anterior != NULL)
		       aux = aux->anterior;

		  
          for(Lista  aux2 = aux; aux2 != NULL ; aux2 = aux2->proximo){
                  int v = aux2->vertice;
                  busca = lvertices[v];                  
				         
                  if (busca != -1 && cores[busca] == WHITE){
                            distancia[busca] = distancia[buscaU]+1;							                             
                            cores[busca] = CRAY;                                                        
                            fila.push(v);
                            
                  }                  
          }
          cores[buscaU] = BLACK;
     }   

}
int main(){
    Digrafo G = initDigrafo();;
	
	
	G=insertVertice(G,1);
	G=insertVertice(G,2);
	G=insertArco(G,1,2);		
	printDigrafo(G);

    return 0;
}
        
       
