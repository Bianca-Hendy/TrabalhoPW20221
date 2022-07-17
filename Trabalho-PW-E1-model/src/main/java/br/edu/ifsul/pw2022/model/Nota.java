/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.pw2022.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author bianca.evangelista
 */
@Entity
@Table(name = "nota")
public class Nota implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_nota", sequenceName = "seq_nota_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_nota", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Min(value = 0, message = "O valor não pode ser negativo")
    @NotNull(message = " A nota 1 deve ser informado")
    @Column(name = "nota_01", nullable = false, columnDefinition = "decimal(4,2)")
    private Double nota01;

    @Min(value = 0, message = "O valor não pode ser negativo")
    @NotNull(message = " A nota 1 deve ser informado")
    @Column(name = "nota_02", nullable = false, columnDefinition = "decimal(4,2)")
    private Double nota02;

    @Min(value = 0, message = "O valor não pode ser negativo")
    @NotNull(message = " A nota 1 deve ser informado")
    @Column(name = "media", nullable = false, columnDefinition = "decimal(4,2)")
    private Double media;

    @NotNull(message = " A disciplina deve ser informada")
    @ManyToOne
    @JoinColumn(name = "disciplina_id", referencedColumnName = "id", nullable = false)
    private Disciplina disciplina;

    @NotNull(message = " O aluno deve ser informado")
    @ManyToOne
    @JoinColumn(name = "aluno", referencedColumnName = "id", nullable = false)
private Aluno aluno;

    public Nota() {
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nota01
     */
    public Double getNota01() {
        return nota01;
    }

    /**
     * @param nota01 the nota01 to set
     */
    public void setNota01(Double nota01) {
        this.nota01 = nota01;
    }

    /**
     * @return the nota02
     */
    public Double getNota02() {
        return nota02;
    }

    /**
     * @param nota02 the nota02 to set
     */
    public void setNota02(Double nota02) {
        this.nota02 = nota02;
    }

    /**
     * @return the media
     */
    public Double getMedia() {
        return media;
    }

    /**
     * @param media the media to set
     */
    public void setMedia(Double media) {
        this.media = media;
    }

    /**
     * @return the disciplina
     */
    public Disciplina getDisciplina() {
        return disciplina;
    }

    /**
     * @param disciplina the disciplina to set
     */
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * @return the aluno
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

  
}
