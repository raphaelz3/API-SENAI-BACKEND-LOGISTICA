package br.com.UrbanSwift.UrbanSwift.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "veiculos")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_veiculo", unique = true, nullable = false)
    private Integer idVeiculo;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_tipo_usuario")
    private TipoUsuario tipoUsuarios;
    @Column(name = "placa",  nullable = false, columnDefinition = "TEXT", unique = true)
    private String placa;
    @Column (name = "modelo", nullable = false, columnDefinition = "TEXT")
    private String modelo;
    @Column (name = "tipo", nullable = false, columnDefinition = "TEXT")
    private String tipo;
}
