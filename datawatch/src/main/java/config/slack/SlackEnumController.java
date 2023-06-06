package config.slack;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SlackEnumController {

    private static LocalDateTime dataHoraAtual = LocalDateTime.now();
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private static String dataHoraFormatada = dataHoraAtual.format(formatter);
    private static List<RedeInterface> ri = new Looca().getRede().getGrupoDeInterfaces().getInterfaces();
    private static String ip = ri.get(ri.size() - 1).getEnderecoIpv4().get(0);
    private static String nomeMaquina = new Looca().getRede().getParametros().getHostName();
    private static String mensagem = null;

    public static String logMessage(SlackEnum level) {

//        LocalDateTime dataHoraAtual = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//        String dataHoraFormatada = dataHoraAtual.format(formatter);
//        List<RedeInterface> ri = new Looca().getRede().getGrupoDeInterfaces().getInterfaces();
//        String ip = ri.get(ri.size() - 1).getEnderecoIpv4().get(0);
//                
//        String mensagem = null;
        switch (level) {
            case INFO_LOGIN:
                mensagem = String.format(" :large_blue_circle: *[INFO]*  [%s]\t\t_IP [%s] Máquina [%s] conectou-se_", dataHoraFormatada, ip, nomeMaquina);
                break;
            case WARNING_LOGIN_FALHO:
                mensagem = String.format(" :large_yellow_circle: *[WARNING]*  [%s]\t\t_IP [%s] Máquina [%s] TENTOU SE CONECTAR_", dataHoraFormatada, ip, nomeMaquina);
                break;
            case WARNING:
                mensagem = String.format(" :large_yellow_circle: *[WARNING]*  [%s]\t\t_IP tentou", dataHoraFormatada);
                break;
            case ERROR:
                mensagem = String.format(" :red_circle: *[ERROR]*  [%s]\t\t", dataHoraFormatada);
                break;
            case DEBBUG:
                mensagem = String.format(" :large_green_circle: *[DEBBUG]*  [%s]\t\t", dataHoraFormatada);
                ;
                break;
            default:
                mensagem = ("[UNKNOWN] ");
                break;

        }
        return mensagem;
    }

    public static String slackAlertUso(Integer fkAlerta, String nomeComponente, String nomeMaquina) {
        switch (fkAlerta) {
            case 1:
                mensagem = String.format(" :red_circle: *[WARNING]* Dados do processador [%s] não estão sendo capturados na máquina [%s]\t\t", nomeComponente, nomeMaquina);
                break;
            case 2:
                mensagem = String.format(" :red_circle: *[WARNING]* O consumo de ram ultrapassou o limite estipulado por muito tempo na máquina [%s]\t\t", nomeMaquina);
                break;
            case 3:
                mensagem = String.format(" :red_circle: *[WARNING]* O disco [%s] está com 90%% de espaço usado na máquina [%s]\t\t", nomeComponente, nomeMaquina);
                break;
            case 4:
                mensagem = String.format(" :red_circle: *[WARNING]* Há um gap no envio de dados na máquina [%s]\t\t", nomeMaquina);
                break;
            case 5:
                mensagem = String.format(" :red_circle: *[WARNING]* O disco [%s] está com 98%% de espaço usado na máquina [%s]\t\t", nomeComponente, nomeMaquina);
                break;
            case 6:
                mensagem = String.format(" :red_circle: *[WARNING]* Dados do disco [%s] não estão sendo capturados na máquina [%s]\t\t", nomeComponente, nomeMaquina);
                break;
            case 7:
                mensagem = String.format(" :red_circle: *[WARNING]* Dados da RAM não estão sendo capturados na máquina [%s]\t\t", nomeMaquina);
                break;
            case 8:
                mensagem = String.format(" :red_circle: *[WARNING]* Dados de rede não estão sendo capturados na máquina [%s]\t\t", nomeMaquina);
                break;
            case 9:
                mensagem = String.format(" :red_circle: *[WARNING]* O uso de ram está como nulo na máquina [%s]\t\t", nomeMaquina);
                break;
            case 10:
                mensagem = String.format(" :red_circle: *[WARNING]* Uso do processador [%s] ultrapassou o limite estipulado na máquina [%s]\t\t", nomeComponente, nomeMaquina);
                break;
            case 11:
                mensagem = String.format(" :red_circle: *[WARNING]* Uso da RAM ultrapassou o limite estipulado na máquina\t\t", nomeMaquina);
                break;
            case 12:
                mensagem = String.format(" :red_circle: *[WARNING]* O uso do disco [%s] ultrapassou o limite estipulado na máquina [%s]\t\t", nomeComponente, nomeMaquina);
                break;
            default:
                mensagem = ("[UNKNOWN]");
                break;
        }
        return mensagem;
    }
}
