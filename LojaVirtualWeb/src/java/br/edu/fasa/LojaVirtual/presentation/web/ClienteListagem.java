/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasa.LojaVirtual.presentation.web;

import br.edu.fasa.LojaVirtual.domainModel.Cliente;
import br.edu.fasa.LojaVirtual.domainModel.ClienteRepository;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author petronio
 */
@Named(value = "clienteListagem")
@RequestScoped
public class ClienteListagem {

    /**
     * Creates a new instance of ClienteListagem
     */
    
        @EJB
    ClienteRepository ejb;
    
    List<Cliente> listagem;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    String  nome;
    
    public List<Cliente> getListagem() {
        if(listagem == null)
            atualizaListagem();
        return listagem;
    }
    
    public void atualizaListagem() {
        if(nome.length()==0)
            listagem = ejb.getTodos();
        else
            listagem = ejb.filtrarPorNome(nome, 0, 100);
    }

    public void setListagem(List<Cliente> listagem) {
        this.listagem = listagem;
    }
    
    public ClienteListagem() {
        this.nome = "";
    }
}
