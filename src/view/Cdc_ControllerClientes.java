package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import bean.CdcClientes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author clari
 */
public class Cdc_ControllerClientes extends AbstractTableModel{
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
        CdcClientes clientes = (CdcClientes) lista.get(rowIndex);
        if (columnIndex == 0){
            return clientes.getCdcIdClientes();
        }
        if (columnIndex == 1){
            return clientes.getCdcNome();
        }
        if (columnIndex == 2){
            return clientes.getCdcCpf();
        }
        if (columnIndex == 3){
            return clientes.getCdcRg();
        }
        if (columnIndex == 4){
            return clientes.getCdcSexo();
        }
        if (columnIndex == 5){
            return clientes.getCdcDataNas();
        }

        return "LP 4";
        
    }
        
    @Override
    public String getColumnName (int column) {
        if (column == 0) return "Código";
        if (column == 1) return "Nome";
        if (column == 2) return "Cpf";
        if (column == 3) return "Rg";
        if (column == 4) return "Sexo";
        if (column == 5) return "Data de Nascimento";
        return "";
    }
    
}


