/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.pw2022.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author bianca.evangelista
 */
@Entity
@Table(name = "disciplina")
public class Disciplina implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_disciplina", sequenceName = "seq_disciplina_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_disciplina", strategy = GenerationType.SEQUENCE)
    private Integer id;

@NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 40, message = "O nome não pode ter mais de {max} caracteres")
    @Column(name = "nome_disciplina", length = 40, nullable = false)
    private String nome;

@NotBlank(message = "A descrição não pode ser em branco")
    @Length(max = 60, message = "A descrição não pode ter mais de {max} caracteres")
    @Column(name = "descricao", length = 60, nullable = false)
    private String descricao;

@Min(value = 0, message = "O valor não pode ser negativo")
    @NotNull(message = " A carga horaria deve ser informado")
    @Column(name = "carga_horaria", nullable = false, columnDefinition = "decimal(4,2)")
    private Double cargaHoraria;

@NotBlank(message = "o campo não pode ser em branco")
    @Column(name = "conhecimentos_minimos", columnDefinition = "text")
    private String conhecimentoMinimos;

@OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY) 
    //quando apaga o pai ira apagar os filhos dele 
    //se tem 10 times e poe o LAZY ira carregar apenas os times
    //se tem 10 times e poe o EAGER ira carregar todos os times e os seus respectivos jogadores 
    private List<Nota> notas = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "disciplinas", joinColumns = @JoinColumn(name = "disciplina", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "nome_aluno", referencedColumnName = "id", nullable = false))
    private Set<Aluno> alunos = new HashSet<>();

 @NotNull(message = " o curso deve ser informado")
    @ManyToOne
    @JoinColumn(name = "curso_id", referencedColumnName = "id")
private Curso curso;

    public Disciplina() {
    }
public void adicionarNota(Nota obj){
        obj.setDisciplina(this);
        this.notas.add(obj);
    }
public void removerNota(int index){
        this.notas.remove(index);
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

    /**
     * @return the cargaHoraria
     */
    public Double getCargaHoraria() {
        return cargaHoraria;
    }

    /**
     * @param cargaHoraria the cargaHoraria to set
     */
    public void setCargaHoraria(Double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    /**
     * @return the conhecimentoMinimos
     */
    public String getConhecimentoMinimos() {
        return conhecimentoMinimos;
    }

    /**
     * @param conhecimentoMinimos the conhecimentoMinimos to set
     */
    public void setConhecimentoMinimos(String conhecimentoMinimos) {
        this.conhecimentoMinimos = conhecimentoMinimos;
    }

    /**
     * @return the notas
     */
    public List<Nota> getNotas() {
        return notas;
    }

    /**
     * @param notas the notas to set
     */
    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    /**
     * @return the alunos
     */
    public Set<Aluno> getAlunos() {
        return alunos;
    }

    /**
     * @param alunos the alunos to set
     */
    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }

    /**
     * @return the curso
     */
    public Curso getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

   
}
