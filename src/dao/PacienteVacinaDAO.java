/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexaoDB.Conexao;
import entity.PacienteVacinaEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author godal
 */
public class PacienteVacinaDAO implements CrudInterface<PacienteVacinaEntity> {

    private final Connection CONEXAODB;
    private PreparedStatement prSet;
    private ResultSet rSet;
    private String sql;
    private List<PacienteVacinaEntity> pacientesList;

    public PacienteVacinaDAO() throws ClassNotFoundException, SQLException {
        this.CONEXAODB = Conexao.conexao();
        this.prSet = null;
        this.rSet = null;
        this.pacientesList = new ArrayList<>();
    }

    @Override
    public boolean registrar(PacienteVacinaEntity dadosRegistro) throws ClassNotFoundException, SQLException {
        sql = "insert into Vacinacao_TABLE (nome_pac, sobrenome_pac, identificao_pac, dataNascimento_pac, genero_pac, email_pac,provincia_pac, planoSaude_pac, numeroPlano_pac, endereco,telefone_pac)values (?,?,?,?,?,?,?,?,?,?,?);";

        prSet = CONEXAODB.prepareStatement(sql);
        prSet.setString(1, dadosRegistro.getNome());
        prSet.setString(2, dadosRegistro.getSobrenome());
        prSet.setString(3, dadosRegistro.getIdentificao());
        prSet.setString(4, dadosRegistro.getDataNascimento());
        prSet.setString(5, dadosRegistro.getGenero());
        prSet.setString(6, dadosRegistro.getEmail());
        prSet.setString(7, dadosRegistro.getProvincia());
        prSet.setString(8, dadosRegistro.getPlanoSaude());
        prSet.setString(9, dadosRegistro.getNumeroPlano());
        prSet.setString(10, dadosRegistro.getEndereco());
        prSet.setString(11, dadosRegistro.getTelefone());

        prSet.execute();
        prSet.close();
        CONEXAODB.close();
        return true;
    }

    @Override
    public boolean login(PacienteVacinaEntity dadosLogin) throws ClassNotFoundException, SQLException {
       return false;
    }

    @Override
    public PacienteVacinaEntity verPerfil(int dadosPerfil) throws ClassNotFoundException, SQLException {
        PacienteVacinaEntity objPacienteVacinaDTO = new PacienteVacinaEntity();
        sql = "SELECT * FROM Vacinacao_TABLE WHERE id=?;";
        prSet = CONEXAODB.prepareStatement(sql);
        prSet.setInt(1, dadosPerfil);

        rSet = prSet.executeQuery();
        if (rSet.next()) {
            objPacienteVacinaDTO.setId(rSet.getInt("id"));
            objPacienteVacinaDTO.setNome(rSet.getString("nome_pac"));
            objPacienteVacinaDTO.setSobrenome(rSet.getString("sobrenome_pac"));
            objPacienteVacinaDTO.setIdentificao(rSet.getString("identificao_pac"));
            objPacienteVacinaDTO.setDataNascimento(rSet.getString("dataNascimento_pac"));
            objPacienteVacinaDTO.setGenero(rSet.getString("genero_pac"));
            objPacienteVacinaDTO.setEmail(rSet.getString("email_pac"));
            objPacienteVacinaDTO.setProvincia(rSet.getString("provincia_pac"));
            objPacienteVacinaDTO.setPlanoSaude(rSet.getString("planoSaude_pac"));
            objPacienteVacinaDTO.setNumeroPlano(rSet.getString("numeroPlano_pac"));
            objPacienteVacinaDTO.setEndereco(rSet.getString("endereco"));
            objPacienteVacinaDTO.setTelefone(rSet.getString("telefone_pac"));
        }
        return objPacienteVacinaDTO;
    }


    @Override
    public boolean editarPerfil(int id, PacienteVacinaEntity dadosEditar) throws ClassNotFoundException, SQLException {
        sql = "update Vacinacao_TABLE set nome_pac=?, sobrenome_pac=?, identificao_pac=?, dataNascimento_pac=?, genero_pac=?, email_pac=?,provincia_pac=?, planoSaude_pac=?, numeroPlano_pac=?, endereco=?,telefone_pac=? where id=?;";
        prSet = this.CONEXAODB.prepareStatement(sql);

        prSet.setString(1, dadosEditar.getNome());
        prSet.setString(2, dadosEditar.getSobrenome());
        prSet.setString(3, dadosEditar.getIdentificao());
        prSet.setString(4, dadosEditar.getDataNascimento());
        prSet.setString(5, dadosEditar.getGenero());
        prSet.setString(6, dadosEditar.getEmail());
        prSet.setString(7, dadosEditar.getProvincia());
        prSet.setString(8, dadosEditar.getPlanoSaude());
        prSet.setString(9, dadosEditar.getNumeroPlano());
        prSet.setString(10, dadosEditar.getEndereco());
        prSet.setString(11, dadosEditar.getTelefone());
        prSet.setInt(12, id);

        prSet.execute();
        return true;
    }

    @Override
    public List<PacienteVacinaEntity> verTodos() throws ClassNotFoundException, SQLException {
        sql = "SELECT * FROM Vacinacao_TABLE";

        prSet = CONEXAODB.prepareStatement(sql);
        rSet = prSet.executeQuery();

        while (rSet.next()) {
            PacienteVacinaEntity objPacienteVacinaDTO = new PacienteVacinaEntity();

            objPacienteVacinaDTO.setId(rSet.getInt(1));
            objPacienteVacinaDTO.setNome(rSet.getString(2));
            objPacienteVacinaDTO.setSobrenome(rSet.getString(3));
            objPacienteVacinaDTO.setIdentificao(rSet.getString(4));
            objPacienteVacinaDTO.setDataNascimento(rSet.getString(5));
            objPacienteVacinaDTO.setGenero(rSet.getString(6));
            objPacienteVacinaDTO.setEmail(rSet.getString(7));
            objPacienteVacinaDTO.setProvincia(rSet.getString(8));
            objPacienteVacinaDTO.setPlanoSaude(rSet.getString(9));
            objPacienteVacinaDTO.setNumeroPlano(rSet.getString(10));
            objPacienteVacinaDTO.setEndereco(rSet.getString(11));
            objPacienteVacinaDTO.setTelefone(rSet.getString(12));
            pacientesList.add(objPacienteVacinaDTO);
        }
        return pacientesList;
    }

    @Override
    public void apagarPerfil(int dadosApagar) throws ClassNotFoundException, SQLException {
        sql = "DELETE FROM Vacinacao_TABLE WHERE id=?";
        prSet = CONEXAODB.prepareStatement(sql);

        prSet.setInt(1, dadosApagar);
        prSet.execute();
    }

}
