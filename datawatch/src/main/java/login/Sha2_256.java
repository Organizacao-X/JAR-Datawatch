package login;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha2_256 {
    public String criarHash(String senha) throws NoSuchAlgorithmException {
        senha+=senha;
        // Obtém uma instância do algoritmo SHA-256
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        
        // Converte a senha para um array de bytes e aplica o algoritmo
        byte[] hashBytes = md.digest(senha.getBytes());
        
        // Converte o array de bytes para uma string em formato hexadecimal
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        String hashSenha = sb.toString();
        
//        System.out.println("Senha original: " + senha);
//        System.out.println("Hash SHA-256: " + hashSenha);
        
        return hashSenha.toUpperCase();
    }
}