package caminhaodelixo;

import java.util.ArrayList;

public class Caminhao {
    private int id; //Atributo não utilizado
    private int capacidade;//Atributo é utilizado pelo construtor na tela "TelaCadastroSetor" na linha 17
    static ArrayList<PontosColeta> pontosColetaVisitados = new ArrayList();
    
    /*
        Role para baixo e vá para o "static calcularTotalLixoColetado()"
    */
    
    private static int nextID = 1; //ID estático que incrementa em 1, nesse caso, é usado de forma parcial
    
    public Caminhao(int capacidade) { //Construtor da Classe
        this.id = nextID;
        nextID++;
        this.capacidade = capacidade;
        
    }
    
    //Getters and Setters
    public static ArrayList<PontosColeta> getPontosColetaVisitados() {
        return pontosColetaVisitados;
    }
    
    public int getId() {
        return id;
    }
    
    public int getCapacidade() {
        return capacidade;
    }
    
    //Método estático com o intuito de retornar o total de lixo de vários pontos de coleta
    public static int calcularTotalLixoColetado() {
        int totalLixoColetado = 0; //variável acumuladora
        for (PontosColeta pontoColeta : pontosColetaVisitados) {
            totalLixoColetado += pontoColeta.getDemandaMaxima(); //varre o total
        
    } 
        return totalLixoColetado; 
    }
}
    
