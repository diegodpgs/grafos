/*
 *CORRIDA DE GRAFOS
 *
 * Escrito por Diego Pedro para a disciplina de Teoria Dos Grafos 2009.2
 */

package nucleo;


import configuracao.movimentaCorredor;
import java.util.List;
import objetos.*;
import graphs.Dijkistra;
import configuracao.configuraJogo;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import telas.Tabuleiro;
import config.DadosDeConfiguracao;

/**
 *
 * @author cefet
 */
public class Kernel {
    
  //armazena posição dos personagens  
  
  //caminho onde se encontra todas as imagens  
  DadosDeConfiguracao config = new DadosDeConfiguracao();  
  private Campo campos[][];  
  private Integer matrizDePesos[][];
  private ImageIcon imgAntPlayer1;
  private ImageIcon imgAntPlayer2;
  private Personagem controle;
  private Personagem player1,player2;
  private int tecla;
  private movimentaCorredor movimentaPlayer;
  private Component componentes[][]; 
  private configuraJogo configJogo;
  private JLabel labelNomePersonagem;
  private JLabel labelMovimentos;
  private JLabel labelCotas;
  private JLabel lLife;
  private String jogadorVersus; 
  public Kernel(){     
  }
  
  public Kernel(configuraJogo configJogo, Component componentes[][],Personagem player1,
          Personagem player2, JLabel labelNomePersonagem, JLabel labelMovimentos,
          JLabel labelCotas, JLabel lLife)
  {
     
     configJogo.inicializa(componentes);     
     this.player1 = player1;   
     this.player2 = player2;
     this.labelNomePersonagem = labelNomePersonagem;
     this.labelMovimentos = labelMovimentos;
     this.labelCotas = labelCotas;
     this.configJogo = configJogo;
     this.lLife = lLife;
     //recebe matrizes do jogo
     setCampos(configJogo.getCampos());
     this.movimentaPlayer = new movimentaCorredor(getCampos(), componentes);
     this.componentes = componentes;  
     this.jogadorVersus = jogadorVersus;     
     
     inicializaPersonagens();
    }
  
    private void inicializaPersonagens(){
         
             //configura as imagens dos persoangens
         //////////////////////////////////////////////////////////////  
         imgAntPlayer1 = new ImageIcon(config.CAMINHO+config.IMGP1);
         imgAntPlayer2 = new ImageIcon(config.CAMINHO+config.IMGP2);  
         JLabel auxLabel = new JLabel();
         auxLabel = (JLabel)componentes[0][0];
         auxLabel.setIcon(imgAntPlayer1); 
         auxLabel = (JLabel)componentes[config.SIZE_COLUNA-1][config.SIZE_LINHA-1];
         auxLabel.setIcon(imgAntPlayer2);  
         atualizaInformacoesDeJogo(player1);
         //inicializa personagem    
         player1.setAtivo(true);     
         controle = player1;
         
        try{
             this.player1.setDijkistra(new Dijkistra(config.SIZE_COLUNA*config.SIZE_LINHA,
                                                    configJogo.getDijkistra().getMatrizDePesos()));
             this.player2.setDijkistra(new Dijkistra(config.SIZE_COLUNA*config.SIZE_LINHA,
                                                    configJogo.getDijkistra().getMatrizDePesos()));
         }catch(Exception ex){
             System.out.println(ex.getMessage());
         }   
    }
  
    
    private void atualizaInformacoesDeJogo(Personagem control){
         this.labelCotas.setText(String.valueOf(control.getCotaPesos()));
         this.labelMovimentos.setText(String.valueOf(control.getMovimentosRestantes()));
         this.labelNomePersonagem.setText(control.getNome());
         this.lLife.setText(String.valueOf(control.getLife()));
    }
    
