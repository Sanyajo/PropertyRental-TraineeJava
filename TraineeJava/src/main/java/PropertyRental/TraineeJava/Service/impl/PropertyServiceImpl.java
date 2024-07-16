package PropertyRental.TraineeJava.Service.impl;

import PropertyRental.TraineeJava.Dto.PropertyDto;
import PropertyRental.TraineeJava.Exception.ResourceNotFoundException;
import PropertyRental.TraineeJava.Mapper.PropertyMapper;
import PropertyRental.TraineeJava.Models.Landlord;
import PropertyRental.TraineeJava.Models.Property;
import PropertyRental.TraineeJava.Repository.LandlordRepository;
import PropertyRental.TraineeJava.Repository.PropertyRepository;
import PropertyRental.TraineeJava.Service.PropertyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    private PropertyRepository propertyRepository;
    private LandlordRepository landlordRepository;

    @Override
    public PropertyDto createProperty(PropertyDto propertyDto) {
        Landlord landlord = landlordRepository.findById(propertyDto.getLandlordId())
                .orElseThrow(() -> new RuntimeException("Арендодателя с id " + propertyDto.getLandlordId() + " не найдено !")
                );
        Property property = PropertyMapper.mapToProperty(propertyDto, landlord);
        Property savedProperty = propertyRepository.save(property);
        return PropertyMapper.mapToPropertyDto(savedProperty);
    }

    @Override
    public PropertyDto getPropertyById(Long id){
        Property property = propertyRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Недвижимость с id " + id + " не найдена !")
        );
        return PropertyMapper.mapToPropertyDto(property);
    }

    @Override
    public List<PropertyDto> getAllProperty() {
        List<Property> propertyList = propertyRepository.findAll();
        List<PropertyDto> propertyDtoList = new ArrayList<>();
        if(propertyList.isEmpty()){
            throw new NullPointerException("Список недвижимости пуст !");
        }else{
            for(var i : propertyList){
                propertyDtoList.add(PropertyMapper.mapToPropertyDto(i));
            }
        }
        return propertyDtoList;
    }

    @Override
    public PropertyDto updateProperty(Long id, PropertyDto propertyDto) {
        Property property = propertyRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Недвижимость с id " + id + " не найдена !")
        );

        Landlord landlord = landlordRepository.findById(propertyDto.getLandlordId()).orElseThrow(
                ()-> new RuntimeException("Не существует арендодателя с id " + propertyDto.getLandlordId() + " !")
        );

        property.setAddress(propertyDto.getAddress());
        property.setDescription(propertyDto.getDescription());
        property.setPropertyType(propertyDto.getPropertyType());
        property.setStatus(propertyDto.getStatus());
        property.setLandlord(landlord);
        propertyRepository.save(property);

        return PropertyMapper.mapToPropertyDto(property);
    }

    @Override
    public void deleteProperty(Long id){
        Property property = propertyRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Недвижимость с id " + id + " не найдена !")
        );

        propertyRepository.delete(property);
    }

    @Override
    public void deleteAllPropertyByIdLandlord(Long id){
        List<Property>  propertyList = propertyRepository.findAllByLandlordId(id);
        for(var i : propertyList){
            propertyRepository.delete(i);
        }
    }

}
