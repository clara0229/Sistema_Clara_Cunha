/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import bean.CdcUsuario;
import bean.CdcVendasProdutos;


/**
 *
 * @author clari
 */
public class Cdc_ControllerVendasProdutos extends AbstractTableModel {
    private List lstVendasProdutos;
    
    public void setList(List lstVendasProdutos){
     this.lstVendasProdutos = lstVendasProdutos;  
    }
    
    public Object getBean(int rowIndex){
        return (CdcVendasProdutos) lstVendasProdutos.get(rowIndex);
    }
    
    public void addBean (CdcVendasProdutos cdcVendasProdutos){
        this.lstVendasProdutos.add(cdcVendasProdutos);
        this.fireTableDataChanged();
    }
    
    public void removeBean (int rowIndex){
        this.lstVendasProdutos.remove(rowIndex);
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return lstVendasProdutos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CdcVendasProdutos cdcVendasProdutos = (CdcVendasProdutos) lstVendasProdutos.get(rowIndex);
        if (columnIndex == 0){
           return cdcVendasProdutos.getCdcVestidos().getCdcIdVestidos();
        } else if (columnIndex ==1) {
            return cdcVendasProdutos.getCdcVestidos().getCdcNome();        
        } else if (columnIndex ==2) {
            return cdcVendasProdutos.getCdcQuantidade();
        } else if (columnIndex ==3) {
            return cdcVendasProdutos.getCdcValorUnitario();
        } else if (columnIndex ==4) {
            return cdcVendasProdutos.getCdcQuantidade() * cdcVendasProdutos.getCdcValorUnitario();
        }
        return "";
        
    }
        
    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Nome";         
        } else if ( columnIndex == 2) {
            return "Quantidade";
        } else if ( columnIndex == 3) {
            return "Valor Unitário";
        }  else if ( columnIndex == 4) {
            return "Total";
        }
        return "";
    }
    
}

