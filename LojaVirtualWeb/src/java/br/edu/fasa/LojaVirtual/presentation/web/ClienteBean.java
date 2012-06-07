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
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        this.id = cliente.getId().toString();
        this.nome = cliente.getNome();
        this.data = cliente.getDataNascimento().toString();
    }

    
    String id, nome, data, erro;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id)  throws Exception {
        this.id = id;
        abrir();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    private void checarClienteAberto()  throws Exception  {
        if(id.length() > 0)
            abrir();
        else
            cliente = new Cliente();
    }
    
    public void abrir() throws Exception {
        long cod = Long.parseLong(id);
            setCliente(ejb.Open(cod));
    }
    
    public void salvar() throws Exception {
        checarClienteAberto();
        
        cliente.setNome(nome);
        cliente.setDataNascimento(null);
        
        ejb.Save(cliente);
    }
    
    public String apagar() throws Exception {
        checarClienteAberto();        
        ejb.Delete(cliente);
        setId("");
        setNome("");
        setData("");
        return "faces/listarClientes.xhtml";
    }
    
    /**
     * Creates a new instance of ClienteBean
     */
    public ClienteBean() {
        this.id = "";
        this.nome = "";
        this.data = "";
        this.data = "";
    }
}
