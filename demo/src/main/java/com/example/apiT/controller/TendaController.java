package com.example.apiT.controller;

import com.example.apiT.model.Tenda;
import com.example.apiT.repository.TendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  
@RequestMapping("/tendas")  
public class TendaController {

    @Autowired
    private TendaRepository tendaRepository;

    
    @GetMapping
    public List<Tenda> listarTendas() {
        return tendaRepository.findAll();
    }

    
    @PostMapping
    public Tenda adicionarTenda(@RequestBody Tenda tenda) {
        return tendaRepository.save(tenda);
    }

    
    @GetMapping("/{id}")
    public Tenda buscarTenda(@PathVariable String id) {
        return tendaRepository.findById(id).orElse(null);
    }

    
    @PutMapping("/{id}")
    public Tenda atualizarTenda(@PathVariable String id, @RequestBody Tenda tenda) {
        tenda.setId(id);
        return tendaRepository.save(tenda);
    }

    
    @DeleteMapping("/{id}")
    public void excluirTenda(@PathVariable String id) {
        tendaRepository.deleteById(id);
    }
}