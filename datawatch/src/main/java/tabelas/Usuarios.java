package tabelas;

public class Usuarios {

    private Integer idUsuario;
    private String nomeUsuario;
    private String email;
    private Long cpf;
    private String senha;
    private Boolean statusUsuario;
    private String imagemUser;
    private Integer adm;
    private Integer fkEmpresa;
    private String uuid;

    public Usuarios(Integer idUsuario, String nomeUsuario, String email, Long cpf, String senha, Boolean statusUsuario, String imagemUser, Integer adm, Integer fkEmpresa, String uuid) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
        this.statusUsuario = statusUsuario;
        this.imagemUser = imagemUser;
        this.adm = adm;
        this.fkEmpresa = fkEmpresa;
        this.uuid = uuid;
    }
    
    
    
        public Usuarios() {
        
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getStatusUsuario() {
        return statusUsuario;
    }

    public void setStatusUsuario(Boolean statusUsuario) {
        this.statusUsuario = statusUsuario;
    }

    public String getImagemUser() {
        return imagemUser;
    }

    public void setImagemUser(String imagemUser) {
        this.imagemUser = imagemUser;
    }

    public Integer getAdm() {
        return adm;
    }

    public void setAdm(Integer adm) {
        this.adm = adm;
    }

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "idUsuario=" + idUsuario + ", nomeUsuario=" + nomeUsuario + ", email=" + email + ", cpf=" + cpf + ", senha=" + senha + ", statusUsuario=" + statusUsuario + ", imagemUser=" + imagemUser + ", adm=" + adm + ", fkEmpresa=" + fkEmpresa + '}';
    }
    
    
}
