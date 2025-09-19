package br.com.UrbanSwift.UrbanSwift.controller;



import br.com.UrbanSwift.UrbanSwift.model.Endereco;
import br.com.UrbanSwift.UrbanSwift.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/endereco")

@Tag(name = "Enderecos", description = "Método Endereço")
public class EnderecoController {
    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService ende) {
        enderecoService = ende;
    }
    //Listar
    @GetMapping
    @Operation(summary = "Listar Todos os Endereços", description = "Essa função lista todos endereços")
    public ResponseEntity<List<Endereco>> listarTodosEnderecos(){
        List<Endereco>  enderecos = enderecoService.listarTodosEnderecos();
        return ResponseEntity.ok(enderecos);
    }
    @GetMapping("/{id}")
    @Operation(summary = "Listar Endereço por ID", description = "Essa função lista endereço por ID")
    public ResponseEntity<?> buscarEndereçosPorId(@PathVariable Integer id){
        Endereco endereco = enderecoService.buscarEnderecoPorId(id);
        if(endereco == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + "Não Encontrado");
        }
        return ResponseEntity.ok(endereco);
    }

    //Criar
    @PostMapping
    @Operation(summary = "Cadastrar Endereço", description = "Função para cadastrar Endereço")
    public ResponseEntity<Endereco> cadastrarEndereco(@RequestBody Endereco endereco){
        Endereco en =  enderecoService.cadastrarEndereco(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(en);
    }
    //Editar
    @PutMapping("/{id}")
    @Operation(summary = "Editar Endereço", description = "Função editar endereço")
    public ResponseEntity<?> editarEndereco(@RequestBody Endereco endereco, @PathVariable Integer id){
        Endereco enderecoAntigo = enderecoService.atualizarEnderecoPorId(id, endereco);
        if(enderecoAntigo == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " não foi encontrado.");
        }
        return ResponseEntity.ok(enderecoAntigo);
    }
    //Deletar
    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar Endereço por ID", description = "Função deletar")
    public ResponseEntity<?> deletarEndereco(@PathVariable Integer id){
        Endereco en =   enderecoService.deletarEnderecoPorId(id);
        if(en == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " não encontrado.");
        }
        return ResponseEntity.ok(en);
    }

}
