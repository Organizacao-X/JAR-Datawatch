/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selects;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import tabelas.Maquinas;

/**
 *
 * @author victor
 */
public class Selects {

    
    public static Maquinas pegarMaquinaCorrespondente(JdbcTemplate con, String mac) {
        List<Maquinas> maquinas = con.query("SELECT * FROM Maquinas WHERE mac = ?", new BeanPropertyRowMapper<>(Maquinas.class), mac);
        return maquinas.get(0);
    }
}
