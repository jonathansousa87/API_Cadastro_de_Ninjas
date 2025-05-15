package br.com.dev.cadastroDeNinjas.repository;

import br.com.dev.cadastroDeNinjas.model.Ninja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<Ninja, Long> {
}
