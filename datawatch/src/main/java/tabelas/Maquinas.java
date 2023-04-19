package tabelas;

import java.util.Date;

public class Maquinas {

    private Integer idMaquina;
    private Integer fkEmpresa;
    private String nomeMaquina;
    private String serie;
    private Date dtChegada;
    private String sistemaOperacional;
    private String processador;
    private Long ram;
    private Integer discoMemoria;
    private Long ip;
    private Integer statusSistema;
    private Double cpuPorcentagem;
    private Double ramTotal;
    private Double discoTotal;
    private Double cpuMetrica;
    private Double ramMetrica;
    private Double discoMetrica;
    private Integer tempoAtividade;

    public Maquinas(Integer idMaquina, Integer fkEmpresa, String nomeMaquina, String serie, Date dtChegada, String sistemaOperacional, String processador, Long ram, Integer discoMemoria, Long ip, Integer statusSistema, Double cpuPorcentagem, Double ramTotal, Double discoTotal, Double cpuMetrica, Double ramMetrica, Double discoMetrica, Integer tempoAtividade) {
        this.idMaquina = idMaquina;
        this.fkEmpresa = fkEmpresa;
        this.nomeMaquina = nomeMaquina;
        this.serie = serie;
        this.dtChegada = dtChegada;
        this.sistemaOperacional = sistemaOperacional;
        this.processador = processador;
        this.ram = ram;
        this.discoMemoria = discoMemoria;
        this.ip = ip;
        this.statusSistema = statusSistema;
        this.cpuPorcentagem = cpuPorcentagem;
        this.ramTotal = ramTotal;
        this.discoTotal = discoTotal;
        this.cpuMetrica = cpuMetrica;
        this.ramMetrica = ramMetrica;
        this.discoMetrica = discoMetrica;
        this.tempoAtividade = tempoAtividade;
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

    public Long getRam() {
        return ram;
    }

    public void setRam(Long ram) {
        this.ram = ram;
    }

    public Integer getDiscoMemoria() {
        return discoMemoria;
    }

    public void setDiscoMemoria(Integer discoMemoria) {
        this.discoMemoria = discoMemoria;
    }

    public Long getIp() {
        return ip;
    }

    public void setIp(Long ip) {
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

    public Double getDiscoTotal() {
        return discoTotal;
    }

    public void setDiscoTotal(Double discoTotal) {
        this.discoTotal = discoTotal;
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

    public Double getDiscoMetrica() {
        return discoMetrica;
    }

    public void setDiscoMetrica(Double discoMetrica) {
        this.discoMetrica = discoMetrica;
    }

    public Integer getTempoAtividade() {
        return tempoAtividade;
    }

    public void setTempoAtividade(Integer tempoAtividade) {
        this.tempoAtividade = tempoAtividade;
    }

    @Override
    public String toString() {
        return "Maquinas{" + "idMaquina=" + idMaquina + ", fkEmpresa=" + fkEmpresa + ", nomeMaquina=" + nomeMaquina + ", serie=" + serie + ", dtChegada=" + dtChegada + ", sistemaOperacional=" + sistemaOperacional + ", processador=" + processador + ", ram=" + ram + ", discoMemoria=" + discoMemoria + ", ip=" + ip + ", statusSistema=" + statusSistema + ", cpuPorcentagem=" + cpuPorcentagem + ", ramTotal=" + ramTotal + ", discoTotal=" + discoTotal + ", cpuMetrica=" + cpuMetrica + ", ramMetrica=" + ramMetrica + ", discoMetrica=" + discoMetrica + ", tempoAtividade=" + tempoAtividade + '}';
    }
    
    
}
