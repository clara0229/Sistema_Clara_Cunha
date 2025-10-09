/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import bean.CdcVendedor;


/**
 *
 * @author clari
 */
public class Cdc_ControllerVendedor extends AbstractTableModel{
 List lista;
    
    public void setList(List lista){
     this. lista = lista;   
    }
    
    public Object getBean(int rowIndex){
        return lista.get(rowIndex);
    }
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CdcVendedor usuarios = (CdcVendedor) lista.get(rowIndex);
        if (columnIndex == 0){
            return usuarios.getCdcIdVendedor();
        }
        if (columnIndex == 1){
            return usuarios.getCdcNome();
        }
        if (columnIndex == 2){
            return usuarios.getCdcCpf();
        }
        if (columnIndex == 3){
            return usuarios.getCdcDataNas();
        }
        return "LP 4";
        
    }
        
    @Override
    public String getColumnName (int column) {
        if (column == 0) return "Código";
        if (column == 1) return "Nome";
        if (column == 2) return "Cpf";
        if (column == 3) return "Data Nascimento";
        return "";
    }
    
}
