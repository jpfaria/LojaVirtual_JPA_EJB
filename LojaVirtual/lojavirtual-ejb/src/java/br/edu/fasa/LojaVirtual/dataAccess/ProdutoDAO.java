/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasa.LojaVirtual.dataAccess;

import br.edu.fasa.LojaVirtual.domainModel.Produto;
import br.edu.fasa.LojaVirtual.domainModel.ProdutoRepository;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author petronio
 */
@Stateless
public class ProdutoDAO 
    extends GenericDAO<Produto>
    implements ProdutoRepository {

    public ProdutoDAO() {
        super(Produto.class);
    }
    
    @Override
    protected Long getID(Produto obj) {
        return obj.getId();
    }

    @Override
    public List<Produto> getTodos() {
        Query query = getManager().createQuery("select c from Produto c order by c.descricao");
        return query.getResultList();
    }

    @Override
    public List<Produto> filtrarPorDescricao(String nome, int start, int qtd) {
        Query query = getManager().createQuery("select c from Produto c where c.descricao like '%"+nome+"%' order by c.descricao");
        if(start > 0 && qtd> 0){
            query.setFirstResult(start).setMaxResults(qtd);
        }
        return query.getResultList();
    }

    
}
