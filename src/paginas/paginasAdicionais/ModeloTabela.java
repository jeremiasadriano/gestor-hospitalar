/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paginas.paginasAdicionais;

/**
 *
 * @author godal
 */
//Impedir de editar a tabela
//Impedir de mover as colunas e linhas
public class ModeloTabela extends javax.swing.table.DefaultTableModel {

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

}
