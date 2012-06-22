/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasa.LojaVirtual.presentation.web;

import br.edu.fasa.LojaVirtual.domainModel.*;
import java.awt.event.ActionEvent;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author petronio
 */
@Named(value = "venda")
@SessionScoped
public class VendaBean implements Serializable {

    /**
     * Creates a new instance of VendaBean
     */
        
        @EJB
        VendaRepository ejb;
        
        @EJB
        ClienteRepository cli;
        
        @EJB
        ProdutoRepository prod;
        
        Venda venda;
    
    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
        this.id = venda.getId().toString();
        this.nome = venda.getCliente().getNome();
        this.data = venda.getData();   
        this.itens = venda.getItens();
    }
    
    List<Venda> listagem;
    List<VendaItem> itens;

    public List<VendaItem> getItens() {
        return itens;
    }

    public void setItens(List<VendaItem> itens) {
        this.itens = itens;
    }

    String id, nome, erro, filtro, mensagem;
    Date data;
    Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
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
    
     public List<Venda> getListagem() {
        if(listagem == null)
            atualizaListagem();
        return listagem;
    }
    
    public void atualizaListagem() {
        if(filtro.length()==0)
            listagem = ejb.getTodos();
        else
            listagem = ejb.filtrarPorNomeCliente(filtro, 0, 100);
    }

    public void setListagem(List<Venda> listagem) {
        this.listagem = listagem;
    }
    
    private void checarVendaAberto()  throws Exception  {
        if(id.length() > 0 && id != "0")
            abrir();
        else
            venda = new Venda();
    }
    
     public String editar() throws Exception  {
         abrir();
        return "faces/editarVenda.xhtml";
     }
     
     public String listar() throws Exception  {
         atualizaListagem();
        return "faces/listarVendas.xhtml";
     }
     
     public String novo() throws Exception   {
        limparCampos();
        return "faces/editarVenda.xhtml";
     }
    
    public void abrir() throws Exception {
        if(id.length() > 0 && id != "0"){
            long cod = Long.parseLong(id);
            setVenda(ejb.Open(cod));
        }
    }
    
    public void salvar() throws Exception {
        try {
            checarVendaAberto();
            //venda.setDescricao(nome);
            venda.setData(data);

            ejb.Save(venda);
            mensagem = "Venda salvo com sucesso!";
        }
        catch(Exception ex) {
            mensagem = "Houve um erro ao tentar salvar o venda! Consulte o log do sistema!";                            
        }
    }
    
    public void evtSalvar(ActionEvent evt) throws Exception {
        salvar();
    }
    
    public String apagar() throws Exception {
        try {
            checarVendaAberto();             
            ejb.Delete(venda);
            limparCampos();
            atualizaListagem();
            mensagem = "Venda removido com sucesso!";                
            return "faces/listarVendas.xhtml";
        }
        catch(Exception ex) {
            mensagem = "Houve um erro ao tentar apagar o venda! Consulte o log do sistema!";                
            return "";
        }
    }

    private void limparCampos() throws Exception {
        setId("");
        setNome("");
        setData(null);
    }
    
    public List<Cliente> buscaClientes(String val){
        return cli.filtrarPorNome(val, 0, 100);
    }
    
    public List<Produto> buscaProdutos(String val){
        return prod.filtrarPorDescricao(val, 0, 100);
    }
    
    /**
     * Creates a new instance of VendaBean
     */
    
    public VendaBean() {
        this.id = "";
        this.nome = "";
        this.filtro = "";
        this.mensagem = "";
    }
    
    
}
