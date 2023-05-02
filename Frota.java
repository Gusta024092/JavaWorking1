package caminhaodelixo;

import java.util.ArrayList;

public class Frota {
    private static int id;
    private static int qtdeFrota;
    private static float capacidadeKG; 
    static ArrayList<String> cmv = new ArrayList();
    static ArrayList<Integer> frotas = new ArrayList();
    static ArrayList<String> tv = new ArrayList();
    
    private static int idnum = 0;
    
    private static int nextID = 1; //Id estático inicia sempre 1 quando o programa for compilado

    public Frota(int qtdeFrota, float capacidadeKG) {
        this.id = nextID;
        nextID++;
        this.qtdeFrota = qtdeFrota;
        this.capacidadeKG = capacidadeKG;
        frotas.add(id);
        
        float t = capacidadeKG * qtdeFrota;
        cmv.add(String.valueOf( t));
    }
    public static ArrayList retornoFrota(){
        return frotas;
    }
 
    public int getId(){
        return id;
    } 

    public int getQtdeFrota() {
        return qtdeFrota;
    }

    public float getCapacidadeKG() {
        return capacidadeKG;
    }
    
    public static ArrayList capacidadeTotal(){
        return cmv;
    }
}
