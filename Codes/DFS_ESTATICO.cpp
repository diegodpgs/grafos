#include<iostream>
#include<queue>
#define MAX 100
#define WHITE 0
#define CRAY  1
#define BLACK 2
#define CONECTADO 1
using namespace std;

int G[MAX][MAX];
int tempoDecorrido[MAX][2];
int V, E;
int cores[MAX];
int timeT = 1;
int predecessor[MAX];

bool visitaDFS(int v, int u){
     cores[v] = CRAY;
     timeT += 1;     
     tempoDecorrido[v][0] = timeT;
     cout<<"visitaDFS("<<v<<") : "<<tempoDecorrido[v][0]<<"/?"<<endl;
     for(int i = 1 ; i < V ; i++){
          //cout<<v<<" : "<<i<<" "<<G[v][i]<<"cores "<<cores[i]<<endl; 
          if(i == v) return true;  
          if(G[v][i] == CONECTADO && cores[i] == WHITE){
                     predecessor[i] = v;
                     visitaDFS(i,u);      
          }
            
     }
     cores[v]= BLACK;
     timeT += 1;
     tempoDecorrido[v][1] = timeT;
     cout<<"return visitaDFS("<<v<<") : "<<tempoDecorrido[v][0]<<"/"<<tempoDecorrido[v][1]<<endl;     
     return false;
}
            
      
bool dfs(int s, int u) {
     int i, j, node;     

     memset(cores, WHITE, sizeof(cores));
     cores[s] = CRAY;
     tempoDecorrido[s][0] = 1; 
     for(i=1; i<V; i++){
          cout<<i<<endl;          
          if(G[s][i] == CONECTADO && cores[i] == WHITE){
              predecessor[i] = s;            
              if(visitaDFS(i,u)) return true;
          }
          cout<<"desconectou"<<endl;
     }
     tempoDecorrido[s][1] = timeT+1;
     return false;
     
}

int main() {

    V=7;
    G[0][1] = CONECTADO; 
    G[1][0] = CONECTADO;
    G[1][2] = CONECTADO;
    G[2][1] = CONECTADO;
    G[3][4] = CONECTADO;
    G[4][3] = CONECTADO;
    G[5][6] = CONECTADO;
    G[6][5] = CONECTADO;
    
    
    
    cout<<dfs(0,6);
    for(int i = 1 ; i <= V ; i++)           {
          cout<<i<<" : "<<tempoDecorrido[i][0]<<"/"<<tempoDecorrido[i][1];
          cout<<" "<<predecessor[i]<<endl;
    }
    system("pause");
    return 0;
}

