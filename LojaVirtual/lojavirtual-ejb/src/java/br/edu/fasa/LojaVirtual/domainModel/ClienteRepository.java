/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasa.LojaVirtual.domainModel;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author petronio
 */
@Remote
public interface ClienteRepository extends Repository<Cliente> {

    List<Cliente> getTodos();

    List<Cliente> filtrarPorNome(String nome, int start, int qtd);
    
}
