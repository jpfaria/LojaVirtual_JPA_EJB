/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasa.LojaVirtual.dataAccess;

import br.edu.fasa.LojaVirtual.domainModel.Repository;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

/**
 *
 * @author petronio
 */
public class GenericDAO<T> implements Repository<T> {
    	
    private Class type;
    
    @PersistenceContext(unitName="lojavirtual")
    private EntityManager manager;

    protected EntityManager getManager() {
        return manager;
    }
    
    public GenericDAO(Class t) {
        type = t;
    }   
    
    @Override
    public boolean Save(T obj)  {
        try {
            getManager().persist(obj);
            return true;
        } catch (Exception e) {  
            e.printStackTrace();
            return false;          
        }
    }

     @Override
    public boolean Delete(T obj)  {
        try {
            getManager().remove(obj);
            return true;
        } catch (Exception e) {  
            e.printStackTrace();
            return false;  
        }
    }

    @Override
    public T Open(Long k)  throws Exception   {
        return (T)getManager().find(type, k);
    }
    
}
