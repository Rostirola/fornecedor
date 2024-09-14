package com.example.fornecedor.service;

import com.example.fornecedor.model.Fornecedor;
import com.example.fornecedor.repository.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FornecedorService {
    private final FornecedorRepository fornecedorRepository;

    public Fornecedor criarFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public Optional<Fornecedor> buscarFornecedorPorId(Long id) {
        return fornecedorRepository.findById(id);
    }

    public Iterable<Fornecedor> buscarTodosFornecedores() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor atualizarFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public void excluirFornecedor(Long id) {
        fornecedorRepository.deleteById(id);
    }
}
