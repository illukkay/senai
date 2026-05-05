/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.senai.controller;

import com.projeto.senai.model.ItemBean;
import com.projeto.senai.service.ItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */
@RestController
@RequestMapping("/itens")
public class ItemController {

    @Autowired
    private ItemService service;

    @GetMapping("/local/{id}")
    public List<ItemBean> listarPorLocal(@PathVariable int id) {
        return service.listarPorLocal(id);
    }

    @PostMapping
    public void criar(@RequestBody ItemBean item) {
        service.criar(item);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable int id) {
        service.excluirItem(id);
    }
}
