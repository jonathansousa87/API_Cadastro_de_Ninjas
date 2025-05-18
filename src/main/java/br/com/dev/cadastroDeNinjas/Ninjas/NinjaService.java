package br.com.dev.cadastroDeNinjas.Ninjas;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public List<NinjaDto> listarNinjas(){
        List<Ninja> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    public NinjaDto buscarPorId(Long id){
         Optional<Ninja> ninja = ninjaRepository.findById(id);
         return ninja.map(ninjaMapper::map).orElse(null);
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

    public NinjaDto atualizarNinja(Long id, NinjaDto ninjaDto){
        Optional<Ninja> ninjaId = ninjaRepository.findById(id);
        if (ninjaId.isPresent()){
            Ninja ninjaUpDate = ninjaMapper.map(ninjaDto);
            ninjaUpDate.setId(id);
            Ninja ninjaSalvo = ninjaRepository.save(ninjaUpDate);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;

    }
}
