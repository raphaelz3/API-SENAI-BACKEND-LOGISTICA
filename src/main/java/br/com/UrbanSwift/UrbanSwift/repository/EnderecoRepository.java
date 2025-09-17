package br.com.UrbanSwift.UrbanSwift.repository;


import br.com.UrbanSwift.UrbanSwift.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository  extends JpaRepository<Endereco,Integer> {

}
