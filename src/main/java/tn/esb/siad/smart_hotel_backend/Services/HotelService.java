package tn.esb.siad.smart_hotel_backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esb.siad.smart_hotel_backend.Models.Hotel;
import tn.esb.siad.smart_hotel_backend.Repositories.HotelRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public ResponseEntity<List<Hotel>> getHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        if (hotels.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(hotels, HttpStatus.OK);

    }

    public ResponseEntity<Hotel> addHotel(Hotel hotel) {
        Hotel hotel1 = hotelRepository.save(hotel);
        return new ResponseEntity<>(hotel1, HttpStatus.CREATED);
        //or
        //return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);

    }

    public ResponseEntity removeHotel(Long id) {
        Optional<Hotel> result = hotelRepository.findById(id);
        if (result.isPresent()) {
            hotelRepository.deleteById(id);
            return new ResponseEntity("Deleted", HttpStatus.OK);
            //or
            //return ResponseEntity.ok("Hotel successfully deleted.");

        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Hotel> updateHotel(Hotel newHotel, Long id) {
        Optional<Hotel> result=hotelRepository.findById(id);
        if (result.isEmpty())
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        Hotel oldHotel = result.get();
        oldHotel.setId(id);
        oldHotel.setName(newHotel.getName());
        oldHotel.setAddress(newHotel.getAddress());
        oldHotel.setRating(newHotel.getRating());
        oldHotel.setRooms(newHotel.getRooms());
        return new ResponseEntity<>(hotelRepository.save(oldHotel),HttpStatus.ACCEPTED);
        //or
        //return ResponseEntity.status(HttpStatus.ACCEPTED).body(oldHotel);

    }

    public ResponseEntity<Hotel> updateHotel_v2(Hotel newHotel, Long id) {
        return hotelRepository.findById(id)
                .map(existingHotel -> {
                    existingHotel.setName(newHotel.getName());
                    existingHotel.setAddress(newHotel.getAddress());
                    existingHotel.setRating(newHotel.getRating());
                    existingHotel.setRooms(newHotel.getRooms());
                    Hotel updatedHotel = hotelRepository.save(existingHotel);
                    return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedHotel);
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    public ResponseEntity<Hotel> getHotelById(Long id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        return hotel.isPresent() ? ResponseEntity.ok(hotel.get()) : ResponseEntity.notFound().build();
    }



    public ResponseEntity<Hotel> getHotelById_v2(Long id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        return hotel.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
