package br.com.UrbanSwift.UrbanSwift.service;


import br.com.UrbanSwift.UrbanSwift.model.Entrega;
import br.com.UrbanSwift.UrbanSwift.repository.EntregasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregasService {
    private final EntregasRepository entregasRepository;

    public EntregasService(EntregasRepository entr) {
        entregasRepository = entr;
    }

    public List<Entrega> listarTodasEntregas() {
        return entregasRepository.findAll();
    }
    //Buscar por ID
    public Entrega buscarEntregaPorId(Integer idEntrega) {
        return entregasRepository.findById(idEntrega).orElse(null);
    }
    //Criar
    public Entrega cadastrarEntrega(Entrega entrega) {
        return entregasRepository.save(entrega);
    }
    //Deletar
    public Entrega deletarEntregaPorId(Integer idEntrega) {
        Entrega c =  buscarEntregaPorId(idEntrega);
        if(c == null){
            return null;
        }
        entregasRepository.deleteById(idEntrega);
        return c;
    }
    //Editar
    public Entrega atualizarEntregaPorId(Integer idEntrega,  Entrega entrega) {
        Entrega c =  buscarEntregaPorId(idEntrega);
        if(c == null){
            return null;
        }
        c.setEndereco(entrega.getEndereco());
        c.setStatus(entrega.getStatus());
        c.setDescricaoProduto(entrega.getDescricaoProduto());
        c.setDataPedido(entrega.getDataPedido());
        c.setTipoUsuario(entrega.getTipoUsuario());

        entregasRepository.save(c);
        return  c;
    }
}
