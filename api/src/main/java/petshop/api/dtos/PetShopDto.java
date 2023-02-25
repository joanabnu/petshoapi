package petshop.api.dtos;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@AllArgsConstructor
public class PetShopDto {


    @NotBlank
    private String nome;

    @NotBlank
    private String especie;

    @NotBlank
    private String raca;

    @NotBlank
    private String altura;

    @NotBlank
    private String peso;

   @NotBlank
    private String tipoPelagem;

   @NotBlank
    private String tipotratamento;
}
