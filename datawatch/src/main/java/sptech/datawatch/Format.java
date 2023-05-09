/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sptech.datawatch;

import com.github.britooo.looca.api.util.Conversor;

/**
 *
 * @author victor
 */
public class Format {
    
    public static Double formatarInserirBanco(Long valor) {
        String valorString = Conversor.formatarBytes(valor).split(" ")[0];
        return Double.valueOf(valorString.replace(",", "."));
    }
}
