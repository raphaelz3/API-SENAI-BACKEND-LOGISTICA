package br.com.UrbanSwift.UrbanSwift.controller;

import br.com.UrbanSwift.UrbanSwift.model.Usuario;
import br.com.UrbanSwift.UrbanSwift.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Usuario")

@Tag(name = "Usuario", description= "Metodos de Usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService user) {

        usuarioService = user;
    }
    //Listar Todos
    @GetMapping
    @Operation(summary = "Listar Todas os Usuario", description = "Essa função lista todos Usuario")
    public ResponseEntity<List<Usuario>> listarTodosUsuario(){
        List<Usuario>  usuario = usuarioService.listarTodosUsuarios();
        return ResponseEntity.ok(usuario);
    }
    //Criar
    @PostMapping
    @Operation(summary = "Cadastrar Usuario", description = "Função para cadastrar Usuario")
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario){
        Usuario en =  usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(en);
    }
    //Editar
    @PutMapping("/{id}")
    @Operation(summary = "Editar Usuario", description = "Função editar Usuario")
    public ResponseEntity<?> editarUsuario(@RequestBody Usuario usuario, @PathVariable Integer id){
        Usuario usuarioAntigo = usuarioService.atualizarUsuarioPorId(id, usuario);
        if(usuarioAntigo == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " não foi encontrado.");
        }
        return ResponseEntity.ok(usuarioAntigo);
    }
    //Deletar
    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar Usuario por ID", description = "Função deletar")
    public ResponseEntity<?> deletarUsuario(@PathVariable Integer id){
        Usuario en =   usuarioService.deletarUsuarioPorId(id);
        if(en == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " não encontrado.");
        }
        return ResponseEntity.ok(en);
    }
}
