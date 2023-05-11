/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hardwares;

import com.github.britooo.looca.api.core.Looca;
import java.util.List;
import com.github.britooo.looca.api.group.discos.Disco;
import java.util.ArrayList;

/**
 *
 * @author victor
 */
public class DatawatchDiscos {

    public List<Disco> discos;
    Looca looca = new Looca();

    public DatawatchDiscos() {
        this.discos = new ArrayList();
    }

    public void inserirDiscos() {
        List<Disco> listaDiscos = looca.getGrupoDeDiscos().getDiscos();

        Integer qtdDiscos = listaDiscos.size();

        for (Integer i = 0; i < qtdDiscos; i++) {
            discos.add(listaDiscos.get(i));
        }

        if (discos.size() != 3) {
            for (Integer i = qtdDiscos; i < 3; i++) {
                discos.add(null);
            }
        }
    }
}
