/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifsul.edu.controle;

import br.edu.ifsul.pw2022.model.Aluno;
import br.edu.ifsul.pw2022.model.Curso;
import br.edu.ifsul.pw2022.model.Disciplina;
import br.edu.ifsul.pw2022.model.Nota;
import br.ifsul.edu.dao.AlunoDAO;
import br.ifsul.edu.dao.CursoDAO;
import br.ifsul.edu.dao.DisciplinaDAO;
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
@Named(value = "controleDisciplina")
@ViewScoped
public class ControleDisciplina implements Serializable {

    @EJB
    private DisciplinaDAO<Disciplina> dao;
    private Disciplina objeto;
    @EJB
    private AlunoDAO<Aluno> daoAluno;

    private Nota nota;

    
    private Boolean novaNota;

    public ControleDisciplina() {
    }
 
   
    public void novaNota() {
        nota = new Nota();
        novaNota = true;
    }

    public void alterarNota(int index) {
        nota = objeto.getNotas().get(index);
        novaNota = false;

    }

    public void salvarNota() {
        if (novaNota) {
            objeto.adicionarNota(nota);
        }
        Util.mensagemInformacao("Nota salvada e alterada com sucesso");
    }

    public void removerNota(int index) {
        objeto.removerNota(index);
        Util.mensagemInformacao("Nota removida com sucesso");
    }

    public String listar() {
        return "/privado/disciplina/listar?faces-redirect-true";
    }

    public void novo() {
        objeto = new Disciplina();
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
    public DisciplinaDAO<Disciplina> getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(DisciplinaDAO<Disciplina> dao) {
        this.dao = dao;
    }

    /**
     * @return the objeto
     */
    public Disciplina getObjeto() {
        return objeto;
    }

    /**
     * @param objeto the objeto to set
     */
    public void setObjeto(Disciplina objeto) {
        this.objeto = objeto;
    }

    /**
     * @return the daoAluno
     */
    public AlunoDAO<Aluno> getDaoAluno() {
        return daoAluno;
    }

    /**
     * @param daoAluno the daoAluno to set
     */
    public void setDaoAluno(AlunoDAO<Aluno> daoAluno) {
        this.daoAluno = daoAluno;
    }

    /**
     * @return the nota
     */
    public Nota getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(Nota nota) {
        this.nota = nota;
    }

    /**
     * @return the novaNota
     */
    public Boolean getNovaNota() {
        return novaNota;
    }

    /**
     * @param novaNota the novaNota to set
     */
    public void setNovaNota(Boolean novaNota) {
        this.novaNota = novaNota;
    }

}
