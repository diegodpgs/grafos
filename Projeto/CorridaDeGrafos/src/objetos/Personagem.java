/*
 *CORRIDA DE GRAFOS
 *
 * Escrito por Diego Pedro para a disciplina de Teoria Dos Grafos 2009.2
 */


package objetos;

import config.DadosDeConfiguracao;
import graphs.*;
/**
 *
 * @author Cefet-pb
 */
public class Personagem {
    
    //habilidades dos personagens    
    DadosDeConfiguracao config = new DadosDeConfiguracao();  
    private String nome; //nome do personagem   
    private int movimentos= config.NUMERO_DE_MOVIMENTOS;
    private int cotaPesos = config.COTA_DE_PESOS;
    private int positionAtual[] = new int [2]; //coluna linha
    private int life;
    private boolean ativo = false;   //se personagem esta ativo ou nao
    private Dijkistra dijkistra;
    private String imagem;
    private String imagem_caminho_percorrido;
    private String eficienciaMenorCaminho;
    public final int destino;
    
      
    
    
    //constror da classe personagem
    public Personagem(String nome, String imagem, int posX, int posY
                     , int destino, String imagem_caminho_percorrido )
    {        
        this.nome = nome;
        this.imagem = imagem;
        positionAtual[0] = posX;//posicao inicial da coluna do campo do personagem
        positionAtual[1] = posY;//posicao inicial da linha  do campo do personagem
        this.ativo = false;
        this.destino = destino;
        this.imagem_caminho_percorrido = imagem_caminho_percorrido;
        this.life = 250;//DadosDeConfiguracao.VALOR_MAXIMO_LIFE;
    }


    public int getMovimentosRestantes() {        
        return movimentos;
    }
    
    public void setMovimentosRestantes(int move) {
         
         if(move >=0)
         this.movimentos = move;
    }

    public int[] getPositionAtual() {
        return positionAtual;
    }

    public void setPositionAtual(int[] positionAtual) {
        this.positionAtual = positionAtual;
    }
    
    
    public int getX() {
         return this.positionAtual[0];  
    }
    
     public int getY() {
         return this.positionAtual[1];  
    }
     
     public void setX(int x) {
         
         if(x>=0 && x < config.SIZE_COLUNA)           
         this.positionAtual[0] = x;  
    }
     
    public void setY(int y) {
         if(y>=0 && y < config.SIZE_LINHA) 
         this.positionAtual[1] = y;  
    }
    
    //retorna situação do jogador
    public boolean getAtivo()
    {
       return ativo;
    }
    //configura situação do jogador
    public void setAtivo(boolean situacao)
    {
       //personagem foi desabilitado renova movimento para 6, a afim de fazer
        //a próxima jogada      
       this.ativo = situacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getCotaPesos() {
        return cotaPesos;
    }

    public void setCotaPesos(int cotaPesos) {
        this.cotaPesos = cotaPesos;
    }

    public Dijkistra getDijkistra() {
        return dijkistra;
    }

    public void setDijkistra(Dijkistra dijkistra) {
        this.dijkistra = dijkistra;
    }
    
    public String getImagemCaminhoPercorrido() {
        return  imagem_caminho_percorrido;
    }
    
    public void setLife(int life){
        this.life = life;
    }
    
    public int getLife(){
        return life;
    }
    
    public void setEficienciaMenorCaminho(String nivel){
        this.eficienciaMenorCaminho = nivel;
    }
    
    public String getEficienciaMenorCaminho(){
        return eficienciaMenorCaminho;
    }
    
    
}
