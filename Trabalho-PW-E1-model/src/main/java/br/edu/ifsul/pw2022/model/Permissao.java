/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.pw2022.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author bianca.evangelista
 */
@Entity
@Table(name = "permissao")
public class Permissao implements Serializable{
    @Id
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 20, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome_permissao", length = 20, nullable = false)        
private String nome;

@NotBlank(message = "O resumo deve ser informado")
    @Length(max = 30, message = "O resumo não pode ter mais que {max} caracteres")
    @Column(name = "resumo", length = 30, nullable = false)  
private String resumo;

@ManyToMany
    @JoinTable(name = "permissoes",

            joinColumns = 
                    @JoinColumn(name = "permissao", referencedColumnName = "nome_permissao", 
                            nullable = false),

            inverseJoinColumns = 
                    @JoinColumn(name = "nome_docente", referencedColumnName = "nome_docente", 
                            nullable = false)
            )     
    private Set<Docente> docentes = new HashSet<>();
    public Permissao() {

    }

    

    /**
     * @return the resumo
     */
    public String getResumo() {
        return resumo;
    }

    /**
     * @param resumo the resumo to set
     */
    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    /**
     * @return the docentes
     */
    public Set<Docente> getDocentes() {
        return docentes;
    }

    /**
     * @param docentes the docentes to set
     */
    public void setDocentes(Set<Docente> docentes) {
        this.docentes = docentes;
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
        final Permissao other = (Permissao) obj;
        return Objects.equals(this.nome, other.nome);
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

}
