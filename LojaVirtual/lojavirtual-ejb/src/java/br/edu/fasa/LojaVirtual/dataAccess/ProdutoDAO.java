/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasa.LojaVirtual.dataAccess;

import br.edu.fasa.LojaVirtual.domainModel.Produto;
import br.edu.fasa.LojaVirtual.domainModel.ProdutoRepository;
import javax.ejb.Stateless;

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

    
}
