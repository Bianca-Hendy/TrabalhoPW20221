/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifsul.edu.controle;

import br.edu.ifsul.pw2022.model.Aluno;
import br.ifsul.edu.dao.AlunoDAO;
import br.ifsul.edu.util.Util;
import br.ifsul.edu.util.UtilRelatorios;
import java.io.Serializable;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author bianca.evangelista
 */
@Named(value = "controleAluno")
@ViewScoped
public class ControleAluno implements Serializable{
     @EJB
    private AlunoDAO<Aluno> dao;
    private Aluno objeto;

    public ControleAluno() {
    }
 public void imprimeAlunos() {
        HashMap parametros = new HashMap();
        UtilRelatorios.imprimeRelatorio("relatorioFacul", parametros, dao.getListaTodos());
    }
public String listar() {
        return "/privado/aluno/listar?faces-redirect-true";
    }

    public void novo() {
        objeto = new Aluno();
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
    public AlunoDAO<Aluno> getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(AlunoDAO<Aluno> dao) {
        this.dao = dao;
    }

    /**
     * @return the objeto
     */
    public Aluno getObjeto() {
        return objeto;
    }

    /**
     * @param objeto the objeto to set
     */
    public void setObjeto(Aluno objeto) {
        this.objeto = objeto;
    }
}
