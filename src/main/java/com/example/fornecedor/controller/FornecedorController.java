package com.example.fornecedor.controller;

import com.example.fornecedor.model.Fornecedor;
import com.example.fornecedor.service.FornecedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/fornecedores")
@RequiredArgsConstructor
public class FornecedorController {
    private final FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<Fornecedor> criarFornecedor(@RequestBody Fornecedor fornecedor) {
        Fornecedor novoFornecedor = fornecedorService.criarFornecedor(fornecedor);
        return ResponseEntity.ok(novoFornecedor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> buscarFornecedorPorId(@PathVariable Long id) {
        Optional<Fornecedor> fornecedor = fornecedorService.buscarFornecedorPorId(id);
        return fornecedor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Iterable<Fornecedor>> buscarTodosFornecedores() {
        Iterable<Fornecedor> fornecedores = fornecedorService.buscarTodosFornecedores();
        return ResponseEntity.ok(fornecedores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> atualizarFornecedor(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
        if (!fornecedorService.buscarFornecedorPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        fornecedor.setId(id);
        Fornecedor fornecedorAtualizado = fornecedorService.atualizarFornecedor(fornecedor);
        return ResponseEntity.ok(fornecedorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirFornecedor(@PathVariable Long id) {
        if (!fornecedorService.buscarFornecedorPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        fornecedorService.excluirFornecedor(id);
        return ResponseEntity.noContent().build();
    }
}
