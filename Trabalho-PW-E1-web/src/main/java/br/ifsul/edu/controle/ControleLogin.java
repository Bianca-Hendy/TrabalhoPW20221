/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifsul.edu.controle;

import br.edu.ifsul.pw2022.model.Docente;
import br.ifsul.edu.dao.DocenteDAO;
import br.ifsul.edu.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author bianca.evangelista
 */
@Named(value = "controleLogin")
@SessionScoped
public class ControleLogin implements Serializable {

    private Docente docenteAutenticado;
    @EJB
    private DocenteDAO<Docente> daoDocente;
    private String docente;
    private String senha;

    public ControleLogin() {
    }

    public String irTelaLogin() {
        return "/login?faces-redirect=true";
    }

    public String efetuarLogin() {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            request.login(docente, senha);
            if (request.getUserPrincipal() != null) {
                docenteAutenticado
                        = daoDocente.getObjectByID(request.getUserPrincipal().getName());
                Util.mensagemInformacao("Docente autenticado com sucesso");
                docente = "";
                senha = "";
            }
            return "/index?faces-redirect=true";
        } catch (Exception e) {
            Util.mensagemErro("Erro no login: " + Util.getMensagemErro(e));
            return "/login?faces-redirect=true";
        }
    }

    public String logout() {
        try {
            docenteAutenticado = null;
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            request.logout();
            return "/index?faces-redirect=true";
        } catch (Exception e) {
            Util.mensagemErro("Erro ao fazer o logout: " + Util.getMensagemErro(e));
            return "/index?faces-redirect=true";
        }
    }

    /**
     * @return the docenteAutenticado
     */
    public Docente getDocenteAutenticado() {
        return docenteAutenticado;
    }

    /**
     * @param docenteAutenticado the docenteAutenticado to set
     */
    public void setDocenteAutenticado(Docente docenteAutenticado) {
        this.docenteAutenticado = docenteAutenticado;
    }

    /**
     * @return the daoDocente
     */
    public DocenteDAO<Docente> getDaoDocente() {
        return daoDocente;
    }

    /**
     * @param daoDocente the daoDocente to set
     */
    public void setDaoDocente(DocenteDAO<Docente> daoDocente) {
        this.daoDocente = daoDocente;
    }

    /**
     * @return the docente
     */
    public String getDocente() {
        return docente;
    }

    /**
     * @param docente the docente to set
     */
    public void setDocente(String docente) {
        this.docente = docente;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
