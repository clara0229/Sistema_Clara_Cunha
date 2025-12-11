/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.CdcClientes;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u1845853
 */
public class ClientesDAO extends AbstractDAO {

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
        Criteria criteria = session.createCriteria(CdcClientes.class);
        criteria.add(Restrictions.eq("cdc_idClientes", codigo) );
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object listNome(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CdcClientes.class);
        criteria.add(Restrictions.like("cdcNome", "%" + nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
        
        public Object listAtivo(String ativo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CdcClientes.class);
        criteria.add(Restrictions.eq("cdcAtivo", ativo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listNomeAtivo(String nome, String ativo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CdcClientes.class);
        criteria.add(Restrictions.like("cdcNome", "%" + nome + "%"));
        criteria.add(Restrictions.eq("cdcAtivo", ativo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
        public ArrayList listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CdcClientes.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return (ArrayList) lista;
}


    public static void main(String[] args) {
        ClientesDAO clientesDAO = new ClientesDAO();
        clientesDAO.listAll();
    }
}
