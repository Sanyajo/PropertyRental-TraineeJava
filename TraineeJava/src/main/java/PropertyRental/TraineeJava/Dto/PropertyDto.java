package PropertyRental.TraineeJava.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDto {
    private Long id;
    private String address;
    private String propertyType;
    private String description;
    private String status;
    private Long landlordId;
}
