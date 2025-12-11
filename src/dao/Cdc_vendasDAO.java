/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.CdcVendas;
import bean.CdcVestidos;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u1845853
 */
public class Cdc_vendasDAO extends AbstractDAO {

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
        Criteria criteria = session.createCriteria(CdcVendas.class);
        criteria.add(Restrictions.eq("cdc_idVendas", codigo) );
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object listId(int nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CdcVendas.class);
        criteria.add(Restrictions.like("cdcIdVendas", "%" + nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
        
    public Object listTotal(double valor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CdcVendas.class);
        criteria.add(Restrictions.ge("cdcTotal", valor));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object listIdTotal(int nome, double valor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CdcVendas.class);
        criteria.add(Restrictions.like("cdcIdVendas", "%" + nome + "%"));
        criteria.add(Restrictions.ge("cdcTotal", valor));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
        public ArrayList listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CdcVendas.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return (ArrayList) lista;
}


    public static void main(int[] args) {
        Cdc_vendasDAO produtosDAO = new Cdc_vendasDAO();
        produtosDAO.listAll();
    }
}
