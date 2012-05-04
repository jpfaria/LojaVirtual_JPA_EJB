/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasa.LojaVirtual;

import br.edu.fasa.LojaVirtual.domainModel.ClienteRepository;
import javax.ejb.Remote;

/**
 *
 * @author petronio
 */
@Remote
public interface Repositorios {
    ClienteRepository cliente();
}