    public void mudaControle(Personagem controleAtual)
    {
                
       //passa o controle para player 2
       if (controleAtual.getNome().equals(player1.getNome())){           
           player2.setCotaPesos(player2.getCotaPesos()+config.COTA_DE_PESOS);           
           player2.setMovimentosRestantes(player2.getMovimentosRestantes()+config.NUMERO_DE_MOVIMENTOS);//esta contando decrementando um movimento            
           player1.setAtivo(false);
           player2.setAtivo(true);
           atualizaInformacoesDeJogo(player2);
           //atualiza a cota de pesos do personagem           
           //a mais se ter tempo resolver isto o problem esta na classe
           //movimentaPersonagem acredito
           controle = player2;
          
           this.tecla = 0; //evita que a tecla pressionada execute metodos 
           //do próximo jogador
           
        } 
       else{           
           player1.setCotaPesos(player1.getCotaPesos()+config.COTA_DE_PESOS);           
           player1.setMovimentosRestantes(player1.getMovimentosRestantes()+config.NUMERO_DE_MOVIMENTOS); //esta contando decrementando um movimento 
           atualizaInformacoesDeJogo(player1);
           player2.setAtivo(false);
           player1.setAtivo(true);
            //atualiza a cota de pesos do personagem           
           //a mais se ter tempo resolver isto o problem esta na classe
           //movimentaPersonagem acredito
           controle = player1;
           this.tecla = 0;//evita que a tecla pressionada execute metodos 
           //do próximo jogador
       }
       
    }
    public boolean finish(Personagem player, int destino){
        int nodo =-1;
        try{
            nodo = DadosDeConfiguracao.matTOlin(player.getY(),player.getX());         
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return  (nodo == destino) && (player.getLife() > 0);
    }
    
    public void jogarUmaRodada() 
    {       
        if(player1.getLife() <= 0){
            JOptionPane.showMessageDialog(null,player1.getNome()
                 +"**MORREU**");
            return;
        }
        
        if(player2.getLife() <= 0){
            JOptionPane.showMessageDialog(null,player2.getNome()
                 +"**MORREU**");
            return;
        }
            
        if (finish(player1,DadosDeConfiguracao.VERTICE_DESTINO_PLAYER_1)){
            JOptionPane.showMessageDialog(null, player1.getNome() + " Venceu! Fim de Jogo!");
          
            
        }
        else if (finish(player2,DadosDeConfiguracao.VERTICE_DESTINO_PLAYER_2)){
            JOptionPane.showMessageDialog(null, player2.getNome() + " Venceu! Fim de Jogo");
            
            
        } else {
            if(tecla == config.KEY_SAIR_PLAYER){ 
                try{                                
                    movimentaPlayer.moveCorredorAutomatico(controle, configJogo.getBFS());
                }catch(java.lang.OutOfMemoryError ex){
                    JOptionPane.showMessageDialog(null, controle.getNome()+" ficou preso",
                                                  " Fim de Jogo",2);
                    return;
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
                mudaControle(controle);
            }
            //movimentacao com o controle
            else if(!controle.getNome().equals("Alan Mathisson Turing"))               
                switch(tecla){
                    case DadosDeConfiguracao.KEY_LEFT_PLAYER :
                         movimentaPlayer.movimenta("LEFT", controle);break;
                    case DadosDeConfiguracao.KEY_RIGHT_PLAYER:
                         movimentaPlayer.movimenta("RIGHT", controle);break;
                    case DadosDeConfiguracao.KEY_UP_PLAYER :
                         movimentaPlayer.movimenta("UP", controle);break;
                    case DadosDeConfiguracao.KEY_DOWN_PLAYER :
                         movimentaPlayer.movimenta("DOWN", controle);break;
                }
            
                
        }
        
        atualizaInformacoesDeJogo(controle);
    }
    
 
    public ImageIcon getImgAntPlayer1() {
        return imgAntPlayer1;
    }

    public void setImgAntPlayer1(ImageIcon imgAntPlayer1) {
        this.imgAntPlayer1 = imgAntPlayer1;
    }

    public ImageIcon getImgAntPlayer2() {
        return imgAntPlayer2;
    }

    public void setImgAntPlayer2(ImageIcon imgAntPlayer2) {
        this.imgAntPlayer2 = imgAntPlayer2;
    }

    public Personagem getControle() {        
        return controle;
    }

    public void setControle(Personagem controle) {
        this.controle = controle;
    }

    public Personagem getPlayer1() {
        return player1;
    }

    public void setPlayer1(Personagem player1) {
        this.player1 = player1;
    }

    public Personagem getPlayer2() {
        return player2;
    }

    public void setPlayer2(Personagem player2) {
        this.player2 = player2;
    }

    public int getTecla() {
        return tecla;
    }

    public void setTecla(int tecla) {      
        this.tecla = tecla;
    }

    public Campo[][] getCampos() {
        return campos;
    }

    public void setCampos(Campo[][] campos) {
        this.campos = campos;
    }

    public Integer[][] getMatrizDePesos() {
        return matrizDePesos;
    }

    public void setMatrizDePesos(Integer[][] matrizDePesos) {
        this.matrizDePesos = matrizDePesos;
    }
    

}
