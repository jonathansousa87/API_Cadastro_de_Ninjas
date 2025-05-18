package br.com.dev.cadastroDeNinjas.Ninjas;

import br.com.dev.cadastroDeNinjas.Missoes.Missao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaDto {

    private Long id;

    private String nome;

    private String email;

    private String rank;

    private String imgUrl;

    private Integer idade;

    private Missao missao;
}
