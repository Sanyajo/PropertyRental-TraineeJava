package PropertyRental.TraineeJava.Controller;

import PropertyRental.TraineeJava.Dto.LandlordDto;
import PropertyRental.TraineeJava.Service.LandlordService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/landlord")
public class LandlordController {

    private LandlordService landlordService;
    @PostMapping("/create")
    public LandlordDto createLandlors(@RequestBody LandlordDto landlordDto){
        return landlordService.createLandlord(landlordDto);
    }

    @GetMapping("/get/{id}")
    public LandlordDto getLandlordById(@PathVariable("id") Long landlordId){
        return landlordService.getLandlordById(landlordId);
    }

    @GetMapping("/all")
    public List<LandlordDto> getAllLandlodr(){
        return landlordService.getAllLandlord();
    }

    @GetMapping("/update/{id}")
    public LandlordDto updateLandlord(@PathVariable("id") Long landlordId, @RequestBody LandlordDto landlordDto){
        return landlordService.updateLandlord(landlordId, landlordDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLandlord(@PathVariable("id") Long landlordId){
        landlordService.deleteLandlord(landlordId);
        return ResponseEntity.ok("Аренедодатель с id " + landlordId + " удален !");
    }
}
