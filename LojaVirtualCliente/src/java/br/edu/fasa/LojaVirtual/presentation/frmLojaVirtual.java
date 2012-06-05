/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fasa.LojaVirtual.presentation;

import br.edu.fasa.LojaVirtual.domainModel.Repository;
import br.edu.fasa.LojaVirtual.presentation.desktop.frmClientes;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author petronio
 */
public abstract class frmLojaVirtual<T> extends javax.swing.JInternalFrame {
    
    public static final String TITULO = "Loja Virtual - LPII - FASA";
    
    private T entidade;
    private ServiceLocator locator;

    protected T getEntidade() {
        return entidade;
    }

    protected void setEntidade(T entidade) {
        this.entidade = entidade;
    }
    
    protected ServiceLocator getServiceLocator() {
        return locator;
    }
    
    public frmLojaVirtual(ServiceLocator loc){
        this.locator = loc;
    }
    
    protected abstract void atualizaEntidade();
    protected abstract T criaEntidadeVazia();
    protected abstract void atualizaCamposFormulario();
    protected abstract void limparCamposFormulario();
    protected abstract void atualizaListagem();
    
    
    protected void salvar(Repository<T> repo) {
        if(JOptionPane.showConfirmDialog(null, "Deseja realmente salvar os dados?", TITULO, JOptionPane.OK_CANCEL_OPTION) == 0){
            try {
                T entidade = getEntidade();
                if(entidade == null)
                   entidade = criaEntidadeVazia();                
                atualizaEntidade();            
                
                if(repo.Save(entidade))
                    JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!", TITULO, 1);
                else
                    JOptionPane.showMessageDialog(null, "Aconteceu um erro ao tentar salvar os dados! Consulte o log de erros.", TITULO, 1);
                
                atualizaListagem();
            } catch (Exception ex) {
                Logger.getLogger(frmClientes.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Aconteceu um erro ao tentar salvar os dados! Consulte o log de erros.", TITULO, 1);
            }            
        }
        else
            JOptionPane.showMessageDialog(null, "Operação cancelada!", TITULO, 1);
    }
    
    protected void apagar(Repository<T> repo) {
         if(JOptionPane.showConfirmDialog(null, "Deseja realmente apagar os dados?", TITULO, JOptionPane.OK_CANCEL_OPTION) == 0){
            try {
                T ent = getEntidade();
                repo.Save(ent);
                if(repo.Delete(ent))
                    JOptionPane.showMessageDialog(null, "Dados apagados com sucesso!", TITULO, 1);
                else 
                    JOptionPane.showMessageDialog(null, "Aconteceu um erro ao tentar apagar os dados! Consulte o log de erros.", TITULO, 1);
                atualizaListagem();
                limparCamposFormulario();
            } catch (Exception ex) {
                Logger.getLogger(frmClientes.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Aconteceu um erro ao tentar apagar os dados! Consulte o log de erros.", TITULO, 1);
            }            
        }
        else
            JOptionPane.showMessageDialog(null, "Operação cancelada!", TITULO, 1);
    }
    
}
