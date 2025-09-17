package br.com.UrbanSwift.UrbanSwift.repository;

import br.com.UrbanSwift.UrbanSwift.model.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario,Integer> {
}
