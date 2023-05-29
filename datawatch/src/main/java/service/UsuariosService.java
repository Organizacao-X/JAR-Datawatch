/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import config.Sha2_256;
import java.security.NoSuchAlgorithmException;
import model.Usuarios;
import repository.UsuariosRepository;

/**
 *
 * @author victor
 */
public class UsuariosService {

    private static UsuariosRepository usuariosRepository = new UsuariosRepository();

    public static Usuarios login(String login, String senha) {
        if (login != null && senha != null) {
            try {
                senha = Sha2_256.criarHash(senha);
            } catch (NoSuchAlgorithmException ex) {
                System.out.println("Erro ao criptografar a senha.");
            }

            Usuarios usuarioBanco = usuariosRepository.login(login, senha);
            if (usuarioBanco != null) {
                return usuarioBanco;
            }
        }
        return null;
    }
}
