/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author victor
 */
public class Empresas {
    
    private Integer idEmpresa;
    private String razaoSocial;
    private String cnpj;
    private String cep;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private Integer verificado;

    public Empresas() {
    }

    public Empresas(Integer idEmpresa, String razaoSocial, String cnpj, String cep, String logradouro, Integer numero, String complemento, String bairro, String cidade, String estado, Integer verificado) {
        this.idEmpresa = idEmpresa;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.verificado = verificado;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getVerificado() {
        return verificado;
    }

    public void setVerificado(Integer verificado) {
        this.verificado = verificado;
    }

    @Override
    public String toString() {
        return String.format("-------------------DADOS EMPRESA-------------------\n"
                + "ID: %d\n"
                + "razaoSocial: %s\n"
                + "CNPJ: %s\n"
                + "CEP: %s\n"
                + "logradouro: %s\n"
                + "numero: %d\n"
                + "complemento: %s\n"
                + "bairro: %s\n"
                + "cidade: %s\n"
                + "estado: %s\n"
                + "verificado: %d\n"
                + "---------------------------------------------------",
                idEmpresa,
                razaoSocial,
                cnpj,
                cep,
                logradouro,
                numero,
                complemento,
                bairro,
                cidade,
                estado,
                verificado);
    }
    
    
}
