package br.com.dev.cadastroDeNinjas.Ninjas;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NinjaService {

    private final NinjaRepository ninjaRepository;

    public List<Ninja> listarNinjas(){
        return ninjaRepository.findAll();
    }

    public Ninja buscarPorId(Long id){
         Optional<Ninja> ninja = ninjaRepository.findById(id);
         return ninja.orElse(null);
    }

    public Ninja criarNinja(Ninja ninja){
        return ninjaRepository.save(ninja);
    }

    public String deleteNinja(Long id){
        ninjaRepository.deleteById(id);
        return "Ninja deletado";
    }

    public Ninja atualizarNinja(Long id, Ninja ninja){
        if (ninjaRepository.existsById(id)){
            ninja.setId(id);
            return ninjaRepository.save(ninja);
        }
        return null;

    }
}
