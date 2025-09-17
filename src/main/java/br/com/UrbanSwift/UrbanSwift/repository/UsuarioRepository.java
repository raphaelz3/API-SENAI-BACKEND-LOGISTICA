package br.com.UrbanSwift.UrbanSwift.repository;

import br.com.UrbanSwift.UrbanSwift.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
}
