/*
 *CORRIDA DE GRAFOS
 *
 * Escrito por Diego Pedro para a disciplina de Teoria Dos Grafos 2009.2
 */

package telas;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.ImageIcon;


import nucleo.Kernel;
import objetos.*;
import configuracao.configuraJogo;
import config.DadosDeConfiguracao;
import configuracao.myMouseAdapter;
/**
 *
 * @author  cefet
 */
public class Tabuleiro extends javax.swing.JFrame {
    
    private Personagem player1;
    private Personagem player2;
    private configuraJogo tabuleiroConfigurado = new configuraJogo(); 
    private Kernel jogo; //inicia jogo 
    private DadosDeConfiguracao config = new DadosDeConfiguracao();
    private Integer[][] camposFluxo;
    private Integer[][] camposErupcoes;
    private Component[][] componentesMatriz;
    private static int linha = 0;
    private static int coluna = 0;    

    /** Creates new form Tabuleiro */
    public Tabuleiro() {
        
        //cria a matriz que contem os valores da rede residual do fluxo
       /* for(int i = 0 ; i < DadosDeConfiguracao.SIZE_COLUNA ; i++){
            camposFluxo[i] = new Integer[DadosDeConfiguracao.SIZE_COLUNA*DadosDeConfiguracao.SIZE_LINHA];            
            for(int j = 0 ; j < DadosDeConfiguracao.SIZE_LINHA ; j++)
                camposFluxo[i][j] = 0;
        }*/
              
        initComponents();   
        componentesMatriz = getComponentes();
        jogo = new Kernel(tabuleiroConfigurado,componentesMatriz,player1, 
                          player2,LtipoPersonagem,Lmovimentos,cotaPesos, lLife); //inicia jogo 
        camposFluxo = tabuleiroConfigurado.getMatrizFluxo(); 
        //DIFICULDADE
        camposErupcoes = tabuleiroConfigurado.getMatrizDeErupcoes(player2.getEficienciaMenorCaminho());
        lNormal.setText(player2.getEficienciaMenorCaminho());
        System.out.println("PASSOU NO CONSTRUTOR");
        
          
    }
    
    public Tabuleiro(Personagem player1, Personagem player2){
        initComponents();
        
        this.player1 = player1;
        this.player2 = player2;
       
       
        componentesMatriz = getComponentes();
        jogo = new Kernel(tabuleiroConfigurado, componentesMatriz,player1, player2
                          ,LtipoPersonagem,Lmovimentos,cotaPesos, lLife); //inicia jogo 
         camposFluxo = tabuleiroConfigurado.getMatrizFluxo();
         camposErupcoes = tabuleiroConfigurado.getMatrizDeErupcoes(player2.getEficienciaMenorCaminho());
         System.out.println("\n....................................\n");
         System.out.println("\n....................................\n");
          
         for(int i = 0 ; i < DadosDeConfiguracao.SIZE_COLUNA ; i++)
             for(int j = 0 ; j < DadosDeConfiguracao.SIZE_LINHA ; j++)
                 System.out.println("coluna : "+i+" linha : "+j+" "+camposErupcoes[i][j]);
         
         lNormal.setText(player2.getEficienciaMenorCaminho());
         
       
     }
    
    //metÃ³do para pegar os componentes do Panel e passar para uma matriz
    
