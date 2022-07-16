/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifsul.edu.dao;

import br.edu.ifsul.pw2022.model.Curso;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author bianca.evangelista
 */
@Stateful
public class CursoDAO<TIPO> extends DAOGenerico<Curso> implements Serializable {

    public CursoDAO() {
        super();
        classePersistente = Curso.class;
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("nome", "Nome", "like"));
        listaOrdem.add(new Ordem("sigla", "Sigla", "like"));
        listaOrdem.add(new Ordem("instituicao.nome", "Instituicao", "like"));
        ordemAtual = listaOrdem.get(1);

        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);
    }

    @Override
    public Curso getObjectByID(Object id) throws Exception {
        Curso obj = em.find(Curso.class, id);
        obj.getDisciplinas().size();
        return obj;
    }

    public List<Curso> getListaObjetosCompleta() {
        String jpql = "select distinct c from Curso c left join fetch c.disciplinas order by d.id";
        return em.createQuery(jpql).getResultList();
    }
}
