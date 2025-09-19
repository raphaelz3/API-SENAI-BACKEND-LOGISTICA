package br.com.UrbanSwift.UrbanSwift.service;



import br.com.UrbanSwift.UrbanSwift.model.Veiculo;
import br.com.UrbanSwift.UrbanSwift.repository.VeiculosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculosService {
    private final VeiculosRepository veiculosRepository;

    public VeiculosService(VeiculosRepository user) {
        veiculosRepository = user;
    }

    public List<Veiculo> listarTodosVeiculos() {
        return veiculosRepository.findAll();
    }
    //Buscar por ID
    public Veiculo buscarVeiculosPorId(Integer idVeiculos) {
        return veiculosRepository.findById(idVeiculos).orElse(null);
    }
    //Criar
    public Veiculo cadastrarVeiculos(Veiculo veiculos) {
        return veiculosRepository.save(veiculos);
    }
    //Deletar
    public Veiculo deletarVeiculoPorId(Integer idVeiculo) {
        Veiculo c =  buscarVeiculosPorId(idVeiculo);
        if(c == null){
            return null;
        }
        veiculosRepository.deleteById(idVeiculo);
        return c;
    }
    //Editar
    public Veiculo atualizarVeiculosPorId(Integer idVeiculo,  Veiculo veiculo) {
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
