/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifsul.edu.controle;

import br.edu.ifsul.pw2022.model.Docente;
import br.edu.ifsul.pw2022.model.Permissao;
import br.ifsul.edu.dao.DocenteDAO;
import br.ifsul.edu.dao.PermissaoDAO;
import br.ifsul.edu.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author bianca.evangelista
 */
@Named(value = "controleDocente")
@ViewScoped
public class ControleDocente implements Serializable {
    
    @EJB
    private DocenteDAO<Docente> dao;
    private Docente objeto;
    private Boolean novo;
    @EJB
    private PermissaoDAO<Permissao> daoPermissao;
    private Permissao permissao;
    private int abaAtiva;
    
    public ControleDocente() {
        
    }
    
    public void removerPermissao(Permissao obj) {
        objeto.getPermissoes().remove(obj);
        Util.mensagemInformacao("Permissão removida com sucesso!");
    }
    
    public void adicionarPermissao() {
        if (!objeto.getPermissoes().contains(permissao)) {
            objeto.getPermissoes().add(permissao);
            Util.mensagemInformacao("Permissão adicionada com sucesso!");
        } else {
            Util.mensagemErro("Docente já possui esta permissão");
        }
    }
    
    public void verificarUnicidadeNomeDocente() {
        if (novo) {
            try {
                if (!dao.verificaUnicidadeNomeDocente(objeto.getNomeDocente())){
                    Util.mensagemErro("Nome do docente '" + objeto.getNomeDocente() + "' "
                            + " já existe no banco de dados!");
                    objeto.setNomeDocente(null);
                    // capturar o componente que chamou o método
                    UIComponent comp = 
                            UIComponent.getCurrentComponent(FacesContext.getCurrentInstance());
                    if (comp != null){
                        // deixar em vermelho após o update
                        UIInput input = (UIInput) comp;
                        input.setValid(false);
                    }
                }
            } catch (Exception e) {
                Util.mensagemErro("Erro do sistema:" + Util.getMensagemErro(e));
            }
        }
    }
    
    public String listar() {
        return "/privado/docente/listar?faces-redirect=true";
    }
    
    public void novo() {
        objeto = new Docente();
        novo = true;
        abaAtiva = 0;
    }
    
    public void alterar(Object id) {
        try {
            objeto = dao.getObjectByID(id);
            novo = false;
            abaAtiva = 0;
        } catch (Exception e) {
            Util.mensagemInformacao("Erro ao recuperar objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void excluir(Object id) {
        try {
            objeto = dao.getObjectByID(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e) {
            Util.mensagemInformacao("Erro ao remover objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void salvar() {
        try {
            if (novo) {
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e) {
            Util.mensagemInformacao("Erro ao salvar objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public DocenteDAO<Docente> getDao() {
        return dao;
    }
    
    public void setDao(DocenteDAO<Docente> dao) {
        this.dao = dao;
    }
    
    public Docente getObjeto() {
        return objeto;
    }
    
    public void setObjeto(Docente objeto) {
        this.objeto = objeto;
    }
    
    public Boolean getNovo() {
        return novo;
    }
    
    public void setNovo(Boolean novo) {
        this.novo = novo;
    }
    
    public PermissaoDAO<Permissao> getDaoPermissao() {
        return daoPermissao;
    }
    
    public void setDaoPermissao(PermissaoDAO<Permissao> daoPermissao) {
        this.daoPermissao = daoPermissao;
    }
    
    public Permissao getPermissao() {
        return permissao;
    }
    
    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    public int getAbaAtiva() {
        return abaAtiva;
    }

    public void setAbaAtiva(int abaAtiva) {
        this.abaAtiva = abaAtiva;
    }
    
}
