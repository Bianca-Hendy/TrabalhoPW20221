/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.pw2022.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author bianca.evangelista
 */
@Entity
@Table(name = "professor")
public class Professor extends Aluno implements Serializable {

    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 40, message = "O nome não pode ter mais de {max} caracteres")
    @Column(name = "titulacao", length = 40, nullable = false)
    private String titulacao;

    @Column(name = "topicos_interesse", columnDefinition = "text") //length funciona apenas com string
    private String topicosInteresse;

    @NotNull(message = " a especialidade deve ser informado")
    @ManyToOne
    @JoinColumn(name = "especialidade", referencedColumnName = "id", nullable = false)
    private Especialidade espec;

    public Professor() {
    }


    
    /**
     * @return the topicosInteresse
     */
    public String getTopicosInteresse() {
        return topicosInteresse;
    }

    /**
     * @param topicosInteresse the topicosInteresse to set
     */
    public void setTopicosInteresse(String topicosInteresse) {
        this.topicosInteresse = topicosInteresse;
    }

    /**
     * @return the espec
     */
    public Especialidade getEspec() {
        return espec;
    }

    /**
     * @param espec the espec to set
     */
    public void setEspec(Especialidade espec) {
        this.espec = espec;
    }

    /**
     * @return the titulacao
     */
    public String getTitulacao() {
        return titulacao;
    }

    /**
     * @param titulacao the titulacao to set
     */
    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }
}
