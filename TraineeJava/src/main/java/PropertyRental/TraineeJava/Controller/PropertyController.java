package PropertyRental.TraineeJava.Controller;

import PropertyRental.TraineeJava.Dto.PropertyDto;
import PropertyRental.TraineeJava.Service.PropertyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/property")
public class PropertyController{

    private PropertyService propertyService;

    @PostMapping("/create")
    public PropertyDto createProperty(@RequestBody PropertyDto propertyDto){
        return propertyService.createProperty(propertyDto);
    }

    @GetMapping("/get/{id}")
    public PropertyDto getPropertyById(@PathVariable("id") Long propertyId){
        return propertyService.getPropertyById(propertyId);
    }

    @GetMapping("/all")
    public List<PropertyDto> getAllProperty(){
        return propertyService.getAllProperty();
    }

    @GetMapping("/update/{id}")
    public PropertyDto updateProperty(@PathVariable("id") Long propertyId, @RequestBody PropertyDto propertyDto){
        return propertyService.updateProperty(propertyId, propertyDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProperty(@PathVariable("id") Long propertyId){
        propertyService.deleteProperty(propertyId);
        return ResponseEntity.ok("Недвижимость с id " + propertyId + " удалена !");
    }


    @DeleteMapping("/delete/landlord/{id}")
    public ResponseEntity<String> deleteAllPropertyByIdLandlord(@PathVariable("id") Long id){
        propertyService.deleteAllPropertyByIdLandlord(id);
        return ResponseEntity.ok("Недвижимости у владельца которорых id " + id + " удалены !");
    }

}
