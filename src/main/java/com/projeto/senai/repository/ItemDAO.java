package com.projeto.senai.repository;

import com.projeto.senai.model.ItemBean;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;


  @Repository
public class ItemDAO {

   
    public List<ItemBean> lerItensPorLocal(int idLocal) {
        List<ItemBean> lista = new ArrayList();

        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM itens WHERE local_id = ?");
            
            stmt.setInt(1, idLocal);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ItemBean item = new ItemBean();
                item.setId(rs.getInt("id"));
                item.setTitulo(rs.getString("titulo"));
                item.setLocalId(rs.getInt("local_id"));

                lista.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public int contarItensNoLocal(int idLocal) {
        int total = 0;
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) as total FROM itens WHERE local_id = ?");
            stmt.setInt(1, idLocal);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }
   
    public boolean existeTituloNoLocal(String titulo, int idLocal) {
        boolean existe = false;
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM itens WHERE titulo = ? AND local_id = ?");
            stmt.setString(1, titulo);
            stmt.setInt(2, idLocal);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                existe = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return existe;
    }
   
    public void inserirItem(ItemBean item) {
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO itens (titulo, local_id) VALUES (?, ?)");
            stmt.setString(1, item.getTitulo());
            stmt.setInt(2, item.getLocalId());
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deletarItem(int id) {
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM itens WHERE id = ?");
            stmt.setInt(1, id);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }}