/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.senai.service;

import com.projeto.senai.model.AuthBean;
import com.projeto.senai.model.UsuarioBean;
import com.projeto.senai.repository.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aluno
 */
@Service
public class UsuarioService {
    @Autowired
    private UsuarioDAO repository;
    
     public void registrar(UsuarioBean usuario){
         repository.registrar(usuario);
     }
     
     public AuthBean logar(String email, String senha){
         return repository.logar(email, senha);
     }   
}
