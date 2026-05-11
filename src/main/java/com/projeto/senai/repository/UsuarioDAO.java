/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.senai.repository;

import com.projeto.senai.model.AuthBean;
import com.projeto.senai.model.IdUsuarioBean;
import com.projeto.senai.model.UsuarioBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */
@Repository
public class UsuarioDAO {
    
    
    public void registrar(AuthBean usuario) {
        try {
    Connection conn = Conexao.conectar();
    String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
    PreparedStatement stmt = conn.prepareStatement(sql);
            
    stmt.setString(1, usuario.getNome());
    stmt.setString(2, usuario.getEmail());
    stmt.setString(3, usuario.getSenha());
            
    stmt.execute();
    
    }catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public AuthBean logar(String email, String senha) {
    AuthBean usuario = new AuthBean();
        try {
    Connection conn = Conexao.conectar();
    String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
            
    stmt.setString(1, email);
    stmt.setString(2, senha);
    ResultSet rs = stmt.executeQuery();

    if (rs.next()) {
       usuario.setNome(rs.getString("nome"));
       usuario.setEmail(rs.getString("email"));
            }
    
   }catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }
    
    public void update (UsuarioBean update){
        try{
    Connection conn = Conexao.conectar();
    PreparedStatement stmt = null;
    stmt = conn.prepareStatement("UPDATE FROM usuarios SET nome = ?, email = ?, senha = ? WHERE id_usuario") ;
    
    
    stmt.setString(1, update.getNome());
    stmt.setString(2, update.getEmail());
    stmt.setString(3, update.getSenha());
    stmt.setInt(4, update.getId());
    
    stmt.executeUpdate();
    
    }catch (Exception e) {
            e.printStackTrace();
    }
}
    
    public void DeletarUsuario(IdUsuarioBean update){
       try{
    Connection conn = Conexao.conectar();
    PreparedStatement stmt = null;
           
    stmt = conn.prepareStatement("DELETE from usuarios WHERE id_usuario = ? ");
           
    stmt.setInt(1, update.getId_usuario());
           
    stmt.executeUpdate();
           
            }catch (Exception e){
           e.printStackTrace();
        }
        }
    
    
    
    
    
    
    
    
    
    
}
