package br.com.alura.ForumHub.controller;

import br.com.alura.ForumHub.dto.PedidosTopico;
import br.com.alura.ForumHub.dto.RespostaTopico;
import br.com.alura.ForumHub.service.ServicoTopico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/topicos")
public class ControleTopico {

    @Autowired
    private ServicoTopico servicoTopico;

    @PostMapping
    public ResponseEntity<RespostaTopico> criarTopico(@Validated @RequestBody PedidosTopico pedidosTopico) {
        RespostaTopico resposta = servicoTopico.criarTopico(pedidosTopico);
        return ResponseEntity.ok(resposta);
    }
    @GetMapping
    public ResponseEntity<List<RespostaTopico>> listarTopicos() {
        List<RespostaTopico> response = servicoTopico.listarTopicos();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespostaTopico> buscarTopico(@PathVariable Long id) {
        return servicoTopico.buscarTopico(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RespostaTopico> atualizarTopico(@PathVariable Long id, @Validated @RequestBody PedidosTopico pedidosTopico) {
        try {
            RespostaTopico resposta = servicoTopico.atualizarTopico(id, pedidosTopico);
            return ResponseEntity.ok(resposta);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTopico(@PathVariable Long id) {
        servicoTopico.deletarTopico(id);
        return ResponseEntity.noContent().build();
    }

}

