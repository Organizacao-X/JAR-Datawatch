package sptech.datawatch;

import java.io.IOException;
import java.io.*;

//public class Reboot {
//    public void rebootar(String remotoPC) throws IOException {
//        /*
//        MEU TEMA É A REINICIALIZAÇÃO DE UM SISTEMA REMOTAMENTE, APRENDENDO
//        PORQUE SERÁ A INOVAÇÃO DO PROJETO DE PI
//         */
//
//        Runtime runtime = Runtime.getRuntime();
//        Process process = runtime.exec("shutdown -r now \\\\" + remotoPC);
//
//        try {
//            int codigoDeSaida = process.waitFor();
//            System.out.println("Código de saída: " + codigoDeSaida);
//        } catch (InterruptedException e) {
//        }
//    }
//}
//public class Reboot {
//   public static void main(String[] args) {
//      String ip = "192.168.1.100"; // IP do computador remoto
//      String username = "username"; // nome de usuário para autenticação
//      String password = "password"; // senha para autenticação
//      String command = "shutdown /r /t 0"; // comando para reiniciar o computador
//
//      String[] cmd = {"cmd.exe", "/c", "net use \\\\" + ip + " /user:" + username + " " + password, "&&", "shutdown /m \\\\" + ip + " /r /t 0"};
//
//      try {
//         Runtime.getRuntime().exec(cmd);
//      } catch (IOException e) {
//         e.printStackTrace();
//      }
//   }
//}
//public class Reboot {
//   public void rebootar(String remotoPC) throws IOException {
//      String username = "Leone"; // nome de usuário para autenticação
//      String password = "25252626"; // senha para autenticação
//      String command = "sudo shutdown -r now"; // comando para reiniciar o computador
//
//      String[] cmd = {"sshpass", "-p", password, "ssh", "-oStrictHostKeyChecking=no", username + "@" + remotoPC, command};
//
//      try {
//         Runtime.getRuntime().exec(cmd);
//      } catch (IOException e) {
//         e.printStackTrace();
//      }
//   }
//}
public class Reboot {

    public void rebootar(String remotoPC) throws IOException {
        String username = "leone"; // nome de usuário para autenticação
        String password = "25252626"; // senha para autenticação
        String command = "sudo shutdown -r now"; // comando para reiniciar o computador

        String cmd = "C:\\Program Files\\PuTTY\\putty.exe -ssh " + username + "@" + remotoPC + " -pw " + password + " " + command;

        try {
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
