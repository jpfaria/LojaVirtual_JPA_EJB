/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasa.LojaVirtual.dataAccess;

import br.edu.fasa.LojaVirtual.domainModel.Cliente;
import br.edu.fasa.LojaVirtual.domainModel.Venda;
import br.edu.fasa.LojaVirtual.domainModel.VendaRepository;
import javax.ejb.Stateless;

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

    
}
