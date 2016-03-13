/*
 *CORRIDA DE GRAFOS
 *
 * Escrito por Diego Pedro para a disciplina de Teoria Dos Grafos 2009.2
 */

package config;

/**
 *
 * @author Diego
 */
public class DadosDeConfiguracao {
    //public enum TIPOS_DE_CAMPO{NEUTRO,FLUXO,ERUPCAO};
    
    /** Creates a new instance of DadosDeConfiguracao */
   
    public  static final int SIZE_COLUNA = 17;
    public  static final int SIZE_LINHA = 9;   
    public  static final int KEY_LEFT_PLAYER = 37;//4
    public  static final int KEY_UP_PLAYER = 38;//8
    public  static final int KEY_RIGHT_PLAYER = 39;//6
    public  static final int KEY_DOWN_PLAYER = 40;//2
    public  static final int KEY_SAIR_PLAYER = 96;// 0  
    public  static final int oo = 2147483647;
    public  static final int VALOR_MAXIMO_PESO = 10;
    //public  final int VALOR_MAXIMO_LIFE = 300;  
    public  static final int VERTICE_DESTINO_PLAYER_1 = 16;    
    public  static final int VERTICE_DESTINO_PLAYER_2 = 136;
    public  static final int NUMERO_DE_NODOS = 153;
    public  static final int AGUA_RASA = 18;    
    public  static final int AGUA = 27;   
    public  static final int AGUA_PROFUNDA = 36; 
    public  final int NUMERO_DE_MOVIMENTOS = 6;
    public  final int COTA_DE_PESOS = 1;
    private final int[] tamanhoDaTabela = new int[2];
    public  static final String SEPARADOR = (String)System.getProperties().get("file.separator"); 
    public  static final String CAMINHO = "C:\\CorridaDeGrafos\\src\\IMG\\";
    public  static final String IMGP1 = "PERS1.jpg";
    public  static final String IMGP2 = "PERS2.jpg";
    public  static final String IMGP1_PERCORRIDO = "CAMINHO_1.jpg";
    public  static final String IMGP2_PERCORRIDO = "CAMINHO_2.jpg";

       
            
    public DadosDeConfiguracao() {       
        tamanhoDaTabela[0] = SIZE_COLUNA;
        tamanhoDaTabela[1] = SIZE_LINHA; 
        String diretorio = DadosDeConfiguracao.class.getProtectionDomain().getCodeSource().getLocation().toString();  
        System.out.println(getPath(diretorio));
      
        
    }
    public static int matTOlin(int linha, int coluna)throws Exception{
        
             if(linha > SIZE_LINHA || linha < 0)
                 throw new Exception("linha maior ou menor que o permitido "+linha);
              if(coluna > SIZE_COLUNA || coluna < 0)
                 throw new Exception("coluna maior ou menor que o permitido "+coluna);
             
             return (((linha+1)*SIZE_COLUNA)-(SIZE_COLUNA-(coluna+1)))-1;
   }
    
    public String getPath(String path){        
        String sistema = System.getProperties().get("os.name").toString(); 
        
        if(!sistema.equals("Linux")){
            System.out.println(sistema);
            path = path.replace("%20"," ");//coloca espacos            
            path = path.replace("/","\\"); //troca as barras
        } 
        
        return path.substring(6, path.length()-1);
   }

          
}
