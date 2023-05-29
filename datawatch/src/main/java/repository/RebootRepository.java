/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.command.ExecStartResultCallback;
import com.github.dockerjava.core.command.WaitContainerResultCallback;

import config.ConexaoAzure;
import java.io.IOException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author victor
 */
public class RebootRepository {
    
    private static final JdbcTemplate jdbcAzure = new ConexaoAzure().getConnection();
    
    public Integer getReboot(Integer fkMaquina) {
        String query = "SELECT rebootar FROM Reboot WHERE fkMaquina = ?";
        Integer reboot = jdbcAzure.queryForObject(query, Integer.class, fkMaquina);
        return reboot;
    }
    
    public void insertReboot(Integer fkMaquina, Integer fkEmpresa) {
        String query = "INSERT INTO Reboot (fkMaquina, fkEmpresa, rebootar) VALUES (?, ?, 0);";
        jdbcAzure.update(query, fkMaquina, fkEmpresa);
    }
    
    public void updateReboot(Integer fkMaquina) {
        String query = "UPDATE Reboot SET rebootar = 0 WHERE fkMaquina = ?;";
        jdbcAzure.update(query, fkMaquina);
    }
    
//    public void rebootar() throws IOException {
//        Runtime runtime = Runtime.getRuntime();
//        Process process = runtime.exec("shutdown -r now");
//
//        try {
//            int codigoDeSaida = process.waitFor();
//            System.out.println("Código de saída: " + codigoDeSaida);
//        } catch (InterruptedException e) {
//        }
//    }

    public void rebootar() throws InterruptedException {
        DefaultDockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder().build();
        DockerClient dockerClient = DockerClientBuilder.getInstance(config).build();
        
        String containerId = "your-container-id";
        
        HostConfig hostConfig = dockerClient.inspectContainerCmd(containerId)
                .exec()
                .getHostConfig();
        
        String[] command = {"sh", "-c", "shutdown -r now"};
        
        String execId = dockerClient.execCreateCmd(containerId)
                .withAttachStdout(true)
                .withAttachStderr(true)
                .withCmd(command)
                .exec()
                .getId();
        
        dockerClient.execStartCmd(execId)
                .exec(new ExecStartResultCallback(System.out, System.err))
                .awaitCompletion();
        
        dockerClient.removeExecCmd(execId).exec();
    }
}
