package br.com.alura.ForumHub.repository;

import br.com.alura.ForumHub.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioTopico extends JpaRepository<Topico, Long> {
}

