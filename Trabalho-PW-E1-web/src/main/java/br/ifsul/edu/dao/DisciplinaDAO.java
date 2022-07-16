/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifsul.edu.dao;

import br.edu.ifsul.pw2022.model.Disciplina;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author bianca.evangelista
 */
@Stateful
public class DisciplinaDAO<TIPO> extends DAOGenerico<Disciplina> implements Serializable {

    public DisciplinaDAO() {
        super();
        classePersistente = Disciplina.class;
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("nome", "Nome Disciplina", "like"));
        

        ordemAtual = listaOrdem.get(1);

        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);
    }
    @Override
 public Disciplina getObjectByID(Object id) throws Exception {
        Disciplina obj = em.find(Disciplina.class, id);
        obj.getNotas().size();
        return obj;
    }
 public List<Disciplina> getListaObjetosCompleta(){
        String jpql = "select distinct d from Disciplina d left join fetch d.notas order by d.id";
        return em.createQuery(jpql).getResultList();
    }
}
