package caminhaodelixo;

import java.util.ArrayList;

public class Circuito{
    private static ArrayList<Setor> setores = new ArrayList();
    private static ArrayList<PontosColeta> pontosColetas = new ArrayList();
    
    public void adicao(Setor e){
        this.setores.add(e);
    }
    
    public static ArrayList<String> exibir(){
        for (Setor st : setores){
            //System.out.println(Setor.getNomeSetor());
        }
        return Setor.getNomeSetor();
    }
}
