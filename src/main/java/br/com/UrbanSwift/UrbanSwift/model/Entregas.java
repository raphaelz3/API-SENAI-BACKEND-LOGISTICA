package br.com.UrbanSwift.UrbanSwift.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "entregas")
public class Entregas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entregas", nullable = false)
    private Long idEntregas;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_tipo_usuario")
    private TipoUsuario tipoUsuario;
    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Enderecos Endereco;
    @Column(name = "descricaoProduto")
    private String descricaoProduto;
    @Column (name = "status", nullable = false, columnDefinition = "TEXT")
    private String status;
    @Column (name = "dataPedido", nullable = false)
    private OffsetDateTime dataPedido;
}
