/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifsul.edu.dao;

import br.edu.ifsul.pw2022.model.Nota;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author bianca.evangelista
 */
@Stateful
public class NotaDAO<TIPO> extends DAOGenerico<Nota> implements Serializable {

    public NotaDAO() {
        super();
        classePersistente = Nota.class;
        listaOrdem.add(new Ordem("id", "ID", "="));

        ordemAtual = listaOrdem.get(1);

        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);
    }

}
