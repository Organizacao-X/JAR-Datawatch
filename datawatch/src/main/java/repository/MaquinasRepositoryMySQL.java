/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import config.ConexaoMySQL;
import model.Maquinas;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author victor
 */
public class MaquinasRepositoryMySQL {
    
    private static final JdbcTemplate jdbcMySQL = new ConexaoMySQL().getConnection();
  
    public void insertMaquina(Maquinas maquina) {
        String query = 
                "INSERT INTO Maquinas (fkEmpresa, nomeMaquina, serie, dtChegada, sistemaOperacional, processador, "
                + "ram, nomeDisco1, nomeDisco2, nomeDisco3, ip, statusSistema, cpuPorcentagem, ramTotal, totalDisco1, "
                + "totalDisco2, totalDisco3, cpuMetrica, ramMetrica, gatilhoDisco1, gatilhoDisco2, gatilhoDisco3, tempoAtividade, mac) "
                + "VALUES "
                + "(?, ?, ?, CURRENT_DATE, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        jdbcMySQL.update(query, maquina.getFkEmpresa(),
                maquina.getNomeMaquina(),
                maquina.getSerie(),
                maquina.getSistemaOperacional(),
                maquina.getProcessador(),
                maquina.getRam(),
                maquina.getNomeDisco1(),
                maquina.getNomeDisco2(),
                maquina.getNomeDisco3(),
                maquina.getIp(),
                maquina.getStatusSistema(),
                maquina.getCpuPorcentagem(),
                maquina.getRamTotal(),
                maquina.getTotalDisco1(),
                maquina.getTotalDisco2(),
                maquina.getTotalDisco3(),
                maquina.getCpuMetrica(),
                maquina.getRamMetrica(),
                maquina.getGatilhoDisco1(),
                maquina.getGatilhoDisco2(),
                maquina.getGatilhoDisco3(),
                maquina.getTempoAtividade(),
                maquina.getMac());
    }
    
    public void updateMaquina(Maquinas maquina) {
        String query = "UPDATE Maquinas SET nomeMaquina = ?, serie = ?, sistemaOperacional = ?,"
                + "processador = ?, ram = ?, nomeDisco1 = ?, ip = ?, cpuPorcentagem = ?, ramTotal = ?,"
                + "totalDisco1 = ?, cpuMetrica = ?, ramMetrica = ?, gatilhoDisco1 = ?, tempoAtividade = ?,"
                + "nomeDisco2 = ?, nomeDisco3 = ?, totalDisco2 = ?, totalDisco3 = ?, gatilhoDisco2 = ?,"
                + "gatilhoDisco3 = ?, mac = ? WHERE idMaquina = ?";
        
        jdbcMySQL.update(query,
                maquina.getNomeMaquina(),
                maquina.getSerie(),
                maquina.getSistemaOperacional(),
                maquina.getProcessador(),
                maquina.getRam(),
                maquina.getNomeDisco1(),
                maquina.getIp(),
                maquina.getCpuPorcentagem(),
                maquina.getRamTotal(),
                maquina.getTotalDisco1(),
                maquina.getCpuMetrica(),
                maquina.getRamMetrica(),
                maquina.getGatilhoDisco1(),
                maquina.getTempoAtividade(),
                maquina.getNomeDisco2(),
                maquina.getNomeDisco3(),
                maquina.getTotalDisco2(),
                maquina.getTotalDisco3(),
                maquina.getGatilhoDisco2(),
                maquina.getGatilhoDisco3(),
                maquina.getMac(),
                maquina.getIdMaquina());
    }
}
