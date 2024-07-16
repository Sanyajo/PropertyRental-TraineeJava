package PropertyRental.TraineeJava.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LandlordDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
