/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasa.LojaVirtual.domainModel;

import javax.ejb.Remote;

/**
 *
 * @author petronio
 */
@Remote
public interface ProdutoRepository extends Repository<Produto> {
    
}
