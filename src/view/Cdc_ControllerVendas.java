/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import bean.CdcVendas;
import bean.CdcClientes;
import bean.CdcVendedor;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author clari
 */
public class Cdc_ControllerVendas extends AbstractTableModel {
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
        CdcVendas vendas = (CdcVendas) lista.get(rowIndex);
        if (columnIndex == 0){
            return vendas.getCdcIdVendas();
        }
        if (columnIndex == 1){
            return vendas.getCdcClientes();
        }
        if (columnIndex == 2){
            return vendas.getCdcVendedor();
        }
        if (columnIndex == 3){
            return vendas.getCdcDataVenda();
        }
        return "LP 4";
        
    }
        
    @Override
    public String getColumnName (int column) {
        if (column == 0) return "Código";
        if (column == 1) return "FK Clientes";
        if (column == 2) return "FK Vendedor";
        if (column == 3) return "Data Venda";
        return "";
    }
    
}

