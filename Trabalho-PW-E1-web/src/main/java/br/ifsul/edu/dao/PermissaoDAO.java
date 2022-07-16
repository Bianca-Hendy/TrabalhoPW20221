/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifsul.edu.dao;

import br.edu.ifsul.pw2022.model.Permissao;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author bianca.evangelista
 */
@Stateful
public class PermissaoDAO<TIPO> extends DAOGenerico<Permissao> implements Serializable {

    public PermissaoDAO() {
        super();
        classePersistente = Permissao.class;
         listaOrdem.add(new Ordem("nome_permissao", "Nome_Permissao", "like"));
        listaOrdem.add(new Ordem("resumo", "Resumo", "like"));

        ordemAtual = listaOrdem.get(1);

        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);
    }

}
