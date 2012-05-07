package br.edu.fasa.LojaVirtual.domainModel;

import br.edu.fasa.LojaVirtual.domainModel.Cliente;
import br.edu.fasa.LojaVirtual.domainModel.VendaItem;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-05-07T13:44:10")
@StaticMetamodel(Venda.class)
public class Venda_ { 

    public static volatile SingularAttribute<Venda, Long> id;
    public static volatile SingularAttribute<Venda, Cliente> cliente;
    public static volatile SingularAttribute<Venda, Date> data;
    public static volatile ListAttribute<Venda, VendaItem> itens;

}