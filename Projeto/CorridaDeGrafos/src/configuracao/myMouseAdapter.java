/*
 *CORRIDA DE GRAFOS
 *
 * Escrito por Diego Pedro para a disciplina de Teoria Dos Grafos 2009.2
 */


package configuracao;
import config.DadosDeConfiguracao;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import nucleo.Kernel;
import objetos.*;

/**
 *
 * @author Diego
 */
public class myMouseAdapter extends MouseAdapter {    

    private Campo[][] campos;
    private configuraJogo configT;   
    private Personagem player1;
    private Personagem player2;
    private int coluna;
    private int linha;
    private JLabel campo;
    private JLabel lCotas;
    
    
    public myMouseAdapter(configuraJogo configTab, Personagem player1,Personagem player2,
                         JLabel label, JLabel labelCotas, int linha, int coluna){        
        configT = configTab; 
        this.player1 = player1;
        this.player2 = player2;
        this.coluna = coluna;
        this.linha = linha;
        campo = label;
        lCotas = labelCotas;
        
    }
    
    public void mouseClicked(MouseEvent e){
          Personagem jogador = player1;
          Integer pesoNovo=0;
          if(player2.getAtivo()==true)
              jogador = player2;
          
          try{
                 String str = JOptionPane.showInputDialog(null, "Entre com o novo valor do peso do Campo : ", 
                                         "Mudanca de peso de Campo : "+jogador.getNome(), 1);
                 pesoNovo = Integer.parseInt(str);   
          }catch(Exception ex){
              return;
          }
          
                 
          int cotaUsada = configT.getCampos()[coluna][linha].getPeso()-pesoNovo;
          
          //gambiarra do absm
          if(configT.getCampos()[coluna][linha].getPeso() < pesoNovo)
              cotaUsada *= -1;
                 
          if(pesoNovo >0 
                  && cotaUsada > 0
                  && cotaUsada <= jogador.getCotaPesos()
                  && pesoNovo <= new DadosDeConfiguracao().VALOR_MAXIMO_PESO){
              
                configT.getCampos()[coluna][linha].setPeso(pesoNovo);
                //modifica o texto do campo a qual foi clicado com o mouse
                campo.setText(String.valueOf(pesoNovo));    
                
                
                jogador.setCotaPesos(jogador.getCotaPesos()- cotaUsada);
                lCotas.setText(String.valueOf(jogador.getCotaPesos()));
                player1.getDijkistra().insereAdjacentes(player1.getDijkistra(), linha, coluna, pesoNovo);
                player2.getDijkistra().insereAdjacentes(player2.getDijkistra(), linha, coluna, pesoNovo);
                              
          }
          else if(pesoNovo<=0 || pesoNovo > new DadosDeConfiguracao().VALOR_MAXIMO_PESO)
              JOptionPane.showMessageDialog(null,"Os pesos dos campos devem ser entre 1 e 10");
    }
    
}
