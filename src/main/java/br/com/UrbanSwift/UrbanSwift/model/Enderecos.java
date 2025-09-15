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
    @Column(name = "id_endereco",  unique = true, nullable = false)
    private Integer idEndereco;


    @Column(name = "id_cliente")
    private Integer idCliente;
}
