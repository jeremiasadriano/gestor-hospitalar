/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexaoDB.Conexao;
import entity.FuncionarioEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import paginas.PacientesVaciandosPage;

/**
 *
 * @author godal
 */
public class FuncionarioDAO implements CrudInterface<FuncionarioEntity> {

    private final Connection CONEXAODB;
    private final List FUNCIONARIOLIST;
    private PreparedStatement prSet;
    private ResultSet rSet;
    private String sql;

    public FuncionarioDAO() throws ClassNotFoundException, SQLException {
        this.CONEXAODB = Conexao.conexao();
        this.FUNCIONARIOLIST = new ArrayList<FuncionarioEntity>();
        this.prSet = null;
        this.rSet = null;
    }

    @Override
    public boolean registrar(FuncionarioEntity dadosRegistro) throws ClassNotFoundException, SQLException {
        return true;
    }

    @Override
    public boolean login(FuncionarioEntity dadosLogin) throws ClassNotFoundException, SQLException {
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
    public FuncionarioEntity verPerfil(int dadosPerfil) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public boolean editarPerfil(int id, FuncionarioEntity dadosEditar) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public List<FuncionarioEntity> verTodos() throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public void apagarPerfil(int dadosApagar) throws ClassNotFoundException, SQLException {

    }

}
