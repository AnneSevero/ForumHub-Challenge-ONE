package br.com.alura.ForumHub.dto;

import br.com.alura.ForumHub.model.EstadoTopico;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PedidosTopico {
    @NotBlank
    private String titulo;

    @NotBlank
    private String mensagem;

    @NotBlank
    private EstadoTopico estado;

    @NotBlank
    private String autor;

    @NotBlank
    private String curso;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public EstadoTopico getEstado() {
        return estado;
    }

    public void setEstado(EstadoTopico estado) {
        this.estado = estado;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
