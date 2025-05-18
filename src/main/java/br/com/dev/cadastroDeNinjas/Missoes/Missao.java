package br.com.dev.cadastroDeNinjas.Missoes;

import br.com.dev.cadastroDeNinjas.Ninjas.Ninja;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_missoes")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Missao {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;

    @JsonManagedReference
    @OneToMany(mappedBy = "missao")
    private List<Ninja> ninjas;
}
