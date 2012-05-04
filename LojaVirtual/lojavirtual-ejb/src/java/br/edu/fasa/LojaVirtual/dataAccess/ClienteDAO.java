/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasa.LojaVirtual.dataAccess;

import br.edu.fasa.LojaVirtual.domainModel.Cliente;
import br.edu.fasa.LojaVirtual.domainModel.ClienteRepository;
import javax.ejb.Stateless;

/**
 *
 * @author petronio
 */
@Stateless
public class ClienteDAO 
    extends GenericDAO<Cliente>
    implements ClienteRepository {

    public ClienteDAO() {
        super(Cliente.class);
    }

    
}
