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

    @EJB
    ClienteRepository cli;
    
    @EJB
    ProdutoRepository pro;
    
    @EJB
    VendaRepository ven;
    
    @Override
    public ProdutoRepository produto() {
        return pro;
    }

    @Override
    public VendaRepository venda() {
        return ven;
    }  
    
    @Override
    public ClienteRepository cliente() {
        return cli;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
