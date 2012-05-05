/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasa.LojaVirtual;

import br.edu.fasa.LojaVirtual.domainModel.ClienteRepository;
import br.edu.fasa.LojaVirtual.domainModel.ProdutoRepository;
import br.edu.fasa.LojaVirtual.domainModel.VendaRepository;
import javax.ejb.Remote;

/**
 *
 * @author petronio
 */
@Remote
public interface Repositorios {
    ClienteRepository cliente();
    ProdutoRepository produto();
    VendaRepository venda();
}
