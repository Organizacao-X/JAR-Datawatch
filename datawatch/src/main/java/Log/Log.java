/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Log;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import sptech.datawatch.Ip;
import tabelas.Usuarios;

/**
 *
 * @author Lucas
 */
public class Log {
    
    private String nomeDocumento;
    private String nomeLogado;
    private List<String> status;
    private String descricao;

    public Log(String nomeDocumento, String nomeLogado, String descricao) {
        this.nomeDocumento = nomeDocumento;
        this.nomeLogado = nomeLogado;
        this.status = new ArrayList<>();
        this.descricao = descricao;
    }
    
    
    
    public void criarLog() throws IOException {
        // Formata a data
        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dataFormatada = dataAtual.format(formato);
        

        // Formata a data e a hora
        LocalDateTime dataHoraAtual = LocalDateTime.now();
        DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dataHoraFormatada = dataHoraAtual.format(formato2);
        
        
        
        setNomeDocumento(dataFormatada);
        
        String titulo = String.format("%s_%s.txt", dataFormatada, getnomeLogado());
        File arquivo = new File(titulo);
        
        
        if(!arquivo.exists()){
          arquivo.createNewFile();
        }
        
        
          List<String> lista = new ArrayList<>();
                    
          lista.add(dataHoraFormatada + " " + getnomeLogado() + " " + getDescricao());
          
          
          Files.write(Paths.get(arquivo.getPath()), lista, StandardOpenOption.APPEND);
          
          
          
          
    }

    public String getNomeDocumento() {
        return nomeDocumento;
    }

    public void setNomeDocumento(String nomeDocumento) {
        this.nomeDocumento = nomeDocumento;
    }
    
    public String getnomeLogado() {
        return nomeLogado;
    }

    public void setnomeLogado(String nomeLogado) {
        this.nomeLogado = nomeLogado;
    }

    public List<String> getStatus() {
        return status;
    }

    public void setStatus(List<String> status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

        
    
}
