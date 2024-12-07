package tn.esb.siad.smart_hotel_backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esb.siad.smart_hotel_backend.Models.Address;
import tn.esb.siad.smart_hotel_backend.Models.Hotel;
import tn.esb.siad.smart_hotel_backend.Repositories.AddressRepository;
import tn.esb.siad.smart_hotel_backend.Services.AddressService;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@CrossOrigin("http://localhost:4200")
public class AddressController {
    @Autowired
    private AddressService addressService;


    //url=http://localhost:9995/addresses/all
    @GetMapping("/all")
    public ResponseEntity<List<Address>> getAllAddresses(){
        return addressService.getAddress();
    }

    //url=http://localhost:9995/addresses/
    @PostMapping("/add")
    public ResponseEntity<Address> add(@RequestBody Address address){
        return addressService.addAddress(address);
    }
}
