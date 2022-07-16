/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.pw2022.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author bianca.evangelista
 */
@Entity
@Table(name = "curso")
public class Curso implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_curso", sequenceName = "seq_curso_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_curso", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank(message = "O nome do curso não pode ser em branco")
    @Length(max = 40, message = "O nome do curso não pode ter mais de {max} caracteres")
    @Column(name = "nome_curso", length = 40, nullable = false)
    private String nome;

    @NotBlank(message = "A sigla não pode ser em branco")
    @Length(max = 5, message = "A sigla não pode ter mais de {max} caracteres")
    @Column(name = "sigla", length = 5, nullable = false)
    private String sigla;

    @NotNull(message = "O campo deve ser informado")
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;

    @Temporal(TemporalType.DATE) //somente TIME o hibernate não aceita
    @NotNull(message = "A data de inicio das atividades deve ser informada")
    @Column(name = "inicio_atividades", nullable = false)
    private Calendar inicioAtividades;

    @Column(name = "descricao", columnDefinition = "text")
    private String descricao;

@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY) 
    private List<Disciplina> disciplinas = new ArrayList<>();

    public Curso() {
    }

public void adicionarDisciplina(Disciplina obj){
        obj.setCurso(this);
        this.getDisciplinas().add(obj);
    }
public void removerDisciplina(int index){
        this.disciplinas.remove(index);
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sigla
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * @param sigla the sigla to set
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    /**
     * @return the ativo
     */
    public Boolean getAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    /**
     * @return the inicioAtividades
     */
    public Calendar getInicioAtividades() {
        return inicioAtividades;
    }

    /**
     * @param inicioAtividades the inicioAtividades to set
     */
    public void setInicioAtividades(Calendar inicioAtividades) {
        this.inicioAtividades = inicioAtividades;
    }

    
   public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    
    public void setDisciplinas(List<Disciplina> disciplina) {
        this.disciplinas = disciplina;
    }

  @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.getId());
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Curso other = (Curso) obj;
        return Objects.equals(this.getId(), other.getId());
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
