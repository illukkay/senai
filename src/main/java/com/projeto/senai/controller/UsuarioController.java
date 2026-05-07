/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.senai.controller;

import com.projeto.senai.model.AuthBean;
import com.projeto.senai.model.UsuarioBean;
import com.projeto.senai.service.TokenService;
import com.projeto.senai.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService service;
     
    @Autowired
    private TokenService token;
             
    @PostMapping("/cadastrar")
    public void Cadastrar(@RequestBody UsuarioBean usuario) {
        service.registrar(usuario);
    }
    
    
    @PostMapping("/logar")
     public String logar(@RequestBody AuthBean req){
        AuthBean usuario = service.logar(req.getEmail(), req.getSenha());  
        if(usuario.getEmail() != null){
            return token.gerarToken(usuario.getEmail());
        }else{
            return "invalido";
        }
    

    
}
}
