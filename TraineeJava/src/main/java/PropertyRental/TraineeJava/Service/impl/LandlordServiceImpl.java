package PropertyRental.TraineeJava.Service.impl;

import PropertyRental.TraineeJava.Dto.LandlordDto;
import PropertyRental.TraineeJava.Exception.ResourceNotFoundException;
import PropertyRental.TraineeJava.Mapper.LandlordMapper;
import PropertyRental.TraineeJava.Models.Landlord;
import PropertyRental.TraineeJava.Repository.LandlordRepository;
import PropertyRental.TraineeJava.Service.LandlordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LandlordServiceImpl implements LandlordService {

    private LandlordRepository landlordRepository;

    @Override
    public LandlordDto createLandlord(LandlordDto landlordDto){
        Landlord landlord = LandlordMapper.mapToLandlord(landlordDto);
        Landlord savedLandLord = landlordRepository.save(landlord);
        return LandlordMapper.mapToLandlordDto(savedLandLord);
    }

    @Override
    public LandlordDto getLandlordById(Long id){
        Landlord landlord = landlordRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Арендодатель с id " + id + " не найден!")
        );
        return LandlordMapper.mapToLandlordDto(landlord);
    }

    @Override
    public List<LandlordDto> getAllLandlord(){
        List<Landlord> landlordList = landlordRepository.findAll();
        List<LandlordDto> landlordDtoList = new ArrayList<>();
        if(landlordList.isEmpty()){
            throw new NullPointerException("Арендодателей не существует !");
        }else{
            for(var i: landlordList){
                landlordDtoList.add(LandlordMapper.mapToLandlordDto(i));
            }
        }
        return  landlordDtoList;
    }

    @Override
    public LandlordDto updateLandlord(Long landlordId, LandlordDto landlordDto) {
        Landlord landlord = landlordRepository.findById(landlordId).orElseThrow(
                () -> new ResourceNotFoundException("Арендодатель с id " + landlordId + " не найден!")
        );

        landlord.setFirstName(landlordDto.getFirstName());
        landlord.setLastName(landlordDto.getLastName());
        landlord.setEmail(landlordDto.getEmail());
        landlord.setPassword(landlordDto.getPassword());
        landlordRepository.save(landlord);

        return LandlordMapper.mapToLandlordDto(landlord);

    }

    @Override
    public void deleteLandlord(Long landlordId) {
        Landlord landlord = landlordRepository.findById(landlordId).orElseThrow(
                ()-> new ResourceNotFoundException("Арендодатель с id " + landlordId + " не найден !")
        );

        landlordRepository.delete(landlord);
    }

}
