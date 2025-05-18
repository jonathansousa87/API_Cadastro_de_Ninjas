package br.com.dev.cadastroDeNinjas.Ninjas;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ninja")
public class NinjaController {

    private final NinjaService ninjaService;


    //Create Ninja
    @PostMapping()
    public NinjaDto criarNinja(@RequestBody NinjaDto ninjaDto){
        return ninjaService.criarNinja(ninjaDto);
    }

    //Lista todos os ninjas
    @GetMapping
    public List<NinjaDto> ListaTodosNinjas(){
        return ninjaService.listarNinjas();
    }

    //Busca ninja por ID
    @GetMapping("/{id}")
    public NinjaDto ninjaPorId(@PathVariable ("id") Long id){
        return ninjaService.buscarPorId(id);
    }
    //Atualiza dados ninja
    @PutMapping("/{id}")
    public NinjaDto atualizaNinja(@PathVariable ("id") Long id, @RequestBody NinjaDto ninjaDto){
        return ninjaService.atualizarNinja(id, ninjaDto);
    }

    //Deleta dados ninja
    @DeleteMapping("/{id}")
    public String deletarNinja(@PathVariable ("id") Long id){
        return  ninjaService.deleteNinja(id);
    }

}
