package PropertyRental.TraineeJava.Repository;

import PropertyRental.TraineeJava.Models.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    List<Property> findAllByLandlordId(Long id);
}
