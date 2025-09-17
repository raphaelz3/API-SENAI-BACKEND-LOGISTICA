package br.com.UrbanSwift.UrbanSwift.service;


import br.com.UrbanSwift.UrbanSwift.model.Endereco;
import br.com.UrbanSwift.UrbanSwift.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

   private final EnderecoRepository enderecoRepository;

   public EnderecoService(EnderecoRepository repo) {
       enderecoRepository = repo;
   }

   public List<Endereco> listarTodosEnderecos() {
       return enderecoRepository.findAll();
   }
    //Buscar por ID
   public Endereco buscarEnderecoPorId(Integer idEndereco) {
       return enderecoRepository.findById(idEndereco).orElse(null);
   }
   //Criar
    public Endereco cadastrarEndereco(Endereco endereco) {
       return enderecoRepository.save(endereco);
    }
    //Deletar
    public Endereco deletarEnderecoPorId(Integer idEndereco) {
        Endereco c =  buscarEnderecoPorId(idEndereco);
        if(c == null){
            return null;
        }
        enderecoRepository.deleteById(idEndereco);
        return c;
    }
    //Editar
    public Endereco atualizarEnderecoPorId(Integer idEndereco,  Endereco endereco) {
       Endereco c =  buscarEnderecoPorId(idEndereco);
       if(c == null){
           return null;
       }
       c.setLogradouro(endereco.getLogradouro());
       c.setNumero(endereco.getNumero());
       c.setCep(endereco.getCep());
       c.setCidade(endereco.getCidade());

       enderecoRepository.save(c);
       return  c;
    }

}
