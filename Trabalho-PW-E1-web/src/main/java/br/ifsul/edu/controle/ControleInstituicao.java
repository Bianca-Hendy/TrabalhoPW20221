/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifsul.edu.controle;

import br.edu.ifsul.pw2022.model.Instituicao;
import br.ifsul.edu.dao.InstituicaoDAO;
import br.ifsul.edu.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author bianca.evangelista
 */
@Named(value = "controleInstituicao")
@ViewScoped
public class ControleInstituicao implements Serializable{
     @EJB
    private InstituicaoDAO<Instituicao> dao;
    private Instituicao objeto;

    public ControleInstituicao() {

    }
 public String listar() {
        return "/privado/instituicao/listar?faces-redirect-true";
    }

    public void novo() {
        objeto = new Instituicao();
    }

    public void alterar(Object id) {
        try {
            objeto = dao.getObjectByID(id);
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: " + Util.getMensagemErro(e));
        }
    }

    public void excluir(Object id) {
        try {
            objeto = dao.getObjectByID(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao remover objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void salvar(){
       try {
           if (objeto.getId() == null){
               dao.persist(objeto);
           } else {
               dao.merge(objeto);
           }
           Util.mensagemInformacao("Objeto persistido com sucesso!");
       } catch (Exception e){
           Util.mensagemErro("Erro ao persistir objeto: " + Util.getMensagemErro(e));
       }
    }

    /**
     * @return the dao
     */
    public InstituicaoDAO<Instituicao> getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(InstituicaoDAO<Instituicao> dao) {
        this.dao = dao;
    }

    /**
     * @return the objeto
     */
    public Instituicao getObjeto() {
        return objeto;
    }

    /**
     * @param objeto the objeto to set
     */
    public void setObjeto(Instituicao objeto) {
        this.objeto = objeto;
    }


}