    //ESTE METODO SO SERA USADO APENAS UMA VEZ
    public Component[][] getComponentes()
    {     
       
       LtipoPersonagem.setText(player1.getNome());
       Lmovimentos.setText(String.valueOf(player1.getMovimentosRestantes()));
       cotaPesos.setText(String.valueOf(player1.getCotaPesos()));
       //recebe todos os componentes do Panel      
       Component[] componentes = painelCampos.getComponents();
       Component Aux [][] = new Component[config.SIZE_COLUNA][]; //cria uma matriz 
       
       linha  = 0; //variavel temporarea para criar a matriz
       coluna = 0; //variavel temporarea para criar a matriz
       
       for (int col = 0; col < config.SIZE_COLUNA; col++)
       {         
          Aux [col] = new Component[config.SIZE_LINHA]; 
       }
       
       for (int i = 0; i < componentes.length; i++)
       {      
              
              componentes[i].addMouseListener(new myMouseAdapter(tabuleiroConfigurado,player1,
                                                                 player2,(JLabel)componentes[i],
                                                                  cotaPesos,linha, coluna));
                      
                           

              Aux[coluna][linha] = componentes[i];    
              ((JLabel)componentes[i]).setText("00"); 
              ((JLabel)componentes[i]).setHorizontalTextPosition(0);
              coluna++;
              // para coordenar as posiÃ§Ãµes da matriz
              if (coluna == config.SIZE_COLUNA) 
              {
                  coluna = 0;
                  linha++;              
              }
       }
       
       return Aux; // retorna os componentes em uma matriz
       
    }
        
    
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Código Gerado ">//GEN-BEGIN:initComponents
    private void initComponents() {
        painelCampos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        jLabel163 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        jLabel166 = new javax.swing.JLabel();
        jLabel167 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        jLabel169 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        jLabel171 = new javax.swing.JLabel();
        jLabel172 = new javax.swing.JLabel();
        jLabel173 = new javax.swing.JLabel();
        jLabel174 = new javax.swing.JLabel();
        jLabel175 = new javax.swing.JLabel();
        jLabel176 = new javax.swing.JLabel();
        jLabel177 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Ljogador = new javax.swing.JLabel();
        LtipoPersonagem = new javax.swing.JLabel();
        jLabel243 = new javax.swing.JLabel();
        Lmovimentos = new javax.swing.JLabel();
        jLabel244 = new javax.swing.JLabel();
        cotaPesos = new javax.swing.JLabel();
        labell = new javax.swing.JLabel();
        lLife = new javax.swing.JLabel();
        labell1 = new javax.swing.JLabel();
        lNormal = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Menu = new javax.swing.JMenu();
        menuNovoJogo = new javax.swing.JMenuItem();
        menuPlayer1 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Corrida de Grafos");
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        painelCampos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        painelCampos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                painelCamposMouseMoved(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel9.setText("00");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel9.setVerifyInputWhenFocusTarget(false);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/FINAL_VERDE.JPG")));
        jLabel17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel21.setForeground(new java.awt.Color(204, 204, 204));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel22.setForeground(new java.awt.Color(204, 204, 204));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel23.setForeground(new java.awt.Color(204, 204, 204));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel23.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel24.setForeground(new java.awt.Color(204, 204, 204));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel24.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel25.setForeground(new java.awt.Color(204, 204, 204));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel25.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel26.setForeground(new java.awt.Color(204, 204, 204));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel26.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel27.setForeground(new java.awt.Color(204, 204, 204));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel27.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel28.setForeground(new java.awt.Color(204, 204, 204));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel28.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel29.setForeground(new java.awt.Color(204, 204, 204));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel29.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel30.setForeground(new java.awt.Color(204, 204, 204));
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel30.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel31.setForeground(new java.awt.Color(204, 204, 204));
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel31.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel32.setForeground(new java.awt.Color(204, 204, 204));
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel32.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel33.setForeground(new java.awt.Color(204, 204, 204));
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel33.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel34.setForeground(new java.awt.Color(204, 204, 204));
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel34.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel35.setForeground(new java.awt.Color(204, 204, 204));
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel35.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel36.setForeground(new java.awt.Color(204, 204, 204));
        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel36.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel37.setForeground(new java.awt.Color(204, 204, 204));
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel37.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel41.setForeground(new java.awt.Color(204, 204, 204));
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel41.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel42.setForeground(new java.awt.Color(204, 204, 204));
        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel42.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel43.setForeground(new java.awt.Color(204, 204, 204));
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel43.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel44.setForeground(new java.awt.Color(204, 204, 204));
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel44.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel45.setForeground(new java.awt.Color(204, 204, 204));
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel45.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel46.setForeground(new java.awt.Color(204, 204, 204));
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel46.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel47.setForeground(new java.awt.Color(204, 204, 204));
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel47.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel48.setForeground(new java.awt.Color(204, 204, 204));
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel48.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel49.setForeground(new java.awt.Color(204, 204, 204));
        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel49.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel50.setForeground(new java.awt.Color(204, 204, 204));
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel50.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel51.setForeground(new java.awt.Color(204, 204, 204));
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel51.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel52.setForeground(new java.awt.Color(204, 204, 204));
        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel52.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel53.setForeground(new java.awt.Color(204, 204, 204));
        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel53.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel54.setForeground(new java.awt.Color(204, 204, 204));
        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel54.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel55.setForeground(new java.awt.Color(204, 204, 204));
        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel55.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel56.setForeground(new java.awt.Color(204, 204, 204));
        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel56.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel57.setForeground(new java.awt.Color(204, 204, 204));
        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel57.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel61.setForeground(new java.awt.Color(204, 204, 204));
        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel61.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel62.setForeground(new java.awt.Color(204, 204, 204));
        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel62.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel63.setForeground(new java.awt.Color(204, 204, 204));
        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel63.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel64.setForeground(new java.awt.Color(204, 204, 204));
        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel64.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel65.setForeground(new java.awt.Color(204, 204, 204));
        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel65.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel66.setForeground(new java.awt.Color(204, 204, 204));
        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel66.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel67.setForeground(new java.awt.Color(204, 204, 204));
        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel67.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel68.setForeground(new java.awt.Color(204, 204, 204));
        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel68.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel69.setForeground(new java.awt.Color(204, 204, 204));
        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel69.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel70.setForeground(new java.awt.Color(204, 204, 204));
        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel70.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel71.setForeground(new java.awt.Color(204, 204, 204));
        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel71.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel72.setForeground(new java.awt.Color(204, 204, 204));
        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel72.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel73.setForeground(new java.awt.Color(204, 204, 204));
        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel73.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel74.setForeground(new java.awt.Color(204, 204, 204));
        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel74.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel75.setForeground(new java.awt.Color(204, 204, 204));
        jLabel75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel75.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel76.setForeground(new java.awt.Color(204, 204, 204));
        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel76.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel77.setForeground(new java.awt.Color(204, 204, 204));
        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel77.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel81.setForeground(new java.awt.Color(204, 204, 204));
        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel81.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel82.setForeground(new java.awt.Color(204, 204, 204));
        jLabel82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel82.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel83.setForeground(new java.awt.Color(204, 204, 204));
        jLabel83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel83.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel84.setForeground(new java.awt.Color(204, 204, 204));
        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel84.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel85.setForeground(new java.awt.Color(204, 204, 204));
        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel85.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel86.setForeground(new java.awt.Color(204, 204, 204));
        jLabel86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel86.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel87.setForeground(new java.awt.Color(204, 204, 204));
        jLabel87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel87.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel88.setForeground(new java.awt.Color(204, 204, 204));
        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel88.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel89.setForeground(new java.awt.Color(204, 204, 204));
        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel89.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel90.setForeground(new java.awt.Color(204, 204, 204));
        jLabel90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel90.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel91.setForeground(new java.awt.Color(204, 204, 204));
        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel91.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel92.setForeground(new java.awt.Color(204, 204, 204));
        jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel92.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel93.setForeground(new java.awt.Color(204, 204, 204));
        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel93.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel94.setForeground(new java.awt.Color(204, 204, 204));
        jLabel94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel94.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel95.setForeground(new java.awt.Color(204, 204, 204));
        jLabel95.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel95.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel96.setForeground(new java.awt.Color(204, 204, 204));
        jLabel96.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel96.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel97.setForeground(new java.awt.Color(204, 204, 204));
        jLabel97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel97.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel101.setForeground(new java.awt.Color(204, 204, 204));
        jLabel101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel101.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel102.setForeground(new java.awt.Color(204, 204, 204));
        jLabel102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel102.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel103.setForeground(new java.awt.Color(204, 204, 204));
        jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel103.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel104.setForeground(new java.awt.Color(204, 204, 204));
        jLabel104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel104.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel105.setForeground(new java.awt.Color(204, 204, 204));
        jLabel105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel105.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel106.setForeground(new java.awt.Color(204, 204, 204));
        jLabel106.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel106.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel107.setForeground(new java.awt.Color(204, 204, 204));
        jLabel107.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel107.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel108.setForeground(new java.awt.Color(204, 204, 204));
        jLabel108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel108.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel109.setForeground(new java.awt.Color(204, 204, 204));
        jLabel109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel109.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel110.setForeground(new java.awt.Color(204, 204, 204));
        jLabel110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel110.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel111.setForeground(new java.awt.Color(204, 204, 204));
        jLabel111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel111.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel112.setForeground(new java.awt.Color(204, 204, 204));
        jLabel112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel112.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel113.setForeground(new java.awt.Color(204, 204, 204));
        jLabel113.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel113.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel114.setForeground(new java.awt.Color(204, 204, 204));
        jLabel114.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel114.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel115.setForeground(new java.awt.Color(204, 204, 204));
        jLabel115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel115.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel116.setForeground(new java.awt.Color(204, 204, 204));
        jLabel116.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel116.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel117.setForeground(new java.awt.Color(204, 204, 204));
        jLabel117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel117.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel121.setForeground(new java.awt.Color(204, 204, 204));
        jLabel121.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel121.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel122.setForeground(new java.awt.Color(204, 204, 204));
        jLabel122.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel122.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel123.setForeground(new java.awt.Color(204, 204, 204));
        jLabel123.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel123.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel124.setForeground(new java.awt.Color(204, 204, 204));
        jLabel124.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel124.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel125.setForeground(new java.awt.Color(204, 204, 204));
        jLabel125.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel125.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel126.setForeground(new java.awt.Color(204, 204, 204));
        jLabel126.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel126.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel127.setForeground(new java.awt.Color(204, 204, 204));
        jLabel127.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel127.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel128.setForeground(new java.awt.Color(204, 204, 204));
        jLabel128.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel128.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel129.setForeground(new java.awt.Color(204, 204, 204));
        jLabel129.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel129.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel130.setForeground(new java.awt.Color(204, 204, 204));
        jLabel130.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel130.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel131.setForeground(new java.awt.Color(204, 204, 204));
        jLabel131.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel131.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel132.setForeground(new java.awt.Color(204, 204, 204));
        jLabel132.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel132.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel133.setForeground(new java.awt.Color(204, 204, 204));
        jLabel133.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel133.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel134.setForeground(new java.awt.Color(204, 204, 204));
        jLabel134.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel134.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel135.setForeground(new java.awt.Color(204, 204, 204));
        jLabel135.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel135.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel136.setForeground(new java.awt.Color(204, 204, 204));
        jLabel136.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel136.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel137.setForeground(new java.awt.Color(204, 204, 204));
        jLabel137.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel137.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel141.setForeground(new java.awt.Color(204, 204, 204));
        jLabel141.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel141.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel142.setForeground(new java.awt.Color(204, 204, 204));
        jLabel142.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel142.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel143.setForeground(new java.awt.Color(204, 204, 204));
        jLabel143.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel143.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel144.setForeground(new java.awt.Color(204, 204, 204));
        jLabel144.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel144.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel145.setForeground(new java.awt.Color(204, 204, 204));
        jLabel145.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel145.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel146.setForeground(new java.awt.Color(204, 204, 204));
        jLabel146.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel146.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel147.setForeground(new java.awt.Color(204, 204, 204));
        jLabel147.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel147.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel148.setForeground(new java.awt.Color(204, 204, 204));
        jLabel148.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel148.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel149.setForeground(new java.awt.Color(204, 204, 204));
        jLabel149.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel149.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel150.setForeground(new java.awt.Color(204, 204, 204));
        jLabel150.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel150.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel151.setForeground(new java.awt.Color(204, 204, 204));
        jLabel151.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel151.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel152.setForeground(new java.awt.Color(204, 204, 204));
        jLabel152.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel152.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel153.setForeground(new java.awt.Color(204, 204, 204));
        jLabel153.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel153.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel154.setForeground(new java.awt.Color(204, 204, 204));
        jLabel154.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel154.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel155.setForeground(new java.awt.Color(204, 204, 204));
        jLabel155.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel155.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel156.setForeground(new java.awt.Color(204, 204, 204));
        jLabel156.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel156.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel157.setForeground(new java.awt.Color(204, 204, 204));
        jLabel157.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel157.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel161.setForeground(new java.awt.Color(204, 204, 204));
        jLabel161.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/FINAL_VERMELHO.JPG")));
        jLabel161.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel162.setForeground(new java.awt.Color(204, 204, 204));
        jLabel162.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel162.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel163.setForeground(new java.awt.Color(204, 204, 204));
        jLabel163.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel163.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel164.setForeground(new java.awt.Color(204, 204, 204));
        jLabel164.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel164.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel165.setForeground(new java.awt.Color(204, 204, 204));
        jLabel165.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel165.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel166.setForeground(new java.awt.Color(204, 204, 204));
        jLabel166.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel166.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel167.setForeground(new java.awt.Color(204, 204, 204));
        jLabel167.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel167.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel168.setForeground(new java.awt.Color(204, 204, 204));
        jLabel168.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel168.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel169.setForeground(new java.awt.Color(204, 204, 204));
        jLabel169.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel169.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel170.setForeground(new java.awt.Color(204, 204, 204));
        jLabel170.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel170.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel171.setForeground(new java.awt.Color(204, 204, 204));
        jLabel171.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel171.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel172.setForeground(new java.awt.Color(204, 204, 204));
        jLabel172.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel172.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel173.setForeground(new java.awt.Color(204, 204, 204));
        jLabel173.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel173.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel174.setForeground(new java.awt.Color(204, 204, 204));
        jLabel174.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel174.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel175.setForeground(new java.awt.Color(204, 204, 204));
        jLabel175.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel175.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel176.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel176.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel177.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/AREIA.jpg")));
        jLabel177.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout painelCamposLayout = new javax.swing.GroupLayout(painelCampos);
        painelCampos.setLayout(painelCamposLayout);
        painelCamposLayout.setHorizontalGroup(
            painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelCamposLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17))
                    .addGroup(painelCamposLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel37))
                    .addGroup(painelCamposLayout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel50)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel53)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel54)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel56)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel57))
                    .addGroup(painelCamposLayout.createSequentialGroup()
                        .addComponent(jLabel61)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel62)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel63)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel64)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel65)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel66)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel67)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel68)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel69)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel70)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel71)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel72)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel73)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel74)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel75)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel76)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel77))
                    .addGroup(painelCamposLayout.createSequentialGroup()
                        .addComponent(jLabel81)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel82)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel83)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel84)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel85)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel86)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel87)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel88)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel89)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel90)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel91)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel92)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel93)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel94)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel95)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel96)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel97))
                    .addGroup(painelCamposLayout.createSequentialGroup()
                        .addComponent(jLabel101)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel102)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel103)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel104)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel105)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel106)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel107)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel108)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel109)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel110)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel111)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel112)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel113)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel114)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel115)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel116)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel117))
                    .addGroup(painelCamposLayout.createSequentialGroup()
                        .addComponent(jLabel121)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel122)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel123)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel124)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel125)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel126)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel127)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel128)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel129)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel130)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel131)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel132)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel133)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel134)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel135)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel136)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel137))
                    .addGroup(painelCamposLayout.createSequentialGroup()
                        .addComponent(jLabel141)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel142)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel143)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel144)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel145)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel146)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel147)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel148)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel149)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel150)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel151)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel152)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel153)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel154)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel155)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel156)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel157))
                    .addGroup(painelCamposLayout.createSequentialGroup()
                        .addComponent(jLabel161)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel162)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel163)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel164)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel165)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel166)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel167)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel168)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel169)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel170)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel171)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel172)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel173)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel174)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel175)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel176)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel177)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelCamposLayout.setVerticalGroup(
            painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel37)
                    .addComponent(jLabel36)
                    .addComponent(jLabel35)
                    .addComponent(jLabel34)
                    .addComponent(jLabel32)
                    .addComponent(jLabel30)
                    .addComponent(jLabel29)
                    .addComponent(jLabel31)
                    .addComponent(jLabel33)
                    .addComponent(jLabel28)
                    .addComponent(jLabel27)
                    .addComponent(jLabel26)
                    .addComponent(jLabel24)
                    .addComponent(jLabel22)
                    .addComponent(jLabel21)
                    .addComponent(jLabel23)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel48)
                    .addComponent(jLabel47)
                    .addComponent(jLabel46)
                    .addComponent(jLabel44)
                    .addComponent(jLabel42)
                    .addComponent(jLabel41)
                    .addComponent(jLabel43)
                    .addComponent(jLabel45)
                    .addComponent(jLabel49)
                    .addComponent(jLabel57)
                    .addComponent(jLabel56)
                    .addComponent(jLabel55)
                    .addComponent(jLabel54)
                    .addComponent(jLabel52)
                    .addComponent(jLabel50)
                    .addComponent(jLabel51)
                    .addComponent(jLabel53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel77)
                    .addComponent(jLabel76)
                    .addComponent(jLabel75)
                    .addComponent(jLabel74)
                    .addComponent(jLabel72)
                    .addComponent(jLabel70)
                    .addComponent(jLabel69)
                    .addComponent(jLabel71)
                    .addComponent(jLabel73)
                    .addComponent(jLabel68)
                    .addComponent(jLabel67)
                    .addComponent(jLabel66)
                    .addComponent(jLabel64)
                    .addComponent(jLabel62)
                    .addComponent(jLabel61)
                    .addComponent(jLabel63)
                    .addComponent(jLabel65))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel88)
                    .addComponent(jLabel87)
                    .addComponent(jLabel86)
                    .addComponent(jLabel84)
                    .addComponent(jLabel82)
                    .addComponent(jLabel81)
                    .addComponent(jLabel83)
                    .addComponent(jLabel85)
                    .addComponent(jLabel89)
                    .addComponent(jLabel97)
                    .addComponent(jLabel96)
                    .addComponent(jLabel95)
                    .addComponent(jLabel94)
                    .addComponent(jLabel92)
                    .addComponent(jLabel90)
                    .addComponent(jLabel91)
                    .addComponent(jLabel93))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel117)
                    .addComponent(jLabel116)
                    .addComponent(jLabel115)
                    .addComponent(jLabel114)
                    .addComponent(jLabel112)
                    .addComponent(jLabel110)
                    .addComponent(jLabel109)
                    .addComponent(jLabel111)
                    .addComponent(jLabel113)
                    .addComponent(jLabel108)
                    .addComponent(jLabel107)
                    .addComponent(jLabel106)
                    .addComponent(jLabel104)
                    .addComponent(jLabel102)
                    .addComponent(jLabel101)
                    .addComponent(jLabel103)
                    .addComponent(jLabel105))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel128)
                    .addComponent(jLabel127)
                    .addComponent(jLabel126)
                    .addComponent(jLabel124)
                    .addComponent(jLabel122)
                    .addComponent(jLabel121)
                    .addComponent(jLabel123)
                    .addComponent(jLabel125)
                    .addComponent(jLabel129)
                    .addComponent(jLabel137)
                    .addComponent(jLabel136)
                    .addComponent(jLabel135)
                    .addComponent(jLabel134)
                    .addComponent(jLabel132)
                    .addComponent(jLabel130)
                    .addComponent(jLabel131)
                    .addComponent(jLabel133))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel157)
                    .addComponent(jLabel156)
                    .addComponent(jLabel155)
                    .addComponent(jLabel154)
                    .addComponent(jLabel152)
                    .addComponent(jLabel150)
                    .addComponent(jLabel149)
                    .addComponent(jLabel151)
                    .addComponent(jLabel153)
                    .addComponent(jLabel148)
                    .addComponent(jLabel147)
                    .addComponent(jLabel146)
                    .addComponent(jLabel144)
                    .addComponent(jLabel142)
                    .addComponent(jLabel141)
                    .addComponent(jLabel143)
                    .addComponent(jLabel145))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel168)
                    .addComponent(jLabel167)
                    .addComponent(jLabel166)
                    .addComponent(jLabel164)
                    .addComponent(jLabel162)
                    .addComponent(jLabel161)
                    .addComponent(jLabel163)
                    .addComponent(jLabel165)
                    .addComponent(jLabel169)
                    .addComponent(jLabel177)
                    .addComponent(jLabel176)
                    .addComponent(jLabel175)
                    .addComponent(jLabel174)
                    .addComponent(jLabel172)
                    .addComponent(jLabel170)
                    .addComponent(jLabel171)
                    .addComponent(jLabel173))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Ljogador.setFont(new java.awt.Font("Calisto MT", 1, 14));
        Ljogador.setForeground(new java.awt.Color(0, 102, 102));
        Ljogador.setText("Nome do JogadorXX");
        Ljogador.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        LtipoPersonagem.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
        LtipoPersonagem.setForeground(new java.awt.Color(0, 51, 51));
        LtipoPersonagem.setText("Von Newman");
        LtipoPersonagem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, java.awt.Color.cyan, null, null));

        jLabel243.setFont(new java.awt.Font("Calisto MT", 1, 14));
        jLabel243.setForeground(new java.awt.Color(0, 102, 102));
        jLabel243.setText("Movimentos restantes");
        jLabel243.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Lmovimentos.setFont(new java.awt.Font("Comic Sans MS", 1, 18));
        Lmovimentos.setText("6");
        Lmovimentos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(102, 255, 255), null, null));
        Lmovimentos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Lmovimentos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel244.setFont(new java.awt.Font("Calisto MT", 1, 14));
        jLabel244.setForeground(new java.awt.Color(0, 102, 102));
        jLabel244.setText("Cota de pesos restantes");
        jLabel244.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cotaPesos.setFont(new java.awt.Font("Comic Sans MS", 1, 18));
        cotaPesos.setText("10");
        cotaPesos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(102, 255, 255), null, null));
        cotaPesos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labell.setFont(new java.awt.Font("Calisto MT", 1, 14));
        labell.setForeground(new java.awt.Color(0, 102, 102));
        labell.setText("Life");
        labell.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lLife.setFont(new java.awt.Font("Comic Sans MS", 1, 18));
        lLife.setText("200");
        lLife.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(102, 255, 255), null, null));
        lLife.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labell1.setFont(new java.awt.Font("Calisto MT", 1, 14));
        labell1.setForeground(new java.awt.Color(0, 102, 102));
        labell1.setText("N\u00edvel");
        labell1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lNormal.setFont(new java.awt.Font("Comic Sans MS", 1, 18));
        lNormal.setText("NORMAL");
        lNormal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(102, 255, 255), null, null));
        lNormal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel18.setText("jLabel18");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LtipoPersonagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Ljogador, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Lmovimentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel243, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel244)
                    .addComponent(cotaPesos, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lLife, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labell, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lNormal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labell1, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(253, 253, 253)
                .addComponent(jLabel18)
                .addContainerGap(437, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel243, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel244)
                    .addComponent(Ljogador)
                    .addComponent(labell1)
                    .addComponent(labell))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lmovimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cotaPesos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LtipoPersonagem)
                    .addComponent(lLife, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addGap(12, 12, 12))
        );

        Menu.setText("Menu");
        menuNovoJogo.setText("Novo Jogo");
        menuNovoJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNovoJogoActionPerformed(evt);
            }
        });

        Menu.add(menuNovoJogo);

        menuPlayer1.setText("Controle");
        menuPlayer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPlayer1ActionPerformed(evt);
            }
        });

        Menu.add(menuPlayer1);

        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });

        Menu.add(jMenuItem1);

        jMenuBar1.add(Menu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(painelCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-762)/2, (screenSize.height-623)/2, 762, 623);
    }// </editor-fold>//GEN-END:initComponents

    private void menuNovoJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNovoJogoActionPerformed
               
                jogo = null;
                player1 = null;
                player2 = null;
                config  = null;
                tabuleiroConfigurado = null;                
                this.dispose();
                new Apresentacao().setVisible(true);
                
    }//GEN-LAST:event_menuNovoJogoActionPerformed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
          
    }//GEN-LAST:event_formWindowStateChanged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
         
    }//GEN-LAST:event_formWindowOpened

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
         
    }//GEN-LAST:event_formFocusGained

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
          
    }//GEN-LAST:event_formWindowGainedFocus

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
          
    }//GEN-LAST:event_formWindowActivated

    private void painelCamposMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelCamposMouseMoved
          
    }//GEN-LAST:event_painelCamposMouseMoved

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
          
    }//GEN-LAST:event_jLabel1MousePressed

    private void menuPlayer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPlayer1ActionPerformed
         JOptionPane.showMessageDialog(null,"4 - Esquerda \n"
                                            +"7 - Cima \n"
                                            +"6 - Direita \n"
                                            +"4 - Baixo \n"
                                            +"0 - Passar jogada\n"
                                            +"f\\F - Mostrar Fluxo \n"
                                            +"n\\N - Mostrar Tabuleiro Normal\n","Controle",1);
    }//GEN-LAST:event_menuPlayer1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
     
           Lmovimentos.setText(String.valueOf(jogo.getControle().getMovimentosRestantes()));
           LtipoPersonagem.setText(jogo.getControle().getNome()) ;
           cotaPesos.setText(String.valueOf(jogo.getControle().getCotaPesos()));         
           jogo.setTecla(evt.getKeyCode());           
           jogo.jogarUmaRodada();
           
           if(evt.getKeyChar() == 'f' || evt.getKeyChar() == 'F'){
              mostrarFluxo("AGUA.jpg");
              mostraErupcoes("LAVA.jpg");
           }
           if(evt.getKeyChar() == 'n' || evt.getKeyChar() == 'N')
              mostrarCampoNormal("AREIA.jpg");
         //isto serÃ¡ executado sempre que for digitado o teclado se der tempo
          //colocar em outro lugar a fim de ser executado menos vezes      
    }//GEN-LAST:event_formKeyPressed

    private void mostrarFluxo(String campo){
         for(int i = 0 ; i < DadosDeConfiguracao.SIZE_COLUNA ; i++){
            for(int j = 0 ; j < DadosDeConfiguracao.SIZE_LINHA ; j++){
                   if(camposFluxo[i][j] != 0 && camposFluxo[i][j] != DadosDeConfiguracao.oo){
                         ImageIcon img = new ImageIcon(config.CAMINHO+"AREIA.jpg");;
                         ((JLabel)componentesMatriz[i][j]).setForeground(new Color(0,0,0));
                         ((JLabel)componentesMatriz[i][j]).setText(String.valueOf(camposFluxo[i][j]));
                         if(camposFluxo[i][j] >= 18
                                 && camposFluxo[i][j] < 27){
                             ((JLabel)componentesMatriz[i][j]).setForeground(new Color(50,50,50));
                             img = new ImageIcon(config.CAMINHO+"AGUARASA.jpg");
                         }
                         else  if(camposFluxo[i][j] >= 27
                                 && camposFluxo[i][j] < 36)
                                 img = new ImageIcon(config.CAMINHO+"AGUA.jpg");
                         else if(camposFluxo[i][j] >=  36){
                             ((JLabel)componentesMatriz[i][j]).setForeground(new Color(255,255,255));
                             img = new ImageIcon(config.CAMINHO+"AGUAPROFUNDA.jpg");
                             
                         }
                         ((JLabel)componentesMatriz[i][j]).setIcon(img );              
                   }      
            }      
         }
         ((JLabel)componentesMatriz[16][0]).setIcon(new ImageIcon(config.CAMINHO+"FINAL_VERDE.JPG"));              
         ((JLabel)componentesMatriz[0][8]).setIcon(new ImageIcon(config.CAMINHO+"FINAL_VERMELHO.JPG"));              
         mostraJogadores();
    }
    
    private void mostraErupcoes(String campo){   
        if(camposErupcoes == null || camposErupcoes[0] == null)
            System.out.println("NULL--------------------------------------");
        for(int i = 0 ; i < DadosDeConfiguracao.SIZE_COLUNA ; i++){
            for(int j = 0 ; j < DadosDeConfiguracao.SIZE_LINHA ; j++){
                   if(camposErupcoes[i][j] != 0 &&
                         camposErupcoes[i][j] != DadosDeConfiguracao.oo){
                         ImageIcon img = new ImageIcon(config.CAMINHO+"AREIA.jpg");
                         
                         ((JLabel)componentesMatriz[i][j]).setForeground(new Color(0,0,0));
                         ((JLabel)componentesMatriz[i][j]).setText(String.valueOf(camposErupcoes[i][j]));                         
                         
                         if(camposErupcoes[i][j] < 40){
                             ((JLabel)componentesMatriz[i][j]).setForeground(new Color(255,255,255));
                             img = new ImageIcon(config.CAMINHO+"LAVA2.jpg");
                         }
                         else if(camposErupcoes[i][j] >= 40
                                 && camposErupcoes[i][j] < 60){
                                 ((JLabel)componentesMatriz[i][j]).setForeground(new Color(255,255,255)); 
                                 img = new ImageIcon(config.CAMINHO+"LAVA_1000.jpg");
                         }
                         else if(camposErupcoes[i][j] >= 60
                                 && camposErupcoes[i][j] < 80){
                                 ((JLabel)componentesMatriz[i][j]).setForeground(new Color(255,255,255)); 
                                 img = new ImageIcon(config.CAMINHO+"LAVA_2000.jpg");
                         }
                          else if(camposErupcoes[i][j] >= 80
                                 && camposErupcoes[i][j] < 100){
                                 ((JLabel)componentesMatriz[i][j]).setForeground(new Color(255,255,255)); 
                                 img = new ImageIcon(config.CAMINHO+"LAVA_3000.jpg");
                         }
                         else if(camposErupcoes[i][j] >= 100){
                                 ((JLabel)componentesMatriz[i][j]).setForeground(new Color(255,255,255)); 
                                 img = new ImageIcon(config.CAMINHO+"LAVA_4000.jpg");
                         }
                         ((JLabel)componentesMatriz[i][j]).setIcon(img );              
                   }      
            }      
         }
         ((JLabel)componentesMatriz[16][0]).setIcon(new ImageIcon(config.CAMINHO+"FINAL_VERDE.JPG"));              
         ((JLabel)componentesMatriz[0][8]).setIcon(new ImageIcon(config.CAMINHO+"FINAL_VERMELHO.JPG"));              
         mostraJogadores();
    }
    /**
     *
     * Muda a configuração para o fluxo
     *
     */
    private void mostrarCampoNormal(String campo){
         for(int i = 0 ; i < DadosDeConfiguracao.SIZE_COLUNA ; i++){
            for(int j = 0 ; j < DadosDeConfiguracao.SIZE_LINHA ; j++){
                   if(camposFluxo[i][j] != 0 && camposFluxo[i][j] != DadosDeConfiguracao.oo){
                         ((JLabel)componentesMatriz[i][j]).setForeground(new Color(0,0,0));
                         ((JLabel)componentesMatriz[i][j]).setText(String.valueOf(jogo.getCampos()[i][j].getPeso()));
                         ((JLabel)componentesMatriz[i][j]).setIcon(new ImageIcon(config.CAMINHO+campo));              
                   }      
            }      
         }
         ((JLabel)componentesMatriz[16][0]).setIcon(new ImageIcon(config.CAMINHO+"FINAL_VERDE.JPG"));              
         ((JLabel)componentesMatriz[0][8]).setIcon(new ImageIcon(config.CAMINHO+"FINAL_VERMELHO.JPG"));              
         mostraJogadores();
    }
    
    /**
     *
     *atualiza jogadores no tabuleiro
     *
     */
    private void mostraJogadores(){         
         int x = jogo.getPlayer1().getX();
         int y = jogo.getPlayer1().getY();
         //mostra imagens do jogador 1
         ImageIcon img = new ImageIcon(DadosDeConfiguracao.CAMINHO+jogo.getPlayer1().getImagem());                       
         ((JLabel)componentesMatriz[x][y]).setIcon(img); 
         //mostra imagens do jogador 2
         x = jogo.getPlayer2().getX();
         y = jogo.getPlayer2().getY();
         img = new ImageIcon(DadosDeConfiguracao.CAMINHO+jogo.getPlayer2().getImagem());              
         ((JLabel)componentesMatriz[x][y]).setIcon(img); 
    }
  // recebe os nomes dos jogadores
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {                
                new Tabuleiro().setVisible(true);
                
            }
        });
    }
    
    // Declaração de variáveis - não modifique//GEN-BEGIN:variables
    private javax.swing.JLabel Ljogador;
    private javax.swing.JLabel Lmovimentos;
    private javax.swing.JLabel LtipoPersonagem;
    private javax.swing.JMenu Menu;
    private javax.swing.JLabel cotaPesos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel243;
    private javax.swing.JLabel jLabel244;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lLife;
    private javax.swing.JLabel lNormal;
    private javax.swing.JLabel labell;
    private javax.swing.JLabel labell1;
    private javax.swing.JMenuItem menuNovoJogo;
    private javax.swing.JMenuItem menuPlayer1;
    private javax.swing.JPanel painelCampos;
    // Fim da declaração de variáveis//GEN-END:variables

   
    
}
