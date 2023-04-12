package sptech.datawatch;

import java.io.IOException;

public class Reboot {
    public void rebootar(String remotoPC) throws IOException {
        /*
        MEU TEMA É A REINICIALIZAÇÃO DE UM SISTEMA REMOTAMENTE, APRENDENDO
        PORQUE SERÁ A INOVAÇÃO DO PROJETO DE PI
         */

        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("shutdown -r -t 0 -m \\\\" + remotoPC);

        try {
            int codigoDeSaida = process.waitFor();
            System.out.println("Código de saída: " + codigoDeSaida);
        } catch (InterruptedException e) {
        }
    }
}
