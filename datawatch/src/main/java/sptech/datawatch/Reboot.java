package sptech.datawatch;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.command.ExecStartResultCallback;

public class Reboot {

    public void rebootar() {
        DockerClient dockerClient = DockerClientBuilder.getInstance().build();

        String containerId = "seu_container_id";

        CreateContainerResponse container = dockerClient.createContainerCmd(containerId)
                .withCmd("shutdown", "-r", "now")
                .exec();

        dockerClient.startContainerCmd(container.getId()).exec();

        ExecStartResultCallback callback = new ExecStartResultCallback();
        dockerClient.execStartCmd(container.getId()).exec(callback);
    }
}
