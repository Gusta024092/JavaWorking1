package caminhaodelixo;

import java.util.ArrayList;

public class Setor {
    private int id;
    private static ArrayList<String> nomeSetor = new ArrayList();
    private ArrayList<String> municipios = new ArrayList<>();

    private static int nextID = 1;

    public Setor(String nomeSetor, String municipios) {
        this.id = nextID;
        nextID++;  
        this.nomeSetor.add(nomeSetor);
        this.municipios.add(municipios);
    }
    

    public static String retornoNome(){
        String lista = "";
        for (int i=0; i<nomeSetor.size(); i++){
            lista = nomeSetor.get(i);
        }
        return lista;
    }
    
    public int getId() {
        return id;
    }

    public ArrayList<String> getMunicipios() {
        return municipios;
    }
    
    public static ArrayList<String> getNomeSetor() {
        return nomeSetor;
    }

    public void setMunicipios(ArrayList<String> municipios) {
        this.municipios = municipios;
    }

    @Override
    public String toString() {
        //return nomeSetor + " : " + id + " : "+ municipios;
        return "" + nomeSetor;
    } 
    
    
}
