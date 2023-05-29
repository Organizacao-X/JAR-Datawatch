package config.slack;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SlackEnumController {
    
    public static String logMessage(SlackEnum level) {
        
        LocalDateTime dataHoraAtual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String dataHoraFormatada = dataHoraAtual.format(formatter);
        List<RedeInterface> ri = new Looca().getRede().getGrupoDeInterfaces().getInterfaces();
        String ip = ri.get(ri.size() - 1).getEnderecoIpv4().get(0);
                
        String mensagem = null;
        
        switch (level) {
            case INFO_LOGIN:
                mensagem = String.format(" :large_blue_circle: *[INFO]*  [%s]\t\t_IP [%s] conectou-se_", dataHoraFormatada, ip);
                break; 
            case WARNING_LOGIN_FALHO:
                mensagem = String.format(" :large_yellow_circle: *[WARNING]*  [%s]\t\t_IP [%s] TENTOU-SE CONECTAR_", dataHoraFormatada, ip);
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
