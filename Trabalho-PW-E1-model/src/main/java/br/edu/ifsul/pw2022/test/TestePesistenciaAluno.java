/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.pw2022.test;

import br.edu.ifsul.pw2022.model.Aluno;
import br.edu.ifsul.pw2022.model.Curso;
import br.edu.ifsul.pw2022.model.Disciplina;
import br.edu.ifsul.pw2022.model.Docente;
import br.edu.ifsul.pw2022.model.Especialidade;
import br.edu.ifsul.pw2022.model.Nota;
import br.edu.ifsul.pw2022.model.Permissao;
import br.edu.ifsul.pw2022.model.Professor;
import java.util.Calendar;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author bianca.evangelista
 */
public class TestePesistenciaAluno {

    // public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-Model-Trabalho");
//        EntityManager em = emf.createEntityManager();
//       Aluno a = em.find(Aluno.class, 2);
//
//        em.getTransaction().begin();
//        em.remove(a);
//        em.getTransaction().commit();
//        em.close();
//        emf.close();}
//public static void main(String[] args){
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-Model-Trabalho");
//        EntityManager em = emf.createEntityManager();
//        Aluno aluno = em.find(Aluno.class,3);
//       
//        aluno.setNome("julia");
//        aluno.setNascimento(Calendar.getInstance());
//        aluno.setEmail("testejulia@gmail.com");
//
//        em.getTransaction().begin();
//        em.persist(aluno);
//        em.getTransaction().commit();
//        em.close();
//        emf.close();
//        
//    }
//
//        Aluno aluno = new Aluno();
//        aluno.setNome("juai");
//        aluno.setNascimento(Calendar.getInstance());
//        aluno.setEmail("testealuno@gmail.com");
//
//        em.getTransaction().begin();
//        em.persist(aluno);
//        em.getTransaction().commit();
//        em.close();
//        emf.close();
//    }
//    public static void main(String[] args){
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-Model-Trabalho");
//        EntityManager em = emf.createEntityManager();
//        em.createQuery("from Professor").getResultList();
//        em.close();
//        emf.close();
//    } 
//public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-Model-Trabalho");
//        EntityManager em = emf.createEntityManager();
//
//        Professor p = new Professor();
//        p.setNome("Julio");
//        p.setEmail("teste@gmail.com");
//        p.setNascimento(Calendar.getInstance());
//        p.setTitulacao("mestre");
//        p.setTopicosInteresse("politica");
//        p.setEspec(em.find(Especialidade.class, 1));
//
//        em.getTransaction().begin();
//        em.persist(p);
//        em.getTransaction().commit();
//        em.close();
//        emf.close();
//
//    }
//    public static void main(String[] args) {
//        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("PW2022-1-Model-Trabalho");
//        EntityManager em = emf.createEntityManager();
//        Disciplina d = em.find(Disciplina.class, 1);
//        
//        Nota n = new Nota();
//        n.setNota01(8.0);
//        n.setNota02(9.0);
//        n.setMedia(10.0);
//        n.setAluno(em.find(Aluno.class, 1));
//        d.adicionarNota(n);
//        
//        em.getTransaction().begin();
//        em.persist(d);
//        em.getTransaction().commit();
//        em.close();
//        emf.close();
//        
//    }
//     public static void main(String[] args) {
//        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("PW2022-1-Model-Trabalho");
//        EntityManager em = emf.createEntityManager();
//        Disciplina d = new Disciplina();
//        
//        d.setNome("Robotica");
//        d.setDescricao("Curso tal");
//        d.setCargaHoraria(220.0);
//        d.setConhecimentoMinimos("conhecimentos de programação");
//        //Disciplina d = em.find(Disciplina.class, 1);
//        
//        Nota n = new Nota();
//        n.setNota01(8.0);
//        n.setNota02(9.0);
//        n.setMedia(10.0);
//        n.setAluno(em.find(Aluno.class, 1));
//        d.adicionarNota(n);
//        
//        
//        
//        em.getTransaction().begin();
//        em.persist(d);
//        em.getTransaction().commit();
//        em.close();
//        emf.close();
//        
//    }

//      public static void main(String[] args) {
//        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("PW2022-1-Model-Trabalho");
//        EntityManager em = emf.createEntityManager();
//        Curso d = new Curso();
//        
//        d.setNome("Robotica");
//        d.setSigla("RB");
//       d.setInicioAtividades(Calendar.getInstance());
//       d.setAtivo(Boolean.TRUE);
//       
//        //Disciplina d = em.find(Disciplina.class, 1);
//        
//      
//        
//        em.getTransaction().begin();
//        em.persist(d);
//        em.getTransaction().commit();
//        em.close();
//        emf.close();
//        
//    }
//public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-Model-Trabalho");
//        EntityManager em = emf.createEntityManager();
//
//        Docente d = new Docente();
//
//        d.setNomeDocente("Bianca");
//        d.setSenha("1234");
//
//        
//
//        em.getTransaction().begin();
//        em.persist(d);
//        em.getTransaction().commit();
//        em.close();
//        emf.close();
//
//    }
//public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-Model-Trabalho");
//        EntityManager em = emf.createEntityManager();
//
//        Permissao p = new Permissao();
//
//       p.setNome("Aluno");
//    p.setResumo("sem açao");
//
//   
//
//    em.getTransaction().begin();
//        em.persist(p);
//        em.getTransaction().commit();
//        em.close();
//        emf.close();
//
//    }
//public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-Model-Trabalho");
//        EntityManager em = emf.createEntityManager();
//
//        Docente d = new Docente();
//
//       d.setNomeDocente("Jorge");
//    d.setSenha("1234");
//   
//
//    em.getTransaction().begin();
//        em.persist(d);
//        em.getTransaction().commit();
//        em.close();
//        emf.close();
//
//    }
public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-Model-Trabalho");
        EntityManager em = emf.createEntityManager();
    Docente d = em.find(Docente.class, "Jorge");
   Permissao p = em.find(Permissao.class, "Professor");
d.getPermissoes().add(p);
    em.getTransaction().begin();
        em.persist(d);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
