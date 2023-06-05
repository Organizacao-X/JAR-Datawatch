package app;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.util.Conversor;

public class Teste {
    public static void main(String[] args) {
        Looca looca = new Looca();
        System.out.printf("looca.getGrupoDeDiscos().getTamanhoTotal(): %s",Conversor.formatarBytes(looca.getGrupoDeDiscos().getTamanhoTotal()));
        System.out.println("\n");
        System.out.printf("looca.getGrupoDeDiscos().getVolumes().get(0).getTotal(): %s",Conversor.formatarBytes(looca.getGrupoDeDiscos().getVolumes().get(1).getTotal()));
        
    }
}
