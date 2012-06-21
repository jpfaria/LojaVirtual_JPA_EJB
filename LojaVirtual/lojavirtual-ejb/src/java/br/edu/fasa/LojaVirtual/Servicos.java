/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasa.LojaVirtual;

import br.edu.fasa.LojaVirtual.domainModel.Cliente;
import br.edu.fasa.LojaVirtual.domainModel.Venda;
import javax.ejb.Remote;

/**
 *
 * @author petronio
 */
@Remote
public interface Servicos {

    Venda criarVenda(Cliente cliente);

    boolean salvarVenda(Venda venda);
    
}
