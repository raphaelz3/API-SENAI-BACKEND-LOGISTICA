package br.com.UrbanSwift.UrbanSwift.service;


import br.com.UrbanSwift.UrbanSwift.model.TipoUsuario;
import br.com.UrbanSwift.UrbanSwift.repository.TipoUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoUsuarioService {
    private final TipoUsuarioRepository tipoUsuarioRepository;

    public TipoUsuarioService(TipoUsuarioRepository entr) {
        tipoUsuarioRepository = entr;
    }

    public List<TipoUsuario> listarTodosTipoUsuario() {
        return tipoUsuarioRepository.findAll();
    }
    //Buscar por ID
    public TipoUsuario buscarTipoUsuarioPorId(Integer idTipoUsuario) {
        return tipoUsuarioRepository.findById(idTipoUsuario).orElse(null);
    }
    //Criar
    public TipoUsuario cadastrarTipoUsuario(TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }
    //Deletar
    public TipoUsuario deletarTipoUsuarioPorId(Integer idTipoUsuario) {
        TipoUsuario c =  buscarTipoUsuarioPorId(idTipoUsuario);
        if(c == null){
            return null;
        }
        tipoUsuarioRepository.deleteById(idTipoUsuario);
        return c;
    }
    //Editar
    public TipoUsuario atualizarTipoUsuarioPorId(Integer idTipoUsuario,  TipoUsuario tipoUsuario) {
        TipoUsuario c =  buscarTipoUsuarioPorId(idTipoUsuario);
        if(c == null){
            return null;
        }
        c.setDescricao(tipoUsuario.getDescricao());

        tipoUsuarioRepository.save(c);
        return  c;
    }
}
