/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasa.LojaVirtual.dataAccess;

import br.edu.fasa.LojaVirtual.domainModel.Repository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author petronio
 */
public class GenericDAO<T> implements Repository<T> {
    	
    private Class type;
    
    private EntityManagerFactory factory;
    private EntityManager manager;

    public EntityManager getManager() {
        return manager;
    }
    
    public EntityTransaction getTransaction() {
        return getManager().getTransaction();
    }
    
    public GenericDAO(Class t) {
            type = t;
            factory = Persistence.createEntityManagerFactory("lojavirtual");
            manager = factory.createEntityManager();
    }   
    
    @Override
    public boolean Save(T obj)  {
        EntityTransaction tran = getTransaction();
        try {
            tran.begin();
                getManager().persist(obj);
                tran.commit();
                return true;
        } catch (Exception e) {  
            tran.rollback();
                e.printStackTrace();
                return false;          
        }
    }

     @Override
    public boolean Delete(T obj)  {
         EntityTransaction tran = getTransaction();
            try {
                tran.begin();
                    getManager().remove(obj);
                    tran.commit();
                    return true;
            } catch (Exception e) {  
                tran.rollback();
                e.printStackTrace();
                return false;  
        }
    }

    @Override
    public T Open(Long k)  throws Exception   {
            return (T)getManager().find(type, k);
    }
    
}
