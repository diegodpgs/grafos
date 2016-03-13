/*
 *CORRIDA DE GRAFOS
 *
 * Escrito por Diego Pedro para a disciplina de Teoria Dos Grafos 2009.2
 */

package configuracao;
import objetos.*;
import graphs.*;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.Random;
import config.DadosDeConfiguracao;
/**
 *
 * @author cefet
 */
public class configuraJogo {
    DadosDeConfiguracao config = new DadosDeConfiguracao();  
    private Campo campos[][] = new Campo[config.SIZE_COLUNA][];   
    private Integer tabelaEnchente[][];
    private Dijkistra dij;
    private FordFulkerson ford; 
    private BFS erupcoes;
    private Integer[][] matrizErupcoes = new Integer[config.SIZE_COLUNA][];
    
    private Random gerador= new Random();
    
    
    public configuraJogo(){
        for(int col = 0; col < config.SIZE_COLUNA; col++){
            campos[col]= new Campo[config.SIZE_LINHA];              
        }
        try{
               setDijkistra(new Dijkistra(config.SIZE_COLUNA*config.SIZE_LINHA)); 
               setFulkerson(new FordFulkerson(config.SIZE_COLUNA*config.SIZE_LINHA));
               erupcoes = new BFS(DadosDeConfiguracao.NUMERO_DE_NODOS);
               tabelaEnchente = new Integer[DadosDeConfiguracao.SIZE_COLUNA][];
               for(int i = 0 ; i < DadosDeConfiguracao.SIZE_COLUNA ; i++)
                    tabelaEnchente[i] = new Integer[DadosDeConfiguracao.SIZE_COLUNA];
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }    
    }
        
