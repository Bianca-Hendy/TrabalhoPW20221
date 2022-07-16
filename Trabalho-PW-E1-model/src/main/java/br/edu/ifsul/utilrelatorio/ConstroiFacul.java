/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.utilrelatorio;

import br.edu.ifsul.pw2022.model.Aluno;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author bianca.evangelista
 */
public class ConstroiFacul {
 
    public static List<Aluno> carregaAlunos(){
        List<Aluno> lista = new ArrayList<>();
        Aluno a = new Aluno();
        a.setId(1);
        a.setNome("Bi");
        a.setNascimento(Calendar.getInstance());
        a.setEmail("teste@gmail.com");
        a.setId(2);
        a.setNome("Anaa");
        a.setNascimento(Calendar.getInstance());
        a.setEmail("teste@gmail3.com");
       
        lista.add(a);
        return lista;
    }

}
