package br.com.UrbanSwift.UrbanSwift.controller;

import br.com.UrbanSwift.UrbanSwift.model.Entrega;
import br.com.UrbanSwift.UrbanSwift.service.EntregaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrega")

@Tag(name = "Entregas", description= "Metodos de Entrega")
public class EntregaController {
    private final EntregaService entregaService;

    public EntregaController(EntregaService ende) {

        entregaService = ende;
    }
    //Listar Todos
    @GetMapping
    @Operation(summary = "Listar Todas as entregas", description = "Essa função lista todas entregas")
    public ResponseEntity<List<Entrega>> listarTodasEntregas(){
        List<Entrega>  entrega = entregaService.listarTodasEntregas();
        return ResponseEntity.ok(entrega);
    }
    //Criar
    @PostMapping
    @Operation(summary = "Cadastrar Entrega", description = "Função para cadastrar Entrega")
    public ResponseEntity<Entrega> cadastrarEntrega(@RequestBody Entrega entrega){
        Entrega en =  entregaService.cadastrarEntrega(entrega);
        return ResponseEntity.status(HttpStatus.CREATED).body(en);
    }
    //Editar
    @PutMapping("/{id}")
    @Operation(summary = "Editar Entrega", description = "Função editar Entrega")
    public ResponseEntity<?> editarEntrega(@RequestBody Entrega entrega, @PathVariable Integer id){
        Entrega entregaAntigo = entregaService.atualizarEntregaPorId(id, entrega);
        if(entregaAntigo == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " não foi encontrado.");
        }
        return ResponseEntity.ok(entregaAntigo);
    }
    //Deletar
    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar Entrega por ID", description = "Função deletar")
    public ResponseEntity<?> deletarEntrega(@PathVariable Integer id){
        Entrega en =   entregaService.deletarEntregaPorId(id);
        if(en == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " não encontrado.");
        }
        return ResponseEntity.ok(en);
    }

}
