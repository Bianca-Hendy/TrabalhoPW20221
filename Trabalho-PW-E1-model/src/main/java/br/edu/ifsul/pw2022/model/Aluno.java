/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.pw2022.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "aluno")
public class Aluno implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_aluno", sequenceName = "seq_aluno_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_aluno", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 40, message = "O nome não pode ter mais de {max} caracteres")
    @Column(name = "nome", length = 40, nullable = false)
    private String nome;

    @NotBlank(message = "O email não pode ser em branco")
    @Length(max = 40, message = "O email não pode ter mais de {max} caracteres")
    @Column(name = "email", length = 40, nullable = false)
    private String email;

    @Temporal(TemporalType.DATE) //somente TIME o hibernate não aceita
    @NotNull(message = "A data de nascimento deve ser informad")
    @Column(name = "data_nascimento", nullable = false)
    private Calendar nascimento;

@ManyToMany
    @JoinTable(name = "disciplinas", joinColumns = @JoinColumn(name = "nome_aluno", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "disciplina", referencedColumnName = "id", nullable = false))
    private Set<Disciplina> disciplinas = new HashSet<>();
    public Aluno() {
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the nascimento
     */
    public Calendar getNascimento() {
        return nascimento;
    }

    /**
     * @param nascimento the nascimento to set
     */
    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    /**
     * @return the disciplinas
     */
    public Set<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    /**
     * @param disciplinas the disciplinas to set
     */
    public void setDisciplinas(Set<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
 @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.id);
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
        final Aluno other = (Aluno) obj;
        return Objects.equals(this.id, other.id);
    }
   

}
