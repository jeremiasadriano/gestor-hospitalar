/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author godal
 */
public class AgendaEntity {

    private String nome, sobrenome, dataConsulta, genero, dataNascimento, endereco, provincia, atendimentoCheckBox, idPlano, feedBackAtendimento, telefone, email, planoSaude;
    private int id;

    public AgendaEntity() {
    }

    public String getEmail() {
        return email;
    }

    public String getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(String planoSaude) {
        this.planoSaude = planoSaude;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String data) {
        this.dataConsulta = data;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getAtendimentoCheckBox() {
        return atendimentoCheckBox;
    }

    public void setAtendimentoCheckBox(String atendimentoCheckBox) {
        this.atendimentoCheckBox = atendimentoCheckBox;
    }

    public String getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(String numeroId) {
        this.idPlano = numeroId;
    }

    public String getFeedBackAtendimento() {
        return feedBackAtendimento;
    }

    public void setFeedBackAtendimento(String experiencia) {
        this.feedBackAtendimento = experiencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
