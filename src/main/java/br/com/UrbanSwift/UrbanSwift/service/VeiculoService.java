package br.com.UrbanSwift.UrbanSwift.service;



import br.com.UrbanSwift.UrbanSwift.model.Veiculo;
import br.com.UrbanSwift.UrbanSwift.repository.VeiculosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {
    private final VeiculosRepository veiculosRepository;

    public VeiculoService(VeiculosRepository user) {
        veiculosRepository = user;
    }

    public List<Veiculo> listarTodosVeiculos() {
        return veiculosRepository.findAll();
    }
    //Buscar por ID
    public Veiculo buscarVeiculoPorId(Integer idVeiculos) {
        return veiculosRepository.findById(idVeiculos).orElse(null);
    }
    //Criar
    public Veiculo cadastrarVeiculo(Veiculo veiculos) {
        return veiculosRepository.save(veiculos);
    }
    //Deletar
    public Veiculo deletarVeiculoPorId(Integer idVeiculo) {
        Veiculo c =  buscarVeiculoPorId(idVeiculo);
        if(c == null){
            return null;
        }
        veiculosRepository.deleteById(idVeiculo);
        return c;
    }
    //Editar
    public Veiculo atualizarVeiculoPorId(Integer idVeiculo,  Veiculo veiculo) {
        Veiculo c =  buscarVeiculoPorId(idVeiculo);
        if(c == null){
            return null;
        }

        c.setModelo(veiculo.getModelo());
        c.setPlaca(veiculo.getPlaca());
        c.setTipo(veiculo.getTipo());
        c.setTipoUsuarios(veiculo.getTipoUsuarios());

        veiculosRepository.save(c);
        return  c;
    }

}
