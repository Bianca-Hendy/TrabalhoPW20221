/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifsul.edu.controle;

import br.edu.ifsul.pw2022.model.Especialidade;
import br.edu.ifsul.pw2022.model.Professor;
import br.ifsul.edu.dao.EspecialidadeDAO;
import br.ifsul.edu.dao.ProfessorDAO;
import br.ifsul.edu.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author bianca.evangelista
 */
@Named(value = "controleProfessor")
@ViewScoped
public class ControleProfessor implements Serializable {

    @EJB
    private ProfessorDAO<Professor> dao;
    private Professor objeto;
    @EJB
    private EspecialidadeDAO<Especialidade> daoEspecialidade;

    public ControleProfessor() {
    }

    public String listar() {
        return "/privado/professor/listar?faces-redirect-true";
    }

    public void novo() {
        objeto = new Professor();
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

    public void salvar() {
        try {
            if (objeto.getId() == null) {
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao persistir objeto: " + Util.getMensagemErro(e));
        }
    }

    /**
     * @return the dao
     */
    public ProfessorDAO<Professor> getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(ProfessorDAO<Professor> dao) {
        this.dao = dao;
    }

    /**
     * @return the objeto
     */
    public Professor getObjeto() {
        return objeto;
    }

    /**
     * @param objeto the objeto to set
     */
    public void setObjeto(Professor objeto) {
        this.objeto = objeto;
    }

    /**
     * @return the daoEspecialidade
     */
    public EspecialidadeDAO getDaoEspecialidade() {
        return daoEspecialidade;
    }

    /**
     * @param daoEspecialidade the daoEspecialidade to set
     */
    public void setDaoEspecialidade(EspecialidadeDAO daoEspecialidade) {
        this.daoEspecialidade = daoEspecialidade;
    }

}
