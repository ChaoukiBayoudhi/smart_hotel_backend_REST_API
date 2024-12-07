package tn.esb.siad.smart_hotel_backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esb.siad.smart_hotel_backend.Models.Hotel;
import tn.esb.siad.smart_hotel_backend.Repositories.HotelRepository;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public ResponseEntity<List<Hotel>> getHotels(){
        List<Hotel> hotels=hotelRepository.findAll();
        if(hotels.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(hotels,HttpStatus.OK);

    }
    public ResponseEntity<Hotel> addHotel(Hotel hotel) {
        Hotel hotel1=hotelRepository.save(hotel);
        return new ResponseEntity<>(hotel1,HttpStatus.CREATED);
    }
}
