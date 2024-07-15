package PropertyRental.TraineeJava.Repository;

import PropertyRental.TraineeJava.Models.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
