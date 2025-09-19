package br.com.UrbanSwift.UrbanSwift.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")

public class Usuario implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;
    @Column(name = "nome_completo",  nullable = false, columnDefinition = "TEXT")
    private String nomeCompleto;
    @Column(name = "email",  nullable = false, columnDefinition = "TEXT", unique = true)
    private String email;
    @Column(name = "senha",  nullable = false, columnDefinition = "TEXT")
    private String senha;
    //EAGER - Usa mais memoria, pois carrega todos os dados de uma vez.
    //O "optional" define se é obrigatorio a chave primaria
    @ManyToOne(fetch = FetchType.EAGER, optional = false)//Aqui definimos uma FK, onde nosso atributo é do tipo da classe que ele recebe a chave
    @JoinColumn(name = "id_tipo_usuario")
    private TipoUsuario tipoUsuario;//a FK é do tipo TipoUsuario, pois é chave estrangeira dessa tabela


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(tipoUsuario.getDescricao()));
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return senha;
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return email;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }
}
