/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifsul.edu.dao;

import br.edu.ifsul.pw2022.model.Instituicao;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author bianca.evangelista
 * @param <TIPO>
 */
@Stateful
public class InstituicaoDAO<TIPO> extends DAOGenerico<Instituicao> implements Serializable {

    public InstituicaoDAO() {
        super();
        classePersistente = Instituicao.class;
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("nome", "Nome", "like"));
        listaOrdem.add(new Ordem("anofundacao", "AnoFundacao", "like"));
        // ordem atual
        ordemAtual = listaOrdem.get(1);
        // inicializar o conversor de ordem com a lista de ordens
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);
    }
}
