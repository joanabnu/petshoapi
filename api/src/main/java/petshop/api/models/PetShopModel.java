package petshop.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

import java.util.UUID;

@Entity
@Table(name = "TB_PET_SHOP")
@AllArgsConstructor
@Data
public class PetShopModel  implements Serializable {
    private static final long serialVersionUID = 1l;

//    -Nome, espécie, raça, altura, peso, tipo pelagem/plumagem, tipo tratamento(ENUM)

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false,length = 90)
    private String nome;

    @Column(nullable = false, length = 20)
    private String especie;


    @Column(nullable = false,length = 20)
    private String raca;

    @Column(nullable = false)
    private String altura;

    @Column(nullable = false)
    private  String peso;

    @Column(nullable = false,length = 50)
    private String tipoPelagem;

    @Column(nullable = true)
    private String tipotratamento;

    public PetShopModel() {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.altura = altura;
        this.peso = peso;
        this.tipoPelagem = tipoPelagem;
        this.tipotratamento = tipotratamento;
    }


}
