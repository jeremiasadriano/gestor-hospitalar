/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexaoDB.Conexao;
import dto.FuncionarioDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import paginas.PacientesVaciandosPage;

/**
 *
 * @author godal
 */
public class FuncionarioDAO implements CrudInterface<FuncionarioDTO> {

    private final Connection CONEXAODB;
    private final List FUNCIONARIOLIST;
    private PreparedStatement prSet;
    private ResultSet rSet;
    private String sql;

    public FuncionarioDAO() throws ClassNotFoundException, SQLException {
        this.CONEXAODB = Conexao.conexao();
        this.FUNCIONARIOLIST = new ArrayList<FuncionarioDTO>();
        this.prSet = null;
        this.rSet = null;
    }

    @Override
    public boolean registrar(FuncionarioDTO dadosRegistro) throws ClassNotFoundException, SQLException {
        return true;
    }

    @Override
    public boolean login(FuncionarioDTO dadosLogin) throws ClassNotFoundException, SQLException {
        sql = "SELECT * FROM Funcionario_TABLE WHERE nome_func=? AND senha_func=?;";
        prSet = CONEXAODB.prepareStatement(sql);

        prSet.setString(1, dadosLogin.getNomeFunc());
        prSet.setString(2, dadosLogin.getSenhaFunc());

        rSet = prSet.executeQuery();

        if (rSet.next()) {
            prSet.close();
            CONEXAODB.close();
            new PacientesVaciandosPage();
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Funcionário não existente, queira por favor verificar as suas credenciais", "Login Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    @Override
    public FuncionarioDTO verPerfil(int dadosPerfil) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public boolean editarPerfil(int id, FuncionarioDTO dadosEditar) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public List<FuncionarioDTO> verTodos() throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public void apagarPerfil(int dadosApagar) throws ClassNotFoundException, SQLException {

    }

}
