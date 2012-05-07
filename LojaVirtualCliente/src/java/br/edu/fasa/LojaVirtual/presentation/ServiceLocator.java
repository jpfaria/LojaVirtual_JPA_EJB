/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasa.LojaVirtual.presentation;

import br.edu.fasa.LojaVirtual.Repositorios;
import br.edu.fasa.LojaVirtual.Servicos;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author petronio
 */
public class ServiceLocator {
    
    private InitialContext ic;
    
    public ServiceLocator() {
        try {
            ic = new InitialContext();
        } catch (NamingException ne) {
            throw new RuntimeException(ne);
        }
    }
    
    private Object lookup(String jndiName) throws NamingException {
        return ic.lookup(jndiName);
    }

    /**
     * will get the ejb Remote home factory. clients need to cast to the type of
     * EJBHome they desire
     *
     * @return the EJB Home corresponding to the homeName
     */
    public Servicos getService() throws NamingException {
        Object objref = lookup("java:global/LojaVirtual/lojavirtual-ejb/ServicosBean");
        return (Servicos) objref;
    }
    
    public Repositorios getRepositorios() throws NamingException {
        Object objref = lookup("java:global/LojaVirtual/lojavirtual-ejb/RepositoriosBean");
        return (Repositorios) objref;
    }
    
}
