package tabelas;

public class Possuem {

    private Integer idPosse;
    private Integer fkEmpresa;
    private Integer fkAlerta;
    private Integer fkMaquina;
    private Integer dataHora;

    public Possuem(Integer idPosse, Integer fkEmpresa, Integer fkAlerta, Integer fkMaquina, Integer dataHora) {
        this.idPosse = idPosse;
        this.fkEmpresa = fkEmpresa;
        this.fkAlerta = fkAlerta;
        this.fkMaquina = fkMaquina;
        this.dataHora = dataHora;
    }

    public Possuem() {

    }

    public Integer getIdPosse() {
        return idPosse;
    }

    public void setIdPosse(Integer idPosse) {
        this.idPosse = idPosse;
    }

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
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

    public Integer getDataHora() {
        return dataHora;
    }

    public void setDataHora(Integer dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "Possuem{" + "idPosse=" + idPosse + ", fkEmpresa=" + fkEmpresa + "fkAlerta=" + fkAlerta + ", fkMaquina=" + fkMaquina + ", dataHora=" + dataHora + '}';
    }

}
