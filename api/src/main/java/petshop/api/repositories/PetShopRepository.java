package petshop.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import petshop.api.models.PetShopModel;

import java.util.UUID;
@Repository
public interface PetShopRepository  extends JpaRepository<PetShopModel, UUID> {


}
