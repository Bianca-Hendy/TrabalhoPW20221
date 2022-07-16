/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifsul.edu.dao;

import br.edu.ifsul.pw2022.model.Especialidade;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author bianca.evangelista
 */
@Stateful
public class EspecialidadeDAO<TIPO> extends DAOGenerico<Especialidade> implements Serializable {

    public EspecialidadeDAO() {
        super();
        classePersistente = Especialidade.class;
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("nome", "Nome", "like"));

        ordemAtual = listaOrdem.get(1);

        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);
    }
}
