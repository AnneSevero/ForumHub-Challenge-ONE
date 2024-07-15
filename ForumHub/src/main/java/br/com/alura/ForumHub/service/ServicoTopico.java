package br.com.alura.ForumHub.service;

import br.com.alura.ForumHub.dto.PedidosTopico;
import br.com.alura.ForumHub.dto.RespostaTopico;
import br.com.alura.ForumHub.model.Topico;
import br.com.alura.ForumHub.repository.RepositorioTopico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicoTopico {
    @Autowired
    private RepositorioTopico repositorioTopico;

    public RespostaTopico criarTopico(PedidosTopico pedidosTopico) {
        Topico topico = new Topico();
        topico.setTitulo(pedidosTopico.getTitulo());
        topico.setMensagem(pedidosTopico.getMensagem());
        topico.setEstado(pedidosTopico.getEstado());
        topico.setAutor(pedidosTopico.getAutor());
        topico.setCurso(pedidosTopico.getCurso());
        Topico salvoTopico = repositorioTopico.save(topico);
        return mapToResponse(salvoTopico);
    }

    public List<RespostaTopico> listarTopicos() {
        return repositorioTopico.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public Optional<RespostaTopico> buscarTopico(Long id) {
        return repositorioTopico.findById(id)
                .map(this::mapToResponse);
    }

    public RespostaTopico atualizarTopico(Long id, PedidosTopico pedidosTopico) {
        return repositorioTopico.findById(id)
                .map(topico -> {
                    topico.setTitulo(pedidosTopico.getTitulo());
                    topico.setMensagem(pedidosTopico.getMensagem());
                    topico.setEstado(pedidosTopico.getEstado());
                    topico.setAutor(pedidosTopico.getAutor());
                    topico.setCurso(pedidosTopico.getCurso());
                    return mapToResponse(repositorioTopico.save(topico));
                })
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
    }

    public void deletarTopico(Long id) {
        repositorioTopico.deleteById(id);
    }

    private RespostaTopico mapToResponse(Topico topico) {
        RespostaTopico resposta = new RespostaTopico();
        resposta.setId(topico.getId());
        resposta.setTitulo(topico.getTitulo());
        resposta.setMensagem(topico.getMensagem());
        resposta.setDataCriacao(topico.getDataDeCriacao());
        resposta.setEstado(topico.getEstado());
        resposta.setAutor(topico.getAutor());
        resposta.setCurso(topico.getCurso());
        return resposta;
    }
}
