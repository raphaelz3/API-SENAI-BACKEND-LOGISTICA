package br.com.UrbanSwift.UrbanSwift.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//lombok
@Getter
@Setter
//Anotação obrigatória para o JPA Funcionar
@NoArgsConstructor
@AllArgsConstructor //opcional, mas bom para facilitar a importação de classes
//JPA
@Entity //Aqui é onde o JPA define essa classe como uma tabela
@Table(name = "tipo_usuario", schema="urbanswift") // o table nos permite personalizar a tabela

public class TipoUsuario {
    @Id//define que a linha de baixo é um ID
    @GeneratedValue(strategy= GenerationType.IDENTITY)//Aqui define a PK como gerada automatica
    @Column(name = "id_tipo_usuario", nullable = false)//aqui configuramos a coluna, apesar de opcional é bom colocar para manter o padrão
    private Integer IdTipoUsuario;
    @Column(name = "descricao",  nullable = false, columnDefinition = "TEXT")//o columnDefinition definimos o campo como text, pois por padrão se não for definido é definido como VARCHAR
    private String descricao;
}
