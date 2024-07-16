package PropertyRental.TraineeJava.Mapper;

import PropertyRental.TraineeJava.Dto.LandlordDto;
import PropertyRental.TraineeJava.Models.Landlord;

public class LandlordMapper {

    public static LandlordDto mapToLandlordDto(Landlord landlord){
        return new LandlordDto(
                landlord.getId(),
                landlord.getFirstName(),
                landlord.getLastName(),
                landlord.getEmail(),
                landlord.getPassword()
        );
    }

    public static Landlord mapToLandlord(LandlordDto landlordDto){
        return new Landlord(
                landlordDto.getId(),
                landlordDto.getFirstName(),
                landlordDto.getLastName(),
                landlordDto.getEmail(),
                landlordDto.getPassword()
        );
    }
}
