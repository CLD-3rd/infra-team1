package com.team1.service;

import com.team1.dto.RentalDto;
import com.team1.entity.Rental;
import com.team1.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class RentalService {

    private final RentalRepository rentalRepository;

    public List<RentalDto> findByUserno(Long userno) {
        List<Rental> rentals = rentalRepository.findByUser_UserNo(userno);

        return rentals.stream().map(r -> new RentalDto(
                r.getRentNo(),
                r.getUser().getUserNo(),           
                r.getOttAccount().getOaccNo(),      
                r.getRstart(),
                r.getRexpiry()
        )).collect(Collectors.toList());
    }
    
    // 구독 인스턴스 삭제
    public void deleteById(Long rentNo) {
        rentalRepository.deleteById(rentNo);
    }

}
