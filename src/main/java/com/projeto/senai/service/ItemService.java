package com.projeto.senai.service;

import com.projeto.senai.model.ItemBean;
import com.projeto.senai.repository.ItemDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemDAO repository;

    public List<ItemBean> listarPorLocal(int idLocal) {
        return repository.lerItensPorLocal(idLocal);
    }

    public void criar(ItemBean item) {
        int total = repository.contarItensNoLocal(item.getLocalId());       
        boolean existe = repository.existeTituloNoLocal(item.getTitulo(), item.getLocalId());
       
        if (total < 10 && !existe) {
            repository.inserirItem(item);
        }
    }

    public void excluirItem(int id) {
        repository.deletarItem(id);
    }
}