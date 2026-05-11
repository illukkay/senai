/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.senai.controller;

import com.projeto.senai.model.AuthBean;
import com.projeto.senai.model.IdUsuarioBean;
import com.projeto.senai.model.UsuarioBean;
import com.projeto.senai.repository.UsuarioDAO;
import com.projeto.senai.service.TokenService;
import com.projeto.senai.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
    public String Cadastrar(@RequestBody AuthBean usuario) {
        service.registrar(usuario);
        return "Cadastrado com sucesso!" ;
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
     
     
    @PutMapping("/modificar/{id}")
    public String update(@PathVariable int id, @RequestBody UsuarioBean update, @RequestHeader("Authorization") String auth){
        System.out.println(auth);
        String tokens = auth.replace("Bearer ", "");
        if(token.validarToken(tokens)){
            update.setId(id);
            service.update(update);
            return "usuario atualizado com sucesso";
        }else{
            return null;
        }
        
        
        
   }
    
    @DeleteMapping("/deletar/{id}")
    public String DeletarUsuario(@PathVariable int id, @RequestBody IdUsuarioBean update, @RequestHeader("Authorization") String auth){
        System.out.println(auth);
        String tokens = auth.replace("Bearer ", "");
        if(token.validarToken(tokens)){
            update.setId_usuario(id);
            service.DeletarUsuario(update);
            return "usuario d com sucesso";
        }else{
            return null;
        }
}
}