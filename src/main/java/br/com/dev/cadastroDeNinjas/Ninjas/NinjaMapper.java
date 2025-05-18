package br.com.dev.cadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public Ninja map(NinjaDto ninjaDto){
        Ninja ninja = new Ninja();
        ninja.setId(ninjaDto.getId());
        ninja.setNome(ninjaDto.getNome());
        ninja.setEmail(ninjaDto.getEmail());
        ninja.setIdade(ninjaDto.getIdade());
        ninja.setRank(ninjaDto.getRank());
        ninja.setImgUrl(ninjaDto.getImgUrl());
        ninja.setMissao(ninjaDto.getMissao());

        return ninja;

    }

    public NinjaDto map(Ninja ninja){
        NinjaDto ninjaDto = new NinjaDto();
        ninjaDto.setId(ninja.getId());
        ninjaDto.setNome(ninja.getNome());
        ninjaDto.setEmail(ninja.getEmail());
        ninjaDto.setIdade(ninja.getIdade());
        ninjaDto.setRank(ninja.getRank());
        ninjaDto.setImgUrl(ninja.getImgUrl());
        ninjaDto.setMissao(ninja.getMissao());

        return ninjaDto;

    }
}
