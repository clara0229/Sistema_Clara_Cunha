/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.CdcVestidos;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u1845853
 */
public class ProdutosDAO extends AbstractDAO {

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
        Criteria criteria = session.createCriteria(CdcVestidos.class);
        criteria.add(Restrictions.eq("cdc_idVestidos", codigo) );
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object listNome(String cdcNome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CdcVestidos.class);
        criteria.add(Restrictions.like("cdcNome", "%" + cdcNome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
        
    public Object listValor(double valor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CdcVestidos.class);
        criteria.add(Restrictions.ge("cdcPreco", valor));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object listNomeValor(String cdcNome, double valor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CdcVestidos.class);
        criteria.add(Restrictions.like("cdcNome", "%" + cdcNome + "%"));
        criteria.add(Restrictions.ge("cdcPreco", valor));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
        public ArrayList listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CdcVestidos.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return (ArrayList) lista;
}


    public static void main(String[] args) {
        ProdutosDAO produtosDAO = new ProdutosDAO();
        produtosDAO.listAll();
    }
}
