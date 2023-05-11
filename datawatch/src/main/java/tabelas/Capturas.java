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
    private Double LivreDisco1;
    private Double LivreDisco2;
    private Double LivreDisco3;

    public Capturas(Integer idCaptura, Integer fkMaquina, Integer fkEmpresa, Date dataHora, Double cpuUso, Double temperatura, Double ramUso, Double redeUpload, Double redeDownload, Double LivreDisco1, Double LivreDisco2, Double LivreDisco3) {
        this.idCaptura = idCaptura;
        this.fkMaquina = fkMaquina;
        this.fkEmpresa = fkEmpresa;
        this.dataHora = dataHora;
        this.cpuUso = cpuUso;
        this.temperatura = temperatura;
        this.ramUso = ramUso;
        this.redeUpload = redeUpload;
        this.redeDownload = redeDownload;
        this.LivreDisco1 = LivreDisco1;
        this.LivreDisco2 = LivreDisco2;
        this.LivreDisco3 = LivreDisco3;
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

    public Double getLivreDisco1() {
        return LivreDisco1;
    }

    public void setLivreDisco1(Double LivreDisco1) {
        this.LivreDisco1 = LivreDisco1;
    }

    public Double getLivreDisco2() {
        return LivreDisco2;
    }

    public void setLivreDisco2(Double LivreDisco2) {
        this.LivreDisco2 = LivreDisco2;
    }

    public Double getLivreDisco3() {
        return LivreDisco3;
    }

    public void setLivreDisco3(Double LivreDisco3) {
        this.LivreDisco3 = LivreDisco3;
    }

    @Override
    public String toString() {
        return String.format("\n\n-=-=-=-=-=-=-=-=-=-=-"
                + "\nidCaptura: %d"
                + "\nfkMaquina: %d"
                + "\nfkEmpresa: %d"
                + "\ndataHora: %s"
                + "\ncpuUso: %.2f"
                + "\ntemperatura: %.2f"
                + "\nramUso: %.2f"
                + "\nredeUpload: %.2f"
                + "\nredeDownload: %.2f"
                + "\nLivreDisco1: %.2f"
                + "\nLivreDisco2: %.2f"
                + "\nLivreDisco3: %.2f", idCaptura, fkMaquina, fkEmpresa, dataHora, cpuUso, temperatura, ramUso, redeUpload, redeDownload, LivreDisco1, LivreDisco2, LivreDisco3);
    }
    
    
}
