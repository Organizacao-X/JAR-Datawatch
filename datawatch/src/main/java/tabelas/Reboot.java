/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tabelas;

/**
 *
 * @author victor
 */
public class Reboot {
    private Integer fkMaquina;
    private Integer fkEmpresa;
    private Integer rebootar;

    public Reboot(Integer fkMaquina, Integer fkEmpresa, Integer rebootar) {
        this.fkMaquina = fkMaquina;
        this.fkEmpresa = fkEmpresa;
        this.rebootar = rebootar;
    }
    
    public Reboot() {
        
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
    
    
}
