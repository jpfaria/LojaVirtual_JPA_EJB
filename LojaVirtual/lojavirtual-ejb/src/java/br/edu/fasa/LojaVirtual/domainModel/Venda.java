/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasa.LojaVirtual.domainModel;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author petronio
 */
@Entity
@Table(name="Vendas")
public class Venda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(cascade= CascadeType.MERGE, fetch= FetchType.EAGER)
    Cliente cliente;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="data")
    Date data;
    
    @OneToMany(cascade= CascadeType.ALL, fetch= FetchType.EAGER)
    @JoinColumn(name="venda")
    List<VendaItem> itens;
    
    public Venda(){
        itens = new LinkedList<VendaItem>();
    }
            

    public List<VendaItem> getItens() {
        return itens;
    }

    public void setItens(List<VendaItem> itens) {
        this.itens = itens;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void addItem(Produto p, int q){
        VendaItem it = new VendaItem();
        it.setVenda(this);
        it.setProduto(p);
        it.setQuantidade(q);
        if(!itens.contains(it))
            itens.add(it);
    }
    
    public void removeItem(VendaItem it){
        if(itens.contains(it))
            itens.remove(it);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.fasa.LojaVirtual.domainModel.Venda[ id=" + id + " ]";
    }
    
}
