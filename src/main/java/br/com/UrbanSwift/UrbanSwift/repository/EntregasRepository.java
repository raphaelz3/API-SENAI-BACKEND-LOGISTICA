package br.com.UrbanSwift.UrbanSwift.repository;

import br.com.UrbanSwift.UrbanSwift.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregasRepository extends JpaRepository<Entrega,Integer> {
}
