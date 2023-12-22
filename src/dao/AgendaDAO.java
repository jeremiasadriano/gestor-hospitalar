/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexaoDB.Conexao;
import dto.AgendaDTO;
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
public class AgendaDAO implements CrudInterface<AgendaDTO> {

    private final Connection CONEXAODB;
    private PreparedStatement prSet;
    private ResultSet rSet;
    private String sql;
    private List<AgendaDTO> pacientesList;

    public AgendaDAO() throws ClassNotFoundException, SQLException {
        this.CONEXAODB = Conexao.conexao();
        this.prSet = null;
        this.rSet = null;
        this.pacientesList = new ArrayList<>();
    }
//    REGISTAR = CREATE

    @Override
    public boolean registrar(AgendaDTO dadosRegistro) throws ClassNotFoundException, SQLException {
        sql = "insert into Agenda_TABLE (nome, sobrenome, telefone, data, genero, data_nascimento, endereco, provincia,atendido,numeroId,experiencia,email,planoSaude)values (?,?,?,?,?,?,?,?,?,?,?,?,?);";

        prSet = CONEXAODB.prepareStatement(sql);
        prSet.setString(1, dadosRegistro.getNome());
        prSet.setString(2, dadosRegistro.getSobrenome());
        prSet.setString(3, dadosRegistro.getTelefone());
        prSet.setString(4, dadosRegistro.getDataConsulta());
        prSet.setString(5, dadosRegistro.getGenero());
        prSet.setString(6, dadosRegistro.getData_nascimento());
        prSet.setString(7, dadosRegistro.getEndereco());
        prSet.setString(8, dadosRegistro.getProvincia());
        prSet.setString(9, dadosRegistro.getAtendimentoCheckBox());
        prSet.setString(10, dadosRegistro.getIdPlano());
        prSet.setString(11, dadosRegistro.getFeedBackAtendimento());
        prSet.setString(12, dadosRegistro.getEmail());
        prSet.setString(13, dadosRegistro.getPlanoSaude());

        prSet.execute();
        prSet.close();
        CONEXAODB.close();
        return true;
    }
// LOGIN = READ

    @Override
    public boolean login(AgendaDTO dadosLogin) throws ClassNotFoundException, SQLException {
        return false;
    }
// LOGIN = READ

    @Override
    public AgendaDTO verPerfil(int dadosPerfil) throws ClassNotFoundException, SQLException {

        sql = "SELECT * FROM Agenda_TABLE WHERE id=?;";
        AgendaDTO objAgendaDTO = new AgendaDTO();
        prSet = CONEXAODB.prepareStatement(sql);
        prSet.setInt(1, dadosPerfil);

        rSet = prSet.executeQuery();
        if (rSet.next()) {
            objAgendaDTO.setId(rSet.getInt("id"));
            objAgendaDTO.setNome(rSet.getString("nome"));
            objAgendaDTO.setSobrenome(rSet.getString("sobrenome"));
            objAgendaDTO.setEmail(rSet.getString("email"));
            objAgendaDTO.setAtendimentoCheckBox(rSet.getString("atendido"));
            objAgendaDTO.setFeedBackAtendimento(rSet.getString("experiencia"));
            objAgendaDTO.setGenero(rSet.getString("genero"));
            objAgendaDTO.setData_nascimento(rSet.getString("data_nascimento"));
            objAgendaDTO.setEndereco(rSet.getString("endereco"));
            objAgendaDTO.setDataConsulta(rSet.getString("data"));
            objAgendaDTO.setProvincia(rSet.getString("provincia"));
            objAgendaDTO.setIdPlano(rSet.getString("numeroId"));
            objAgendaDTO.setPlanoSaude(rSet.getString("planoSaude"));
            objAgendaDTO.setTelefone(rSet.getString("telefone"));
        }
        return objAgendaDTO;
    }
//Editar = update

    @Override
    public boolean editarPerfil(int id, AgendaDTO dadosEditar) throws ClassNotFoundException, SQLException {
        sql = "update Agenda_TABLE set nome=?, sobrenome=?, telefone=?, data=?, genero=?, data_nascimento=?, endereco=?, provincia=?,atendido=?,numeroId=?,experiencia=?,email=?,planoSaude=?where id=?;";
        prSet = this.CONEXAODB.prepareStatement(sql);

        prSet = CONEXAODB.prepareStatement(sql);
        prSet.setString(1, dadosEditar.getNome());
        prSet.setString(2, dadosEditar.getSobrenome());
        prSet.setString(3, dadosEditar.getTelefone());
        prSet.setString(4, dadosEditar.getDataConsulta());
        prSet.setString(5, dadosEditar.getGenero());
        prSet.setString(6, dadosEditar.getData_nascimento());
        prSet.setString(7, dadosEditar.getEndereco());
        prSet.setString(8, dadosEditar.getProvincia());
        prSet.setString(9, dadosEditar.getAtendimentoCheckBox());
        prSet.setString(10, dadosEditar.getIdPlano());
        prSet.setString(11, dadosEditar.getFeedBackAtendimento());
        prSet.setString(12, dadosEditar.getEmail());
        prSet.setString(13, dadosEditar.getPlanoSaude());
        prSet.setInt(14, id);
        prSet.execute();
        return true;
    }
// verTodos = READ

    @Override
    public List<AgendaDTO> verTodos() throws ClassNotFoundException, SQLException {
        sql = "SELECT * FROM Agenda_TABLE";

        prSet = CONEXAODB.prepareStatement(sql);
        rSet = prSet.executeQuery();

        while (rSet.next()) {
            AgendaDTO objAgendaDTO = new AgendaDTO();
            objAgendaDTO.setId(rSet.getInt("id"));
            objAgendaDTO.setNome(rSet.getString("nome"));
            objAgendaDTO.setSobrenome(rSet.getString("sobrenome"));
            objAgendaDTO.setEmail(rSet.getString("email"));
            objAgendaDTO.setAtendimentoCheckBox(rSet.getString("atendido"));
            objAgendaDTO.setFeedBackAtendimento(rSet.getString("experiencia"));
            objAgendaDTO.setGenero(rSet.getString("genero"));
            objAgendaDTO.setData_nascimento(rSet.getString("data_nascimento"));
            objAgendaDTO.setEndereco(rSet.getString("endereco"));
            objAgendaDTO.setDataConsulta(rSet.getString("data"));
            objAgendaDTO.setProvincia(rSet.getString("provincia"));
            objAgendaDTO.setIdPlano(rSet.getString("numeroId"));
            objAgendaDTO.setPlanoSaude(rSet.getString("planoSaude"));
            objAgendaDTO.setTelefone(rSet.getString("telefone"));

            pacientesList.add(objAgendaDTO);
        }
        return pacientesList;
    }
//apagarPerfil = DELETE 

    @Override
    public void apagarPerfil(int dadosApagar) throws ClassNotFoundException, SQLException {
        sql = "DELETE FROM Agenda_TABLE WHERE id=?";
        prSet = CONEXAODB.prepareStatement(sql);

        prSet.setInt(1, dadosApagar);
        prSet.execute();
    }

//    CRUD
//    CREATE READ UPDATE DELETE
}
