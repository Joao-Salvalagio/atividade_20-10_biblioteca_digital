package com.crud.aula_20_10_2025.services;

import com.crud.aula_20_10_2025.models.LivroModel;
import com.crud.aula_20_10_2025.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public List<LivroModel> findAll() {
        return livroRepository.findAll();
    }

    public LivroModel findById(Long id) {
        return livroRepository.findById(id).get();
    }

    public LivroModel save(@RequestBody LivroModel livroModel) {
        return livroRepository.save(livroModel);
    }

    public void deletebyId(Long id) {
        livroRepository.deleteById(id);
    }

    public void updatebyId(Long id, @RequestBody LivroModel livroModel) {
        LivroModel findbook = livroRepository.findById(id).orElse(null);
        if (findbook != null) {
            findbook.setTitulo(livroModel.getTitulo());
            findbook.setAutor(livroModel.getAutor());
            findbook.setDescricao(livroModel.getDescricao());
            findbook.setPreco(livroModel.getPreco());
            livroRepository.save(findbook);
        }
    }
}
