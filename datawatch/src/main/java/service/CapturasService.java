/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import java.time.LocalDateTime;
import java.util.List;
import model.Capturas;
import repository.CapturasRepositoryAzure;
import repository.CapturasRepositoryMySQL;
import utility.Util;

/**
 *
 * @author victor
 */
public class CapturasService {
    
    private static final Looca looca = new Looca();
    private static final CapturasRepositoryAzure capturasRepositoryAzure = new CapturasRepositoryAzure();
    private static final CapturasRepositoryMySQL capturasRepositoryMySQL = new CapturasRepositoryMySQL();
    
    public static void setCaptura(Capturas captura) {
        List<RedeInterface> ri = looca.getRede().getGrupoDeInterfaces().getInterfaces();
        
        Integer qtdDiscos = looca.getGrupoDeDiscos().getQuantidadeDeDiscos();
        
        switch (qtdDiscos) {
            case 1:
                captura.setLivreDisco1(Util.formatarParaDouble(looca.getGrupoDeDiscos().getVolumes().get(0).getDisponivel()));
                captura.setLivreDisco2(null);
                captura.setLivreDisco3(null);
                break;
            case 2: 
                captura.setLivreDisco1(Util.formatarParaDouble(looca.getGrupoDeDiscos().getVolumes().get(0).getDisponivel()));
                captura.setLivreDisco2(Util.formatarParaDouble(looca.getGrupoDeDiscos().getVolumes().get(1).getDisponivel()));
                captura.setLivreDisco3(null);
                break;
            case 3:
                captura.setLivreDisco1(Util.formatarParaDouble(looca.getGrupoDeDiscos().getVolumes().get(0).getDisponivel()));
                captura.setLivreDisco2(Util.formatarParaDouble(looca.getGrupoDeDiscos().getVolumes().get(1).getDisponivel()));
                captura.setLivreDisco3(Util.formatarParaDouble(looca.getGrupoDeDiscos().getVolumes().get(2).getDisponivel()));
                break;
            default:
                throw new AssertionError();
        }
        
        captura.setCpuUso(looca.getProcessador().getUso());
        captura.setDataHora(LocalDateTime.now());
        captura.setTemperatura(10 + Math.random() * looca.getProcessador().getUso());
        captura.setRamUso(Util.formatarParaDouble(looca.getMemoria().getEmUso()));
        captura.setRedeDownload(Util.formatarParaDouble(ri.get(ri.size() -1).getBytesRecebidos()));
        captura.setRedeUpload(Util.formatarParaDouble(ri.get(ri.size() - 1).getBytesEnviados()));
        
        System.out.println("Dados capturados!");
        System.out.println(captura);
    }
    
    public static void insertCapturaAzure(Capturas captura) {
        if (captura != null) {
            capturasRepositoryAzure.insertCaptura(captura);
            System.out.println("Dados da captura inseridos no banco. - Azure");
        } else {
            System.out.println("Insert de captura falhou. Objeto captura inválido.");
        }
    }

    public static void insertCapturaMySQL(Capturas captura) {
        if (captura != null) {
            capturasRepositoryMySQL.insertCaptura(captura);
            System.out.println("Dados da captura inseridos no banco. - MySQL");
        } else {
            System.out.println("Insert de captura falhou. Objeto captura inválido.");
        }
    }
    
    public static Capturas getUltimaCaptura(Integer fkMaquina) {
        Capturas captura = capturasRepositoryAzure.getUltimaCaptura(fkMaquina);
        return captura;
    }
}
