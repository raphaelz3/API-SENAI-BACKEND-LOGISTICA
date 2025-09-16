package br.com.UrbanSwift.UrbanSwift.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "enderecos")
public class Enderecos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco",  unique = true, nullable = false, columnDefinition = "TEXT")
    private Integer idEndereco;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "tipo_usuario_id")
    private TipoUsuario tipoUsuario;
    @Column (name = "logradouro",  nullable = false, columnDefinition = "TEXT")
    private String logradouro;
    @Column (name = "numero", nullable = false, columnDefinition = "TEXT")
    private Integer numero;
    @Column (name = "cidade",  nullable = false, columnDefinition = "TEXT")
    private String cidade;
    @Column (name = "cep",  nullable = false, length = 8)
    private String cep;
}
