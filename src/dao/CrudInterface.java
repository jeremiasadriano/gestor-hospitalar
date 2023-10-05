/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author godal
 * @param <T>
 */
public abstract interface CrudInterface<T> {

    abstract boolean registrar(T dadosRegistro) throws ClassNotFoundException, SQLException;

    abstract boolean login(T dadosLogin) throws ClassNotFoundException, SQLException;

    abstract T verPerfil(int dadosPerfil) throws ClassNotFoundException, SQLException;

    abstract boolean editarPerfil(int id, T dadosEditar) throws ClassNotFoundException, SQLException;

    abstract List<T> verTodos() throws ClassNotFoundException, SQLException;

    abstract void apagarPerfil(int dadosApagar) throws ClassNotFoundException, SQLException;

}
