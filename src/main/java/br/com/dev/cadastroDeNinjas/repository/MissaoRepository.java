package br.com.dev.cadastroDeNinjas.repository;

import br.com.dev.cadastroDeNinjas.model.Missao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissaoRepository extends JpaRepository<Missao, Long> {
}
