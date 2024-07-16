package PropertyRental.TraineeJava.Mapper;

import PropertyRental.TraineeJava.Dto.PropertyDto;
import PropertyRental.TraineeJava.Models.Landlord;
import PropertyRental.TraineeJava.Models.Property;

public class PropertyMapper {

    public static PropertyDto mapToPropertyDto(Property property){
        return new PropertyDto(
                property.getId(),
                property.getAddress(),
                property.getPropertyType(),
                property.getDescription(),
                property.getStatus(),
                property.getLandlord().getId()
        );
    }

    public static Property mapToProperty(PropertyDto propertyDto, Landlord landlord){
        return new Property(
                propertyDto.getId(),
                propertyDto.getAddress(),
                propertyDto.getPropertyType(),
                propertyDto.getDescription(),
                propertyDto.getStatus(),
                landlord
        );
    }
}