    //inicializa a matriz
    //ESTE MÉTODO SÓ SER�? USADO APENAS UMA VEZ
    public void inicializa(Component [][]componentes)
    {
      
          for (int coluna = 0; coluna  < config.SIZE_COLUNA ; coluna++)
           {
              
              for (int linha = 0; linha < config.SIZE_LINHA; linha++)
              {
                 int numeroPesoGerado = gerador.nextInt(config.VALOR_MAXIMO_PESO)+1;
                 int F_MATRIZ_TO_LINEAR = -1;
                 
                 try{       
                    F_MATRIZ_TO_LINEAR = DadosDeConfiguracao.matTOlin(linha,coluna);
                 }catch(Exception ex){
                     System.out.println(ex.getMessage());
                 }

                 //posicao x : posicao y : peso : tipo de campo : caminho para imagem
                 Campo campo = new Campo(coluna*46+1,linha*46+1,numeroPesoGerado,"AREIA",
                         config.CAMINHO+"AREIA", new ImageIcon(config.CAMINHO+"AREIA.jpg"));              

                 //insere os adjacentes do nodo atual na matriz de adjacencia

                 getCampos()[coluna][linha] = campo;           
                 dij.insereAdjacentes((Graph)getDijkistra(), linha, coluna, numeroPesoGerado);                 
                 JLabel aux =(JLabel)componentes[coluna][linha];             

                  //inicializa a coordenada do campo
                 aux.setLocation(getCampos()[coluna][linha].getX(), getCampos()[coluna][linha].getY());
                  //inicializa a imagem do campo             
                 aux.setIcon(getCampos()[coluna][linha].getImagem());
                 //configura pesos
                 aux.setText(String.valueOf(getCampos()[coluna][linha].getPeso()));

             }
          } 
          ford.setMatrizDePesos(dij.getMatrizDePesos());
          erupcoes.setMatrizDePesos(dij.getMatrizDePesos());
         // System.out.println("---------------BFS-BFS-BFS-BFS-BFS--------------\n\n\n");
        try {
            erupcoes.printMatriz();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
       
    
    }
    /**
     *Configura o campo de fluxo que representara a enchente
     *os valores dos campos 9x17 sera a soma de todos os fluxos que chega
     *ao nodo     
     */
    public void configTabelaDeFluxo(FordFulkerson ford){
        
        //roda o fluxo m�ximo
        //System.out.println(ford.fordFulkerson(0,5));
        /*try {
            ford.printMatriz();
        } catch (Exception ex) {
            ex.printStackTrace();
        }*/
        //faz a soma dos valores
        for(int j = 0 ; j < ford.getNUMERO_DE_NODOS() ; j++){
             int fluxoIn = 0;            
             for(int i = 0 ; i < ford.getNUMERO_DE_NODOS() ; i++){                         
                 if(ford.getMatrizDePesos()[j][i] != ford.OO)
                     fluxoIn += ford.getMatrizDePesos()[j][i];
                // System.out.println("fluxo In "+fluxoIn);
             }
             
             int linha  = j / DadosDeConfiguracao.SIZE_COLUNA;
             int coluna = j % DadosDeConfiguracao.SIZE_COLUNA;
             //armaze o fluxoin no indice especifico
             
             getCampos()[coluna][linha].setFluxo(fluxoIn);
             tabelaEnchente[coluna][linha] = fluxoIn;
         }                
    }
    
    
    private void configuraTabelaErupcoes(){
        
       
        //faz a soma dos valores
        for(int j = 0 ; j < DadosDeConfiguracao.NUMERO_DE_NODOS ; j++){                       
             for(int i = 0 ; i < DadosDeConfiguracao.NUMERO_DE_NODOS ; i++){                         
                 if(erupcoes.getMatrizDePesos()[j][i] != 0)
                       erupcoes.getMatrizDePesos()[j][i] = 1;              
             }
           
         }                
  
    }
        
    public Integer[][] getMatrizDeErupcoes(String dificuldade){
        configuraTabelaErupcoes();
       
        for(int i = 0 ; i < DadosDeConfiguracao.SIZE_COLUNA ; i++){
            matrizErupcoes[i] = new Integer[DadosDeConfiguracao.SIZE_LINHA];
            for(int j = 0 ; j < DadosDeConfiguracao.SIZE_LINHA ; j++)
                matrizErupcoes[i][j] = 0;
        }
          
        //System.out.println("BREAKPOINT-0----------------------------------------------------------------------------------");        
        try {         
          
            int ecentridade = 0;
            int NumeroDeErupcoes = 0;
            
            if(dificuldade.equals("FACIL")){
                ecentridade = 4;
                NumeroDeErupcoes = 2;
            }
            else if(dificuldade.equals("NORMAL")){
                ecentridade = 5;
                NumeroDeErupcoes = 3;
            }
            else {
                ecentridade = 6;
                NumeroDeErupcoes = 4;
            }
           // System.out.println("BREAKPOINT-2----------------------------------------------------------------------------------");
            for(int i = 0 ; i < NumeroDeErupcoes ; i++)
                 matrizErupcoes = erupcoes.getErupcoes(gerador.nextInt(DadosDeConfiguracao.NUMERO_DE_NODOS)-1,
                                              ecentridade,matrizErupcoes);
            //System.out.println("BREAKPOINT-3----------------------------------------------------------------------------------"); 
        } catch (Exception ex) {
            System.out.println("Falha ao retornar a matriz de erupcoes "
                               +"Memoria  : "+matrizErupcoes);
        }
       
       for(int i = 0 ; i < DadosDeConfiguracao.SIZE_COLUNA ; i++){           
            for(int j = 0 ; j < DadosDeConfiguracao.SIZE_LINHA ; j++)
               campos[i][j].setBFS(matrizErupcoes[i][j]);
        }
       return matrizErupcoes;
    }
    
    public Campo[][] getCampos() {
        return campos;
    }
   
    public void setCampos(Campo[][] campos) {
        this.campos = campos;
    }

    public Dijkistra getDijkistra() {        
        return dij;
    }

    public void setDijkistra(Dijkistra dij) {
        this.dij = dij;
    }
    
    public FordFulkerson getFulkerson() {        
        return ford;
    }
    
    public BFS getBFS() {        
        return erupcoes;
    }

    public void setFulkerson(FordFulkerson ford) {
        this.ford = ford;
    }
    
    public Integer[][] getMatrizFluxo(){
        configTabelaDeFluxo(ford);        
        return tabelaEnchente;
    }
    
}
