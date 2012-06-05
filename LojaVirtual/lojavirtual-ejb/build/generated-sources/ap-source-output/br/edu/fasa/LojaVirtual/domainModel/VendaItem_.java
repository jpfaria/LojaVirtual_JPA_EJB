package br.edu.fasa.LojaVirtual.domainModel;

import br.edu.fasa.LojaVirtual.domainModel.Produto;
import br.edu.fasa.LojaVirtual.domainModel.Venda;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-06-05T13:04:46")
@StaticMetamodel(VendaItem.class)
public class VendaItem_ { 

    public static volatile SingularAttribute<VendaItem, Long> id;
    public static volatile SingularAttribute<VendaItem, Produto> produto;
    public static volatile SingularAttribute<VendaItem, Integer> quantidade;
    public static volatile SingularAttribute<VendaItem, Venda> venda;

}