/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifsul.edu.controle;

import br.edu.ifsul.pw2022.model.Curso;
import br.edu.ifsul.pw2022.model.Disciplina;
import br.edu.ifsul.pw2022.model.Instituicao;
import br.ifsul.edu.dao.CursoDAO;
import br.ifsul.edu.dao.DisciplinaDAO;
import br.ifsul.edu.dao.InstituicaoDAO;
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
@Named(value = "controleCurso")
@ViewScoped
public class ControleCurso implements Serializable {

    @EJB
    private CursoDAO<Curso> dao;
    private Curso objeto;
    @EJB
    private InstituicaoDAO<Instituicao> daoInstituicao;
private Disciplina disciplina;
    private Boolean novaDisciplina;
    private int abaAtiva;

     public ControleCurso() {
    }


    public void novaDisciplina() {
        disciplina = new Disciplina();
        novaDisciplina = true;
    }

    public void alterarDisciplina(int index) {
        disciplina = objeto.getDisciplinas().get(index);
        novaDisciplina = false;

    }

    public void salvarDisciplina() {
        if (novaDisciplina) {
            objeto.adicionarDisciplina(disciplina);
        }
        Util.mensagemInformacao("Disciplina salvada ou alterada com sucesso");
    }

    public void removerDisciplina(int index) {
        objeto.removerDisciplina(index);
        Util.mensagemInformacao("Disciplina removida com sucesso");
    }

    public String listar() {
        return "/privado/curso/listar?faces-redirect-true";
    }

    public void novo() {
        objeto = new Curso();
        abaAtiva = 0;
    }

    public void alterar(Object id) {
        try {
            objeto = dao.getObjectByID(id);
            abaAtiva = 0;
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
    public CursoDAO<Curso> getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(CursoDAO<Curso> dao) {
        this.dao = dao;
    }

    /**
     * @return the objeto
     */
    public Curso getObjeto() {
        return objeto;
    }

    /**
     * @param objeto the objeto to set
     */
    public void setObjeto(Curso objeto) {
        this.objeto = objeto;
    }

    /**
     * @return the daoInstituicao
     */
    public InstituicaoDAO<Instituicao> getDaoInstituicao() {
        return daoInstituicao;
    }

    /**
     * @param daoInstituicao the daoInstituicao to set
     */
    public void setDaoInstituicao(InstituicaoDAO<Instituicao> daoInstituicao) {
        this.daoInstituicao = daoInstituicao;
    }


    /**
     * @return the disciplina
     */
    public Disciplina getDisciplina() {
        return disciplina;
    }

    /**
     * @param disciplina the disciplina to set
     */
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * @return the novaDisciplina
     */
    public Boolean getNovaDisciplina() {
        return novaDisciplina;
    }

    /**
     * @param novaDisciplina the novaDisciplina to set
     */
    public void setNovaDisciplina(Boolean novaDisciplina) {
        this.novaDisciplina = novaDisciplina;
    }

    /**
     * @return the abaAtiva
     */
    public int getAbaAtiva() {
        return abaAtiva;
    }

    /**
     * @param abaAtiva the abaAtiva to set
     */
    public void setAbaAtiva(int abaAtiva) {
        this.abaAtiva = abaAtiva;
    }

}
