/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author victor
 */
public class Usuarios {

    private Integer idUsuario;
    private String nomeUsuario;
    private String email;
    private String cpf;
    private String senha;
    private Integer statusUsuario;
    private String imagemUser;
    private Integer adm;
    private Integer fkEmpresa;
    private String uuid;

    public Usuarios() {
    }

    public Usuarios(Integer idUsuario, String nomeUsuario, String email, String cpf, String senha, Integer statusUsuario, String imagemUser, Integer adm, Integer fkEmpresa, String uuid) {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getStatusUsuario() {
        return statusUsuario;
    }

    public void setStatusUsuario(Integer statusUsuario) {
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return String.format("-------------------DADOS USUARIO-------------------\n"
                + "ID: %d\n"
                + "nomeUsuario: %s\n"
                + "email: %s\n"
                + "CPF: %s\n"
                + "senha: %s\n"
                + "statusUsuario: %d\n"
                + "imagemUser: %s\n"
                + "adm: %d\n"
                + "fkEmpresa: %d\n"
                + "uuid: %s\n"
                + "---------------------------------------------------",
                idUsuario,
                nomeUsuario,
                email,
                cpf,
                senha,
                statusUsuario,
                imagemUser,
                adm,
                fkEmpresa,
                uuid);
    }
}
