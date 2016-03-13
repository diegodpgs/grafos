/*
 *CORRIDA DE GRAFOS
 *
 * Escrito por Diego Pedro para a disciplina de Teoria Dos Grafos 2009.2
 */


package objetos;

import javax.swing.ImageIcon;
import config.DadosDeConfiguracao;

/**
 *
 * @author cefet
 */
public class Campo {
    
 private int x,y;
 private String caminho;
 private String tipo;
 private ImageIcon imagem;
 private int peso;
 private int fluxo;
 private int BFS;
 
 public Campo(int x, int y, int peso, String tipo, String caminho, ImageIcon imagem)
 {
      this.x = x;
      this.y = y;
      this.tipo = tipo;
      this.caminho = caminho;
      this.setPeso(peso);
      this.imagem = imagem;
 
 }
 public Campo(){}

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ImageIcon getImagem() {
        return imagem;
    }

    public void setImagem(ImageIcon imagem) {
        this.imagem = imagem;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    public int getBFS() {
        return BFS;
    }

    public void setBFS(int BFS) {
        this.BFS = BFS;
    }
    
     public int getFluxo() {
        return fluxo;
    }

    public void setFluxo(int fluxo) {
        this.fluxo = fluxo;
    }
    
     public int getDano() {
       // System.out.println("BFS : "+BFS+" FLUXO : "+fluxo);
     if(BFS == 0){
           
           if(fluxo >= 18 
                   && fluxo< 27)
               return (18+fluxo)/2;       
           else if(fluxo >= 27
                   && fluxo < 36)
               return (27+fluxo)/2;
           else if(fluxo >= 36) 
              return  (36+fluxo)/2;         
     }
     
     return BFS;
       
    }
 
  
 
}
