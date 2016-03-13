/**
 *   BFS 
 *   ESTÁTICO
 *   MESMAS CARACTERISTICAS DE IMPLEMENTAÇÃO DE DIJKSTRA
 *   FUNCIONA PARA GRAFOS DIRIGIDOS
 * 
 */
  
#include<iostream>
#include<stack>
#include<queue>
#include<string.h>
#define MAX 100
#define WHITE 0
#define CRAY  1
#define BLACK 2
#define CONECTADO 1
using namespace std;


int G[MAX][MAX];
int cor[MAX];
int V, E;
int distancias[MAX];
int predecessor[MAX];

void bfs(int s) {
     int i, node;
	 queue<int> myStack;
     memset(cor, WHITE, sizeof(cor));
	 memset(distancias, 0, sizeof(distancias));	 
     memset(predecessor, 0, sizeof(predecessor));	 
	 //inicia a distancia
	 distancias[s] = 0;
	 myStack.push(s);
	 
     while(!myStack.empty())
     {
          node = myStack.back();
          myStack.pop();
          
          for(i=0; i<= V; i++){
               if(G[node][i]==CONECTADO){
				   //pinta vertice adjacente ao vertice nodo
				   //caso nao tenha lido				   
				   if(cor[i]==WHITE){
					    cor[i] = CRAY;
					    predecessor[i] =node;
						distancias[i] += distancias[node] + 1;
					    myStack.push(i);
				   }
			   }
		  }
		  cor[node] = BLACK;
     }
     
}

int main() {
    memset(cor, WHITE, sizeof(cor));
	V = 10;
	E = 6;
	G[1][2] = CONECTADO;	
	G[2][5] = CONECTADO;
	G[7][4] = CONECTADO;
	
	G[7][2] = CONECTADO;

	G[4][6] = CONECTADO;
	
	G[3][4] = CONECTADO;
	G[8][9] = CONECTADO;


	
	
    bfs(3);
	cout<<"distancia de 1 a :"<<endl;
	for(int i = 0 ; i <= V ; i++)
	    cout<<i<<" : "<<distancias[i]<<"predecessor : "<<predecessor[i]<<endl; 	
	
    system("pause");
    return 0;
}
