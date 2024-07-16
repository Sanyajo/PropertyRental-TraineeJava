package PropertyRental.TraineeJava.Service;

import PropertyRental.TraineeJava.Dto.PropertyDto;

import java.util.List;

public interface PropertyService {
    PropertyDto createProperty(PropertyDto propertyDto);

    PropertyDto getPropertyById(Long id);

    List<PropertyDto> getAllProperty ();

    PropertyDto updateProperty(Long id, PropertyDto propertyDto);

    void deleteProperty(Long id);

    void deleteAllPropertyByIdLandlord(Long id);
}
