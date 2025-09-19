package br.com.UrbanSwift.UrbanSwift.controller;



import br.com.UrbanSwift.UrbanSwift.model.Veiculo;
import br.com.UrbanSwift.UrbanSwift.service.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veiculo")

@Tag(name = "Veiculo", description= "Metodos de Veiculo")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veic) {

        veiculoService = veic;
    }
    //Listar Todos
    @GetMapping
    @Operation(summary = "Listar Todas os Veiculos", description = "Essa função lista todos Veiculos")
    public ResponseEntity<List<Veiculo>> listarTodosVeiculos(){
        List<Veiculo>  veiculo = veiculoService.listarTodosVeiculos();
        return ResponseEntity.ok(veiculo);
    }
    //Listar ID
    @GetMapping("/{id}")
    @Operation(summary = "Listar Veiculo por ID", description = "Essa função buscar veiculo por ID")
    public ResponseEntity<?> buscarVeiculoPorId(@PathVariable Integer id){
        Veiculo veiculo = veiculoService.buscarVeiculoPorId(id);
        if(veiculo == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + "Não Encontrado");
        }
        return ResponseEntity.ok(veiculo);
    }
    //Criar
    @PostMapping
    @Operation(summary = "Cadastrar Veiculo", description = "Função para cadastrar veiculo")
    public ResponseEntity<Veiculo> cadastrarVeiculo(@RequestBody Veiculo veiculo){
        Veiculo veic =  veiculoService.cadastrarVeiculo(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(veic);
    }
    //Editar
    @PutMapping("/{id}")
    @Operation(summary = "Editar Veiculo", description = "Função editar Veiculo")
    public ResponseEntity<?> editarVeiculo(@RequestBody Veiculo veiculo, @PathVariable Integer id){
        Veiculo veiculoAntigo = veiculoService.atualizarVeiculoPorId(id, veiculo);
        if(veiculoAntigo == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " não foi encontrado.");
        }
        return ResponseEntity.ok(veiculoAntigo);
    }
    //Deletar
    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar Veiculo por ID", description = "Função deletar")
    public ResponseEntity<?> deletarUsuario(@PathVariable Integer id){
        Veiculo en =   veiculoService.deletarVeiculoPorId(id);
        if(en == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " não encontrado.");
        }
        return ResponseEntity.ok(en);
    }
}
