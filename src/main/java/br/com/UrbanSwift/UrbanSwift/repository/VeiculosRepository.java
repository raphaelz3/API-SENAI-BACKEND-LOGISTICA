package br.com.UrbanSwift.UrbanSwift.repository;

import br.com.UrbanSwift.UrbanSwift.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculosRepository extends JpaRepository<Veiculo,Integer> {
}
