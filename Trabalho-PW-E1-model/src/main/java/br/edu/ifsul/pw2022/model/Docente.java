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
@Table (name = "docente")
public class Docente implements Serializable {
    @Id
    @NotBlank(message = "O nome docente não pode ser em branco")
    @Length(max = 40, message = "O nome docente não pode ter mais de {max} caracteres")
    @Column(name = "nome_docente", length = 40, nullable = false)
    private String nomeDocente;

    @NotBlank(message = "A senha não pode ser em branco")
    @Length(max = 20, message = "A senha não pode ter mais de {max} caracteres")
    @Column(name = "senha_docente", length = 20, nullable = false)
    private String senha;

   @ManyToMany
    @JoinTable(name = "permissoes",
            // se refere a classe usuário
            joinColumns = 
                    @JoinColumn(name = "nome_docente", referencedColumnName = "nome_docente", 
                            nullable = false),
            // se refere ao tipo da lista <Permissao>
            inverseJoinColumns = 
                    @JoinColumn(name = "permissao", referencedColumnName = "nome_permissao", 
                            nullable = false)
            )            
    private Set<Permissao> permissoes = new HashSet<>();

    public Docente() {
    }

    /**
     * @return the nomeDocente
     */
    public String getNomeDocente() {
        return nomeDocente;
    }

    /**
     * @param nomeDocente the nomeDocente to set
     */
    public void setNomeDocente(String nomeDocente) {
        this.nomeDocente = nomeDocente;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
   public Set<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(Set<Permissao> permissoes) {
        this.permissoes = permissoes;
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
        final Docente other = (Docente) obj;
        return Objects.equals(this.nomeDocente, other.nomeDocente);
    }
}
