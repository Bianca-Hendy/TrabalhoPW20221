/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifsul.edu.converters;


import br.edu.ifsul.pw2022.model.Instituicao;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 20171PF.CC0380
 */
@Named(value="converterInstituicao")
@RequestScoped
public class ConverterInstituicao implements Serializable, Converter{
    @PersistenceContext(unitName = "PW-2022-1-Trabalho")
    private EntityManager em;
    
    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
        if(string == null || string.equals("Selecione um registro")){
            return null;
        }
        return em.find(Instituicao.class, Integer.parseInt(string));
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object t) {
        if(t == null){
            return null;
        }
        Instituicao obj = (Instituicao) t;
        return obj.getId().toString();
    }
    
}
