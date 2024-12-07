package tn.esb.siad.smart_hotel_backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esb.siad.smart_hotel_backend.Models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
