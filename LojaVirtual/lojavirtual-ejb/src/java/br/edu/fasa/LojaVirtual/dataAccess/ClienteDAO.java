/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasa.LojaVirtual.dataAccess;

import br.edu.fasa.LojaVirtual.domainModel.Cliente;
import br.edu.fasa.LojaVirtual.domainModel.ClienteRepository;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author petronio
 */
@Stateless
public class ClienteDAO 
    extends GenericDAO<Cliente>
    implements ClienteRepository {

    @Override
    protected Long getID(Cliente obj) {
        return obj.getId();
    }

    public ClienteDAO() {
        super(Cliente.class);
    }

    @Override
    public List<Cliente> getTodos() {
        Query query = getManager().createQuery("select c from Cliente c order by c.nome");
        return query.getResultList();
    }

    @Override
    public List<Cliente> filtrarPorNome(String nome, int start, int qtd) {
        Query query = getManager().createQuery("select c from Cliente c where c.nome like '%"+nome+"%' order by c.nome");
        if(start > 0 && qtd> 0){
            query.setFirstResult(start).setMaxResults(qtd);
        }
        return query.getResultList();
    }

    
}
