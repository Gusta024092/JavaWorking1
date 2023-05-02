package caminhaodelixo;

import java.util.ArrayList;

public class PontosColeta{
    private ArrayList<Setor> setores = new ArrayList();
    private float demandaMaxima;
    private static ArrayList<Float> lixoSetor = new ArrayList();

    public PontosColeta(float demandaMaxima) {
        this.demandaMaxima = demandaMaxima;
        lixoSetor.add(demandaMaxima);
    }
    
    public static ArrayList retornarLixo(){
        return lixoSetor;
    }
    
    public float getDemandaMaxima() {
        return demandaMaxima;
    }

    public void setDemandaMaxima(float demandaMaxima) {
        this.demandaMaxima = demandaMaxima;
    }

    public ArrayList<Setor> getSetores() {
        return setores;
    }
    
    public void retornar(PontosColeta e){
        Caminhao.pontosColetaVisitados.add(e);
    }
}
