/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author victor
 */
public class Reboot {
    
    private Integer fkMaquina;
    private Integer fkEmpresa;
    private Integer rebootar;

    public Reboot() {
    }

    public Reboot(Integer fkMaquina, Integer fkEmpresa, Integer reebotar) {
        this.fkMaquina = fkMaquina;
        this.fkEmpresa = fkEmpresa;
        this.rebootar = reebotar;
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

    public Integer getRebootar() {
        return rebootar;
    }

    public void setRebootar(Integer rebootar) {
        this.rebootar = rebootar;
    }

    @Override
    public String toString() {
        return String.format("-------------------DADOS REBOOT-------------------\n"
                + "fkMaquina: %d\n"
                + "fkEmpresa: %d\n"
                + "reebotar: %d\n"
                + "---------------------------------------------------",
                fkMaquina,
                fkEmpresa,
                rebootar);
    }
    
    
}
