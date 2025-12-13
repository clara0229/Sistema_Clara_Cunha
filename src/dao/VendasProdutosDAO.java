/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.CdcClientes;
import bean.CdcVendas;
import bean.CdcVendasProdutos;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u1845853
 */
public class VendasProdutosDAO extends AbstractDAO {

    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public Object list(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CdcVendasProdutos.class);
        criteria.add(Restrictions.eq("cdc_idVendasProdutos", codigo) );
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public void deleteVendas(CdcVendas vendas) {
        List lista = (List) listProdutos(vendas);
        for (int i = 0; i < lista.size(); i++) {
            CdcVendasProdutos vendasProdutos = (CdcVendasProdutos) lista.get(i);
            delete(vendasProdutos);
        }
    }

    @Override
        public ArrayList listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CdcVendasProdutos.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return (ArrayList) lista;
}
        public Object listProdutos(CdcVendas vendas) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CdcVendasProdutos.class);
        criteria.add(Restrictions.eq("cdcVendas", vendas));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }


    public static void main(String[] args) {
        VendasProdutosDAO clientesDAO = new VendasProdutosDAO();
        clientesDAO.listAll();
    }
}
