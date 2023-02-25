package petshop.api.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import petshop.api.models.PetShopModel;
import petshop.api.repositories.PetShopRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Data
@AllArgsConstructor
@Service
public class PetShopService {
    final PetShopRepository petShopRepository;



    @Transactional
    public PetShopModel save(PetShopModel petShopModel){
        return petShopRepository.save(petShopModel);
    }


    public List<PetShopModel> findAll() {
        return petShopRepository.findAll();
    }
    public Optional<PetShopModel> findById(UUID id) {
        return petShopRepository.findById(id);
    }

    @Transactional
    public void delete(PetShopModel petShopModel) {
        petShopRepository.delete(petShopModel);
    }
}
