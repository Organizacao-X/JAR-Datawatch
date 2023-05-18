/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selects;

import com.github.britooo.looca.api.core.Looca;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import tabelas.Empresas;
import tabelas.Maquinas;
import tabelas.Reboot;

/**
 *
 * @author victor
 */
public class Selects {

    public static Maquinas pegarMaquinaCorrespondente(JdbcTemplate con) {
        String mac = pegarMac();
        System.out.println(mac);
        List<Maquinas> maquinas = con.query("SELECT * FROM Maquinas WHERE mac = ?", new BeanPropertyRowMapper<>(Maquinas.class), mac);
        if (maquinas.size() != 0) {
            return maquinas.get(0);
        }
        return null;
    }
    
    public static String pegarMac() {
        Looca looca = new Looca();
        return looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getEnderecoMac();
    }
    
    public static Boolean reebotar(JdbcTemplate conAzure, Integer fkMaquina, Integer fkEmpresa) {
        List<Reboot> reboot = conAzure.query("SELECT * FROM Reboot WHERE fkMaquina = ? AND fkEmpresa = ?", new BeanPropertyRowMapper(Reboot.class), fkMaquina, fkEmpresa);
        if (reboot.get(0).getRebootar().equals(1)) {
            conAzure.update("UPDATE Reboot SET rebootar = 0 WHERE fkMaquina = ? AND fkEmpresa = ?", fkMaquina, fkEmpresa);
            return true;
        }
        return false;
    }
    
    public static List<Empresas> pegarEmpresa(JdbcTemplate con, Integer idEmpresa) {
        List<Empresas> empresas = con.query("SELECT * FROM Empresas WHERE idEmpresa = ?;", new BeanPropertyRowMapper(Empresas.class), idEmpresa);
        return empresas;
    }
}
