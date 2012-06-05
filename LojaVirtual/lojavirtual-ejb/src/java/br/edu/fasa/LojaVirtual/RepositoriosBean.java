/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasa.LojaVirtual;

import br.edu.fasa.LojaVirtual.domainModel.ClienteRepository;
import br.edu.fasa.LojaVirtual.domainModel.ProdutoRepository;
import br.edu.fasa.LojaVirtual.domainModel.VendaRepository;
import javax.ejb.EJB;
import javax.ejb.Singleton;

/**
 *
 * @author petronio
 */
@Singleton
public class RepositoriosBean implements Repositorios {

    static RepositoriosBean instance;
    
    public static RepositoriosBean getInstance(){
        if(instance == null)
            instance = new RepositoriosBean();
        return instance;
    }
    
    @EJB
    ClienteRepository cli;
    
    @Override
    public ClienteRepository cliente() {
        return cli;
    }
    
    @EJB
    ProdutoRepository pro;
    
    @Override
    public ProdutoRepository produto() {
        return pro;
    }
    
    @EJB
    VendaRepository ven;
    
    @Override
    public VendaRepository venda() {
        return ven;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
