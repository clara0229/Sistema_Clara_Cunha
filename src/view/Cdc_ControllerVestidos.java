/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import bean.CdcVestidos;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author clari
 */
public class Cdc_ControllerVestidos extends AbstractTableModel {
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
        CdcVestidos vestidos = (CdcVestidos) lista.get(rowIndex);
        if (columnIndex == 0){
            return vestidos.getCdcIdVestidos();
        }
        if (columnIndex == 1){
            return vestidos.getCdcNome();
        }
        if (columnIndex == 2){
            return vestidos.getCdcPreco();
        }
        if (columnIndex == 3){
            return vestidos.getCdcModelo();
        }
        return "LP 4";
        
    }
        
    @Override
    public String getColumnName (int column) {
        if (column == 0) return "Código";
        if (column == 1) return "Nome";
        if (column == 2) return "Preço";
        if (column == 3) return "Modelo";
        return "";
    }
    
}
