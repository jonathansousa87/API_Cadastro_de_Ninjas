package br.com.dev.cadastroDeNinjas.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_ninjas")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ninja {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "rank")
    private String rank;

    @Column(name = "img_url")
    private String imgUrl;

    private Integer idade;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "missao_id", referencedColumnName = "id")
    private Missao missao;
}
