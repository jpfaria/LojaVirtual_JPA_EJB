/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasa.LojaVirtual.dataAccess;

import br.edu.fasa.LojaVirtual.domainModel.Venda;
import br.edu.fasa.LojaVirtual.domainModel.VendaRepository;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author petronio
 */
@Stateless
public class VendaDAO 
    extends GenericDAO<Venda>
    implements VendaRepository {

    public VendaDAO() {
        super(Venda.class);
    }
    
    @Override
    protected Long getID(Venda obj) {
        return obj.getId();
    }

    @Override
    public List<Venda> getTodos() {
        Query query = getManager().createQuery("select v from Venda v order by v.data");
        return query.getResultList();
    }

    @Override
    public List<Venda> filtrarPorNomeCliente(String nome, int start, int qtd) {
        Query query = getManager().createQuery("select v from Venda v join v.cliente c where c.nome like '%"+nome+"%' order by v.data");
        if(start > 0 && qtd> 0){
            query.setFirstResult(start).setMaxResults(qtd);
        }
        return query.getResultList();
    }
    
}
