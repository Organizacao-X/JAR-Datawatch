package sptech.datawatch;

import org.springframework.jdbc.core.JdbcTemplate;
import tabelas.Usuarios;
import login.TelaLogin;

public class Datawatch {

    public static void main(String[] args) {
           
        // AQUI A GENTE CRIA CONEXAO COM O BANCO DE DADOS 
        // CONFIGURADO NO CONEXAO.JAVA
        Conexao conexao = new Conexao();

        // ESSE CON SEMPRE VAMOS USAR PRA DAR COMANDOS NO BANCO
        JdbcTemplate con = conexao.getConnection();

        // AQUI PEGA O ENDEREÇO DE CONEXAO E USA O TEMPLATE PRA ACESSAR
        conexao.getConnection();
    }
}
