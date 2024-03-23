/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexaoDB.Conexao;
import entity.ConsultasEntity;
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
public class ConsultasDAO implements CrudInterface<ConsultasEntity> {

    private final Connection CONEXAODB;
    private PreparedStatement prSet;
    private ResultSet rSet;
    private String sql;
    private List<ConsultasEntity> pacientesList;

    public ConsultasDAO() throws ClassNotFoundException, SQLException {
        this.CONEXAODB = Conexao.conexao();
        this.prSet = null;
        this.rSet = null;
        this.pacientesList = new ArrayList<>();
    }

    @Override
    public boolean registrar(ConsultasEntity dadosRegistro) throws ClassNotFoundException, SQLException {
        sql = "insert into Consultas_TABLE (nome, sobrenome, email, peso, idade, metas, objetivos, altura,dataC)values (?,?,?,?,?,?,?,?,?);";

        prSet = CONEXAODB.prepareStatement(sql);
        prSet.setString(1, dadosRegistro.getNome());
        prSet.setString(2, dadosRegistro.getSobrenome());
        prSet.setString(3, dadosRegistro.getEmail());
        prSet.setDouble(4, dadosRegistro.getPeso());
        prSet.setInt(5, dadosRegistro.getIdade());
        prSet.setString(6, dadosRegistro.getMetas());
        prSet.setString(7, dadosRegistro.getObjetivos());
        prSet.setDouble(8, dadosRegistro.getAltura());
        prSet.setString(9, dadosRegistro.getData());

        prSet.execute();
        prSet.close();
        CONEXAODB.close();
        return true;
    }

    @Override
    public boolean login(ConsultasEntity dadosLogin) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ConsultasEntity verPerfil(int dadosPerfil) throws ClassNotFoundException, SQLException {
        ConsultasEntity objConsultasDTO = new ConsultasEntity();
        sql = "SELECT * FROM Consultas_TABLE WHERE id=?;";
        prSet = CONEXAODB.prepareStatement(sql);
        prSet.setInt(1, dadosPerfil);

        rSet = prSet.executeQuery();
        if (rSet.next()) {
            objConsultasDTO.setId(rSet.getInt("id"));
            objConsultasDTO.setNome(rSet.getString("nome"));
            objConsultasDTO.setSobrenome(rSet.getString("sobrenome"));
            objConsultasDTO.setEmail(rSet.getString("email"));
            objConsultasDTO.setPeso(rSet.getDouble("peso"));
            objConsultasDTO.setIdade(rSet.getInt("idade"));
            objConsultasDTO.setMetas(rSet.getString("metas"));
            objConsultasDTO.setObjetivos(rSet.getString("objetivos"));
            objConsultasDTO.setAltura(rSet.getDouble("altura"));
            objConsultasDTO.setData(rSet.getString("dataC"));
        }
        return objConsultasDTO;
    }

    @Override
    public boolean editarPerfil(int id, ConsultasEntity dadosEditar) throws ClassNotFoundException, SQLException {
        sql = "update Consultas_TABLE set nome=?, sobrenome=?, email=?, peso=?, idade=?, metas=?, objetivos=?, altura=?,dataC=? where id=?;";
        prSet = this.CONEXAODB.prepareStatement(sql);

        prSet.setString(1, dadosEditar.getNome());
        prSet.setString(2, dadosEditar.getSobrenome());
        prSet.setString(3, dadosEditar.getEmail());
        prSet.setDouble(4, dadosEditar.getPeso());
        prSet.setInt(5, dadosEditar.getIdade());
        prSet.setString(6, dadosEditar.getMetas());
        prSet.setString(7, dadosEditar.getObjetivos());
        prSet.setDouble(8, dadosEditar.getAltura());
        prSet.setString(9, dadosEditar.getData());
        prSet.setInt(10, id);

        prSet.execute();
        return true;
    }

    @Override
    public List<ConsultasEntity> verTodos() throws ClassNotFoundException, SQLException {
        sql = "SELECT * FROM Consultas_TABLE";

        prSet = CONEXAODB.prepareStatement(sql);
        rSet = prSet.executeQuery();

        while (rSet.next()) {
            ConsultasEntity objConsultasDTO = new ConsultasEntity();

            objConsultasDTO.setId(rSet.getInt("id"));
            objConsultasDTO.setNome(rSet.getString("nome"));
            objConsultasDTO.setSobrenome(rSet.getString("sobrenome"));
            objConsultasDTO.setEmail(rSet.getString("email"));
            objConsultasDTO.setPeso(rSet.getDouble("peso"));
            objConsultasDTO.setIdade(rSet.getInt("idade"));
            objConsultasDTO.setMetas(rSet.getString("metas"));
            objConsultasDTO.setObjetivos(rSet.getString("objetivos"));
            objConsultasDTO.setAltura(rSet.getDouble("altura"));
            objConsultasDTO.setData(rSet.getString("dataC"));

            pacientesList.add(objConsultasDTO);
        }
        return pacientesList;
    }

    @Override
    public void apagarPerfil(int dadosApagar) throws ClassNotFoundException, SQLException {
        sql = "DELETE FROM Consultas_TABLE WHERE id=?";
        prSet = CONEXAODB.prepareStatement(sql);

        prSet.setInt(1, dadosApagar);
        prSet.execute();
    }

}
