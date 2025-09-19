package br.com.UrbanSwift.UrbanSwift.service;


import br.com.UrbanSwift.UrbanSwift.model.Usuario;
import br.com.UrbanSwift.UrbanSwift.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository user) {
        usuarioRepository = user;
    }

    public List<Usuario> listarTodosUsuarios() {
        return usuarioRepository.findAll();
    }
    //Buscar por ID
    public Usuario buscarUsuarioPorId(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario).orElse(null);
    }
    //Criar
    public Usuario cadastrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    //Deletar
    public Usuario deletarUsuarioPorId(Integer idUsuario) {
        Usuario c =  buscarUsuarioPorId(idUsuario);
        if(c == null){
            return null;
        }
        usuarioRepository.deleteById(idUsuario);
        return c;
    }
    //Editar
    public Usuario atualizarUsuarioPorId(Integer idUsuario,  Usuario usuario) {
        Usuario c =  buscarUsuarioPorId(idUsuario);
        if(c == null){
            return null;
        }

        c.setTipoUsuario(usuario.getTipoUsuario());
        c.setEmail(usuario.getEmail());
        c.setSenha(usuario.getSenha());
        c.setNomeCompleto(usuario.getNomeCompleto());

        usuarioRepository.save(c);
        return  c;
    }
}
