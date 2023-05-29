/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import com.github.britooo.looca.api.util.Conversor;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author victor
 */
public class Util {
     
    public static Double formatarParaDouble(Long valor) {
        Double valorFormatado = 0.0;
        
        String valorComIdentificador = Conversor.formatarBytes(valor);
        String[] valorIdentificadorSeparado = valorComIdentificador.split(" ");
        valorFormatado = Double.valueOf(valorIdentificadorSeparado[0].replace(",", "."));
//        if (valorIdentificadorSeparado[1].contains("KiB")) {
//            // CONVERTENDO O VALOR DE KB PRA GB
//            valorFormatado = Double.valueOf(valorIdentificadorSeparado[0].replace(",", "."))/1000000;
//        } else if (valorIdentificadorSeparado[1].contains("MiB")) {
//            // CONVERTENDO O VALOR DE MB PRA GB
//            valorFormatado = Double.valueOf(valorIdentificadorSeparado[0].replace(",", "."))/1000;
//        } else if (valorIdentificadorSeparado[1].contains("GiB")) {
//            // CONVERTENDO O VALOR DE GB PRA GB
//            valorFormatado = Double.valueOf(valorIdentificadorSeparado[0].replace(",", "."));
//        } else if (valorIdentificadorSeparado[1].contains("TiB")) {
//            valorFormatado = Double.valueOf(valorIdentificadorSeparado[0].replace(",", "."))*1000;
//        }
        return valorFormatado;
    }
    
    public static String randomizeSerie() {
        String[] alfabeto = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", 
        "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String serie = "";
        
        for (Integer i = 0; i < 4; i++) {
            Integer randomAlfabeto = ThreadLocalRandom.current().nextInt(0, 26);
            serie += alfabeto[randomAlfabeto];
        }
        serie += ThreadLocalRandom.current().nextInt(0, 10);
        
        return serie;
    }
}