package petshop.api.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import petshop.api.dtos.PetShopDto;
import petshop.api.models.PetShopModel;
import petshop.api.services.PetShopService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@AllArgsConstructor
@Data

//CrosOrigin para ser acessado de qualquer fonte
@CrossOrigin(origins ="*",maxAge = 3600)

@RequestMapping("/pet-shop")

public class PetShopController {

    final PetShopService petShopService;

    @PostMapping
    public ResponseEntity<Object>savePetShop(@RequestBody @Valid PetShopDto petShopDto){


        PetShopModel petShopModel = new PetShopModel();
        BeanUtils.copyProperties(petShopDto,petShopModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(petShopService.save(petShopModel));

    }


    @GetMapping
    public ResponseEntity<List<PetShopModel>> getAllPetShop(){
        return  ResponseEntity.status(HttpStatus.OK).body(petShopService.findAll());
    }



  @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePetShop(@PathVariable(value = "id") UUID id){
      Optional<PetShopModel> petShopModelOptional = petShopService.findById(id);
      if (!petShopModelOptional.isPresent()){
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet Shop não encontrado");

      }
      return ResponseEntity.status(HttpStatus.OK).body(petShopModelOptional.get());
  }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePetShop(@PathVariable(value = "id") UUID id){
        Optional<PetShopModel> petShopModelOptional = petShopService.findById(id);
        if (!petShopModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet Shop não encontrado");

        }
        petShopService.delete(petShopModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Pet Shop deletado com sucesso!   ");
    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePetShop(@PathVariable(value = "id") UUID id, @RequestBody @Valid PetShopDto petShopDto){
        Optional<PetShopModel> petShopModelOptional = petShopService.findById(id);
        if (!petShopModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet Shop não encontrado");

        }
        //    -Nome, espécie, raça, altura, peso, tipo pelagem/plumagem, tipo tratamento
        PetShopModel petShopModel = petShopModelOptional.get();
        petShopModel.setNome(petShopDto.getNome());
        petShopModel.setEspecie(petShopDto.getEspecie());
        petShopModel.setRaca(petShopDto.getRaca());
        petShopModel.setAltura(petShopDto.getAltura());
        petShopModel.setPeso(petShopDto.getPeso());
        petShopModel.setTipoPelagem(petShopDto.getTipoPelagem());
        petShopModel.setTipotratamento(petShopDto.getTipotratamento());
        return ResponseEntity.status(HttpStatus.OK).body(petShopService.save(petShopModel));
    }



}
