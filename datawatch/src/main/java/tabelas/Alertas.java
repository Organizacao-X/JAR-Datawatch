package tabelas;

public class Alertas {

    private Integer idAlerta;
    private String nomeAlerta;

    public Alertas(Integer idAlerta, String nomeAlerta) {
        this.idAlerta = idAlerta;
        this.nomeAlerta = nomeAlerta;
    }

    public Alertas(){
    }
    
    public Integer getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(Integer idAlerta) {
        this.idAlerta = idAlerta;
    }

    public String getNomeAlerta() {
        return nomeAlerta;
    }

    public void setNomeAlerta(String nomeAlerta) {
        this.nomeAlerta = nomeAlerta;
    }

    @Override
    public String toString() {
        return "Alertas{" + "idAlerta=" + idAlerta + ", nomeAlerta=" + nomeAlerta + '}';
    }

    
}
