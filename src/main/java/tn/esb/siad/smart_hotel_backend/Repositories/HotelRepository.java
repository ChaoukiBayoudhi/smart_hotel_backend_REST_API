package tn.esb.siad.smart_hotel_backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esb.siad.smart_hotel_backend.Models.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {
    //we have these methods provided by the ORM:
    //findAll() => return List<Hotel> containing all hotels
    //findById(5) => return Optional<Hotel>
    //Optional is a type that could contain one or zero value.
    //Optional<Hotel> result=repository.findById(5);
    //two cases:
    //there is an hotel that have the id 5 =  result.isPresent() ==True
    //else if result.isPresent()==false
    //hotel h=new hotel();
    //h.setId(3);
    //Hotel h1=repository.save(h);
    //if the id 3 is on the database so the existing hotel is updated
    //else a new hotel is inserted
    //repository.deleteById(3); removes the existing hotel from the database

}
