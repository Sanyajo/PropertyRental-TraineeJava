package PropertyRental.TraineeJava.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="landlord")
@Data
@NoArgsConstructor
public class Landlord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name", nullable = false)
    private String FirstName;

    @Column(name="last_name", nullable = false)
    private String LastName;

    @Column(name="email", unique = true, nullable = false)
    private String Email;

    @Column(name="Password", nullable = false)
    private String Password;
}
