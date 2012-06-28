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
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.event.ActionEvent;

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
        //this.data = cliente.getDataNascimento().toString();
    }
    
    List<Cliente> listagem;

    String id, nome, erro, filtro, mensagem;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    Date data;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    

    public String getId() {
        return id;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public void setId(String id)  throws Exception {
        this.id = id;        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
     public List<Cliente> getListagem() {
        if(listagem == null)
            atualizaListagem();
        return listagem;
    }
    
    public void atualizaListagem() {
        if(filtro.length()==0)
            listagem = ejb.getTodos();
        else
            listagem = ejb.filtrarPorNome(filtro, 0, 100);
    }

    public void setListagem(List<Cliente> listagem) {
        this.listagem = listagem;
    }
    
    private void checarClienteAberto()  throws Exception  {
        if(id.length() > 0 && id != "0")
            abrir();
        else
            cliente = new Cliente();
    }
    
     public String editar() throws Exception  {
         abrir();
        return "faces/editarCliente.xhtml";
     }
     
     public String listar() throws Exception  {
         atualizaListagem();
        return "faces/listarClientes.xhtml";
     }
     
     public String novo() throws Exception   {
        limparCampos();
        return "faces/editarCliente.xhtml";
     }
    
    public void abrir() throws Exception {
        if(id.length() > 0 && id != "0"){
            long cod = Long.parseLong(id);
            if(cliente == null || (cliente != null && cliente.getId() != cod ) )
                setCliente(ejb.Open(cod));
        }
    }
    
    public void salvar() throws Exception {
        try {
            checarClienteAberto();
            cliente.setNome(nome);
            cliente.setDataNascimento(data);

            ejb.Save(cliente);
            mensagem = "Cliente salvo com sucesso!";
        }
        catch(Exception ex) {
            mensagem = "Houve um erro ao tentar salvar o cliente! Consulte o log do sistema!";                            
        }
    }
    
    public void evtSalvar(ActionEvent evt) throws Exception {
        salvar();
    }
    
    public String apagar() throws Exception {
        try {
            checarClienteAberto();             
            ejb.Delete(cliente);
            limparCampos();
            atualizaListagem();
            mensagem = "Cliente removido com sucesso!";                
            return "faces/listarClientes.xhtml";
        }
        catch(Exception ex) {
            mensagem = "Houve um erro ao tentar apagar o cliente! Consulte o log do sistema!";                
            return "";
        }
    }

    private void limparCampos() throws Exception {
        setId("");
        setNome("");
        setData(null);
    }
    
    /**
     * Creates a new instance of ClienteBean
     */
    
    public ClienteBean() {
        this.id = "";
        this.nome = "";
        this.data = null;
        this.filtro = "";
        this.mensagem = "";
    }
    
}
