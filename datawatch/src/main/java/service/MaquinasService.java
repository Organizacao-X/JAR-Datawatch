/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import com.github.britooo.looca.api.util.Conversor;
import java.util.List;
import model.Maquinas;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import repository.MaquinasRepositoryAzure;
import repository.MaquinasRepositoryMySQL;
import utility.Util;

/**
 *
 * @author victor
 */
public class MaquinasService {
    private static final Looca looca = new Looca();
    private static final MaquinasRepositoryAzure maquinasRepositoryAzure = new MaquinasRepositoryAzure();
    private static final MaquinasRepositoryMySQL maquinasRepositoryMySQL = new MaquinasRepositoryMySQL();
 
    public static Maquinas setMaquina() {
        //<editor-fold defaultstate="collapsed" desc="sets da máquina com os dados do looca">
        Maquinas maquina = new Maquinas();
        Double ramTotal = Util.formatarParaDouble(looca.getMemoria().getTotal());
        List<RedeInterface> ri = looca.getRede().getGrupoDeInterfaces().getInterfaces();
        List<Disco> discos = looca.getGrupoDeDiscos().getDiscos();
        
//        for (Disco disco : discos) {
//            System.out.println(disco);
//            System.out.println(Conversor.formatarBytes(disco.getTamanho()));
//        }
        
//        List<Volume> volumes = looca.getGrupoDeDiscos().getVolumes();
//        for (Volume volume : volumes) {
//            System.out.println();
//            System.out.println(volume);
//            System.out.println(Conversor.formatarBytes(volume.getTotal()));
//            System.out.println(Conversor.formatarBytes(volume.getDisponivel()));
//        }

        Disco disco1 = discos.get(0);
        Disco disco2 = discos.size() > 1 ? discos.get(1) : null;
        Disco disco3 = discos.size() > 2 ? discos.get(2) : null;
        Double totalDisco1 = disco1 != null ? Util.formatarParaDouble(looca.getGrupoDeDiscos().getVolumes().get(0).getTotal()) : null;
        Double totalDisco2 = disco2 != null ? Util.formatarParaDouble(disco2.getTamanho()) : null;
        Double totalDisco3 = disco3 != null ? Util.formatarParaDouble(disco3.getTamanho()) : null;
        
        maquina.setCpuPorcentagem(looca.getProcessador().getUso());
        maquina.setIp(ri.get(ri.size() - 1).getEnderecoIpv4().get(0));
        maquina.setMac(ri.get(ri.size() - 1).getEnderecoMac());
        maquina.setNomeDisco1(disco1.getModelo());
        maquina.setNomeDisco2(disco2 != null ? disco2.getModelo() : null);
        maquina.setNomeDisco3(disco3 != null ? disco3.getModelo() : null);
        maquina.setNomeMaquina(looca.getRede().getParametros().getHostName());
        maquina.setProcessador(looca.getProcessador().getNome());
        maquina.setRam(Conversor.formatarBytes(looca.getMemoria().getTotal()));
        maquina.setRamTotal(ramTotal);
        maquina.setSistemaOperacional(looca.getSistema().getSistemaOperacional());
        maquina.setTempoAtividade(Integer.valueOf(looca.getSistema().getTempoDeAtividade() + ""));
        maquina.setTotalDisco1(totalDisco1);
        maquina.setTotalDisco2(totalDisco2);
        maquina.setTotalDisco3(totalDisco3);
        maquina.setSerie(Util.randomizeSerie());
        maquina.setStatusSistema(1);
        
        maquina.setCpuMetrica(90.0);
        maquina.setRamMetrica(ramTotal * 0.95);
        maquina.setGatilhoDisco1(totalDisco1 * 0.9);
        maquina.setGatilhoDisco2(totalDisco2 == null ? null : totalDisco2 * 0.70);
        maquina.setGatilhoDisco3(totalDisco3 == null ? null : totalDisco3 * 0.70);
        
        return maquina;
        //</editor-fold>
    }
    
    public static Maquinas getMaquinaAzure() {
        // Pega o mac
        List<RedeInterface> ri = looca.getRede().getGrupoDeInterfaces().getInterfaces();
        String mac = ri.get(ri.size() - 1).getEnderecoMac();
        if (mac != null) {
            Maquinas maquinaBanco = maquinasRepositoryAzure.getMaquina(mac);
            if (maquinaBanco != null) {
                System.out.println("Máquina já existente no banco de dados. - Azure");
                return maquinaBanco;
            }
        }
        return null;
    }
    
    public static Maquinas updateMaquinaAzure(Maquinas maquina) {
        Maquinas maquinaNova = setMaquina();
        maquinaNova.setIdMaquina(maquina.getIdMaquina());
        maquinaNova.setFkEmpresa(maquina.getFkEmpresa());
        maquinaNova.setSerie(maquina.getSerie());
        
        maquinasRepositoryAzure.updateMaquina(maquinaNova);
        System.out.println("Dados da máquina atualizados. - Azure");
        return maquinaNova;
    }
    
    public static void insertMaquinaAzure(Maquinas maquina) {
        if (maquina != null) {
            SqlRowSet rs = maquinasRepositoryAzure.insertMaquina(maquina);
            if(rs.next()) {
                    maquina.setIdMaquina(rs.getInt("idMaquina"));
                    maquina.setDtChegada(rs.getDate("dtChegada"));
            }
            System.out.println("Máquina inserida com sucesso. - Azure");
            
        } else {
            System.out.println("Não é possível inserir dados da máquina. Objeto inválido.");
        }
    }
    
    public static void updateMaquinaMySQL(Maquinas maquina) {
        Maquinas maquinaNova = setMaquina();
        maquinaNova.setIdMaquina(maquina.getIdMaquina());
        maquinaNova.setFkEmpresa(maquina.getFkEmpresa());
        maquinaNova.setCpuMetrica(maquina.getCpuMetrica());
        maquinaNova.setGatilhoDisco1(maquina.getGatilhoDisco1());
        maquinaNova.setGatilhoDisco2(maquina.getGatilhoDisco2());
        maquinaNova.setGatilhoDisco3(maquina.getGatilhoDisco3());
        maquinaNova.setRamMetrica(maquina.getRamMetrica());
        maquinaNova.setSerie(maquina.getSerie());
        
        maquinasRepositoryMySQL.updateMaquina(maquinaNova);
        System.out.println("Dados da máquina atualizados. - MySQL");
    }
    
    public static void insertMaquinaMySQL(Maquinas maquina) {
        if (maquina != null) {
            maquinasRepositoryMySQL.insertMaquina(maquina);
            System.out.println("Máquina inserida com sucesso. - MySQL");
        } else {
            System.out.println("Não é possível inserir dados da máquina. Objeto inválido.");
        }
    }
}
