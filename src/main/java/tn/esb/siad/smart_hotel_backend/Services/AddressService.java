package tn.esb.siad.smart_hotel_backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esb.siad.smart_hotel_backend.Models.Address;
import tn.esb.siad.smart_hotel_backend.Repositories.AddressRepository;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public ResponseEntity<List<Address>> getAddress(){
        List<Address> Addresses=addressRepository.findAll();
        if(Addresses.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(Addresses,HttpStatus.OK);

    }
    public ResponseEntity<Address> addAddress(Address Address) {
        Address Address1=addressRepository.save(Address);
        return new ResponseEntity<>(Address1,HttpStatus.CREATED);
    }
}
