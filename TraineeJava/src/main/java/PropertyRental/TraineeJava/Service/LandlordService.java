package PropertyRental.TraineeJava.Service;

import PropertyRental.TraineeJava.Dto.LandlordDto;

import java.util.List;

public interface LandlordService {
    LandlordDto createLandlord(LandlordDto landlordDto);


    LandlordDto getLandlordById(Long id);

    List<LandlordDto> getAllLandlord();

    LandlordDto updateLandlord(Long landlordId, LandlordDto landlordDto);

    void deleteLandlord(Long landlordId);

}
