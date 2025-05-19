package br.com.dev.cadastroDeNinjas.Ninjas;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ninja")
public class NinjaController {

    private final NinjaService ninjaService;


    //Create Ninja
    @PostMapping()
    public ResponseEntity<NinjaDto> criarNinja(@RequestBody NinjaDto ninjaDto){
        NinjaDto novoNinja = ninjaService.criarNinja(ninjaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoNinja);

    }

    //Lista todos os ninjas
    @GetMapping
    public ResponseEntity<List<NinjaDto>> ListaTodosNinjas(){
        List<NinjaDto> listaNinjas =  ninjaService.listarNinjas();
        return ResponseEntity.ok(listaNinjas);
    }

    //Busca ninja por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> ninjaPorId(@PathVariable ("id") Long id){
        NinjaDto ninjaDto = ninjaService.buscarPorId(id);
        if (ninjaDto == null){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja não encontrado");
        }
        return ResponseEntity.ok(ninjaDto);
    }

    //Atualiza dados ninja
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizaNinja(@PathVariable ("id") Long id, @RequestBody NinjaDto ninjaDto){
        NinjaDto ninja =  ninjaService.atualizarNinja(id, ninjaDto);
        if (ninja != null){
            return ResponseEntity.ok(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja ID: "+id+" não encontrado");
    }

    //Deleta dados ninja
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable ("id") Long id){
        if(ninjaService.buscarPorId(id) != null){
            ninjaService.deleteNinja(id);
            return ResponseEntity.ok("Ninja deletado com sucesso");
        }
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja de ID: " +id+ " não encontrado");
    }

}
