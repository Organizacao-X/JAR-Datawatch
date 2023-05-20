package slack;

import java.time.LocalDateTime;
import sptech.datawatch.Ip;
import java.time.format.DateTimeFormatter;

public class SlackEnumController {
    
    public static String logMessage(SlackEnum level) {
        
        LocalDateTime dataHoraAtual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String dataHoraFormatada = dataHoraAtual.format(formatter);
        
        String mensagem = null;
        
        switch (level) {
            case INFO_LOGIN:
                mensagem = String.format(" :large_blue_circle: *[INFO]*  [%s]\t\t_IP [%s] conectou-se_", dataHoraFormatada, Ip.getIp());
                break; 
            case WARNING_LOGIN_FALHO:
                mensagem = String.format(" :large_yellow_circle: *[WARNING]*  [%s]\t\t_IP [%s] TENTOU-SE CONECTAR_", dataHoraFormatada, Ip.getIp());
                break;
            case WARNING:
                mensagem = String.format(" :large_yellow_circle: *[WARNING]*  [%s]\t\t_IP tentou", dataHoraFormatada);
                break;
            case ERROR:
                mensagem = String.format(" :red_circle: *[ERROR]*  [%s]\t\t", dataHoraFormatada);
                break;
            case DEBBUG:
                mensagem = String.format(" :large_green_circle: *[DEBBUG]*  [%s]\t\t", dataHoraFormatada);;
                break;
            default:
                mensagem = ("[UNKNOWN] ");
                break;
                
        }
                return mensagem;
    }
}
