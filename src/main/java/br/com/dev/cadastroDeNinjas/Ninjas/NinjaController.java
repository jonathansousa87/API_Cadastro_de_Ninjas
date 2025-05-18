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
    public Ninja criarNinja(@RequestBody Ninja ninja){
        return ninjaService.criarNinja(ninja);
    }

    //Lista todos os ninjas
    @GetMapping
    public List<Ninja> ListaTodosNinjas(){
        return ninjaService.listarNinjas();
    }

    //Busca ninja por ID
    @GetMapping("/{id}")
    public Ninja ninjaPorId(@PathVariable ("id") Long id){
        return ninjaService.buscarPorId(id);
    }
    //Atualiza dados ninja
    @PutMapping("/{id}")
    public Ninja atualizaNinja(@PathVariable ("id") Long id, @RequestBody Ninja ninja){
        return ninjaService.atualizarNinja(id,ninja);
    }

    //Deleta dados ninja
    @DeleteMapping("/{id}")
    public String deletarNinja(@PathVariable ("id") Long id){
        return  ninjaService.deleteNinja(id);
    }

}
