package PropertyRental.TraineeJava.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@NoArgsConstructor
@Data
@Table(name="property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "address", nullable = false)
    private String Address;

    @Column(name = "property_type", nullable = false)
    private String PropertyType;

    @Column(name = "description", nullable = false)
    private String Description;

    @Column(name = "status", nullable = false)
    private String Status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ladnlord_id")
    private Landlord LandlordId;

}
