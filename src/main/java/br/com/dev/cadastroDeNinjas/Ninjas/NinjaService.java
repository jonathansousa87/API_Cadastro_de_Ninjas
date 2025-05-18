package br.com.dev.cadastroDeNinjas.Ninjas;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public List<Ninja> listarNinjas(){
        return ninjaRepository.findAll();
    }

    public Ninja buscarPorId(Long id){
         Optional<Ninja> ninja = ninjaRepository.findById(id);
         return ninja.orElse(null);
    }

    public NinjaDto criarNinja(NinjaDto ninjaDto){
        Ninja ninja = ninjaMapper.map(ninjaDto);
        ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
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
