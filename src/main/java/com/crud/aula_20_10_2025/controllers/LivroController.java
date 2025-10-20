package com.crud.aula_20_10_2025.controllers;

import com.crud.aula_20_10_2025.models.LivroModel;
import com.crud.aula_20_10_2025.repositories.LivroRepository;
import com.crud.aula_20_10_2025.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<LivroModel> findAll() {
        return livroService.findAll();
    }

    @GetMapping("/{id}")
    public LivroModel findById(@PathVariable Long id) {
        return livroService.findById(id);
    }

    @PostMapping
    public LivroModel save(@RequestBody LivroModel livroModel) {
        return livroService.save(livroModel);
    }

    @DeleteMapping("/{id}")
    public void deletebyId(@PathVariable Long id) {
        livroService.deletebyId(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody LivroModel livroModel) {
        livroService.updatebyId(id, livroModel);
    }
}
