/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.RebootRepository;

/**
 *
 * @author victor
 */
public class RebootService {
    
    private static final RebootRepository rebootRepository = new RebootRepository();
    
    public static Boolean getReboot(Integer idMaquina) {
        Integer rebootar = rebootRepository.getReboot(idMaquina);
        return rebootar != 0;
    }
    
    public static void insertReboot(Integer idMaquina, Integer fkEmpresa) {
        rebootRepository.insertReboot(idMaquina, fkEmpresa);
    }
    
    public static void updateReboot(Integer idMaquina) {
        rebootRepository.updateReboot(idMaquina);
    }
    
    public static void rebootar(Integer idMaquina) throws InterruptedException { 
        Integer rebootar = rebootRepository.getReboot(idMaquina);
        if (rebootar != 0) {
            updateReboot(idMaquina);
            System.out.println("Reiniciando a máquina em 3 segundos.");
            Thread.sleep(3000);
            try {
                rebootRepository.rebootar();
            } catch (IOException ex) {
                Logger.getLogger(RebootService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
