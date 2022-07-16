/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifsul.edu.dao;

import br.edu.ifsul.pw2022.model.Docente;
import java.io.Serializable;
import javax.ejb.Stateful;
import javax.persistence.Query;

/**
 *
 * @author bianca.evangelista
 */
@Stateful
public class DocenteDAO<TIPO> extends DAOGenerico<Docente> implements Serializable {

    public DocenteDAO() {
        super();
        classePersistente = Docente.class;
        listaOrdem.add(new Ordem("nome_docente", "Nome_Docente", "="));
        

        ordemAtual = listaOrdem.get(0);

        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);
    }
 @Override
    public Docente getObjectByID(Object id) throws Exception {
        Docente obj = em.find(Docente.class, id);
        // uso para evitar o erro de lazy inicialization exception
        obj.getPermissoes().size();
        return obj;
    }     
    
    public boolean verificaUnicidadeNomeDocente(String nomeDocente) throws Exception {
        String jpql = "from Docente where nome_docente = :pNome_Docente";
        Query query = em.createQuery(jpql);
        query.setParameter("pNome_Docente", nomeDocente);
        if (query.getResultList().size() > 0){
            return false;
        } else {
            return true;
        }
    }    
}
