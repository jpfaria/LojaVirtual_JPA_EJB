/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lojavirtualcliente;

import br.edu.fasa.LojaVirtual.Repositorios;
import br.edu.fasa.LojaVirtual.domainModel.Cliente;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author petronio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Context context = new InitialContext();
            
            Repositorios ejb = (Repositorios)context.lookup("java:global/LojaVirtual/lojavirtual-ejb/RepositoriosBean");
            
            Cliente cli = new Cliente();
            
            cli.setNome("Petronio");
            Calendar cal = Calendar.getInstance();
            cal.set(1982, 12, 8);
            cli.setDataNascimento(cal.getTime());
            
            ejb.cliente().Save(cli);
            
        } catch (NamingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
