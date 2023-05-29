/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author victor
 */
public class Log {
    
    private Integer fkAlerta;
    private Integer fkMaquina;
    private Integer fkEmpresa;
    private LocalDateTime dataHora;

    public Log() {
    }

    public Log(Integer fkAlerta, Integer fkMaquina, Integer fkEmpresa, LocalDateTime dataHora) {
        this.fkAlerta = fkAlerta;
        this.fkMaquina = fkMaquina;
        this.fkEmpresa = fkEmpresa;
        this.dataHora = dataHora;
    }

    public Integer getFkAlerta() {
        return fkAlerta;
    }

    public void setFkAlerta(Integer fkAlerta) {
        this.fkAlerta = fkAlerta;
    }

    public Integer getFkMaquina() {
        return fkMaquina;
    }

    public void setFkMaquina(Integer fkMaquina) {
        this.fkMaquina = fkMaquina;
    }

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return String.format("\n-------------------DADOS LOG-------------------\n"
                + "fkMaquina: %d\n"
                + "fkEmpresa: %d\n"
                + "dataHora: %s\n"
                + "---------------------------------------------------",
                fkMaquina,
                fkEmpresa,
                dataHora);
    }
}
