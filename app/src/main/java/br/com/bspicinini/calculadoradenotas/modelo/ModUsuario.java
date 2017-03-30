package br.com.bspicinini.calculadoradenotas.modelo;

/**
 * Created by bspicinini on 30/03/2017.
 */

public class ModUsuario {
    private int codUsuario;
    private String nomUsuario;
    private String descLogin;
    private String descPassword;
    private String descEmail;

    public int getCodUsuario() {
        return codUsuario;
    }

    public String getDescEmail() {
        return descEmail;
    }

    public void setDescEmail(String descEmail) {
        this.descEmail = descEmail;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getDescLogin() {
        return descLogin;
    }

    public void setDescLogin(String descLogin) {
        this.descLogin = descLogin;
    }

    public String getDescPassword() {
        return descPassword;
    }

    public void setDescPassword(String descPassword) {
        this.descPassword = descPassword;
    }
}
