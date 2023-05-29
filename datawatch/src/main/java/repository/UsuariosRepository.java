/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import config.ConexaoAzure;
import java.util.List;
import model.Usuarios;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author victor
 */
public class UsuariosRepository {
    
    private static JdbcTemplate jdbcAzure = new ConexaoAzure().getConnection();
    
    public Usuarios login(String login, String senha) {
        List<Usuarios> usuarioBanco = jdbcAzure.query("SELECT * FROM Usuarios WHERE email = ? AND senha = ?;", new BeanPropertyRowMapper(Usuarios.class), login, senha);
        if (!usuarioBanco.isEmpty()) {
            return usuarioBanco.get(0);
        }
        return null;
    }
}
