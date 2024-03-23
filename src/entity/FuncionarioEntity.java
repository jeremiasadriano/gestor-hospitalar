/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author godal
 */
public class FuncionarioEntity {

    private String nomeFunc, senhaFunc, emailFunc;
    private int idadeFunc, idFunc;

    public FuncionarioEntity() {
    }

    public String getNomeFunc() {
        return nomeFunc;
    }

    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    public String getSenhaFunc() {
        return senhaFunc;
    }

    public void setSenhaFunc(String senhaFunc) {
        this.senhaFunc = senhaFunc;
    }

    public String getEmailFunc() {
        return emailFunc;
    }

    public void setEmailFunc(String emailFunc) {
        this.emailFunc = emailFunc;
    }

    public int getIdadeFunc() {
        return idadeFunc;
    }

    public void setIdadeFunc(int idadeFunc) {
        this.idadeFunc = idadeFunc;
    }

    public int getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

}
