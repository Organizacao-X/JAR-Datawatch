package tabelas;

import java.util.Date;

public class Capturas {

    private Integer idCaptura;
    private Integer fkMaquina;
    private Integer fkEmpresa;
    private Date dataHora;
    private Double cpuUso;
    private Double temperatura;
    private Double ramUso;
    private Double redeUpload;
    private Double redeDownload;
    private Double discoLivre;

    public Capturas(Integer idCaptura, Integer fkMaquina, Integer fkEmpresa, Date dataHora, Double cpuUso, Double temperatura, Double ramUso, Double redeUpload, Double redeDownload, Double discoLivre) {
        this.idCaptura = idCaptura;
        this.fkMaquina = fkMaquina;
        this.fkEmpresa = fkEmpresa;
        this.dataHora = dataHora;
        this.cpuUso = cpuUso;
        this.temperatura = temperatura;
        this.ramUso = ramUso;
        this.redeUpload = redeUpload;
        this.redeDownload = redeDownload;
        this.discoLivre = discoLivre;
    }

    public Capturas() {
    }

    public Integer getIdCaptura() {
        return idCaptura;
    }

    public void setIdCaptura(Integer idCaptura) {
        this.idCaptura = idCaptura;
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

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Double getCpuUso() {
        return cpuUso;
    }

    public void setCpuUso(Double cpuUso) {
        this.cpuUso = cpuUso;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getRamUso() {
        return ramUso;
    }

    public void setRamUso(Double ramUso) {
        this.ramUso = ramUso;
    }

    public Double getRedeUpload() {
        return redeUpload;
    }

    public void setRedeUpload(Double redeUpload) {
        this.redeUpload = redeUpload;
    }

    public Double getRedeDownload() {
        return redeDownload;
    }

    public void setRedeDownload(Double redeDownload) {
        this.redeDownload = redeDownload;
    }

    public Double getDiscoLivre() {
        return discoLivre;
    }

    public void setDiscoLivre(Double discoLivre) {
        this.discoLivre = discoLivre;
    }

    @Override
    public String toString() {
        return "Capturas{" + "idCaptura=" + idCaptura + ", fkMaquina=" + fkMaquina + ", fkEmpresa=" + fkEmpresa + ", dataHora=" + dataHora + ", cpuUso=" + cpuUso + ", temperatura=" + temperatura + ", ramUso=" + ramUso + ", redeUpload=" + redeUpload + ", redeDownload=" + redeDownload + ", discoLivre=" + discoLivre + '}';
    }
    
    
}
