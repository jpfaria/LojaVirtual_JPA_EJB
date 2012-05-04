/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasa.LojaVirtual.domainModel;

/**
 *
 * @author petronio
 */

public interface Repository<T> {
    boolean Save(T obj);
    boolean Delete(T obj);
    T Open(Long k) throws Exception ;
}
