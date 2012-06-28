/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasa.LojaVirtual.presentation.web;

import br.edu.fasa.LojaVirtual.domainModel.Produto;
import br.edu.fasa.LojaVirtual.domainModel.ProdutoRepository;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author petronio
 */
@Named(value = "produto")
@SessionScoped
public class ProdutoBean implements Serializable {

    /**
     * Creates a new instance of ProdutoBean
     */
        
        @EJB
        ProdutoRepository ejb;
        
        Produto produto;
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        this.id = produto.getId().toString();
        this.nome = produto.getDescricao();
        this.valor = produto.getValor();
    }
    
    List<Produto> listagem;

    String id, nome, erro, filtro, mensagem;
    Double valor;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
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
    
     public List<Produto> getListagem() {
        if(listagem == null)
            atualizaListagem();
        return listagem;
    }
    
    public void atualizaListagem() {
        if(filtro.length()==0)
            listagem = ejb.getTodos();
        else
            listagem = ejb.filtrarPorDescricao(filtro, 0, 100);
    }

    public void setListagem(List<Produto> listagem) {
        this.listagem = listagem;
    }
    
    private void checarProdutoAberto()  throws Exception  {
        if(id.length() > 0 && id != "0")
            abrir();
        else
            produto = new Produto();
    }
    
     public String editar() throws Exception  {
         abrir();
        return "faces/editarProduto.xhtml";
     }
     
     public String listar() throws Exception  {
         atualizaListagem();
        return "faces/listarProdutos.xhtml";
     }
     
     public String novo() throws Exception   {
        limparCampos();
        return "faces/editarProduto.xhtml";
     }
    
    public void abrir() throws Exception {
        if(id.length() > 0 && id != "0"){
            long cod = Long.parseLong(id);
            if(produto == null || (produto != null && produto.getId() != cod ) )
                setProduto(ejb.Open(cod));
        }
    }
    
    public void salvar() throws Exception {
        try {
            checarProdutoAberto();
            produto.setDescricao(nome);
            produto.setValor(valor);

            ejb.Save(produto);
            mensagem = "Produto salvo com sucesso!";
        }
        catch(Exception ex) {
            mensagem = "Houve um erro ao tentar salvar o produto! Consulte o log do sistema!";                            
        }
    }
        
    public String apagar() throws Exception {
        try {
            checarProdutoAberto();             
            ejb.Delete(produto);
            limparCampos();
            atualizaListagem();
            mensagem = "Produto removido com sucesso!";                
            return "faces/listarProdutos.xhtml";
        }
        catch(Exception ex) {
            mensagem = "Houve um erro ao tentar apagar o produto! Consulte o log do sistema!";                
            return "";
        }
    }

    private void limparCampos() throws Exception {
        setId("");
        setNome("");
        setValor(new Double(0));
    }
    
    /**
     * Creates a new instance of ProdutoBean
     */
    
    public ProdutoBean() {
        this.id = "";
        this.nome = "";
        this.filtro = "";
        this.mensagem = "";
    }
    
    
}
