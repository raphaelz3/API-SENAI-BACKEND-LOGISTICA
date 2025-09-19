package br.com.UrbanSwift.UrbanSwift.controller;



import br.com.UrbanSwift.UrbanSwift.model.Entrega;
import br.com.UrbanSwift.UrbanSwift.model.TipoUsuario;
import br.com.UrbanSwift.UrbanSwift.service.TipoUsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/UserType")

@Tag(name = "Tipo Usuario", description= "Metodos de Tipo Usuario")
public class TipoUsuarioController {
    private final TipoUsuarioService tipoUsuarioService;

    public TipoUsuarioController(TipoUsuarioService user) {

        tipoUsuarioService = user;
    }
    //Listar Todos
    @GetMapping
    @Operation(summary = "Listar Todas os TipoUsuario", description = "Essa função lista todos TipoUsuario")
    public ResponseEntity<List<TipoUsuario>> listarTodosTipoUsuario(){
        List<TipoUsuario>  tipoUsuario = tipoUsuarioService.listarTodosTipoUsuario();
        return ResponseEntity.ok(tipoUsuario);
    }
    //Listar ID
    @GetMapping("/{id}")
    @Operation(summary = "Listar Tipo Usuario por ID", description = "Essa função lista Tipo Usuario por ID")
    public ResponseEntity<?> buscarTipoUsuarioPorId(@PathVariable Integer id){
        TipoUsuario tipoUsuario = tipoUsuarioService.buscarTipoUsuarioPorId(id);
        if(tipoUsuario == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + "Não Encontrado");
        }
        return ResponseEntity.ok(tipoUsuario);
    }
    //Criar
    @PostMapping
    @Operation(summary = "Cadastrar TipoUsuario", description = "Função para cadastrar TipoUsuario")
    public ResponseEntity<TipoUsuario> cadastrarTipoUsuario(@RequestBody TipoUsuario tipoUsuario){
        TipoUsuario en =  tipoUsuarioService.cadastrarTipoUsuario(tipoUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(en);
    }
    //Editar
    @PutMapping("/{id}")
    @Operation(summary = "Editar TipoUsuario", description = "Função editar TipoUsuario")
    public ResponseEntity<?> editarTipoUsuario(@RequestBody TipoUsuario tipoUsuario, @PathVariable Integer id){
        TipoUsuario tipoUsuarioAntigo = tipoUsuarioService.atualizarTipoUsuarioPorId(id, tipoUsuario);
        if(tipoUsuarioAntigo == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " não foi encontrado.");
        }
        return ResponseEntity.ok(tipoUsuarioAntigo);
    }
    //Deletar
    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar TipoUsuario por ID", description = "Função deletar")
    public ResponseEntity<?> deletarTipoUsuario(@PathVariable Integer id){
        TipoUsuario en =   tipoUsuarioService.deletarTipoUsuarioPorId(id);
        if(en == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " não encontrado.");
        }
        return ResponseEntity.ok(en);
    }
}
