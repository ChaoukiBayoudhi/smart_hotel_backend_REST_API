package tn.esb.siad.smart_hotel_backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esb.siad.smart_hotel_backend.Models.Hotel;
import tn.esb.siad.smart_hotel_backend.Services.HotelService;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@CrossOrigin("http://localhost:4200")
public class HotelController {
    @Autowired
    private HotelService hotelService;
    //url=http://localhost:9995/hotels/all
    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> getAllHotels(){
        return hotelService.getHotels();
    }

    //url=http://localhost:9995/hotels/add
    @PostMapping("/add")
    public ResponseEntity<Hotel> add(@RequestBody Hotel hotel){
        return hotelService.addHotel(hotel);
    }

    // URL: http://localhost:9995/hotels/delete/{id}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable Long id) {
        return hotelService.removeHotel(id);
    }

    // URL: http://localhost:9995/hotels/update/{id}
    @PutMapping("/update/{id}")
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel, @PathVariable Long id) {
        return hotelService.updateHotel(hotel, id);
    }
    // URL: http://localhost:9995/hotels/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id) {
        return hotelService.getHotelById(id);
    }


}
