/*
 *CORRIDA DE GRAFOS
 *
 * Escrito por Diego Pedro para a disciplina de Teoria Dos Grafos 2009.2
 */


package configuracao;

import java.util.List;
import java.util.ArrayList;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import config.DadosDeConfiguracao;
import graphs.*;
import objetos.*;
import nucleo.Kernel;

/**
 *
 * @author cefet
 */
public class movimentaCorredor {

  //instancia a classe Kernel para utilizar o path sem qualquer 
   //dano,modificação, ou acesso do Kernel original
    
  private DadosDeConfiguracao config = new DadosDeConfiguracao();  
  //pega o caminho
  private List shortPath;  
  private Campo campos[][];
  private Component componetesDoTabuleiro[][];
  private int indiceNoCaminho = 0;  
  private BFS bfs;
    //verifica se o posicionamento do vetor foi violado  
 
  public movimentaCorredor(Campo campos[][],Component componentes[][]){
      this.campos = campos;
      this.componetesDoTabuleiro = componentes;
  }

  public void refleshImages(int antX,int antY,Personagem jogador){ 
      
         JLabel aux; 
         aux = (JLabel)componetesDoTabuleiro[antX][antY]; //cast para acessar o Label da tabela        
         ImageIcon auxIMG2 = new ImageIcon("C:\\CorridaDeGrafos\\src\\IMG\\"+jogador.getImagemCaminhoPercorrido());
         aux.setIcon(auxIMG2);        
         //muda a casa a qual o personagem se movimentará para a sua imagem
         //muda referencia para posicao atual
          aux = (JLabel)componetesDoTabuleiro[jogador.getX()][jogador.getY()];
         
         //cria uma variavel temporarea imagem 
         auxIMG2 = new ImageIcon("C:\\CorridaDeGrafos\\src\\IMG\\"+jogador.getImagem()); 
                
         aux.setIcon(auxIMG2);          
         
  }
  
  public void movimenta(String movimento, Personagem jogador)
  {
        //recebe o jogador que está no controle       
        int ant[] = new int[2];
       
        //jogador.getDijkistra().printPath();
        ant[0] = jogador.getX();//recebe posicaoX atual do jogador ativo
        ant[1] = jogador.getY();//recebe posicaoY atual do jogador ativo
        
              
         
         
         int peso = campos[jogador.getX()][jogador.getY()].getPeso();
         int fluxo = campos[jogador.getX()][jogador.getY()].getFluxo();
         int erupcao = campos[jogador.getX()][jogador.getY()].getBFS();
         int life;
         
        
         life = campos[jogador.getX()][jogador.getY()].getDano();
         
         if(jogador.getMovimentosRestantes() >= peso+fluxo){ 
            //deixa os arcos que saem do vertice onde o atual se encontra
            //em infinito na matriz de pesos do corretor atual         
            ((Graph)jogador.getDijkistra()).insereAdjacentes(jogador.getDijkistra(),ant[1],ant[0], jogador.getDijkistra().OO);  
            //exclui o pai do nodo origem            
            jogador.setMovimentosRestantes(jogador.getMovimentosRestantes()-peso-fluxo ); 
            //tira life
            jogador.setLife(jogador.getLife()-life);

            //tipo de personagem  tecla <== ESQUERDA
            if(movimento.equals("LEFT")) 
                       jogador.setX(jogador.getX()-1);         

              //tipo de personagem  tecla ^CIMA       
            if(movimento.equals("UP")) 
                       jogador.setY(jogador.getY()-1);  

              //tipo de personagem  tecla ==>DIREITA   
             if(movimento.equals("RIGHT")) 
                       jogador.setX(jogador.getX()+1); 

              //tipo de personagem  tecla BAIXO   
            if(movimento.equals("DOWN")) 
                       jogador.setY(jogador.getY()+1);         

            refleshImages(ant[0],ant[1],jogador);           
         }      
       
    }
    
    /**
     *Move corredor do seu local ate o destino pelo menor caminho, equanto
     *haver saldo de movientos
     */
    public void moveCorredorAutomatico(Personagem player, BFS bfs) throws Exception{
        this.bfs = bfs;
        int loops = 0;
        if(player == null) throw new Exception("Foi passado um jogador nulo "
                                               +" para mover no tabuleiro");
        
        indiceNoCaminho = 0;
        //pega o peso do nodo atual
        int pesoDoCampo = campos[player.getX()][player.getY()].getPeso();     
        int nodo = DadosDeConfiguracao.matTOlin(player.getY(), player.getX());                          
        
        player.getDijkistra().setNivel(player.getEficienciaMenorCaminho());       
        player.getDijkistra().dijkistra(nodo,player.destino,bfs);
        List caminho = player.getDijkistra().getPath();
      
             
        //enquanto o corredor poder se mover
        try{
                    moverCorredor(player, caminho, nodo);
                    
                    while( moverCorredor(player, caminho, nodo)  
                            && player.destino != nodo
                            && caminho.size() >= indiceNoCaminho){

                        loops += 1;
                        if(loops > (DadosDeConfiguracao.SIZE_COLUNA*DadosDeConfiguracao.SIZE_LINHA)+1)
                            throw new Exception("Ficou em loop infinito");
                        nodo = DadosDeConfiguracao.matTOlin(player.getY(), player.getX());  
                    }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
   
    private boolean moverCorredor(Personagem player, List caminho, int vertice) throws Exception{
            int linha = vertice / DadosDeConfiguracao.SIZE_COLUNA;            
            int coluna = vertice % DadosDeConfiguracao.SIZE_COLUNA;
                    
            
            if(linha != player.getY() 
               || coluna != player.getX())
                 throw new Exception("Indices diferentes"
                         +" Linha convertida "+linha+"<>"+player.getY()
                         +" Linha player" 
                         +"\nColuna convertida "+coluna+"<>"+player.getX()
                         +" Coluna player");
                        
            int verticeNoCaminho = (Integer)caminho.get(caminho.size()-1-indiceNoCaminho);  
            indiceNoCaminho += 1;
            
          
           //se o nodo no caminho esta do lado direito
           if(vertice+1 == verticeNoCaminho)
                     movimenta("RIGHT",player);
           //se o nodo no caminho esta do lado esquerdo
           else if (vertice-1 == verticeNoCaminho)
                     movimenta("LEFT",player);
           //se o nodo no caminho esta abaixo
           else if (vertice > verticeNoCaminho)
                     movimenta("UP",player);
           //se o nodo no caminho esta acima
           else if (vertice  < verticeNoCaminho)
                     movimenta("DOWN",player);  
           else{
                return false;
           }
           
                   
           return true;
    }
  
}
