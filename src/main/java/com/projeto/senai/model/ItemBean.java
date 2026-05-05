/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.senai.model;

/**
 *
 * @author Aluno
 */
public class ItemBean {
    private Integer id;
    private String titulo;
    private Integer localId;

    public ItemBean() {
    }

    public ItemBean(Integer id, String titulo, Integer localId) {
        this.id = id;
        this.titulo = titulo;
        this.localId = localId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getLocalId() {
        return localId;
    }

    public void setLocalId(Integer localId) {
        this.localId = localId;
    }

}
