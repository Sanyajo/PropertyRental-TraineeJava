package PropertyRental.TraineeJava.Service;

import PropertyRental.TraineeJava.Repository.LandlordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LandlordService {

    private final LandlordRepository landlordRepository;
}
