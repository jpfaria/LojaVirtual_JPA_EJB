/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasa.LojaVirtual.presentation.web;

import br.edu.fasa.LojaVirtual.domainModel.Cliente;
import br.edu.fasa.LojaVirtual.domainModel.ClienteRepository;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
/**
 *
 * @author petronio
 */
@Named(value = "cliente")
@SessionScoped
public class ClienteBean implements Serializable {


    @EJB
    ClienteRepository ejb;
    
    Cliente cliente;
    List<Cliente> listagem;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        this.id = cliente.getId().toString();
        this.nome = cliente.getNome();
        this.data = cliente.getDataNascimento().toString();
    }

    public List<Cliente> getListagem() {
        if(listagem == null)
            listagem = ejb.getTodos();
        return listagem;
    }

    public void setListagem(List<Cliente> listagem) {
        this.listagem = listagem;
    }
    
    
    
    String id, nome, data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        abrir();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    private void checarClienteAberto() {
        if(cliente == null && id.length() > 0)
            abrir();
        else
            cliente = new Cliente();
    }
    
    public void abrir(){
        try {
            long cod = Long.parseLong(id);
            setCliente(ejb.Open(cod));
        }
        catch(Exception e){
            
        }
        
    }
    
    public void salvar(){
        checarClienteAberto();
        
        cliente.setNome(nome);
        cliente.setDataNascimento(null);
        
        ejb.Save(cliente);
    }
    
    public void apagar(){
        checarClienteAberto();
        ejb.Delete(cliente);
    }
    
    /**
     * Creates a new instance of ClienteBean
     */
    public ClienteBean() {
        
    }
}
