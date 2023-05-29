/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;


/**
 *
 * @author victor
 */
public class Maquinas {

    private Integer idMaquina;
    private Integer fkEmpresa;
    private String nomeMaquina;
    private String serie;
    private Date dtChegada;
    private String sistemaOperacional;
    private String processador;
    private String ram;
    private String nomeDisco1;
    private String ip;
    private Integer statusSistema;
    private Double cpuPorcentagem;
    private Double ramTotal;
    private Double totalDisco1;
    private Double cpuMetrica;
    private Double ramMetrica;
    private Double gatilhoDisco1;
    private Integer tempoAtividade;
    private String nomeDisco2;
    private String nomeDisco3;
    private Double totalDisco2;
    private Double totalDisco3;
    private Double gatilhoDisco2;
    private Double gatilhoDisco3;
    private String mac;

    public Maquinas(Integer idMaquina, Integer fkEmpresa, String nomeMaquina, String serie, Date dtChegada, String sistemaOperacional, String processador, String ram, String nomeDisco1, String ip, Integer statusSistema, Double cpuPorcentagem, Double ramTotal, Double totalDisco1, Double cpuMetrica, Double ramMetrica, Double gatilhoDisco1, Integer tempoAtividade, String nomeDisco2, String nomeDisco3, Double totalDisco2, Double totalDisco3, Double gatilhoDisco2, Double gatilhoDisco3, String mac) {
        this.idMaquina = idMaquina;
        this.fkEmpresa = fkEmpresa;
        this.nomeMaquina = nomeMaquina;
        this.serie = serie;
        this.dtChegada = dtChegada;
        this.sistemaOperacional = sistemaOperacional;
        this.processador = processador;
        this.ram = ram;
        this.nomeDisco1 = nomeDisco1;
        this.ip = ip;
        this.statusSistema = statusSistema;
        this.cpuPorcentagem = cpuPorcentagem;
        this.ramTotal = ramTotal;
        this.totalDisco1 = totalDisco1;
        this.cpuMetrica = cpuMetrica;
        this.ramMetrica = ramMetrica;
        this.gatilhoDisco1 = gatilhoDisco1;
        this.tempoAtividade = tempoAtividade;
        this.nomeDisco2 = nomeDisco2;
        this.nomeDisco3 = nomeDisco3;
        this.totalDisco2 = totalDisco2;
        this.totalDisco3 = totalDisco3;
        this.gatilhoDisco2 = gatilhoDisco2;
        this.gatilhoDisco3 = gatilhoDisco3;
        this.mac = mac;
    }

    public Maquinas() {

    }

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    public String getNomeMaquina() {
        return nomeMaquina;
    }

    public void setNomeMaquina(String nomeMaquina) {
        this.nomeMaquina = nomeMaquina;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Date getDtChegada() {
        return dtChegada;
    }

    public void setDtChegada(Date dtChegada) {
        this.dtChegada = dtChegada;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getNomeDisco1() {
        return nomeDisco1;
    }

    public void setNomeDisco1(String nomeDisco1) {
        this.nomeDisco1 = nomeDisco1;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getStatusSistema() {
        return statusSistema;
    }

    public void setStatusSistema(Integer statusSistema) {
        this.statusSistema = statusSistema;
    }

    public Double getCpuPorcentagem() {
        return cpuPorcentagem;
    }

    public void setCpuPorcentagem(Double cpuPorcentagem) {
        this.cpuPorcentagem = cpuPorcentagem;
    }

    public Double getRamTotal() {
        return ramTotal;
    }

    public void setRamTotal(Double ramTotal) {
        this.ramTotal = ramTotal;
    }

    public Double getTotalDisco1() {
        return totalDisco1;
    }

    public void setTotalDisco1(Double totalDisco1) {
        this.totalDisco1 = totalDisco1;
    }

    public Double getCpuMetrica() {
        return cpuMetrica;
    }

    public void setCpuMetrica(Double cpuMetrica) {
        this.cpuMetrica = cpuMetrica;
    }

    public Double getRamMetrica() {
        return ramMetrica;
    }

    public void setRamMetrica(Double ramMetrica) {
        this.ramMetrica = ramMetrica;
    }

    public Double getGatilhoDisco1() {
        return gatilhoDisco1;
    }

    public void setGatilhoDisco1(Double gatilhoDisco1) {
        this.gatilhoDisco1 = gatilhoDisco1;
    }

    public Integer getTempoAtividade() {
        return tempoAtividade;
    }

    public void setTempoAtividade(Integer tempoAtividade) {
        this.tempoAtividade = tempoAtividade;
    }

    public String getNomeDisco2() {
        return nomeDisco2;
    }

    public void setNomeDisco2(String nomeDisco2) {
        this.nomeDisco2 = nomeDisco2;
    }

    public String getNomeDisco3() {
        return nomeDisco3;
    }

    public void setNomeDisco3(String nomeDisco3) {
        this.nomeDisco3 = nomeDisco3;
    }

    public Double getTotalDisco2() {
        return totalDisco2;
    }

    public void setTotalDisco2(Double totalDisco2) {
        this.totalDisco2 = totalDisco2;
    }

    public Double getTotalDisco3() {
        return totalDisco3;
    }

    public void setTotalDisco3(Double totalDisco3) {
        this.totalDisco3 = totalDisco3;
    }

    public Double getGatilhoDisco2() {
        return gatilhoDisco2;
    }

    public void setGatilhoDisco2(Double gatilhoDisco2) {
        this.gatilhoDisco2 = gatilhoDisco2;
    }

    public Double getGatilhoDisco3() {
        return gatilhoDisco3;
    }

    public void setGatilhoDisco3(Double gatilhoDisco3) {
        this.gatilhoDisco3 = gatilhoDisco3;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    @Override
    public String toString() {
        return String.format("\n-------------------DADOS MÁQUINA-------------------\n"
                + "ID: %d\n"
                + "fkEmpresa: %d\n"
                + "nomeMaquina: %s\n"
                + "serie: %s\n"
                + "dtChegada: %s\n"
                + "SO: %s\n"
                + "CPU: %s\n"
                + "RAM: %s\n"
                + "nomeDisco1: %s\n"
                + "nomeDisco2: %s\n"
                + "nomeDisco3: %s\n"
                + "totalDisco1: %.2f\n"
                + "totalDisco2: %.2f\n"
                + "totalDisco3: %.2f\n"
                + "gatilhoDisco1: %.2f\n"
                + "gatilhoDisco2: %.2f\n"
                + "gatilhoDisco3: %.2f\n"
                + "IP: %s\n"
                + "MAC: %s\n"
                + "Status: %d\n"
                + "CPU Pct: %.2f\n"
                + "CPU Metrica: %.2f\n"
                + "RAM Total: %.2f\n"
                + "RAM Metrica: %.2f\n"
                + "Tempo atividade: %d\n"
                + "---------------------------------------------------",
                idMaquina,
                fkEmpresa,
                nomeMaquina,
                serie,
                dtChegada,
                sistemaOperacional,
                processador,
                ram,
                nomeDisco1,
                nomeDisco2,
                nomeDisco3,
                totalDisco1,
                totalDisco2,
                totalDisco3,
                gatilhoDisco1,
                gatilhoDisco2,
                gatilhoDisco3,
                ip,
                mac,
                statusSistema,
                cpuPorcentagem,
                cpuMetrica,
                ramTotal,
                ramMetrica,
                tempoAtividade);
    }
}
