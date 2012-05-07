/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasa.LojaVirtual;

import br.edu.fasa.LojaVirtual.domainModel.Cliente;
import br.edu.fasa.LojaVirtual.domainModel.Venda;
import java.util.Calendar;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author petronio
 */
@Stateless
public class ServicosBean implements Servicos {

    @EJB
    Repositorios repo;
    
    @Override
    public Venda criarVenda(Cliente cliente) {
        Venda tmp = new Venda();
        tmp.setCliente(cliente);
        Calendar cal = Calendar.getInstance();
        tmp.setData(cal.getTime());
        repo.venda().Save(tmp);
        return tmp;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public boolean salvarVenda(Venda venda) {
        return false;
    }
    
}
